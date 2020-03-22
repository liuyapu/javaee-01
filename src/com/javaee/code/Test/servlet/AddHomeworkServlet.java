package com.javaee.code.Test.servlet;

import com.javaee.code.Test.jdbc.StudentHomeworkJdbc;
import com.javaee.code.Test.model.Student;
import com.javaee.code.Test.model.StudentHomework;
import com.javaee.code.Test.model.TeacherHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addh")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");//
        TeacherHomework sh = new TeacherHomework();
        /**
         * 赋值
         */
        sh.setHomework_id(Long.parseLong(req.getParameter("homework_id")));
        sh.setHomeworkTitle(req.getParameter("title"));
        sh.setHomeworkContent(req.getParameter("content"));
        sh.setCreateTime(new Date());
        sh.setUpdateTime(new Date());

        Boolean result = StudentHomeworkJdbc.addTeacherHomework(sh);
        if(result) {
            resp.getWriter().println("添加作业成功！");
        }else{
            resp.getWriter().println("添加作业失败！" );
        }
    }
}
