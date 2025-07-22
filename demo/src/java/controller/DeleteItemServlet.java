package controller;

import dao.ItemDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemsID = request.getParameter("itemsID");
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.deleteItem(itemsID);

        response.sendRedirect("ItemServlet");
    }
}
