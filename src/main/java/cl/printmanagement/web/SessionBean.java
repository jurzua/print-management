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
	
	public User loadUser(){
		
		String userIdString = this.pageContext.getRequest().getParameter("userId");
		Long userId = Long.parseLong(userIdString);
		User user = DBService.getInstance().getUser(userId);
		
		return user;
	}
	
	/**
	 * Este método es usado para eliminar un usuario. 
	 * El usuario es selecionado por su id que viene como parametro de la request.
	 */
	public void removeUser(){
		String userIdString = this.pageContext.getRequest().getParameter("userId");
		Long userId = Long.parseLong(userIdString);
		User user = DBService.getInstance().getUser(userId);
		try {
			DBService.getInstance().removeDBEntry(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveEditingUser(){
		
		String userIdString = this.pageContext.getRequest().getParameter("userId");
		Long userId = Long.parseLong(userIdString);
		User user = DBService.getInstance().getUser(userId);
		
		String userName = this.pageContext.getRequest().getParameter("userName");
		String password = this.pageContext.getRequest().getParameter("password");
		String role = this.pageContext.getRequest().getParameter("role");
		String email = this.pageContext.getRequest().getParameter("email");
		String firstName = this.pageContext.getRequest().getParameter("firstName");
		String lastName = this.pageContext.getRequest().getParameter("lastName");

		user.setPassword(password);
		user.setUserName(userName);
		user.setRole(role);
		user.setEmail(email);
		user.setLastName(lastName);
		user.setFirstName(firstName);
		
		try {
			DBService.getInstance().saveDBEntry(user);
			System.out.println("Edit User OK " + user);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
				System.out.println("User found " + this.currentUser);
			}
		}
		if(this.currentUser == null){
			System.out.println("User NOT found " + this.currentUser);
		}
		return currentUser != null;
	}
	
	public void logout(){
		this.currentUser = null;
	}

	public void createUser() {

		String userName = this.pageContext.getRequest().getParameter("userName");
		String password = this.pageContext.getRequest().getParameter("password");
		String role = this.pageContext.getRequest().getParameter("role");
		String email = this.pageContext.getRequest().getParameter("email");
		String firstName = this.pageContext.getRequest().getParameter("firstName");
		String lastName = this.pageContext.getRequest().getParameter("lastName");
		
		User user = new User();
		user.setPassword(password);
		user.setUserName(userName);
		user.setRole(role);
		user.setEmail(email);
		user.setLastName(lastName);
		user.setFirstName(firstName);
		
		try {
			DBService.getInstance().saveDBEntry(user);
			System.out.println("User saved OK " + user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
