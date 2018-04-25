<%-- 
    Document   : register
    Created on : Apr 25, 2018, 10:36:07 AM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register page</title>
    </head>
    <body>
        <p> Welcome, new customer. Please register a new account here : </p>
        <form method="GET" action="${pageContext.request.contextPath}/login">
            <label for="username">User Name</label>
            <input type="text" id="username" name="username"/>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
            <input type="submit" value="Submit!"/>
        </form>
        <a href="${pageContext.request.contextPath}/views/user/browsebooks.jsp">Home</a>
    </body>
</html>
