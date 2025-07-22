package controller;

import dao.ItemDAO;
import model.Item;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemsID = request.getParameter("itemsID");
        String itemsName = request.getParameter("itemsName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String categoryID = request.getParameter("categoryID");
        String itemsImagePath = request.getParameter("itemsImagePath");

        Item newItem = new Item(itemsID, itemsName, price, quantity, categoryID, itemsImagePath);
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.addItem(newItem);

        response.sendRedirect("ItemServlet");
    }
}
