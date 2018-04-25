<%-- 
    Document   : dashboard
    Created on : Apr 23, 2018, 3:41:30 PM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>All books in stock : </h1>
        <p> Todo : show the books that are in stock <b>Update prices</b> <b>Remove book</b> </p>
        <form action="${pageContext.request.contextPath}/admin/addbook" method="GET">
            <input type="submit" value="Add new book"/>
        </form>
        
    </body>
</html>
