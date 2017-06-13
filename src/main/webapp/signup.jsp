<%--
  Created by IntelliJ IDEA.
  User: Tony.Jaa
  Date: 2017/6/13
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>注册</h1>
<form action="student" method="post">
    <input type="hidden" name="action" value="register">
    <input type="text" name="nick" placeholder="昵称"><br>
    <input type="text" name="mobile" placeholder="手机号"><br>
    <input type="password" name="password" placeholder="密码"><br>
    <input type="submit" value="注册">
</form>
</body>
</html>
