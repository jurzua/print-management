<%@page import="cl.printmanagement.bo.User"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="sessionBean" class="cl.printmanagement.web.SessionBean" scope="session" />
<jsp:setProperty name="sessionBean" property="pageContext" value="${pageContext}" />

<%
	User user = sessionBean.loadUser();
%>



<html>
	<head>
		<jsp:include page="head.jsp"/>
	</head>
	
	<body>
		<jsp:include page="menu.jsp"/>
		
		<h1>Editar Usuario</h1>
		
		<form action="editUserExecution.jsp" method="GET">
			
			<input type="hidden" name="userId" value="<%=user.getId()%>"/>
			
			<table>
				<tr>
					<td>Nombre usuario</td>
					<td><input type="text" name="userName" value="<%=user.getUserName() %>" /></td>
				</tr>
				<tr>
					<td>Nombre</td>
					<td><input type="text" name="firstName" value="<%=user.getFirstName() %>"/></td>
				</tr>
				<tr>
					<td>Apellido</td>
					<td><input type="text" name="lastName" value="<%=user.getLastName() %>"/></td>
				</tr>
				<tr>
					<td>Rol</td>
					<td>
						 <select name="role">
							  <option value="personal">Personal</option>
							  <option value="admin">Administrador</option>
						</select> 
					</td>
				</tr>
				<tr>
					<td>Correo</td>
					<td><input type="text" name="email" value="<%=user.getEmail() %>"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" value="<%=user.getPassword() %>"/></td>
				</tr>
			</table>
			
			
			<input type="submit" value="Guardar" />
		</form>
		
	</body>
