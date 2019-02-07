<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register form</title>
</head>
<body>
<h1>
    Fill in the form to register:
</h1>
<form action="/register" method="post">
    User name that would be your login:<input type="text" name="login"/><br/><br/>
    Password:<input type="password" name="password"/><br/><br/>
    <input type="submit" value="REGISTER"/>
</form>
</body>
</html>
