<%-- 
    Document   : browsebooks
    Created on : Apr 23, 2018, 3:35:52 PM
    Author     : chatterburger
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
                <p>${requestScope.allBooks}</p>
                    <c:forEach items="${requestScope.allBooks}" var="bookDetails">
                        <p>Inside the foreach loop : ${bookDetails} </p>
                        <tr>
                            <td>${bookDetails.ID}</td>
                            <td>${bookDetails.title}</td>
                            <td>${bookDetails.author}</td>
                            <td>${bookDetails.genre}</td>
                            <td>${bookDetails.description}</td>
                            <td>${bookDetails.ISBN}</td>
                            <td>
                                <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/ViewBook" method="get">
                                    <input type="hidden" name="bookID" value="${bookDetails.ID}">
                                    <button type="submit" class="btn btn-warning">See detail</button>
                                </form>
                                <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/AddToCart" method="post">
                                    <input type="hidden" name="bookID" value="${bookDetails.ID}">
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
                    <div align="center">No  books in stock.</div>
                </div>
            </c:if>
    </body>
</html>
