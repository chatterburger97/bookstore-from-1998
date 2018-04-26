<%-- 
    Document   : checkoutsuccessful
    Created on : Apr 26, 2018, 10:39:32 AM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout successful</title>
    </head>
    <body>
        <p> Checked out successfully</p>
        <p>${requestScope.successMessage}</p>
    </body>
</html>
