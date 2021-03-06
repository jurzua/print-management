<%@page import="cl.printmanagement.bo.User"%>
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
		
		<h1>Lista Usuarios</h1>
			
		<!-- used http://www.tablesgenerator.com/html_tables -->
		<%if (sessionBean.isLoggedIn()){%>
			<%if (sessionBean.isUserAdmin()){%>				
				<table class="tg">
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Nombre Usuario</th>
						<th>Rol</th>
						<th>Correo</th>
						<th>Numero de Documentos Impresos</th>
						<th>Acciones</th>
						<th>Eliminar</th>
					</tr>
					
					<% for(User user : sessionBean.getUserList()) { %>
					
					<tr>
						<td><%=user.getFirstName() %></td>
						<td><%=user.getLastName() %></td>
						<td><%=user.getUserName() %></td>
						<td><%=user.getRole() %></td>
						<td><%=user.getEmail() %></td>
						<td><%=sessionBean.getPrintNumber(user.getUserName()) %></td>
						<td><a href="<%=sessionBean.getAppBean().getContextRoot() %>/pages/userEditor.jsp?userId=<%=user.getId() %>">Editar</a></td>
						<td><a href="<%=sessionBean.getAppBean().getContextRoot() %>/pages/userDeleteExecution.jsp?userId=<%=user.getId() %>">Eliminar</a></td>
					</tr>
					
					<% } %>
				</table>
			<% }else {%>
				<h2>Solo el administrador puede ver esta información.</h2>
			<% } %>	
		<% }else {%>
			<h2>Tu te tienes que loggear para ver esta informacion</h2>
		<% } %>
	</body>
</html>