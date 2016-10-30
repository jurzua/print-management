<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="sessionBean" class="cl.printmanagement.web.SessionBean" scope="session" />
<jsp:setProperty name="sessionBean" property="pageContext" value="${pageContext}" />

<html>
	<head>
	</head>
	
	<body>
	
		<h1>Lista Usuarios</h1>
			<a href="pages/prints.jsp">Volver</a></br>
		<a href="pages/userRegister.jsp">Registrar Usuario</a></br>
	
		<!-- used http://www.tablesgenerator.com/html_tables -->
		<table class="tg">
			<tr>
				<th>Nombre Usuario</th>
				<th>Funcion</th>
				<th>Computador</th>
				<th>Numero de Documentos Impresos</th>
			</tr>
			
			<% for(User user : sessionBean.getUserList()) { %>
			
			<tr>
				<td><%=user.getName() %></td>
			</tr>
			
			<% } %>
		</table>
	</body>
</html>