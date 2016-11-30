package com.pu.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.pu.dao.FilepathinformDAO;
import com.pu.pojo.FileToUrl;
import com.pu.pojo.Filepathinform;
import com.pu.service.FilePath;
/*
 * author:pu
 * time:2016年11月24日
 * 功能说明：通过servlet获取数据库中压缩包名称和预览图名称，并且用把名称和服务器地址拼接到一起用map的形式返回
 * 
 */
public class FileList {
	
	public static List<FileToUrl> getlist(HttpServletRequest request,
			HttpServletResponse response){
		Map<String,String> value=new HashMap<String,String>();
		Map<String,Object> result=new HashMap<String,Object>();
		
		FilepathinformDAO filepathinformdao=new FilepathinformDAO();
		List<Filepathinform> list=filepathinformdao.findAll();
		String path=FilePath.getFilelPath(request);
		int filesize=list.size();
		List<FileToUrl> listfiletourl=new ArrayList<FileToUrl>();
		
		for(Integer i=0;i<filesize;i++){
			//获得服务器路径
			
			//获取数据库中的值
			FileToUrl filetourl=new FileToUrl();
			
		   	filetourl.setFileName(list.get(i).getFilename());
			filetourl.setUrlName( path+"/"+"preimg/"+list.get(i).getPreimgurl());
		    filetourl.setFilezip(path+"/"+"upload/"+list.get(i).getFilepathzip());
			listfiletourl.add(filetourl);
			  System.out.println("!!!!!!"+path+"/"+"upload/"+list.get(i).getFilepathzip()+"!!!!!!");
//			value.put("filezip", path+"/"+"upload/"+list.get(i).getFilepathzip());
//			
//		   value.put("fileimg",  path+"/"+"preimg/"+list.get(i).getPreimgurl());
		//	value.put(path+"/"+"upload/"+list.get(i).getFilepathzip(), path+"/"+"preimg/"+list.get(i).getPreimgurl());
		    // result.put(i.toString(), value);
		     
		     
		    
			
		}
	
		
	
	    
		return listfiletourl;
		
		
	}

}
