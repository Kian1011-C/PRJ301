/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Model.Users;
import Utils.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vovan
 */
public class UserDao {
    
    

    public Users CheckLogin(String username, String password) {
        String sql = "select * from Users where userName = ? and password = ?";
        List<Users> list = new ArrayList<>();

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {

            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Users us = new Users(rs.getString("userID"),
                        rs.getString("userName"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getString("roleID"),
                        rs.getString("password"));

               return us;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean CheckGetName(String userName) {
        String sql = "Select * from Users where userName = ? ";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, userName);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void AddUsers(Users u) {
        String sql = "Insert into Users value ('?', '?', '?', '?', '?','?')";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, u.getUserID());
            stm.setString(2, u.getEmail());
            stm.setString(3, u.getUserName());
            stm.setString(4, u.getPhoneNumber());
            stm.setString(5, u.getRoleID());
            stm.setString(6, u.getPassword());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Users> GetUsers() {
        String sql = "select * from Users ";
        List<Users> list = new ArrayList<>();
        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Users us = new Users(rs.getString("userID"),
                        rs.getString("userName"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getString("roleID"),
                        rs.getString("password"));
                list.add(us);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Users> SearchValue(String username) {
        String sql = "select * from Users where userName Like  ? ";
        List<Users> list = new ArrayList<>();
        try (Connection con = ConnectDB.getConnection();
                PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, "%" + username + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Users us = new Users(rs.getString("userID"),
                        rs.getString("userName"),
                        rs.getString("email"),
                        rs.getString("phoneNumber"),
                        rs.getString("roleID"),
                        rs.getString("password"));
                list.add(us);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean delete(String userId) {
        String sql = "DELETE FROM Users WHERE userId = ?";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, userId);
            return stm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void Update(String userId, String username, String email, String password, String role, String phoneNumber) {
        String sql = "Update Users set userName = ?, email = ?, phoneNumber = ?, password = ? , roleID = ? Where userID = ? ";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, email);
            stm.setString(3, phoneNumber);
            stm.setString(4, password);
            stm.setString(5, role);
            stm.setString(6, userId);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
