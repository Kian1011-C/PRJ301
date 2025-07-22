package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Assignment_KhaiNP_Spring2025;encrypt=false";
    private static final String USER = "sa";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
