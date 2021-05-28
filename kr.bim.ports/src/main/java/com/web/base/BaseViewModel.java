package com.web.base;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.web.base.code.dao.CodeSysDTO;
import com.web.base.menu.dao.MenuDTO;
public class BaseViewModel {
	private String requestIP;
	private Date requestTime;
	private MenuDTO menuDetail;
	private List<MenuDTO> menus;
	private List<CodeSysDTO> codes;
	private int pageNo;
	private int pageSize;
	private String id;
	private int resultCount;
	private String resultData;
	private String resultMessage;
	private String menuHtml;
    private int totalCount;
    private String isValidYN;
    private String pg;
	private CommonParams commonParams;
	private String rememberMeYn;
	private List<MultipartFile> uploadFiles;
	private boolean enableWriteYN;
	private String keyModule;
	private String keyExponent;
	private String fileGroup;
	private int fileSeq;
	private String version;
	private String jwtTocken;
	
	public String getRequestIP() {
		return requestIP;
	}
	public void setRequestIP(String requestIP) {
		this.requestIP = requestIP;
	}
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	public MenuDTO getMenuDetail() {
		return menuDetail;
	}
	public void setMenuDetail(MenuDTO menuDetail) {
		this.menuDetail = menuDetail;
	}
	public List<MenuDTO> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuDTO> menus) {
		this.menus = menus;
	}
	public List<CodeSysDTO> getCodes() {
		return codes;
	}
	public void setCodes(List<CodeSysDTO> codes) {
		this.codes = codes;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getResultCount() {
		return resultCount;
	}
	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}
	public String getResultData() {
		return resultData;
	}
	public void setResultData(String resultData) {
		this.resultData = resultData;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public String getMenuHtml() {
		return menuHtml;
	}
	public void setMenuHtml(String menuHtml) {
		this.menuHtml = menuHtml;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getIsValidYN() {
		return isValidYN;
	}
	public void setIsValidYN(String isValidYN) {
		this.isValidYN = isValidYN;
	}
	public String getPg() {
		return pg;
	}
	public void setPg(String pg) {
		this.pg = pg;
	}
	public CommonParams getCommonParams() {
		return commonParams;
	}
	public void setCommonParams(CommonParams commonParams) {
		this.commonParams = commonParams;
	}
	public String getRememberMeYn() {
		return rememberMeYn;
	}
	public void setRememberMeYn(String rememberMeYn) {
		this.rememberMeYn = rememberMeYn;
	}
	public List<MultipartFile> getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(List<MultipartFile> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	public boolean isEnableWriteYN() {
		return enableWriteYN;
	}
	public void setEnableWriteYN(boolean enableWriteYN) {
		this.enableWriteYN = enableWriteYN;
	}
	public String getKeyModule() {
		return keyModule;
	}
	public void setKeyModule(String keyModule) {
		this.keyModule = keyModule;
	}
	public String getKeyExponent() {
		return keyExponent;
	}
	public void setKeyExponent(String keyExponent) {
		this.keyExponent = keyExponent;
	}
	public String getFileGroup() {
		return fileGroup;
	}
	public void setFileGroup(String fileGroup) {
		this.fileGroup = fileGroup;
	}
	public int getFileSeq() {
		return fileSeq;
	}
	public void setFileSeq(int fileSeq) {
		this.fileSeq = fileSeq;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getJwtTocken() {
		return jwtTocken;
	}
	public void setJwtTocken(String jwtTocken) {
		this.jwtTocken = jwtTocken;
	}

	
	
}
