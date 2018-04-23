<%-- 
    Document   : index
    Created on : Apr 14, 2018, 7:43:17 PM
    Author     : chatterburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello Form</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="HelloFormServlet">
            <input type="text" name="first_name"/>
            <input type="text" name="last_name"/>
            <input type="submit"/>
        </form>
    </body>
</html>
