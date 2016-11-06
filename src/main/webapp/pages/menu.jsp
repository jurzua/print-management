<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="sessionBean" class="cl.printmanagement.web.SessionBean" scope="session" />
<jsp:setProperty name="sessionBean" property="pageContext" value="${pageContext}" />


<table>
	<tr>
		<td>
			<a href="<%=sessionBean.getAppBean().getContextRoot() %>/pages/prints.jsp">Home</a>
		</td>
		<td>
			<a href="<%=sessionBean.getAppBean().getContextRoot() %>/pages/userList.jsp">Lista Usuario</a>
		</td>

		
		<% if(sessionBean.getCurrentUser() != null) {%>
			<td>
				<p>Bienvenido <%= sessionBean.getCurrentUser().getUserName()%></p>
			</td>
			<td>
				<a href="<%=sessionBean.getAppBean().getContextRoot() %>/pages/logoutExecution.jsp">Logout</a>
			</td>
		<% }else { %>
			<td>
				<a href="<%=sessionBean.getAppBean().getContextRoot() %>/pages/login.jsp">Login</a>
			</td>
		<% } %>
		
		
		
		<% if(sessionBean.isUserAdmin()){ %>
			<td>
				<a href="<%=sessionBean.getAppBean().getContextRoot() %>/pages/userRegister.jsp">Crear usuario</a>
			</td>
		<% } %>
		
		
	</tr>
</table>

