<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Create developer</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<button id="addProject" type="button">ADD PROJECT</button>
<label for="projectName">Project name: </label><input type="text" id="projectName">
<label for="projectCost">Project cost: </label><input type="text" id="projectCost">
<label for="projectCompany">Project company: </label><input type="text" id="projectCompany">
<label for="projectCustomer">Project customer: </label><input type="text" id="projectCustomer">
<label for="projectDevelopers">Project developers: </label><input type="text" id="projectDevelopers">
<script>
    $("#addProject").click(onProjectAddClick);

    function onProjectAddClick() {
        alert("click");
        var urlGet = "http://localhost:8080/springdemo_war_exploded/project/add";
        var projectCreateInput = {
            "name": $("#projectName").val(),
            "cost":$("#projectCost").val(),
            "company":$("#projectCompany").val(),
            "customer":$("#projectCustomer").val(),
            "projectDevelopers":$("#projectDevelopers").val()
        };
        $.ajax({
            url: urlGet,
            method: "POST",
            data: JSON.stringify(projectCreateInput),
            success: function (resp) {
                console.log("Get all projects response: " + resp);
                drawDevelopers(resp);
            },
            error: function (err) {
                console.log("Get all projects response ERROR: " + err)
            },
            contentType: "application/json",
            dataType: "json"
        });
    }



</script>
<%--<form method="POST" action="${contextPath}/project/add">--%>
    <%--<h2>ADD NEW PROJECT</h2>--%>
    <%--<label for="name">Name</label>--%>
    <%--<input id="name" name="name" type="text"/>--%>
    <%--<br>--%>
    <%--<label for="cost">Cost</label>--%>
    <%--<input id="cost" name="cost" type="number"/>--%>
    <%--<br>--%>
    <%--<label for="customer">Customer</label>--%>
    <%--<input id="customer" name="customer" type="text"/>--%>
    <%--<br>--%>
    <%--<label for="company">Company</label>--%>
    <%--<input id="company" name="company" type="text"/>--%>
    <%--<br>--%>
    <%--<label for="developersList">Developer</label>--%>
    <%--<input id="developersList" name="developersList" type="text"/>--%>
    <%--<br>--%>
    <%--<input value="Add project" type="submit">--%>
<%--</form>--%>
</body>
</html>
