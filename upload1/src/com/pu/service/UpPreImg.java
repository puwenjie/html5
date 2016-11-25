package com.pu.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pu.dao.FilepathinformDAO;
import com.pu.pojo.Filepathinform;

/*
 *时间：2016年11月16日
 *author:pu
 *功能：
 *1，实现预留图片的上传，
 *2，保存预留图片地址到数据库， 
 *3，获取图片 
 *
 */
public class UpPreImg {
	
	
	 
	 
	 /**
		 * 图片上传函数，图片上传到服务器文件夹中
		 * 
		 * @param request HttpServletRequest
		 * @param relativeUploadPath 上传文件保存的相对路径，例如"preimg/"，注意，末尾的"/"不要丢了
		 * @param maxSize 上传的最大文件尺寸，单位字节
		 * @param thresholdSize 最大缓存，单位字节
		 * @param fileTypes 文件类型，会根据上传文件的后缀名判断。<br>
		 * 比如支持上传jpg,jpeg,gif,png图片,那么此处写成".jpg .jpeg .gif .png",<br>
		 * 也可以写成".jpg/.jpeg/.gif/.png"，类型之间的分隔符是什么都可以，甚至可以不要，<br>
		 * 直接写成".jpg.jpeg.gif.png"，但是类型前边的"."不能丢
		 * 
		 * @return
		 */
		public  static void uploadImg(HttpServletRequest request, String relativeUploadPath, int maxSize, int thresholdSize, String fileTypes) {
			// 设置字符编码
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}

			String tempPath = relativeUploadPath + "imgtemp"; // 临时文件目录
			String serverPath = request.getSession().getServletContext().getRealPath("/").replace("\\", "/");
			fileTypes = fileTypes.toLowerCase(); // 将后缀全转换为小写

			//如果上传文件目录和临时目录不存在则自动创建
			if (!new File(serverPath + relativeUploadPath).isDirectory()) {
				new File(serverPath + relativeUploadPath).mkdirs();
			}
			if (!new File(serverPath + tempPath).isDirectory()) {
				new File(serverPath + tempPath).mkdirs();
			}

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(thresholdSize); // 最大缓存
			factory.setRepository(new File(serverPath + tempPath));// 临时文件目录

			ServletFileUpload upload = new ServletFileUpload(factory);

			upload.setSizeMax(maxSize);// 文件最大上限
			//System.out.println(upload.setSizeMax(maxSize));
	       
			List<String> filePaths = new ArrayList<String>();

			List<FileItem> items;
			try {
				items = upload.parseRequest(request);
				
				// 获取所有文件列表
				for (FileItem item : items) {
					
					// 获得文件名，文件名包括路径
					if (!item.isFormField()) { // 如果是文件
						// 文件名
						String fileName = item.getName().replace("\\", "/");
						
					    //判断是否数据库中有何图片名一样的数据库条，如果有则吧图片名称存入对应的数据库
						//String imgname;
						//FilepathinformDAO filepathinformdao=new FilepathinformDAO();
						
//						if(fileName.endsWith("jpg")){
//							imgname=fileName.replaceAll(".jpg", "");
//							imgnamesave.storeImg(imgname);
//						}else if(fileName.endsWith("png")){
//							
//							imgname=fileName.replaceAll(".png", "");
//							filepathinformdao.findByFilename(imgname);
//						}else{
//							
//							imgname=fileName.replaceAll(".gif", "");
//							filepathinformdao.findByFilename(imgname);
//							
//						}
						//文件后缀名
						String suffix = null;
						if (fileName.lastIndexOf(".") > -1) {
							suffix = fileName.substring(fileName.lastIndexOf("."));
						} else { //如果文件没有后缀名，不处理，直接跳过本次循环
							continue;
						}
						
						// 不包含路径的文件名
						String SimpleFileName = fileName;
						if (fileName.indexOf("/") > -1) {
							SimpleFileName = fileName.substring(fileName
									.lastIndexOf("/") + 1);
						}

						// 如果文件类型字符串中包含该后缀名，保存该文件
						if (fileTypes.indexOf(suffix.toLowerCase()) > -1) {
							String uuid = UUID.randomUUID().toString();
							SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
							String imgname=sf.format(new Date())
								  + uuid + SimpleFileName;
							
//							String absoluteFilePath = serverPath
//									+ relativeUploadPath + sf.format(new Date())
//									+ " " + uuid + " " + SimpleFileName;
							String absoluteFilePath = serverPath
									+ relativeUploadPath +imgname;
							//用上传的文件名称做对比，如果图片名称和数据库中的filename相同，那么我们把这个图生成的文件名存入到数据库中去
						
							ImgNameSave imgnamesave=new ImgNameSave();
							imgnamesave.storeImg(fileName,imgname);
							
							
							item.write(new File(absoluteFilePath));
							filePaths.add(absoluteFilePath);
						} 
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
				System.out.print("文件太大异常");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.print("其他异常");
			}

			
		}

		/**
		 * 文件上传
		 * 
		 * @param request HttpServletRequest
		 * @param relativeUploadPath 上传文件保存的相对路径，例如"preimg/"，注意，末尾的"/"不要丢了
		 * @param maxSize 上传的最大文件尺寸，单位字节
		 * @param fileTypes 文件类型，会根据上传文件的后缀名判断。<br>
		 * 比如支持上传jpg,jpeg,gif,png图片,那么此处写成".jpg .jpeg .gif .png",<br>
		 * 也可以写成".jpg/.jpeg/.gif/.png"，类型之间的分隔符是什么都可以，甚至可以不要，<br>
		 * 直接写成".jpg.jpeg.gif.png"，但是类型前边的"."不能丢
		 * @return
		 */
		public static void uploadImg(HttpServletRequest request, String relativeUploadPath, int maxSize, String fileTypes) {
			uploadImg(request, relativeUploadPath, maxSize, 5*1024, fileTypes);
		}
		
		/**
		 * 文件上传，不限大小
		 * 
		 * @param request HttpServletRequest
		 * @param relativeUploadPath 上传文件保存的相对路径，例如"preimg/"，注意，末尾的"/"不要丢了
		 * @param fileTypes 文件类型，会根据上传文件的后缀名判断。<br>
		 * 比如支持上传jpg,jpeg,gif,png图片,那么此处写成".jpg .jpeg .gif .png",<br>
		 * 也可以写成".jpg/.jpeg/.gif/.png"，类型之间的分隔符是什么都可以，甚至可以不要，<br>
		 * 直接写成".jpg.jpeg.gif.png"，但是类型前边的"."不能丢
		 * @return
		 */
		public static void uploadImg(HttpServletRequest request, String relativeUploadPath, String fileTypes) {
			uploadImg(request, relativeUploadPath, -1, 5*1024, fileTypes);
		}
}
