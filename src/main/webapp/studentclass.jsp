<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>学生中心</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="https://www.layuicdn.com/auto/layui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div class="container">
    <div class="layui-row">
        <ul class="layui-nav layui-bg-green" lay-filter="">
            <li class="layui-nav-item"><a href="student.jsp">个人信息</a></li>
            <li class="layui-nav-item"><a href="studentclass.jsp">班级信息</a></li>
            <li class="layui-nav-item"><a href="studentcourse.jsp">课程信息</a></li>
            <li class="layui-nav-item"><a href="studentplan.jsp">课程表信息</a></li>
            <li class="layui-nav-item"><a href="studentscore.jsp">成绩信息</a></li>
        </ul>
    </div>
    <br>
    <div class="layui-row">
        <form class="layui-form" action="">
            <input type="hidden" name="id" value="">
            <div class="layui-form-item">
                <label class="layui-form-label">编号</label>
                <div class="layui-input-inline">
                    <input type="text" name="id" required disabled  value="${classes.id}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">课程名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" required disabled  value="${classes.name}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">专业</label>
                <div class="layui-input-inline">
                    <input type="text" name="major" required disabled  value="${classes.major}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">课时</label>
                <div class="layui-input-inline">
                    <input type="text" name="nums" required disabled  value="${classes.nums}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">入学年份</label>
                <div class="layui-input-inline">
                    <input type="text" name="years" required disabled  value="${classes.years}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">辅导员</label>
                <div class="layui-input-inline">
                    <input type="text" name="fudaoyuan" required disabled  value="${classes.fudaoyuan}" autocomplete="off" class="layui-input">
                </div>
            </div>

        </form>
    </div>
</div>
</body>
</html>