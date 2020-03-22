<%@ page import="com.javaee.code.Test.model.StudentHomework" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/3/21
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师选择</title>
    <%
        List<StudentHomework> homeworklist = (List<StudentHomework>) request.getAttribute("list");
    %>

    <script type="text/javascript">

       //  function aclick () {
       //     window.location.href='displayhomework.jsp';
       //     session.setAttribute("homeworklist",homeworklist);
       // }

    </script>
</head>
<body>

  <%
      List<StudentHomework> list = (List<StudentHomework>) request.getAttribute("list");
  %>
  <h1 align="center"><a href="adds.jsp">添加学生 </a></h1>
  <h1 align="center"><a href="addh.jsp">添加作业 </a></h1>
  <h1 align="center"><a href="javascript:void(0)" onclick="window.location.href='displayhomework.jsp';
           <%request.getSession().setAttribute("homeworklist",list);%>">查看作业 </a></h1>

</body>
</html>
