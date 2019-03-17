<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Create developer</title>
</head>
<body>
<form method="POST" action="http://localhost:8080/springdemo_war_exploded/developer/create">
    <h2>Create developer</h2>
    <label for="name">Name</label>
    <input id="name" name="name" type="text"/>
<br>
    <label for="age">Age</label>
    <input id="age" name="age" type="number"/>
<br>
    <label for="salary">Salary</label>
    <input id="salary" name="salary" type="number"/>
<br>
    <input value="Create developer" type="submit">
</form>
</body>
</html>
