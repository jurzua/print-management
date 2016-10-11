package cl.printmanagement.web;

public class ApplicationBean {
	
	private static ApplicationBean app;
	
	public static ApplicationBean getInstance(){
		if(app == null){
			app = new ApplicationBean();
		}
		return app;
	}

	public String getContextRoot(){
		return "http://localhost:8080/print-management";
	}
}
