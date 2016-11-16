<%@page import="cl.printmanagement.bo.Print"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="sessionBean" class="cl.printmanagement.web.SessionBean" scope="session" />
<jsp:setProperty name="sessionBean" property="pageContext" value="${pageContext}" />

<html>
	<head>
		<jsp:include page="head.jsp"/>
	</head>
	
	<body>
		<jsp:include page="menu.jsp"/>
		
		<h1>Crear Usuario</h1>
		
		<form action="registerExecution.jsp" method="GET">
			
			<table>
				<tr>
					<td>Nombre usuario</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Nombre</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>Apellido</td>
					<td><input type="text" name="lastName" /></td>
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
					<td><input type="text" name="email" /></td>
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