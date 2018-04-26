<%-- 
    Document   : updatebookdetails
    Created on : Apr 26, 2018, 3:10:49 PM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin : Update Book Details </title>
    </head>
    <body>
                
        <header>
            <%@ include file="./templates/header.jspf"%>
        </header>
        <p> Current book details : </p>
        <p>title : ${requestScope.bookToUpdate.title}</p>
        <p>genre : ${requestScope.bookToUpdate.genre}</p>
        <p>author : ${requestScope.bookToUpdate.author}</p>
        <p>ISBN : ${requestScope.bookToUpdate.ISBN}</p>
        
        <form id="updatebookform" method="POST" action="${pageContext.request.contextPath}/admin/updateBook">
            <input type="hidden" id="bookID" name="bookID" value="${requestScope.bookToUpdate.id}"/>
            <label for="title">Title : </label>
            <input id="title" name="title" type="text" placeholder="${requestScope.bookToUpdate.title}"/>
            
            <label for="author">Author : </label>
            <input id="author" name="author" type="text" placeholder="${requestScope.bookToUpdate.author}"/>
               
            <label for="ISBN">Genre/category : </label>
            <input id="genre" name="genre" type="text" placeholder="${requestScope.bookToUpdate.genre}"/>
            
                        
            <label for="ISBN">ISBN : </label>
            <input id="ISBN" name="ISBN" type="text" placeholder="${requestScope.bookToUpdate.ISBN}"/>
            
            
            <label for="description">Description : </label>
            <textarea form="updatebookform" id="description" name="description" rows="5" placeholder="${requestScope.bookToUpdate.description}"></textarea>
            <input type="submit" value="Update details"/>
        </form>
    </body>
</html>
