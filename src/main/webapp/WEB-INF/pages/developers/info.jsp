<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>DevInfo</title>
</head>
<body>
<h1>
    About Developer: <br>
</h1>

<%--@elvariable id="developer" type="mate.academy.springdemo.dto.output.DeveloperDtoOutput"--%>
<c:out value = "${developer}" >
  Developer name is:  ${developer.name} <br>
    ${developer.name} 's age is:  ${developer.age}<br>
    ${developer.name} 's salary is ${developer.salary}<br>
</c:out>
</body>
</html>
