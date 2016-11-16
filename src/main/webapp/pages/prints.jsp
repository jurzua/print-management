<%@page import="cl.printmanagement.web.SessionBean"%>
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
		
		<h1>Prints</h1>
	
		<!-- used http://www.tablesgenerator.com/html_tables -->
		<%if (sessionBean.isLoggedIn()){%>
				<table class="tg">
					<tr>
						<th>Fecha</th>
						<th>Impresora</th>
						<th>Usuario</th>
						<th>Computador</th>
						<th>Documento</th>
						<th>Número de páginas</th>
					</tr>
					
					<% for(Print print : sessionBean.getPrintList()) { %>
					
					<tr>
						<td><%=print.getFormattedCreationTime() %></td>
						<td><%=print.getPrinter() %></td>
						<td><%=print.getUserName() %></td>
						<td><%=print.getComputer() %></td>
						<td><%=print.getDocument() %></td>
						<td><%=print.getPagesNumber() %></td>
					</tr>
					<% } %>
				</table>
		<% }else {%>
			<h2>Tu te tienes que loggear para ver esta informacion</h2>
		<% } %>
	</body>
</html>


