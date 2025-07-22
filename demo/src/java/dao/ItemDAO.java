package dao;

import model.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    
    // Lấy danh sách tất cả sản phẩm
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM Items";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Item item = new Item(
                    rs.getString("itemsID"),
                    rs.getString("itemsName"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getString("categoryID"),
                    rs.getString("itemsImagePath")
                );
                items.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    // Thêm một sản phẩm mới
    public boolean addItem(Item item) {
        String sql = "INSERT INTO Items (itemsID, itemsName, price, quantity, categoryID, itemsImagePath) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, item.getItemsID());
            ps.setString(2, item.getItemsName());
            ps.setDouble(3, item.getPrice());
            ps.setInt(4, item.getQuantity());
            ps.setString(5, item.getCategoryID());
            ps.setString(6, item.getItemsImagePath());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa sản phẩm theo ID
    public boolean deleteItem(String itemsID) {
        String sql = "DELETE FROM Items WHERE itemsID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, itemsID);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
