package com.pu.action;

import com.pu.dao.FilepathinformDAO;
import com.pu.pojo.Filepathinform;

/*
 * time:2016年11月16日
 * author:pu
 * 功能:文件路径的保存功能
 * 参数：
 * 	private String filename;预览文件的名称
 *	private String filepathzip;预览文件的下载地址，下载文件为zip或者rar
 *	private String filepathurl;预览文件的地址
 *	private String preimgurl;预览图的地址
 *	private Integer downtimes;省略，默认为0
 *
 * 
 */
public class SaveFilePath {
	
      public static void savePath(String filename,
     String filepathzip,
  	 String filepathurl,
     String preimgurl)
     {
    		Filepathinform finform=new Filepathinform(filename,filepathzip,filepathurl,preimgurl,0);
    	  
    		FilepathinformDAO fileinf=new FilepathinformDAO();
    		fileinf.save(finform);
    	     	  
      }
}
