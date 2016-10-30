<%@page import="cl.printmanagement.bo.Print"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="sessionBean" class="cl.printmanagement.web.SessionBean" scope="session" />
<jsp:setProperty name="sessionBean" property="pageContext" value="${pageContext}" />

<html>
	<head>
	</head>
	
	<body>
		<a href="<%=sessionBean.getAppBean().getContextRoot() %>/pages/userList.jsp">Lista Usuario</a></br>
		<a href="<%=sessionBean.getAppBean().getContextRoot() %>/pages/login.jsp">Volver</a></br>
		
		<h1>Registrar Usuario</h1>
		
		<form action="registerExecution.jsp" method="GET">
			
			<table>
				<tr>
					<td>Nombre usuario</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" /></td>
				</tr>
			</table>
			
			
			<input type="submit" value="Guardar" />
		</form>
		
	</body>
</html>