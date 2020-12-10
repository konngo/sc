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
    <form class="layui-form" action="/scores?method=saveorupdate">
        <input type="hidden" name="id" value="${scores.id}">
        <input type="hidden" name="method" value="saveorupdate">

         <div class="layui-form-item">
             <label class="layui-form-label">学生编号</label>
             <div class="layui-input-inline">
                 <input type="text" name="studentid" value="${scores.studentid}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">课程编号</label>
             <div class="layui-input-inline">
                 <input type="text" name="courseid" value="${scores.courseid}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">成绩</label>
             <div class="layui-input-inline">
                 <input type="text" name="score" value="${scores.score}" autocomplete="off" class="layui-input">
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