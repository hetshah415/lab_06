<%-- 
    Document   : register
    Created on : 24 Jun, 2022, 5:09:32 PM
    Author     : het
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="shoppingList">
            <label>Username:</label>
            <input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <br>
            <input type="submit" value="Register name">
        </form>
        <p>${message}</p>
    </body>
</html>
