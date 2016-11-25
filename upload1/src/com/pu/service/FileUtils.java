package com.pu.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pu.dao.FilepathinformDAO;
import com.pu.pojo.Filepathinform;
/*
 * 功能：上传文件和下载文件的接口功能
 * 时间：2016年11月14日
 * 人员：pu
 *  
 */
public class FileUtils {

	private FileUtils() {

	}
//下载压塑包列表文件，获取下载文件的文件名列表到客户端，然后由客户端在将服务器路径+文件名组合为下载地址
	//, String relativeFilePath历史参数，已删除
	public static List<String> download(HttpServletRequest request,
			HttpServletResponse response) {
		List<String> fileurlpath = new ArrayList<String>() ;
		String serverPath = FilePath.getFilelPath(request)+"/"+"upload"+"/";
		//String serverPath = request.getSession().getServletContext().getRealPath("/").replace("\\", "/")+"upload";
		//return GetFileList.getFileName(serverPath);
		//获取文件列表的名称
		List<String> filenamelist=GetFileList.getFileName(FilePath.getZipFilePath(request));
		
		int j=filenamelist.size();
		//List<String> filenamelist=GetFileList.getFileName(serverPath);
		for(int i=0;i<j;i++){
			String str=serverPath+filenamelist.get(i);
			fileurlpath.add(str);
			
		}
		
		return fileurlpath;
		//System.out.print(GetFileList.getFileName(serverPath));
		
		
		
/*
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String fileName = request.getSession().getServletContext()
					.getRealPath("/")
					+ relativeFilePath;
			fileName = fileName.replace("\\", "/");//统一分隔符格式
			File file = new File(fileName);
			//如果文件不存在
			if (file == null || !file.exists()) {
				String msg = "file not exists!";
				System.out.println(msg);
				PrintWriter out = response.getWriter();
				out.write(msg);
				out.flush();
				out.close();
				return;
			}

			String fileType = request.getSession().getServletContext()
					.getMimeType(fileName);
			if (fileType == null) {
				fileType = "application/octet-stream";
			}
			response.setContentType(fileType);
			System.out.println("文件类型是：" + fileType);
			String simpleName = fileName.substring(fileName.lastIndexOf("/")+1);
			String newFileName = new String(simpleName.getBytes(), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename="+newFileName);

			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(
					response.getOutputStream());

			byte[] buffer = new byte[1024];
			int length = 0;

			while ((length = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, length);
			}

			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * 文件上传
	 * 
	 * @param request HttpServletRequest
	 * @param relativeUploadPath 上传文件保存的相对路径，例如"upload/"，注意，末尾的"/"不要丢了
	 * @param maxSize 上传的最大文件尺寸，单位字节
	 * @param thresholdSize 最大缓存，单位字节
	 * @param fileTypes 文件类型，会根据上传文件的后缀名判断。<br>
	 * 比如支持上传jpg,jpeg,gif,png图片,那么此处写成".jpg .jpeg .gif .png",<br>
	 * 也可以写成".jpg/.jpeg/.gif/.png"，类型之间的分隔符是什么都可以，甚至可以不要，<br>
	 * 直接写成".jpg.jpeg.gif.png"，但是类型前边的"."不能丢
	 * @return
	 * serverPath为服务器地址
	 * 
	 */
	public static List<String> upload(HttpServletRequest request, String relativeUploadPath, int maxSize, int thresholdSize, String fileTypes) {
		// 设置字符编码
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		String tempPath = relativeUploadPath + "temp"; // 临时文件目录
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
					System.out.print(fileName);
				//以下为将文件名称包含后缀存入数据库
					Filepathinform filepathinform=new Filepathinform();
					//filepathinform.setFilepathzip(fileName);
				//以下为将文件名称不包含后缀存入数据库
					if(fileName.endsWith(".zip")){
						filepathinform.setFilename(fileName.replaceAll(".zip", ""));
						
					}
					else {
						filepathinform.setFilename(fileName.replaceAll(".rar", ""));
						
					}
			
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
//						//String absoluteFilePath = serverPath
//								+ relativeUploadPath + sf.format(new Date())
//								+ " " + uuid + " " + SimpleFileName;
						
						//以下为将文件名称包含后缀存入数据库
						String filepathzip=sf.format(new Date())
							   + uuid  + SimpleFileName;
//						String absoluteFilePath = serverPath
//							+ relativeUploadPath + sf.format(new Date())
//								+ " " + uuid + " " + SimpleFileName;
//					
						String absoluteFilePath = serverPath
								+ relativeUploadPath + filepathzip;
						//用javabean的方式设置压缩包的名称
						filepathinform.setFilepathzip(filepathzip);
						//保存对象到数据库中
						FilepathinformDAO filepathinformdao=new FilepathinformDAO();
						filepathinformdao.save(filepathinform);
						
						item.write(new File(absoluteFilePath));
						filePaths.add(absoluteFilePath);
						
					}
					System.out.print("这是简化的名称2");
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			System.out.print("文件太大异常");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("其他异常");
		}

		return filePaths;
	}

	/**
	 * 文件上传
	 * 
	 * @param request HttpServletRequest
	 * @param relativeUploadPath 上传文件保存的相对路径，例如"upload/"，注意，末尾的"/"不要丢了
	 * @param maxSize 上传的最大文件尺寸，单位字节
	 * @param fileTypes 文件类型，会根据上传文件的后缀名判断。<br>
	 * 比如支持上传jpg,jpeg,gif,png图片,那么此处写成".jpg .jpeg .gif .png",<br>
	 * 也可以写成".jpg/.jpeg/.gif/.png"，类型之间的分隔符是什么都可以，甚至可以不要，<br>
	 * 直接写成".jpg.jpeg.gif.png"，但是类型前边的"."不能丢
	 * @return
	 */
	public static List<String> upload(HttpServletRequest request, String relativeUploadPath, int maxSize, String fileTypes) {
		return upload(request, relativeUploadPath, maxSize, 5*1024, fileTypes);
	}
	
	/**
	 * 文件上传，不限大小
	 * 
	 * @param request HttpServletRequest
	 * @param relativeUploadPath 上传文件保存的相对路径，例如"upload/"，注意，末尾的"/"不要丢了
	 * @param fileTypes 文件类型，会根据上传文件的后缀名判断。<br>
	 * 比如支持上传jpg,jpeg,gif,png图片,那么此处写成".jpg .jpeg .gif .png",<br>
	 * 也可以写成".jpg/.jpeg/.gif/.png"，类型之间的分隔符是什么都可以，甚至可以不要，<br>
	 * 直接写成".jpg.jpeg.gif.png"，但是类型前边的"."不能丢
	 * @return
	 */
	public static List<String> upload(HttpServletRequest request, String relativeUploadPath, String fileTypes) {
		return upload(request, relativeUploadPath, -1, 5*1024, fileTypes);
	}
}
