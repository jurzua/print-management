<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<jsp:include page="head.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    	
    	<jsp:include page="menu.jsp"/>
    	
        <form method="post" action="loginExecution.jsp">
        	<table>
                <thead>
                    <tr>
                        <th colspan="2">Ingrese Aqui sus Datos</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nombre Usuario</td>
                        <td><input type="text" name="userName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                    </tr>
                </tbody>
			</table>
        </form>
    </body>
</html>