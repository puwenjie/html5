package com.servlet;

public class UploadState {
	private String id;//上传编号
	private int state;//上传状态 0 正常 -1 错误 1 上传完毕
	private String errormsg;//错误信息
	private String targetfile;//目标文件
	private long totalsize;//文件总大小
	private long uploadsize;//已上传大小
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTargetfile() {
		return targetfile;
	}
	public void setTargetfile(String targetfile) {
		this.targetfile = targetfile;
	}
	/**
	 * 上传状态 0 正常 -1 错误 1 上传完毕
	 * @param state
	 */
	public int getState() {
		return state;
	}
	/**
	 * 上传状态 0 正常 -1 错误 1 上传完毕
	 * @param state
	 */
	public void setState(int state) {
		this.state = state;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public long getTotalsize() {
		return totalsize;
	}
	public void setTotalsize(long totalsize) {
		this.totalsize = totalsize;
	}
	public long getUploadsize() {
		return uploadsize;
	}
	public void setUploadsize(long uploadsize) {
		this.uploadsize = uploadsize;
	}
	
}
