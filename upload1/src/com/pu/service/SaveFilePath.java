package com.pu.service;
/*
 * time:2016年11月16日
 * aurthor:pu
 *  功能:实现上传路径保存到数据库中，其中包括的参数有
 *  String filename;预览文件的名称
 *	String filepathzip;预览文件的下载地址，下载文件为zip或者rar
 *	String filepathurl;预览文件的地址
 *	String preimgurl;预览图的地址，如果默认预留图地址为 img/pre.jpg
 *  Integer downtimes;省略，默认为0
 * 
 */
import com.pu.dao.FilepathinformDAO;
import com.pu.pojo.Filepathinform;

public class SaveFilePath {
	public static void savePath(String filename, String filepathzip,
			String filepathurl, String preimgurl) {
		Filepathinform finform = new Filepathinform(filename, filepathzip,
				filepathurl, preimgurl, 0);
		FilepathinformDAO fileinf = new FilepathinformDAO();
		fileinf.save(finform);

	}

	public static void savePath(String filename, String filepathzip,
			String filepathurl) {

		savePath(filename, filepathzip, filepathurl, "/img/pre.jpg");
	}
	
}
