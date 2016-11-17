package com.pu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pu.service.FilePath;
import com.pu.service.GetFileList;

import common.utils.FileUtils1;

public class FileUtilsTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//下载文件
		FileUtils1.download(request, response, "files/学生信息.xls");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//上传文件
		List<String> filePaths = FileUtils1.upload(request, "upload/",10*1024*1024,".zip .rar");
		//String filename=request.getParameter("fileUpload");
		StringBuffer  locationadd=request.getRequestURL();;
		System.out.println(locationadd+"这是路径");
	//	System.out.println(request.getSession().getServletContext().getRealPath("/")+"upload");
	//	GetFileList getfilelist=new GetFileList();
		//System.out.println(filename+"这是上传的文件名");
		GetFileList.getFileName(FilePath.getFilePathZip(request)); 
		System.out.println(filePaths);
	}
}
