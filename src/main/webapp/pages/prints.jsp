<%@page import="cl.printmanagement.bo.Print"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="sessionBean" class="cl.printmanagement.web.SessionBean" scope="session" />
<jsp:setProperty name="sessionBean" property="pageContext" value="${pageContext}" />

<html>
	<head>
	</head>
	
	<body>
	
		<a href="pages/userList.jsp">User List</a></br>
		<a href="pages/userRegister.jsp">User Register</a></br>
	
		<!-- used http://www.tablesgenerator.com/html_tables -->
		<table class="tg">
			<tr>
				<th>Fecha</th>
				<th>Impresora</th>
				<th>Usuario</th>
				<th>Computador</th>
				<th>Documento</th>
			</tr>
			
			<% for(Print print : sessionBean.getPrintList()) { %>
			
			<tr>
				<td><%=print.getFormattedCreationTime() %></td>
				<td><%=print.getPrinter() %></td>
				<td><%=print.getUser() %></td>
				<td><%=print.getComputer() %></td>
				<td><%=print.getDocument() %></td>
			</tr>
			
			<% } %>
		</table>
	
	</body>
</html>