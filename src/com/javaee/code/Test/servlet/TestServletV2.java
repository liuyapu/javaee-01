package com.javaee.code.Test.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServletV2 extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        resp.getWriter().println("Hello V2");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

    }
}
