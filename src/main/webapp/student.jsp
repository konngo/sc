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
            <li class="layui-nav-item"><a href="resetpassword.jsp">修改密码</a></li>
            <li class="layui-nav-item"><a href="deleteuser.jsp">注销账号</a></li>
        </ul>
    </div>
    <br>
    <div class="layui-row">
        <form class="layui-form" action="">
            <input type="hidden" name="id" value="">
            <div class="layui-form-item">
                <label class="layui-form-label">学号</label>
                <div class="layui-input-inline">
                    <input type="text" name="sno" required disabled  value="${students.sno}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">学号</label>
                <div class="layui-input-inline">
                    <input type="text" name="sno" required disabled  value="${students.sno}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="name" required disabled  value="${students.name}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-inline">
                    <input type="text" name="sex" required disabled  value="${students.sex}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">生日</label>
                <div class="layui-input-inline">
                    <input type="text" name="birth" required disabled  value="${students.birth}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">专业</label>
                <div class="layui-input-inline">
                    <input type="text" name="major" required disabled  value="${students.major}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">班级</label>
                <div class="layui-input-inline">
                    <input type="text" name="classes" required disabled  value="${students.classes}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">家庭住址</label>
                <div class="layui-input-inline">
                    <input type="text" name="address" required disabled  value="${students.address}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">联系电话</label>
                <div class="layui-input-inline">
                    <input type="text" name="phone" required disabled  value="${students.phone}" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-inline">
                    <input type="text" name="comment" required disabled  value="${students.comment}" autocomplete="off" class="layui-input">
                </div>
            </div>

        </form>
    </div>
</div>
</body>
</html>