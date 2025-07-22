<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.Item" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
    <h2>Danh sách sản phẩm</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Danh mục</th>
            <th>Ảnh</th>
            <th>Hành động</th>
        </tr>
        <%
            List<Item> items = (List<Item>) request.getAttribute("items");
            if (items != null) {
                for (Item item : items) {
        %>
        <tr>
            <td><%= item.getItemsID() %></td>
            <td><%= item.getItemsName() %></td>
            <td><%= item.getPrice() %></td>
            <td><%= item.getQuantity() %></td>
            <td><%= item.getCategoryID() %></td>
            <td><img src="<%= item.getItemsImagePath() %>" width="50"></td>
            <td>
                <a href="DeleteItemServlet?itemsID=<%= item.getItemsID() %>">Xóa</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</body>
</html>
