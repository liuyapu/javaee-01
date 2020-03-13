<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/3/13
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加作业</title>
    <style type="text/css">
        .form1{
            width: 500px;
            height: 2000px;
        }
    </style>
</head>
<body>
<div align="center">
    <form class = "form1" method="post" action="/addh">
        <fieldset>
            <legend align="left">添加作业</legend>
            作业id: &nbsp;&nbsp;<input name = "homework_id" type="text"><br><br>
            作业标题:&nbsp;&nbsp;<input name = "title" type="text"><br><br>
            作业内容:&nbsp;&nbsp;<input name = "content" type="text"><br><br>
            发布时间:&nbsp;&nbsp;<input name= "" type="date"><br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type = "submit" name = "submit" value="添加"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type = "button" name = "reset" value="重置"/>
        </fieldset>
    </form>
</div>

</body>
</html>
