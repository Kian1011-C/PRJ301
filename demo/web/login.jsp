<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
    <h2>Đăng nhập</h2>
    <form action="LoginServlet" method="post">
        Email: <input type="text" name="email" required><br>
        Mật khẩu: <input type="password" name="password" required><br>
        <input type="submit" value="Đăng nhập">
    </form>
    <p style="color:red">${errorMessage}</p>
</body>
</html>
