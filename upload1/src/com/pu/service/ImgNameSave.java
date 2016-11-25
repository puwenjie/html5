package com.pu.service;

import java.util.List;

import com.pu.dao.FilepathinformDAO;
import com.pu.pojo.Filepathinform;

public class ImgNameSave {
	
	//将图片的名称保存到数据库
		//在上传图片的时候读取图片名称，requst读取的图片名称含有后缀，去掉后缀后和数据库中的filename名称作对比，，如果存在的话就将图片名称存入到数据库preimgurl中去
	FilepathinformDAO filepathinformdao=new FilepathinformDAO();
	
		 public void storeImg(String imgfilename, String imgname){
			 //.....
			// String filename=null;
			 
			 String[] names = imgfilename.split("\\.");
		     //System.out.println(names[0]);
			 
			 List<Filepathinform> list=filepathinformdao.findByFilename(names[0]);
			 if(list != null && list.size() != 0){
				 for(int i=0;i<list.size();i++){
				 list.get(i).setPreimgurl(imgname);
				 filepathinformdao.attachDirty(list.get(i));
				 
			 }
				
			 }else{
				 //页面输入一个请您注意查看是否预览图的文件名称输入有问题。
				 System.out.print("meiyoushujuku");
				 
			 }
			 
			 
		 }
		
	   //获取和数据库中filename相匹配的图片地址，返回保存在数据库中的预留图片地址
		 public  String getPreImgurl(String filename){
			 //......
			 List<Filepathinform> list=filepathinformdao.findByFilename(filename);
			 if(list != null && list.size() != 0){
				 
				return list.get(0).getPreimgurl();
				 
			 }else{
				 //更具文件名查找到缩略图地址，如果没有缩略图，则输出默认的缩略图地址
				 System.out.print("meiyoushujuku缩略图，默认图片显示缩略");
				 return "preimg/pre.jpg";
			 }
			
		 }

}
