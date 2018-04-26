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
        <p>Pay by card : ${requestScope.adjustedTotal}<p>
        <a href="${pageContext.request.contextPath}/user/cart">Cancel checkout/Back to cart</a>
        <form action="${pageContext.request.contextPath}/views/user/checkoutsuccessful.jsp" method="POST">
            <input type="text" disabled name="creditcardnumber"/>
            <input type="text" disabled name="CVV"/>
            <input type="submit" value="confirm checkout"/>
        </form>
    </body>
</html>
