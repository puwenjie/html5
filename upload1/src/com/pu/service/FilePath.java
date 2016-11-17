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
	//获取压缩包下载路径
	public static String  getFilePathZip(HttpServletRequest request){
		String pahtZip=request.getSession().getServletContext().getRealPath("/")+"upload";
		return pahtZip;
		
	}
	//获取解压后的文件路径
	
	public static String   getFilepath(HttpServletRequest request){
		
		String pahtZip=request.getSession().getServletContext().getRealPath("/")+"decompression";
		return pahtZip;
	}
	
	
}
