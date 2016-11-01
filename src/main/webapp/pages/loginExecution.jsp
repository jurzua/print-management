<jsp:useBean id="sessionBean" class="cl.printmanagement.web.SessionBean" scope="session" />
<jsp:setProperty name="sessionBean" property="pageContext" value="${pageContext}" />

<% 
	sessionBean.loginUser(); 
	
	response.sendRedirect(sessionBean.getAppBean().getContextRoot() + "/pages/userList.jsp");
%>





