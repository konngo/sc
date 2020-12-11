<%@ page import="cn.konngo.model.UsersBean" %>
<%@ page import="cn.konngo.service.UsersService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑页面</title>
    <script src="https://www.layuicdn.com/auto/layui.js"></script>
</head>
<%
    UsersBean user= (UsersBean) request.getSession().getAttribute("users");
    UsersService service=new UsersService();
    service.delete(user.getId());
%>
<body>

</body>
</html>