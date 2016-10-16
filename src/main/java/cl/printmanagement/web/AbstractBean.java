package cl.printmanagement.web;

import java.util.ArrayList;

import javax.faces.context.FacesContext;


public class AbstractBean {
	public static String BEAN_APP = "appBean";
	public static String BEAN_SESSION = "sessionBean";
	
	protected SessionBean getSession(){
		SessionBean session = 
			((SessionBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(BEAN_SESSION));
		
		if(session == null){
			session = new SessionBean();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(BEAN_SESSION, session);
		}
		
		return session;
	}
	
	protected Object getRequestBean(String name){
		return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(name);
	}
	
	public void addMsg(String msg){
		if(getSession().getMsgList() == null)
			getSession().setMsgList(new ArrayList<String>());
		getSession().getMsgList().add(msg);
	}
	
	public ApplicationBean getAppBean(){
		return ApplicationBean.getInstance();
	}
	
	public void addInternalError(Exception e){
		e.printStackTrace();
		addMsg("Internal Error: " + e.getMessage());
	}
}
