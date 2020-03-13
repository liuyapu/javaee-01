package com.javaee.code.Test.servlet;

import com.javaee.code.Test.jdbc.StudentHomeworkJdbc;
import com.javaee.code.Test.model.StudentHomework;
import com.javaee.code.Test.model.TeacherHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ckh")
public class chakanHomework extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TeacherHomework> list2 = StudentHomeworkJdbc.selectAll2();

        req.setAttribute("list2",list2);
        req.getRequestDispatcher("teacher.jsp").forward(req,resp);
    }
}
