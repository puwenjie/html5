package com.pu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pu.service.FilePath;
import com.pu.service.GetFileList;

import common.utils.FileUtils;

public class FileUtilsTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//下载文件
		FileUtils.download(request, response, "files/学生信息.xls");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//上传文件
		List<String> filePaths = FileUtils.upload(request, "upload/",10*1024*1024,".zip .rar");
	//	System.out.println(request.getSession().getServletContext().getRealPath("/")+"upload");
	//	GetFileList getfilelist=new GetFileList();
		GetFileList.getFileName(FilePath.getFilePathZip(request)); 
		System.out.println(filePaths);
	}
}
