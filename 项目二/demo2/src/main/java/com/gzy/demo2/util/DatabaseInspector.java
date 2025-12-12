package com.gzy.demo2.util;

import java.sql.*;

public class DatabaseInspector {
    private static final String URL = "jdbc:mysql://localhost:3306/student_society?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "352987";

    public static void main(String[] args) {
        try {
            // 加载MySQL JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 连接数据库
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("成功连接到数据库！");
            
            // 获取所有表名
            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables("student_society", null, null, new String[]{"TABLE"});
            
            System.out.println("\n=== 数据库表结构 ===");
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("\n表名: " + tableName);
                
                // 获取表的列信息
                ResultSet columns = metaData.getColumns("student_society", null, tableName, null);
                System.out.println("列信息:");
                System.out.println("列名\t\t\t\t\t数据类型\t\t长度\t\t允许为空\t\t备注");
                System.out.println("------------------------------------------------------------------------");
                
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String typeName = columns.getString("TYPE_NAME");
                    int size = columns.getInt("COLUMN_SIZE");
                    String isNullable = columns.getString("IS_NULLABLE");
                    String remarks = columns.getString("REMARKS");
                    
                    System.out.printf("%-20s\t\t%s\t\t%d\t\t%s\t\t%s\n", 
                                    columnName, typeName, size, isNullable, remarks != null ? remarks : "");
                }
                columns.close();
            }
            tables.close();
            connection.close();
            
        } catch (ClassNotFoundException e) {
            System.err.println("找不到MySQL JDBC驱动: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("数据库连接错误: " + e.getMessage());
            e.printStackTrace();
        }
    }
}