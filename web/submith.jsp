<%@ page import="com.javaee.code.Test.model.TeacherHomework" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/3/13
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1 align="center">欢迎同学</h1>
<table align="center" width = "960" border="1"
       bgcolor="white" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fff00" height = "50">

        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>创建时间</td>
        <td>作业提交</td>
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
        <td><input type="text" value="<%=sh.getHomeworkContent()%>"></td>
        <td><%=sh.getCreateTime()%></td>
        <td><input name="submit" type="submit" value="提交" /></td>
    </tr>
    <%
            }
        }
    %>
</table>


</body>
</html>
