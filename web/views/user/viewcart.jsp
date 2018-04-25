<%-- 
    Document   : viewcart
    Created on : Apr 25, 2018, 7:02:11 PM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
    </head>
    <body>
        <header>
            <%@ include file="./templates/header.jspf"%>
        </header>
        <p> Cart : </p>
        <table border="1">
            <thead>
                    <th><b>Book name<b></th>
                    <th><b>Unit price<b></th>
                    <th><b>Quantity</b></th>
            </thead>
            <tbody>

                <c:forEach items="${sessionScope.cart}" var="cartDetail" >
                    <tr>
                       <td>${cartDetail.value.addedBook.title}</td>
                       <td>${cartDetail.value.addedBook.price}</td>
                       <td>${cartDetail.value.qty}</td>
                       <td>
                          <a href="../removefromcart?bookID=${cartDetail.key}">Remove</a>
                       </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form method="GET" action="../user/checkout?paymentmethod=loyalty">
            <input type="submit" value="Checkout with store credit"/>
        </form>
        <form method="GET" action="../user/checkout?paymentmethod=creditcard">
            <input type="submit" value="Checkout with credit card"/>
        </form>
        <a href="../user/view"/>Browse books</a>
    </body>
</html>
