package com.pu.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.pu.pojo.FileToUrl;
import com.pu.service.FileUtils;

public class FileImgList extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	// 返回压缩包地址
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 下载文件
		// , "files/学生信息.xls"已删除参数
		
	        
		List<FileToUrl> list = FileList.getlist(request, response);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray json = JSONArray.fromObject(list,jsonConfig);
		//JSONArray json = JSONArray.fromObject(newList, jsonConfig);
		String jsonObject = json.toString();
		
		
		response.setHeader("Content-type", "text/html;charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		//request.setAttribute("data", list);
		System.out.print("-------------");
		System.out.print(jsonObject);
		System.out.print("-------------");
//		RequestDispatcher dispatcher = request
//				.getRequestDispatcher("view.jsp"); // 使用req对象获取RequestDispatcher对象
//		dispatcher.forward(request, response);
		// 为request对象添加参数
//		RequestDispatcher dispatcher = request
//				.getRequestDispatcher("download.jsp"); // 使用req对象获取RequestDispatcher对象
//		dispatcher.forward(request, response);

	}
}
