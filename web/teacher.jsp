<%@ page import="com.javaee.code.Test.model.TeacherHomework" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/3/12
  Time: 21:24
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

<h1 align="center">老师欢迎</h1>
<table align="center" width = "960" border="1"
       bgcolor="white" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fff00" height = "50">

        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>创建时间</td>
    </tr>
    <%
        List<TeacherHomework> list2 = (List<TeacherHomework>) request.getAttribute("list2");

        if(null == list2 || list2.size() <= 0){
            out.print("None data.");
        }
        else{
            for(TeacherHomework sh : list2){

    %>
    <tr align="center" bgcolor="white" height = "30">
        <td><%=sh.getHomework_id()%></td>

        <td><%=sh.getHomeworkTitle()%></td>
        <td><%=sh.getHomeworkContent()%></td>
        <td><%=sh.getCreateTime()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<div align="center">
    <input style="height: 40px;width: 60px;" align="center" onclick="window.location.href='addh.jsp';" type = "button" name = "submit" value="添加"/>
</div>


</body>
</html>
