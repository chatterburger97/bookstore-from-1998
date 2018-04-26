<%-- 
    Document   : changeqty
    Created on : Apr 26, 2018, 1:07:52 PM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm delete book</title>
    </head>
    <body>
        <p> Are you sure you want to remove ${requestScope.bookName} ?</p>
        <form action="${pageContext.request.contextPath}/admin/remove" method="POST">
            <input type="hidden" id="bookID" name="bookID" value="${requestScope.bookID}"/>
            <input type="submit" value="Confirm removal"/>
        </form>
    </body>
</html>
