<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Item</title>
</head>
<body>
    <h1>Edit Item</h1>
    <form:form action="${pageContext.request.contextPath}/items/edit" method="post" modelAttribute="item">
        <form:hidden path="id"/>
        <label for="name">Name:</label>
        <form:input path="name"/><br/><br/>
        <label for="description">Description:</label>
        <form:textarea path="description"/><br/><br/>
        <input type="submit" value="Update Item"/>
    </form:form>
    <br/>
    <a href="${pageContext.request.contextPath}/items/list">Back to List</a>
</body>
</html>