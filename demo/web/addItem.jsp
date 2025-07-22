<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
    <h2>Thêm sản phẩm mới</h2>
    <form action="AddItemServlet" method="post">
        ID: <input type="text" name="itemsID" required><br>
        Tên: <input type="text" name="itemsName" required><br>
        Giá: <input type="number" name="price" step="0.01" required><br>
        Số lượng: <input type="number" name="quantity" required><br>
        Danh mục: <input type="text" name="categoryID" required><br>
        Ảnh: <input type="text" name="itemsImagePath"><br>
        <input type="submit" value="Thêm">
    </form>
</body>
</html>
