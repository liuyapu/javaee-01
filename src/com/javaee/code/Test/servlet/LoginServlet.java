package com.javaee.code.Test.servlet;

import com.javaee.code.Test.jdbc.StudentHomeworkJdbc;
import com.javaee.code.Test.model.Student;
import com.javaee.code.Test.model.StudentHomework;
import com.javaee.code.Test.model.Teacher;
import com.javaee.code.Test.model.TeacherHomework;
import com.sun.deploy.util.StringUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");//
        //先获取是老师还是学生登录

        Long user_id;
        String string_id = req.getParameter("user_id");
        String password = req.getParameter("user_password");
        if(password==null || password == "" || string_id == null || string_id == ""){
            System.out.println("用户id或密码不能为空！");

            JOptionPane.showMessageDialog(null, "账号密码不能为空");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        else{
            user_id = Long.parseLong(string_id);
            if(req.getParameter("c3").equals("student")){
                System.out.println("是学生");
                Student s = new Student();

                s.setStudentId(user_id);

                //s.setStudent_name(req.getParameter("student_name"));
                s.setStudent_password(password);
                //s.setCreateTime(new Date());
                Boolean result = StudentHomeworkJdbc.loginS(s);
                if(result){
                    System.out.println("该学生登录成功");  //进入学生界面
                    List<TeacherHomework> homework_list = StudentHomeworkJdbc.selectAll2();

                    req.setAttribute("student_id",user_id);
                    req.setAttribute("homework_list",homework_list);
                    req.getRequestDispatcher("submith.jsp").forward(req, resp);
                }
                else{
                    System.out.println("密码错误");
                    JOptionPane.showMessageDialog(null, "密码错误");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            }
            else{
                System.out.println("是老师");
                Teacher t = new Teacher();
                t.setTeacher_id(user_id);
                t.setTeacher_password(password);

                Boolean result = StudentHomeworkJdbc.loginT(t);
                if(result){
                    System.out.println("该老师登录成功");  //进入学生界面
                    //获取作业列表,并将list传递到就是jsp界面
                    List<StudentHomework> list = StudentHomeworkJdbc.selectAll();

                    req.setAttribute("list",list);

                    req.getRequestDispatcher("choice.jsp").forward(req, resp);
                }
                else{
                    System.out.println("密码错误");
                    JOptionPane.showMessageDialog(null, "密码错误");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            }
        }

    }
}
