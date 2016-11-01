<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form method="post" action="login.jsp">
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
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Usuario Incorrecto <a href="userRegister.jsp">Registrarse Aqui</a></td>
                    </tr>
                </tbody>
        </form>
    </body>
</html>