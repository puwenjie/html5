package com.pu.service;

import javax.servlet.http.HttpServletRequest;
/*
 * time:2016年11月15日
 * author:pu
 * 功能：获取服务器中文件夹的路径，其中有两个函数，
 * 1，一个函数名为getFilePathzip（）为获取压缩包下载路径
 * 2，一个函数名为getFilepath（）为获取解压后文件夹路径，
 * upload为压缩文件的路径
 * decompression为解压后的文件夹路径
 * 
 */
   public class FilePath {
	//获取压缩包url下载文件夹路径，可以用这个路径+文件名称去下载文件
	public static String  getFilelPath(HttpServletRequest request){
		HttpServletRequest httpRequest=(HttpServletRequest)request; 
		String filepath = "http://" + request.getServerName() //服务器地址  
                + ":"   
                + request.getServerPort()           //端口号  
                + request.getContextPath() ;     //项目名称  
              //  + request.getServletPath();     //请求页面或其他地址  
		System.out.print(filepath+"这是url地址");
		//获取服务器文件路径地址：String pahtZip=request.getSession().getServletContext().getRealPath("/")+"upload";
		return filepath;
		
	}
	//获取压缩包的文件夹路径，可以用这个路径去遍历文件的名称信息
	public static String getZipFilePath(HttpServletRequest request){
		String pathzip=request.getSession().getServletContext().getRealPath("/")+"upload";
		return pathzip;
		
		
	}
	
	//获取解压后的文件路径
	
//	public static String   getFilepath(HttpServletRequest request){
//		HttpServletRequest httpRequest=(HttpServletRequest)request; 
//		String pathzip = "http://" + request.getServerName() //服务器地址  
//                + ":"   
//                + request.getServerPort()           //端口号  
//                + request.getContextPath()+"/decompression" ;     //项目名称  
//              //  + request.getServletPath();     //请求页面或其他地址  
//		//String pahtZip=request.getSession().getServletContext().getRealPath("/")+"decompression";
//		return pathzip;
//	}
	
	
}
