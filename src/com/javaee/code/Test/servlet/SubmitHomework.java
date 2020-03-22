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
import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/submithomework")
public class SubmitHomework extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");//
        //新建一个StudentHomework对象,用于存储待提交的作业
        StudentHomework sh = new StudentHomework();

        sh.setHomeworkId(Long.parseLong(req.getParameter("homeworkid")));
        sh.setStudentId(Long.parseLong(req.getParameter("studentid")));
        sh.setHomeworkTitle(req.getParameter("homeworktitle"));
        sh.setHomeworkContent(req.getParameter("homeworkcontent"));
        String str = req.getParameter("homeworktime");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sh.setCreateTime(date);
        sh.setUpdateTime(new Date());
        Boolean bl = StudentHomeworkJdbc.submithomework(sh);
        if(bl){
            System.out.println("数据更新成功");
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        }
        else{
            //数据更新失败，即之前并未提交过，将数据插入表内
            System.out.println("数据更新失败");
            sh.setCreateTime(new Date());
            sh.setUpdateTime(new Date());
            if(StudentHomeworkJdbc.insertstudenthomework(sh)){
                //JOptionPane.showMessageDialog(null, "作业提交成功");
                req.getRequestDispatcher("success.jsp").forward(req, resp);
                System.out.println("数据插入成功");
            }
            else{
                System.out.println("数据插入失败");
                req.getRequestDispatcher("failed.jsp").forward(req, resp);
            }

        }
//
        String s1 = req.getParameter("l");
        System.out.println("作业是"+s1);
    }
}