package com.web.base.project.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.base.BaseService;
import com.web.base.CommonParams;
import com.web.base.file.dao.AttachFileDTO;
import com.web.base.project.dao.ProjectFilesDao;
import com.web.base.project.dao.ProjectFilesDto;
import com.web.base.project.dao.ProjectItemsDto;
import com.web.base.project.dao.ProjectStepDto;
@Service("projectFileService")
public class ProjectFileServiceImpl extends BaseService implements IProjectFileService {
	@Value("${file.project.path}")
	private String projectFilePath;
	
	@Autowired
	private ProjectFilesDao projectFileDao;
	
	@Override
	public List<ProjectFilesDto> createFile(List<MultipartFile> paramFiles,List<String> categorySeqs, CommonParams common) {
		List<ProjectFilesDto> rs=createFile(paramFiles,common,projectFilePath,null,null,null);
		int i=0;
		if(paramFiles.size()==categorySeqs.size()) {
			for (ProjectFilesDto projectFilesDto : rs) {
				projectFilesDto.setCategory_seq(Integer.parseInt(categorySeqs.get(i)));
				i++;
			}
		}else {
			rs=null;
		} 
			
		return rs;
		
	}

	@Override
	public List<ProjectFilesDto> createFile(List<MultipartFile> paramFiles, CommonParams common, String filePath,String folderName,String oldVersion,String fixedVersion) {
		List<ProjectFilesDto> rs=new ArrayList<ProjectFilesDto>();
		String fileFolderPath=createPath(filePath,folderName);
		String fileGrp = UUID.randomUUID().toString();
		String version=fixedVersion==null?createVersion(oldVersion):fixedVersion;
		Date date = new Date();
		SimpleDateFormat curDate = new SimpleDateFormat("yyyyMMddHHmmss");
		
		if (paramFiles != null && paramFiles.size() > 0) {
			try {
				int i = 1;
				for (MultipartFile multipartFile : paramFiles) {

					String orgFileName = multipartFile.getOriginalFilename();
					String newFileName = curDate.format(date) + i;
					String fileType = orgFileName.substring(
							orgFileName.lastIndexOf(".") + 1, orgFileName.length());
					;

					if (multipartFile.getBytes().length > 0) {
						File file = new File(fileFolderPath + newFileName + "."+ fileType);
						multipartFile.transferTo(file);
						ProjectFilesDto temp = new ProjectFilesDto();
						temp.setFile_ext(fileType);
						temp.setFile_grp_id(fileGrp);
						temp.setFile_new_name(newFileName + "." + fileType);
						temp.setFile_org_name(orgFileName);
						temp.setFile_size(multipartFile.getSize());
						temp.setCreate_user_id(common.getLoginUserID());
						temp.setUpdate_user_id(common.getLoginUserID());
						temp.setFile_path(fileFolderPath);
						temp.setVersion(version);
						rs.add(temp);
						i++;
					}
				}

			} catch (Exception ex) {
				logger.debug(ex.getMessage());
			}

		}
		return rs;
	}
	


	private String createPath( String filePath,String folderName) {
		Date date = new Date();
		SimpleDateFormat dayDir = new SimpleDateFormat("yyyyMMdd");
		StringBuilder builder=new StringBuilder();
		builder.append(filePath);
		builder.append(File.separator);
		if(!stringIsNullOrEmpty(folderName)) {
			builder.append(folderName);
			builder.append(File.separator);
		}
		builder.append(dayDir.format(date));
		builder.append(File.separator);
		filePath = builder.toString();
		File dirTarget = new File(filePath);
	
		if (!dirTarget.exists()) {
			dirTarget.mkdirs();
		}
		return filePath;
	}
	
	private String createVersion(String paramVersion) {
		String rs=null;
		
		if(!stringIsNullOrEmpty(paramVersion)) {
			paramVersion=paramVersion.replace(".","");
			int oldVersion=Integer.parseInt(paramVersion);
			char[] arr=Integer.toString(oldVersion+1).toCharArray();
			StringBuilder builder=new StringBuilder();
			for(int i=0;i<arr.length-1;i++) {
				builder.append(arr[i]);
				builder.append(".");
			}
			builder.append(arr[arr.length - 1]);
			rs=builder.toString();
		}else {
			rs="1.0.0";
		}
		return rs;
	}

	@Override
	public int create(List<ProjectFilesDto> paramFiles, String paramId) {
		int rs=0;
		for (ProjectFilesDto projectFilesDto : paramFiles) {
			projectFilesDto.setPrj_id(paramId);
			projectFilesDto.setFile_title(projectFilesDto.getVersion());
			rs+=projectFileDao.create(projectFilesDto);
			
		}
		return rs;
	}

	@Override
	public List<ProjectFilesDto> list(String paramFileGrpId) {
		HashMap<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("file_grp_id",paramFileGrpId);
		
		return projectFileDao.list(paramMap);
	}


}
