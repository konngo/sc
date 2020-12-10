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
    <div class="layui-row">
        <ul class="layui-nav layui-bg-green" lay-filter="">
            <li class="layui-nav-item"><a href="student.jsp">个人信息</a></li>
            <li class="layui-nav-item"><a href="studentclass.jsp">班级信息</a></li>
            <li class="layui-nav-item"><a href="studentcourse.jsp">课程信息</a></li>
            <li class="layui-nav-item"><a href="studentplan.jsp">课程表信息</a></li>
            <li class="layui-nav-item"><a href="studentscore.jsp">成绩信息</a></li>
            <li class="layui-nav-item"><a href="resetpassword.jsp">修改密码</a></li>
        </ul>
    </div>
    <span style="color: red">
        ${status}
    </span>

    <form class="layui-form" action="/users">
        <input type="hidden" name="method" value="resetpassword">
        <div class="layui-form-item">
            <label class="layui-form-label">旧密码</label>
            <div class="layui-input-inline">
                <input type="text" name="oldpassword" value="" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">新密码</label>
            <div class="layui-input-inline">
                <input type="text" name="newpassword" value="" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">重复新密码</label>
            <div class="layui-input-inline">
                <input type="text" name="repassword" value="" autocomplete="off" class="layui-input">
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