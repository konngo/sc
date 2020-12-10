<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <table class="layui-table">
            <colgroup>
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>学生编号</th>
                <th>课程编号</th>
                <th>成绩</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="scores" items="${s}">
                <tr>
                    <td>${ scores.studentid }</td>
                    <td>${ scores.courseid }</td>
                    <td>${ scores.score }</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>