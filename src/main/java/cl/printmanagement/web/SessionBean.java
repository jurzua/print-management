package cl.printmanagement.web;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cl.printmanagement.DBService;
import cl.printmanagement.bo.Print;

//AAAAAAAAAAAAA
public class SessionBean extends JSPWrapper{
	
	private static final Logger logger = Logger.getLogger(SessionBean.class);
	
	private List<Print> printList = new ArrayList<Print>();
	
	/**
	 * Contructor, se crea solo una vez
	 */
	public SessionBean(){
	}
		
	public List<Print> getPrintList() {
		return DBService.getInstance().getPrintList();
	}

	public void setPrintList(List<Print> printList) {
		this.printList = printList;
	}
}
