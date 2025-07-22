package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

public class UserDAO {
    public User login(String email, String password) {
        User user = null;
        String sql = "SELECT * FROM Users WHERE email = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                    rs.getString("userID"),
                    rs.getString("userName"),
                    rs.getString("email"),
                    rs.getString("phoneNumber"),
                    rs.getString("roleID"),
                    rs.getString("password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
