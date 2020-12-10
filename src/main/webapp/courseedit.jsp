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
    <form class="layui-form" action="/course?method=saveorupdate">
        <input type="hidden" name="id" value="${course.id}">

        <input type="hidden" name="method" value="saveorupdate">

         <div class="layui-form-item">
             <label class="layui-form-label">课程名</label>
             <div class="layui-input-inline">
                 <input type="text" name="name" value="${course.name}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">学时</label>
             <div class="layui-input-inline">
                 <input type="text" name="times" value="${course.times}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">学分</label>
             <div class="layui-input-inline">
                 <input type="text" name="scores" value="${course.scores}" autocomplete="off" class="layui-input">
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