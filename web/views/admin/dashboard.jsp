<%-- 
    Document   : dashboard
    Created on : Apr 23, 2018, 3:41:30 PM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
    </head>
    <body>
    <header>
        <%@ include file="./templates/header.jspf"%>
    </header>
    <h1>All books in stock : </h1>
    <form action="${pageContext.request.contextPath}/admin/addbook" method="GET">
        <input type="submit" value="Add new book"/>
    </form>
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
                    <th><b>Price</b></th>  
                    <th><b>Quantity</b></th>
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
                       <td>${bookDetail.price}</td>
                       <td>${bookDetail.description}</td>
                       <td>${bookDetail.quantity}</td>
                       <td>
                          <a href="../admin/changeBook?bookID=${bookDetail.id}&changeType=modify">Modify book details</a>
                       </td>
                       <td>
                           <a href="../admin/changeBook?bookID=${bookDetail.id}&changeType=remove">Remove book</a>
                       </td>
                       <td>
                           <a href="../admin/changeBook?bookID=${bookDetail.id}&changeType=qty">Update stock</a>
                       </td>
                       <td>
                           <a href="../admin/changeBook?bookID=${bookDetail.id}&changeType=qty">Update price</a>
                       </td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
</body>
</html>
