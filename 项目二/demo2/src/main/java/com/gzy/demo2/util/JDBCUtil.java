package com.gzy.demo2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC工具类，用于获取数据库连接
 */
public class JDBCUtil {
    // 数据库驱动
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // 数据库URL
    private static final String URL = "jdbc:mysql://localhost:3306/student_society?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8";
    // 数据库用户名
    private static final String USERNAME = "root";
    // 数据库密码
    private static final String PASSWORD = "352987";
    
    static {
        try {
            // 加载数据库驱动
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库驱动加载失败");
        }
    }
    
    /**
     * 获取数据库连接
     * @return 数据库连接对象
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接获取失败");
        }
        return connection;
    }
    
    /**
     * 关闭数据库连接资源
     * @param connection 数据库连接对象
     * @param preparedStatement PreparedStatement对象
     * @param resultSet 结果集对象
     */
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库资源关闭失败");
        }
    }
}