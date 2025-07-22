package controller;

import dao.DBUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;


@WebServlet("/menu")
public class MenuController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Item> menuList = new ArrayList<>();
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Items")) {
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Item item = new Item(
                    rs.getString("itemsID"),
                    rs.getString("itemsName"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    rs.getString("categoryID"),
                    rs.getString("itemsImagePath")
                );
                menuList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("menuList", menuList);
        request.getRequestDispatcher("menu.jsp").forward(request, response);
    }
}
