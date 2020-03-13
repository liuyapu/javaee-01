package com.javaee.code.Test.jdbc;

import com.javaee.code.Test.model.Student;
import com.javaee.code.Test.model.StudentHomework;
import com.javaee.code.Test.model.TeacherHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkJdbc {
    public static void main(String[] args) {
        List<StudentHomework> list = selectAll();

        for (StudentHomework sh : list){
            System.out.println("作业是："+sh.getHomeworkContent());
        }
    }



    public static List<StudentHomework> selectAll(){


        String url = "jdbc:mysql://127.0.0.1:3306/school";

        String allUrl = url + "?user=root&password=123456";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_student_homework";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(allUrl)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static List<TeacherHomework> selectAll2(){


        String url = "jdbc:mysql://127.0.0.1:3306/school";

        String allUrl = url + "?user=root&password=123456";

        String driverName = "com.mysql.cj.jdbc.Driver";

        String sqlString = "SELECT * FROM s_homework";

        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<TeacherHomework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(allUrl)) {
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    // 获取执行结果
                    while (resultSet.next()){
                        TeacherHomework sh1 = new TeacherHomework();

                        sh1.setHomework_id(resultSet.getLong("homework_id"));
                        sh1.setHomeworkTitle(resultSet.getString("title"));
                        sh1.setHomeworkContent(resultSet.getString("content"));
                        sh1.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(sh1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static Boolean addStudent(Student s){
        String url ="jdbc:mysql://127.0.0.1:3306/school";
        String driverName="com.mysql.cj.jdbc.Driver";
        Boolean a=false;
        String sqlString="insert into s_student(student_id,student_name) values(?,?)";
        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Student> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
            try(PreparedStatement ps = connection.prepareStatement(sqlString);){
                ps.setLong(1,s.getStudentId());
                ps.setString(2,s.getStudent_name());
                int row = ps.executeUpdate();
                if(row > 0){
                    System.out.println("成功添加了 " + row + "条数据！ ");
                    a=true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return a;
    }
    public static Boolean addTeacherHomework(TeacherHomework s){
        String url ="jdbc:mysql://127.0.0.1:3306/school";
        String driverName="com.mysql.cj.jdbc.Driver";
        Boolean a=false;
        String sqlString="insert into s_homework(homework_id,title,content) values(?,?,?)";
        try {
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection =  DriverManager.getConnection(url,"root","123456")) {
            try(PreparedStatement ps = connection.prepareStatement(sqlString);){
                ps.setLong(1,s.getHomework_id());
                ps.setString(2,s.getHomeworkTitle());
                ps.setString(3,s.getHomeworkContent());

                int row = ps.executeUpdate();
                if(row > 0){
                    System.out.println("成功添加了 " + row + "条数据！ ");
                    a=true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return a;
    }
}
