<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login form</title>
</head>
<body>
<h1>
    Put your login and password in the form to login:
</h1>
<form action="/login" method="post">
    Login:   <input type="text" name="login"/><br/><br/>
    Password:<input type="password" name="password"/><br/><br/>
    <input type="submit" value="LOGIN"/>
</form>
</body>
</html>
