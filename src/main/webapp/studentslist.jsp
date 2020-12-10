<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>管理员</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="https://www.layuicdn.com/auto/layui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<div class="container">
    <div class="layui-row">
        <ul class="layui-nav layui-bg-green" lay-filter="">
            <li class="layui-nav-item"><a href="index.jsp">用户信息管理</a></li>
            <li class="layui-nav-item"><a href="studentslist.jsp">学生信息管理</a></li>
            <li class="layui-nav-item"><a href="classeslist.jsp">班级信息管理</a></li>
            <li class="layui-nav-item"><a href="courselist.jsp">课程信息管理</a></li>
            <li class="layui-nav-item"><a href="courseplanlist.jsp">课程表信息管理</a></li>
            <li class="layui-nav-item"><a href="scoreslist.jsp">成绩信息管理</a></li>
        </ul>
    </div>
    <br>

    <div class="layui-row">
        <div class="demoTable">
            <div class="layui-col-xs2">
                学号：
                <input class="layui-input" name="sno" id="sno" autocomplete="off">
            </div>
            <div class="layui-col-xs2">
                姓名：
                <input class="layui-input" name="name" id="name" autocomplete="off">
            </div>
            <div class="layui-col-xs2">
                专业：
                <input class="layui-input" name="major" id="major" autocomplete="off">
            </div>
            <div class="layui-col-xs2">
                班级：
                <input class="layui-input" name="classes" id="classes" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload">搜索</button>
        </div>
    </div>


    <div class="layui-row">

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-sm" lay-event="getCheckData">添加</button>
            </div>
        </script>

        <table class="layui-hide" id="demo" lay-filter="test"></table>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
    </div>
</div>
</body>
<script>

    layui.use(['table'],function (){
        var table = layui.table //表格
            ,laypage = layui.laypage //分页


        //执行一个 table 实例
        table.render({
            elem: '#demo'
            ,height: 420
            ,url: '/students?method=list' //数据接口
            ,title: '列表'
            ,id:'testReload'
            ,page: true //开启分页
            ,toolbar: '#toolbarDemo' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
            ,totalRow: true //开启合计行
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field: 'id', title: '编号'}
                ,{field: 'sno', title: '学号'}
                ,{field: 'name', title: '姓名'}
                ,{field: 'sex', title: '性别'}
                ,{field: 'birth', title: '生日'}
                ,{field: 'major', title: '专业'}
                ,{field: 'classes', title: '班级'}
                ,{field: 'address', title: '家庭住址'}
                ,{field: 'phone', title: '联系电话'}
                ,{field: 'comment', title: '备注'}
                ,{fixed: 'right', width: 165, align:'center', toolbar: '#barDemo'}
            ]]
        });


        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData': {
                    layer.open({
                        type: 2
                        ,area: ['600px', '400px']
                        ,shade: 0
                        ,content: 'studentsedit.jsp'
                        ,btn: ['关闭']
                        ,yes: function(){
                            layer.closeAll();
                        }
                    });
                }
            };
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.ajax({
                        type: "GET",
                        url: "/students?method=delete&id="+data.id,
                        success:function (data){
                            if (data.code=='0'){
                                obj.del();
                                layer.close(index);
                                layer.alert('删除成功');
                            }else {
                                layer.alert('服务器异常，请联系系统管理员');
                            }
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                layer.open({
                    type: 2
                    ,area: ['600px', '400px']
                    ,shade: 0
                    ,content: '/students?method=edit&id='+data.id
                    ,btn: ['关闭']
                    ,yes: function(){
                        layer.closeAll();
                    }
                });
            }
        });


        // 重载表格
        var $ = layui.$, active = {
            reload: function(){
                console.log("reload")

                var sno = $('#sno');
                var name = $('#name');
                var major = $('#major');
                var classes = $('#classes');

                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        sno: sno.val(),
                        name: name.val(),
                        major: major.val(),
                        classes: classes.val(),
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    })
</script>
</html>