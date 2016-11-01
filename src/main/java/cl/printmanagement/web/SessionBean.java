package cl.printmanagement.web;

import java.util.List;

import org.apache.log4j.Logger;

import cl.printmanagement.DBService;
import cl.printmanagement.bo.Print;
import cl.printmanagement.bo.User;

//AAAAAAAAAAAAA
public class SessionBean extends JSPWrapper {

	private static final Logger logger = Logger.getLogger(SessionBean.class);

	private User currentUser;
	
	/**
	 * Contructor, se crea solo una vez
	 */
	public SessionBean() {
	}

	public List<Print> getPrintList() {
		return DBService.getInstance().getPrintList();
	}

	public List<User> getUserList() {
		return DBService.getInstance().getUserList();
	}

	public int getPrintNumber(String userName) {
		List<Print> list = DBService.getInstance().getPrintList(userName);
		return list.size();
	}
	
	public boolean login(){
		String userName = this.pageContext.getRequest().getParameter("userName");
		String password = this.pageContext.getRequest().getParameter("password");
		
		for(User user : DBService.getInstance().getUserList()){
			if(user.getPassword().equals(password) && user.getUserName().equals(userName)){
				this.currentUser = user;
			}
		}
		return currentUser != null;
	}

	public void createUser() {

		String userName = this.pageContext.getRequest().getParameter("userName");
		String password = this.pageContext.getRequest().getParameter("password");

		User user = new User();
		user.setPassword(password);
		user.setUserName(userName);

		try {
			DBService.getInstance().saveDBEntry(user);
			System.out.println("User saved OK " + user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void loginUser(){
		
		
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
