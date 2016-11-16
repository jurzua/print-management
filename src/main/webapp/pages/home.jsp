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
		
		<h1>Home</h1>
	
	</body>
</html>


