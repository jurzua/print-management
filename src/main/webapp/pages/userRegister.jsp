<%@page import="cl.printmanagement.bo.Print"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="sessionBean" class="cl.printmanagement.web.SessionBean" scope="session" />
<jsp:setProperty name="sessionBean" property="pageContext" value="${pageContext}" />

<html>
	<head>
	</head>
	
	<body>
		<a href="userList.jsp">Lista Usuario</a></br>
		<a href="login.jsp">Volver</a></br>
		
		<h1>Registrar Usuario</h1>
	</body>
</html>