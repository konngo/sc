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
    <form class="layui-form" action="/classes">
        <input type="hidden" name="id" value="${classes.id}">
        <input type="hidden" name="method" value="saveorupdate">

         <div class="layui-form-item">
             <label class="layui-form-label">名称</label>
             <div class="layui-input-inline">
                 <input type="text" name="name" value="${classes.name}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">专业</label>
             <div class="layui-input-inline">
                 <input type="text" name="major" value="${classes.major}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">课时</label>
             <div class="layui-input-inline">
                 <input type="text" name="nums" value="${classes.nums}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">入学年份</label>
             <div class="layui-input-inline">
                 <input type="text" name="years" value="${classes.years}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">辅导员</label>
             <div class="layui-input-inline">
                 <input type="text" name="fudaoyuan" value="${classes.fudaoyuan}" autocomplete="off" class="layui-input">
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