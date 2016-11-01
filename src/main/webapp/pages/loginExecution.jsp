<jsp:useBean id="sessionBean" class="cl.printmanagement.web.SessionBean" scope="session" />
<jsp:setProperty name="sessionBean" property="pageContext" value="${pageContext}" />

<% 
	sessionBean.login(); 
	if(sessionBean.getCurrentUser() != null){
		response.sendRedirect(sessionBean.getAppBean().getContextRoot() + "/pages/userList.jsp");
	}else{
		response.sendRedirect(sessionBean.getAppBean().getContextRoot() + "/pages/login.jsp");	
	}
	
%>





