<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/3/13
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
    <style type="text/css">
        fieldset{
            width:300px;

            border:2px solid black;
            padding-left:20px;
        }
    </style>
</head>
<body>
<div align="center">
    <form method="post" action="/adds">
        <fieldset align="center">
            <legend align="left">添加学生</legend>
            学&nbsp;&nbsp;号：<input name="student_id" type="text"/><br><br>

            姓&nbsp;名：&nbsp;<input name="student_name" type="text"/><br><br>
            添加时间:&nbsp;&nbsp;<input name= "" type="date"><br><br>
            &nbsp;&nbsp;&nbsp;<input name="submit" type="submit" value="添加" />
        </fieldset>
    </form>
</div>>
</body>
</html>
