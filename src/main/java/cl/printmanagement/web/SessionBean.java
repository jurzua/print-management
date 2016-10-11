package cl.printmanagement.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(eager=true)
@SessionScoped
public class SessionBean extends AbstractBean {

	private List<String> msgList = new ArrayList<String>();
	
	public SessionBean(){
		
		try {
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println("Starting SessionBean!!!");
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		} catch (Exception e) {
			addInternalError(e);
		}
	}
	
	
	public void listenerCloseMessageDialog(AjaxBehaviorEvent event){
		System.out.println("listenerCloseMessageDialog");
		this.msgList = new ArrayList<String>();
	}
	
	public boolean isShowMessageDialog(){
		return msgList != null && !msgList.isEmpty();
	}

	public List<String> getMsgList() {
		return msgList;
	}

	public void setMsgList(List<String> msgList) {
		this.msgList = msgList;
	}
}
