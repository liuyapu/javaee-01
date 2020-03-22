<%@ page import="com.javaee.code.Test.model.TeacherHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Array" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/3/13
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    Long student_id = (Long)request.getAttribute("student_id");
%>
<h1 align="center">欢迎<%=student_id%>同学</h1>
<%
    if(student_id == null){
        out.print("请同学先登录");
    }
%>

<table align="center" width = "960" border="1"
       bgcolor="white" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fff00" height = "50">

        <td>学生id</td>
        <td>作业id</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>创建时间</td>
        <td>作业提交</td>
    </tr>
    <%
        List<TeacherHomework> list2 = (List<TeacherHomework>) request.getAttribute("homework_list");



        if(null == list2 || list2.size() <= 0){
            out.print("None data.");
        }
        else{
            int i = 0;
            for(TeacherHomework sh : list2){


    %>

    <form method="post" action="/submithomework">
        <tr align="center" bgcolor="white" height = "30" name = "l<%=i%>i%>">
            <td ><input name="studentid" value="<%=student_id%>" readonly="readonly"></td>
            <td><input name="homeworkid" value="<%=sh.getHomework_id()%>" readonly="readonly"></td>

            <td><input name="homeworktitle" value="<%=sh.getHomeworkTitle()%>" readonly="readonly"></td>
            <td><input name="homeworkcontent" type="text" value="<%=sh.getHomeworkContent()%>"></td>
            <td><input name="homeworktime" type="text" value="<%=sh.getCreateTime()%>"></td>
            <td><input name="submit" type="submit" value="提交作业" /></td>
        </tr>
    </form>

    <%
            i++;}
        }
    %>
</table>


</body>
</html>
