package test;

import java.util.List;

import org.apache.commons.collections.set.ListOrderedSet;

import com.pu.dao.FilepathinformDAO;
import com.pu.dao.UserDAO;
import com.pu.pojo.Filepathinform;
import com.pu.pojo.User;

public class testdao {

	public static void main (String args[]){
//		User use=new User("xingm","mima","yoxuiang","jihuoma",123);
//		System.out.print(use.getEmail());
//		UserDAO userdao=new UserDAO();
//		userdao.save(use);
//		
//		
//		Filepathinform finform=new Filepathinform("NIHAO","HAHA","KEYI","HEIHEI",2);
//		System.out.print(finform.getFilename());
//		FilepathinformDAO fileinf=new FilepathinformDAO();
//		fileinf.save(finform);
		
//		 String filename="NIHAO12.jpg";
//		 String[] names = filename.split("\\.");
//	     System.out.println(names[0]);
//		 FilepathinformDAO filepathinformDAO=new FilepathinformDAO();
//		 List<Filepathinform> list=filepathinformDAO.findByFilename(names[0]);
//		// System.out.print(list.get(0).getFilename());
//		 if(list != null && list.size() != 0){
//			 list.get(0).setPreimgurl("img/pr.jpg");
//			 filepathinformDAO.attachDirty(list.get(0));
//			 
//		 }else{
//			 System.out.print("meiyoushujuku");
//			 
//		 }
//		
		String imgfilename ="img.zip";
		String[] names = imgfilename.split("\\.");
		System.out.print(names[1]);
		
	}
	}