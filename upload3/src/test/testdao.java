package test;

import com.pu.dao.UserDAO;
import com.pu.pojo.User;

public class testdao {

	public static void main (String args[]){
		User use=new User("xingm","mima","yoxuiang","jihuoma",123);
		System.out.print(use.getEmail());
		UserDAO userdao=new UserDAO();
		userdao.save(use);
		
	}
	
}
