package com.pu.pojo;
/*
 * time:2016年11月30日
 * author：pu
 * 功能：作为实体类，记录从数据库返回到前台的信息
 * 将类创建对象后，以json的格式返回
 * filename：表示项目的名称
 * urlname:表示项目的缩略图地址
 * filezip：表示的是项目下载地址
 * 
 */
public class FileToUrl {

	
	String fileName;
	String urlName;
	String filezip;
	public String getFilezip() {
		return filezip;
	}
	public void setFilezip(String filezip) {
		this.filezip = filezip;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUrlName() {
		return urlName;
	}
	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	
}
