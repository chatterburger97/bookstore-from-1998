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
        <title>Change price</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/admin/changeprice" method="POST">
            <label for="qty">New Price</label>
            <input type="hidden" id="bookID" name="bookID" value="${requestScope.bookID}"/>
            <input type="number" id="qty" name="newprice"/>
            <input type="submit" name="submit" value="change price!"/>
        </form>
    </body>
</html>
