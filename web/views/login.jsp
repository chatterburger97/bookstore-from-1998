<%-- 
    Document   : login
    Created on : Apr 24, 2018, 12:30:35 PM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <header>
            <c:if test="${not empty sessionScope.currentUserID}">
                <c:if test="${sessionScope.currentUserRole  == 'usr'}">
                    <p>You are logged in as user <span style="color:greenyellow">${sessionScope.currentUserName}</span> </p>
                </c:if>
                <c:if test="${sessionScope.currentUserRole  == 'admin'}">
                    <p>You are logged in as admin <span style="color:orange">${sessionScope.currentUserName}</span> </p>
                </c:if>                
                <a href="${pageContext.request.contextPath}/user/view">Continue to browse books as  ${sessionScope.currentUserName}</a>

            </c:if>
            <c:if test="${empty sessionScope.currentUserID}">
                <a href="${pageContext.request.contextPath}/views/user/browsebooks.jsp">Continue to browse books as guest</a>
            </c:if>
        </header>
        <form method="POST" action="${pageContext.request.contextPath}/login">
            <label for="username">User Name</label>
            <input type="text" id="username" name="username"/>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
            <input type="submit" value="Submit!"/>
        </form>
    </body>
</html>
