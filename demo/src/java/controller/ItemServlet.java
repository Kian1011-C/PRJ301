package controller;

import dao.ItemDAO;
import model.Item;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemDAO itemDAO = new ItemDAO();
        List<Item> items = itemDAO.getAllItems();

        request.setAttribute("items", items);
        request.getRequestDispatcher("items.jsp").forward(request, response);
    }
}
