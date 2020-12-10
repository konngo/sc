<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑页面</title>
    <script src="https://www.layuicdn.com/auto/layui.js"></script>
</head>
<body>
<div class="layui-content">
    <form class="layui-form" action="/users">
        <input type="hidden" name="id" value="${users.id}">
        <input type="hidden" name="method" value="saveorupdate">


         <div class="layui-form-item">
             <label class="layui-form-label">用户名</label>
             <div class="layui-input-inline">
                 <input type="text" name="username" value="${users.username}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">密码</label>
             <div class="layui-input-inline">
                 <input type="text" name="password" value="${users.password}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">类型</label>
             <div class="layui-input-inline">
                 <input type="text" name="type" value="${users.type}" autocomplete="off" class="layui-input">
             </div>
         </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn layui-btn-primary">提交</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>