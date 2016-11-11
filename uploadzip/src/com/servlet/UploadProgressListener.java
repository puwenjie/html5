package com.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class UploadProgressListener implements ProgressListener {

	private HttpSession session;
	// private long megaBytes = -1;

//	private long maxSize = 100 * 1024 * 1024;// 最大文件大小100M

	public UploadProgressListener(HttpServletRequest request) {

		session = request.getSession();
		UploadState us=(UploadState)session.getAttribute("upstate");
		if (us == null) {
			us = new UploadState();
			session.setAttribute("upstate", us);
		}
		us.setState(0);// 默认正常状态
		us.setTotalsize(0);
		us.setId(request.getParameter("upid"));
	}

	/**
	 * 
	 * 为了进度条监听器不会引起性能问题 解决方案,是减少进步条的活动数 比如，只有当上传了1兆字节的时候才反馈给用户
	 * 
	 */
	public void update(long pBytesRead, long pContentLength, int pItems) {
		/*
		 * long mBytes = pBytesRead / 1048576; if (megaBytes == mBytes) {
		 * return; } megaBytes = mBytes;
		 */
		UploadState state = (UploadState) session.getAttribute("upstate");
		state.setTotalsize(pContentLength);
		if (pContentLength == -1) {
			state.setErrormsg("已完成" + pItems + "个文件的上传");
			state.setState(1);
			state.setUploadsize(pBytesRead);
		} else {
			state.setErrormsg("正在上传第" + pItems + "个文件");
			state.setState(0);
			state.setUploadsize(pBytesRead);
		}
	}
}