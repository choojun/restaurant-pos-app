<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>View Item</title>
</head>
<body>
    <h1>View Item</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        <tr>
            <td><c:out value="${item.id}"/></td>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.description}"/></td>
        </tr>
    </table>
    <br/>
    <a href="${pageContext.request.contextPath}/items/list">Back to List</a>
</body>
</html>