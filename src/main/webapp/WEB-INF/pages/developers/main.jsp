<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--@elvariable id="developer" type="mate.academy.springdemo.dto.output.DeveloperDtoOutput"--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Developers</title>
</head>
<body>
<h1>
    Developers List:
</h1>
<%--@elvariable id="developers" type="java.util.List"--%>
<c:forEach items = "${developers}" var = "developer">
    ${developer}<br>
</c:forEach>
</body>
</html>
