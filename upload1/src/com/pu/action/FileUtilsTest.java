package com.pu.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pu.service.FilePath;
import com.pu.service.GetFileList;

import com.pu.service.FileUtils;

public class FileUtilsTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 返回压缩包地址
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 下载文件
		// , "files/学生信息.xls"已删除参数
		List<String> list = FileUtils.download(request, response);

		request.setAttribute("data", list);
		// 为request对象添加参数
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("download.jsp"); // 使用req对象获取RequestDispatcher对象
		dispatcher.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 上传文件
		List<String> filePaths = FileUtils.upload(request, "upload/",
				10 * 1024 * 1024, ".zip .rar");
		// String filename=request.getParameter("fileUpload");
		StringBuffer locationadd = request.getRequestURL();
		System.out.println(locationadd + "这是路径");
		// System.out.println(request.getSession().getServletContext().getRealPath("/")+"upload");
		// GetFileList getfilelist=new GetFileList();
		// System.out.println(filename+"这是上传的文件名");
		GetFileList.getFileName(FilePath.getZipFilePath(request));
		System.out.println(filePaths);
	}
}
