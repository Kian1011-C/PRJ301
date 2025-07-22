package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Assignment_KhaiNP_Spring2025";
    private static final String USER = "sa"; // Thay bằng username SQL Server của bạn
    private static final String PASSWORD = "12345"; // Thay bằng mật khẩu của bạn

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
