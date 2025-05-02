<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Item List</title>
</head>
<body>
    <h1>Item List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>View</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="item" items="${items}">
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.description}"/></td>
                <td><a href="${pageContext.request.contextPath}/items/view/${item.id}">View</a></td>
                <td><a href="${pageContext.request.contextPath}/items/edit/${item.id}">Edit</a></td>
                <td><a href="${pageContext.request.contextPath}/items/delete/${item.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="${pageContext.request.contextPath}/items/create">Create New Item</a>
</body>
</html>