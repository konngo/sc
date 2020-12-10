<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="https://www.layuicdn.com/auto/layui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>
<body>
<div class="wrap">
<%--    <img src="images/back.jpg" class="imgStyle">--%>
    <div class="loginForm">
        <form action="users">
            <input type="hidden" name="method" value="login">
            <div class="logoHead">
               <h2 style="margin-top: 15px">登录</h2>
            </div>
            <div class="usernameWrapDiv">
                <div class="usernameLabel">
                    <label>用户名:</label>
                </div>
                <div class="usernameDiv">
                    <i class="layui-icon layui-icon-username adminIcon"></i>
                    <input id="loginUsername" class="layui-input adminInput" type="text" name="username" placeholder="输入用户名" >
                </div>
            </div>
            <div class="usernameWrapDiv">
                <div class="usernameLabel">
                    <label>密码:</label>
                </div>
                <div class="passwordDiv">
                    <i class="layui-icon layui-icon-password adminIcon"></i>
                    <input id="loginPassword" class="layui-input adminInput" type="password" name="password" placeholder="输入密码">
                </div>
            </div>
            <div class="usernameWrapDiv">
                <div class="passwordDiv">
                    <button type="submit" class="layui-btn">登录</button>
                </div>
            </div>

        </form>
    </div>
</div>
</body>
<style>
    .wrap{
        width: 100%;
        height: 100%;
        background-size: cover;
    }
    .loginForm{
        margin-left: 35%;
        margin-top: 10%;
        /*background-color: #cccccc;*/
        background-color: #e7e7e7;
        width: 400px;
        height: 400px;
        float: left;
        z-index: 9999;
        position: fixed;
        opacity: 0.75;
    }
    .usernameDiv{
        width: 300px;
        height: 40px;
        padding-left: 130px;
        padding-top: 30px;

    }
    .adminInput{
        width: 200px;
        height: 40px;
        font-size: 15px;
        border-radius: 0.5em;
        /*margin-left: auto;*/
        /*border: 1px solid #cccccc;*/
    }
    .passwordDiv{
        width: 300px;
        height: 40px;
        padding-left: 130px;
        padding-top: 28px;
    }
    .cardDiv{
        width: 120px;
        height: 40px;
        padding-top: 28px;
        padding-left: 14px;
        float: left;
    }
    .cardInput{
        width: 124px;
        height: 40px;
        font-size: 15px;
        border-radius: 0.5em 0em 0em 0.5em;
    }
    .codeDiv{
        width: 100px;
        height: 40px;
        padding-top: 28px;
        padding-right: 20px;
        float: left;
    }
    .codeInput{
        width: 80px;
        height: 40px;
        font-size: 15px;
        border-radius: 0em 0.5em 0.5em 0em;
        /*验证码样式*/
        font-family: Arial;
        font-style: italic;
        font-weight: bold;
        /*border: 0;*/
        letter-spacing: 2px;
        cursor: pointer;
    }
    i{
        position: absolute;
    }
    .adminIcon{
        font-size: 22px;
        margin-top: 8px;
        margin-left: 165px;
    }
    .logoHead{
        width: 250px;
        height: 60px;
        padding-left: 90px;
        padding-top: 25px;
    }
    .usernameLabel{
        width: 60px;
        height: 30px;
        font-size: 16px;
        float: left;
        margin-left: 55px;
        margin-top: 40px;
    }
    .submitLabel{
        width: 160px;
        height: 30px;
        font-size: 13px;
        float: left;
        margin-left: 55px;
        margin-top: 40px;
        cursor: pointer;
    }
    .usernameWrapDiv{
        width: 400px;
        height: 70px;
    }
    .submitDiv{
        width: 150px;
        height: 40px;
        padding-left: 10px;
        padding-top: 28px;
        float: left;
    }
    .submit{
        width: 100px;
        height: 40px;
        border-radius: 0.5em;
    }
    img{
        position: absolute;
    }
    .imgStyle{
        width: 100%;
        height: 100%;
    }
    /*登陆表单样式 end*/

    /*注册页面样式 start*/
    .registerPage{
        width: 100%;
        height: 100%;
        /*background-color: #cccccc;*/
        display: none;
        opacity: 0.75;
    }
    .registerDiv{
        width: 100%;
        height: 100%;
        z-index: 9999;
        opacity: 0.75;
    }
    /*注册页面样式 end*/
</style>
</html>
