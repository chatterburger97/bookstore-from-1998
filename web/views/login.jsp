<%-- 
    Document   : login
    Created on : Apr 24, 2018, 12:30:35 PM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form method="GET" action="${pageContext.request.contextPath}/login">
            <label for="username">User Name</label>
            <input type="text" id="username" name="username"/>
            <label for="password">Password</label>
            <input type="text" id="password" name="password"/>
            <input type="submit" value="Submit!"/>
        </form>
    </body>
</html>
