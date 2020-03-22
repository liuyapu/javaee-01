<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/3/16
  Time: 16:27
  To change this template use File | Settings | File Templates.
  登陆界面，验证学生老师登录
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .form1{
            width: 500px;
            height: 500px;
        }
    </style>
</head>
<body>
<div align="center">
    <form class = "form1" method="post" action="/login">

        <fieldset align = "align">
            <legend align="left">登陆页面</legend><br>
            用户名:&nbsp;&nbsp;<input name = "user_id" type="text"><br><br>
            &nbsp;密&nbsp;&nbsp;码:&nbsp;&nbsp;<input name="user_password" type="password"><br><br>
            类型: &nbsp;<input type="radio" name = "c3" value="teacher" checked = "checked"/>教师
            &nbsp;<input type="radio" name = "c3" value="student" />学生<br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "submit" name = "submit" value="登录"/>
            &nbsp;&nbsp;&nbsp;&nbsp;<input type = "button" name = "reset" value="重置"/>
        </fieldset>

    </form>
</div>
</body>
</html>
