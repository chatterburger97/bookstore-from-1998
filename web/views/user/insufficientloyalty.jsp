<%-- 
    Document   : creditcardpayment
    Created on : Apr 26, 2018, 4:55:31 AM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pay by credit card</title>
    </head>
    <body>
        <c:if test="${not empty requestScope.errorMessage}">
            <p>${errorMessage}</p>
        </c:if>
        <p>Cart subtotal : ${requestScope.cartTotal}<p>
        <p>Your loyalty points : ${requestScope.loyaltyPoints}<p>
        <p>Balance to pay after using loyalty points : ${requestScope.adjustedTotal}<p>
        <a href="${pageContext.request.contextPath}/user/cart">Cancel checkout/Back to cart</a>
        <form action="${pageContext.request.contextPath}/user/checkout" method="GET">
            <input type="hidden" name="paymentMethod" value="creditcard"/>
            <input type="hidden" name="adjustedTotal" value="${requestScope.adjustedTotal}"/>
            <input type="submit" value="proceed to pay balance with creditcard"/>
        </form>
    </body>
</html>
