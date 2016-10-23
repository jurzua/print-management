package cl.printmanagement.web;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cl.printmanagement.DBService;
import cl.printmanagement.bo.Print;
import cl.printmanagement.bo.User;

//AAAAAAAAAAAAA
public class SessionBean extends JSPWrapper{
	
	private static final Logger logger = Logger.getLogger(SessionBean.class);
	
	
	/**
	 * Contructor, se crea solo una vez
	 */
	public SessionBean(){
	}
		
	public List<Print> getPrintList() {
		return DBService.getInstance().getPrintList();
	}

	public List<User> getUserList(){
		return DBService.getInstance().getUserList();
	}
	
	public void registerUser(){
		String name = null;
		String password = null;
		String email = null;
		
		User user = new User();
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		
		try {
			DBService.getInstance().saveDBEntry(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
