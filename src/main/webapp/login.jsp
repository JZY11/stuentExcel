<%--
  Created by IntelliJ IDEA.
  User: Tony.Jaa
  Date: 2017/6/13
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>主页</h1>
<form action="student" method="post">
    <input type="hidden" name="action" value="add">
    <input type="text" name="name" value="姓名"><br>
    <input type="text" name="gender" value="性别"><br>
    <input type="text" name="age" value="年龄"><br>
    <input type="text" name="education" value="学历">
    <input type="submit" value="添加">
</form>
</body>
</html>
