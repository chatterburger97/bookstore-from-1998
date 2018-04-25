<%-- 
    Document   : browsebooks
    Created on : Apr 23, 2018, 3:35:52 PM
    Author     : chatterburger
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <table border="1">
            <thead>
                <tr>
                    <th><b>Book ID</b></th>
                    <th><b>Title</b></th>
                    <th><b>Author</b></th>
                    <th><b>Genre/Category</b></th>
                    <th><b>Short description</b></th>
                    <th><b>ISBN</b></th>                        
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.allBooks}" var="bookDetail" >
                    <tr>
                       <td>${bookDetail.id}</td>
                       <td>${bookDetail.title}</td>
                       <td>${bookDetail.author}</td>
                       <td>${bookDetail.genre}</td>
                       <td>${bookDetail.ISBN}</td>
                       <td>${bookDetail.description}</td>
                       <td>
                          <a href="../addtocart?bookID=${bookDetail.id}">Add to cart</a>
                       </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
    <c:if test="${not empty sessionScope.lastAddedToCart}">
        <div>
            <div align="center">
                <p style="color:green">Successfully added the book to cart : ${sessionScope.lastAddedToCart}</p>
            </div>
        </div>
    </c:if>    
    <c:if test="${empty requestScope.allBooks}">
        <div>
            <div align="center">
                <p style="color:red">No more books in stock.</p>
            </div>
        </div>
    </c:if>
</body>
</html>
