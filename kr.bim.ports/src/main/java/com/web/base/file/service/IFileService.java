package com.web.base.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.web.base.CommonParams;
import com.web.base.file.dao.AttachFileDTO;
import com.web.base.file.dao.DBInfoDTO;
import com.web.base.file.dao.FolderDTO;



public interface IFileService {
	public String create(List<MultipartFile> paramFiles,CommonParams common);
	public String editFile(List<MultipartFile> paramFiles,String fileGrpID) ;
	public String create(List<MultipartFile> paramFiles,String filePath,String fileGrpID) ;
	public String create(List<MultipartFile> paramFiles,CommonParams common,String filePath);
	public String create(List<MultipartFile> paramFiles,List<String> paramTitles, String filePath);
	public String create(List<MultipartFile> paramFiles,List<String> paramTitles, String filePath,String fileGrpID);
	public String createZip(String fileGrpID) throws Exception;
	public void moveFileFromTmep(String fileGrpID,String filePath) throws Exception;
	
	public int update(List<AttachFileDTO> paramFile);
	public List<AttachFileDTO> createObj(List<MultipartFile> paramFiles,String filePath);
	public AttachFileDTO detail(int paramSeq);
	public int delete(int paramSeq);
	public int delete(List<Integer> paramSeqs);
	public List<AttachFileDTO> list(List<String> fileGrps);
	public List<AttachFileDTO> list(String fileGrp);
	public List<String> listImageUnzipFiles(String fileGrpID);
	public boolean isExtImgCheck(List<MultipartFile> paramFiles);
	public boolean isExtDocCheck(List<MultipartFile> paramFiles);
	public List<FolderDTO> getFileSizeList();
	
	public List<DBInfoDTO> dbList();
	String getImageBase64(AttachFileDTO paramFile) throws Exception;
	public boolean isNotFileEmpty(List<MultipartFile> paramFiles);
	public AttachFileDTO detailFileInfo(String paramFileGrpId) ;
	
	public String createBase64ImageSave(String paramImgString,String paramFilePath);
	public int updateFileGrp(String file_grp_id_now, String fileGrpID);
	
}

