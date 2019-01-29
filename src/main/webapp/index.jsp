<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

<%!
    String getFormattedDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        return sdf.format(new Date());
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring example!</title>
</head>
<body>
In WEBAPP
<h1>WELLCOME, MY FRIEND!</h1>
<i>Today is <%= getFormattedDate() %></i>
<h3>If you want to have some information about the developer or project, you can go here
<a href="WEB-INF/pages/developers/info.jsp">linkToDevInfo</a>
</h3>
</body>
</html>