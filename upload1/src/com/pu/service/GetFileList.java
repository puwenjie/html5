package com.pu.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetFileList {

	/**
	 * 功能：获取文件夹列表的函数
	 * 时间：2016年11月14日
	 * @author pu
	 */


    public static List<String> getFileName(String path) {
    	List<String> result=new ArrayList<String>();
    	//System.out.print(path+"这是路径");
        //"../upload"; // 路径
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            result.add(path + " not exists");
            return result;
        }

        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");
                result.add(fs.getName());
            } else {
                System.out.println(fs.getName());
                result.add(fs.getName());
            }
        }
		return result;
    }
}
