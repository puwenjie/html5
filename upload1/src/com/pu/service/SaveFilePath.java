package com.pu.service;

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
