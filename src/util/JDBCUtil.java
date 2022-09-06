/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class JDBCUtil {
    private static Connection conn;

    public static Connection getConnection() { 
        if (conn == null) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String dbUser = "trang", dbPass = "123", dbUrl = "jdbc:sqlserver://localhost:1433;"
                        + ";databaseName=su22b2_sof203;encrypt=false;trustServerCetificate = true;";

                conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                System.out.println("Kết nối thành công");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
