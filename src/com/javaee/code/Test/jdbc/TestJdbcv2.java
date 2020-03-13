package com.javaee.code.Test.jdbc;

import java.sql.*;

public class TestJdbcv2 {
    public static String getMysql(){
        //定义url
        String url = "jdbc:mysql://127.0.0.1:3306/dbsj1";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String sqlString = "select * from s limit 6";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            //加载驱动
            Class.forName(driverName);
            //创建连接
            connection = DriverManager.getConnection(url,"root","123456");

            //通过连接获取statement
            statement = connection.createStatement();

            //通过statemen，做一些增删改查
            resultSet = statement.executeQuery(sqlString);
            while (resultSet.next()){
                System.out.println(resultSet.getLong(1));
            }
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
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
