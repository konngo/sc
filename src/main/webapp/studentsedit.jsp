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
    <form class="layui-form" action="/students?method=saveorupdate">
        <input type="hidden" name="id" value="${students.id}">
        <input type="hidden" name="method" value="saveorupdate">

         <div class="layui-form-item">
             <label class="layui-form-label">学号</label>
             <div class="layui-input-inline">
                 <input type="text" name="sno" value="${students.sno}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">姓名</label>
             <div class="layui-input-inline">
                 <input type="text" name="name" value="${students.name}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">性别</label>
             <div class="layui-input-inline">
                 <input type="text" name="sex" value="${students.sex}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">生日</label>
             <div class="layui-input-inline">
                 <input type="text" name="birth" value="${students.birth}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">专业</label>
             <div class="layui-input-inline">
                 <input type="text" name="major" value="${students.major}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">班级</label>
             <div class="layui-input-inline">
                 <input type="text" name="classes" value="${students.classes}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">家庭住址</label>
             <div class="layui-input-inline">
                 <input type="text" name="address" value="${students.address}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">联系电话</label>
             <div class="layui-input-inline">
                 <input type="text" name="phone" value="${students.phone}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">备注</label>
             <div class="layui-input-inline">
                 <input type="text" name="comment" value="${students.comment}" autocomplete="off" class="layui-input">
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