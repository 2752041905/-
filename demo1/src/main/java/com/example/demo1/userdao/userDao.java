package com.example.demo1.userdao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
@Service
public class userDao {
    private Connection conn;
    public void conection() {
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("成功加载MySQL驱动！");
        }catch(ClassNotFoundException e1){
            System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
        }
        String url="jdbc:mysql://localhost:3306/test";    //JDBC的URL
        try {
            conn = DriverManager.getConnection(url,    "root","Wang20021124@");
            //创建一个Statement对象
            Statement stmt = conn.createStatement(); //创建Statement对象
//            System.out.print("成功连接到数据库！");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public boolean validateUser(String name, String password) {
        try {
            conection();
            String query = "SELECT COUNT(*) FROM user WHERE name = ? AND password = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
//                System.out.println("数据库成功关闭");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public boolean addUser(String name,String password){
        try {
            conection();
            String query = "INSERT INTO user (name, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
//                System.out.println("数据库成功关闭");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }



}
