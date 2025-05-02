<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete Item</title>
</head>
<body>
    <h1>Delete Item</h1>
    <p>Are you sure you want to delete the item?</p>
    <p>Name: <c:out value="${item.name}"/></p>
    <p>Description: <c:out value="${item.description}"/></p>
    <form action="${pageContext.request.contextPath}/items/delete" method="post">
        <input type="hidden" name="id" value="${item.id}"/>
        <input type="submit" value="Delete"/>
    </form>
    <br/>
    <a href="${pageContext.request.contextPath}/items/list">Back to List</a>
</body>
</html>