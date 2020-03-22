package com.javaee.code.Test.servlet;

import com.javaee.code.Test.jdbc.StudentHomeworkJdbc;
import com.javaee.code.Test.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/adds")

public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");//
        Student s = new Student();
        /**
         * 赋值
         */
        s.setStudentId(Long.parseLong(req.getParameter("student_id")));
        s.setStudent_name(req.getParameter("student_name"));
        s.setStudent_password(req.getParameter("student_id"));
        s.setCreateTime(new Date());

        Boolean result = StudentHomeworkJdbc.addStudent(s);
        if(result) {
            resp.getWriter().println("添加学生成功！");
        }else{
            resp.getWriter().println("添加学生失败！" );
        }
    }
}

