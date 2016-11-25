package com.pu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pu.service.FilePath;
import com.pu.service.FileUtils;
import com.pu.service.GetFileList;
import com.pu.service.UpPreImg;

public class ImgUpUtils extends HttpServlet{
   
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 上传文件
		UpPreImg.uploadImg(request, "preimg/",
				
				10 * 1024 * 1024, ".jpg .png .jpeg");
		// String filename=request.getParameter("fileUpload");
		//StringBuffer locationadd = request.getRequestURL();
		//System.out.println(locationadd + "这是路径");
		// System.out.println(request.getSession().getServletContext().getRealPath("/")+"upload");
		// GetFileList getfilelist=new GetFileList();
		// System.out.println(filename+"这是上传的文件名");
		
		//GetFileList.getFileName(FilePath.getZipFilePath(request));
		//System.out.println(filePaths);
		
	}
	
	
}
