package com.javaee.code.Test.jdbc;

import org.omg.CORBA.Request;

import java.io.PrintWriter;
import java.sql.*;

public class Jdbc {
    public static String getMysql(){
        //定义url
        String url = "jdbc:mysql://127.0.0.1:3306/dbsj1";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "select * from s limit 6";
        DriverManager.setLogWriter(new PrintWriter(System.out));
        try{
            //加载驱动
            Class.forName(driverName);
            //创建连接
           Connection connection = DriverManager.getConnection(url,"root","123456");

           //通过连接获取statement
           Statement statement = connection.createStatement();

           //通过statemen，做一些增删改查
            ResultSet resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()){
                System.out.println(resultSet.getLong(1));
            }


        }
        catch (ClassNotFoundException | SQLException e){
             e.printStackTrace();
        }
        return url;
    }
    public static void main(String[] args){
       getMysql();
    }
}
