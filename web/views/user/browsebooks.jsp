<%-- 
    Document   : browsebooks
    Created on : Apr 23, 2018, 3:35:52 PM
    Author     : chatterburger
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>1998Bookstore</title>
    </head>
    <body>
        <header>
            <%@ include file="./templates/header.jspf"%>
        </header>
        <h1>Latest books : </h1>
                    <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th><h1><b>Book ID</b></h1></th>
                        <th><h1><b>Title</b></h1></th>
                        <th><h1><b>Author</b></h1></th>
                        <th><h1><b>Genre/Category</b></h1></th>
                        <th><h1><b>Short description</b></h1></th>
                        <th><h1><b>ISBN</b></h1></th>                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.allbooks}" var="book">
                        <tr>
                            <td>${book.bookID}</td>
                            <td>${book.title}</td>
                            <td>${book.authorID}</td>
                            <td>${book.genre}</td>
                            <td>${book.description}</td>
                            <td>${book.ISBN}</td>
                            <td>
                                <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/ViewBook" method="get">
                                    <input type="hidden" name="bookID" value="${book.bookID}">
                                    <button type="submit" class="btn btn-warning">See detail</button>
                                </form>
                                <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/AddToCart" method="post">
                                    <input type="hidden" name="Bookinguserid" value="${book.bookID}">
                                    <br><br>
                                    <button type="submit" class="btn btn-success">Quick Add</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
            <c:if test="${empty requestScope.allbooks}">
                <div class="alert alert-info">
                    <div align="center">No Room Assigned to the User.</div>
                </div>
            </c:if>
    </body>
</html>
