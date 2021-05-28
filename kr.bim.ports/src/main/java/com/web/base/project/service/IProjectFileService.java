package com.web.base.project.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.web.base.CommonParams;
import com.web.base.project.dao.ProjectFilesDto;

public interface IProjectFileService {
	 public List<ProjectFilesDto> createFile(List<MultipartFile> paramFiles,List<String> categorySeqs, CommonParams common) ;
	 public List<ProjectFilesDto> createFile(List<MultipartFile> paramFiles, CommonParams common, String filePath,String folderName,String oldVersion,String fixedVersion);
	 public int create(List<ProjectFilesDto> paramFiles,String paramId);
	 public List<ProjectFilesDto> list(String paramFileGrpId);
}
