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
    <form class="layui-form" action="/courseplan?method=saveorupdate">
        <input type="hidden" name="id" value="${courseplan.id}">

        <input type="hidden" name="method" value="saveorupdate">

         <div class="layui-form-item">
             <label class="layui-form-label">课程号</label>
             <div class="layui-input-inline">
                 <input type="text" name="courseid" value="${courseplan.courseid}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">班级号</label>
             <div class="layui-input-inline">
                 <input type="text" name="classesid" value="${courseplan.classesid}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">授课教师</label>
             <div class="layui-input-inline">
                 <input type="text" name="teacher" value="${courseplan.teacher}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">授课时间</label>
             <div class="layui-input-inline">
                 <input type="text" name="times" value="${courseplan.times}" autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label">授课地点</label>
             <div class="layui-input-inline">
                 <input type="text" name="address" value="${courseplan.address}" autocomplete="off" class="layui-input">
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