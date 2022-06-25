<%-- 
    Document   : shoppingList
    Created on : 24 Jun, 2022, 5:09:52 PM
    Author     : het
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        
        <h1>Shopping List</h1>
        
        Hello, ${username} 
        <br>
        <br>
        <a href=shoppingList?action=logout>Logout</a>
        
        <br>
        <h2>List</h2>
        
        <form method="post" action="shoppingList">
            <label>Add item:</label>
            <input type="text" name="item">
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add">
        </form>
        
        <br>
        
    <c:if test="${not empty itemList}">
        <form method="post" action="shoppingList">
            <c:forEach var="itemList" items="${itemList}">
                <input type="radio" name="item" value="${itemList}">${itemList}<br>
            </c:forEach>
            <br>
            <input type="hidden" name="action" value="delete">
            <input type="submit" value="Delete">         
        </form>
    </c:if>
    
</body>
</html>
