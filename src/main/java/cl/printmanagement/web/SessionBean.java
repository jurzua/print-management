package cl.printmanagement.web;


import org.apache.log4j.Logger;


public class SessionBean extends JSPWrapper{
	
	private static final Logger logger = Logger.getLogger(SessionBean.class);
	
	
	public SessionBean(){
		
	}
	
	public void test(){
		//System.out.println("Request=" + getRequest());
		//System.out.println("Response=" + getResponse());
		System.out.println(this.getPageContext().getSession().getAttribute("sessionBean"));
	}
}
