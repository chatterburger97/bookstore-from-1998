<%-- 
    Document   : addbooks
    Created on : Apr 25, 2018, 3:42:53 PM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new book</title>
    </head>
    <body>
        
        <header>
            <%@ include file="./templates/header.jspf"%>
        </header>
        <form id="addbookform" action="${pageContext.request.contextPath}/admin/view" method="GET">
            <input type="submit" value="Back to admin dashboard"/>
        </form>
        <p style="color:red">${requestScope.responsemessage}</p>
        <p> add a new book </p>
        <form action="${pageContext.request.contextPath}/admin/addbook" method="POST">
            <label for="title">Title : </label>
            <input id="title" name="title" type="text"/>
            
            <label for="author">Author : </label>
            <input id="author" name="author" type="text"/>
               
            <label for="ISBN">Genre/category : </label>
            <input id="genre" name="genre" type="text"/>
            
                        
            <label for="ISBN">ISBN : </label>
            <input id="ISBN" name="ISBN" type="text"/>
            
            
            <label for="description">Description : </label>
            <textarea form="addbookform" id="author" name="author" rows="5"></textarea>
            
            
            <input type="submit" value="Add to stock"/>
        </form>
    </body>
</html>
