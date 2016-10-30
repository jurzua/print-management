<%@page import="cl.printmanagement.bo.Print"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="sessionBean" class="cl.printmanagement.web.SessionBean" scope="session" />
<jsp:setProperty name="sessionBean" property="pageContext" value="${pageContext}" />

<html>
	<head>
	</head>
	
	<body>
			<a href="userRegister.jsp">Registrar Usuario</a></br>
			<a href="prints.jsp">Volver</a></br>
		<h1>Lista Usuarios</h1>
			
		<!-- used http://www.tablesgenerator.com/html_tables -->
		<table class="tg">
			<tr>
				<th>Nombre Usuario</th>
				<th>Funcion</th>
				<th>Computador</th>
				<th>Numero de Documentos Impresos</th>
			</tr>
			
			<% for(Print print : sessionBean.getPrintList()) { %>
			
			<tr>
				<td><%=print.getUser() %></td>
				<td><%=print.getFunction() %></td>
				<td><%=print.getComputer() %></td>
				<td><%=print.getNumberPrints() %></td>
			</tr>
			
			<% } %>
		</table>
	</body>
</html>