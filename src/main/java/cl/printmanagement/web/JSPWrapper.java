package cl.printmanagement.web;

import javax.servlet.jsp.PageContext;

public class JSPWrapper {
	
	protected PageContext pageContext;
	
	public static String SESSION_BEAN = "sessionBean";
	private static ApplicationBean appBean;
	
	public SessionBean getSessionBean(){
		return (SessionBean)getSessionBean(SESSION_BEAN);
	}
	
	public ApplicationBean getAppBean() {
		if(appBean == null){
			appBean = new ApplicationBean();
		}
		return appBean; 
	}
	
	
	private Object getSessionBean(String beanName) {
		return this.getPageContext().getSession().getAttribute(beanName);
	}
	
	public void init(){
		System.out.println("THIS METHOD SHOULD BE IMPLEMENTED!!!!");
	}

	public PageContext getPageContext() {
		return pageContext;
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}
}
