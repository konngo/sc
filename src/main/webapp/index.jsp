<%@ page import="java.net.InetAddress" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>管理员</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="https://www.layuicdn.com/auto/layui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <style>
        table td{
            font-size:10.5pt;
        }
        .black12 {
            font-size: 12px;
            color: #000000;
            text-decoration: none;
        }
        .black12 a {
            color: #000000;
        }
        .black12 a:hover {
            color: #0048bf;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="layui-row">
        <ul class="layui-nav layui-bg-green" lay-filter="">
            <li class="layui-nav-item"><a href="users.jsp">用户信息管理</a></li>
            <li class="layui-nav-item"><a href="studentslist.jsp">学生信息管理</a></li>
            <li class="layui-nav-item"><a href="classeslist.jsp">班级信息管理</a></li>
            <li class="layui-nav-item"><a href="courselist.jsp">课程信息管理</a></li>
            <li class="layui-nav-item"><a href="courseplanlist.jsp">课程表信息管理</a></li>
            <li class="layui-nav-item"><a href="scoreslist.jsp">成绩信息管理</a></li>
        </ul>
    </div>
    <br>
    <div class="layui-row">

        <table cellspacing="0" cellpadding="0" width="100%" height="98%" style="padding:0px;margin:0px;">
            <tbody>
            <tr>
                <td width="100%" valign="top">
                    <table width="100%" height="100%" style="padding:0px;margin:0px;"><!-- 两行 -->

                        <!-- 路径 begin -->
                        <tr>
                            <td>
                                <table width="100%" height="39px" border="0" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td id="path" class="black12">当前位置：首页&gt;系统所有属性
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 路径 end -->

                        <!-- 正文 begin -->
                        <tr>
                            <td style="height:100%;" width="100%">
                                <table width="100%" height="100%" bgColor="#FFFFFF" style="border:1px #aac9e8 solid" cellpadding="0" cellspacing="0">
                                    <tr><td height="10"></td></tr>
                                    <tr>
                                        <td height="30"><strong>全部系统属性</strong></td>
                                    </tr>
                                    <tr>
                                        <td bgcolor="#aaaaaa" height="1"></td>
                                    </tr>
                                    <tr><td height="20"></td></tr>
                                    <tr>
                                        <td>所有的系统属性，即 <b><i>System.getProperties()</i></b> 的输出。</td>
                                    </tr>
                                    <tr><td height="10"></td></tr>
                                    <tr>
                                        <td class="block-indent" style="padding-left:10px">
                                            <table width="98%" border="0" cellspacing="1" cellpadding="2" bgcolor="#999999">
                                                <tr bgcolor="#CCCCCC">
                                                    <th width="5%">&nbsp;</th>
                                                    <th width="20%" nowrap>属性名</th>
                                                    <th width="75%" nowrap>属性值</th>
                                                </tr>
                                                <%
                                                    InetAddress addr = InetAddress.getLocalHost();
                                                    String ip=addr.getHostAddress().toString();//获得本机IP
                                                    String address=addr.getHostName().toString();//获得本机名称
                                                %>
                                                <tr bgcolor="#FFFFFF">
                                                    <td align="center"></td>
                                                    <td>IP</td>
                                                    <td style="word-break:break-all;"><%=ip %></td>
                                                </tr>
                                                <tr bgcolor="#FFFFFF">
                                                    <td align="center"></td>
                                                    <td>address</td>
                                                    <td style="word-break:break-all;"><%=address %></td>
                                                </tr>
                                                <%
                                                    int iCount = 1;
                                                    Enumeration enu = System.getProperties().keys();
                                                    while(enu.hasMoreElements())
                                                    {
                                                        String sKey = (String) enu.nextElement();
                                                        String sVal = System.getProperty(sKey);
                                                %>
                                                <tr bgcolor="#FFFFFF">
                                                    <td align="center"><%= iCount++ %>&nbsp;</td>
                                                    <td><%= sKey %></td>
                                                    <td style="word-break:break-all;"><%= sVal %></td>
                                                </tr>

                                                <%
                                                    }
                                                %>
                                                <tr bgcolor="#FFFFFF">
                                                    <td align="right"><%= iCount++ %>&nbsp;</td>
                                                    <td>Default Locale</td>
                                                    <td><%= Locale.getDefault() %></td>
                                                </tr>
                                                <%
                                                    Runtime runtimeInfo = Runtime.getRuntime();
                                                    long unitMb = 1204 * 1024L;
                                                %>
                                                <tr bgcolor="#FFFFFF">
                                                    <td align="right"><%= iCount++ %>&nbsp;</td>
                                                    <td>TotalMemory</td>
                                                    <td><%=runtimeInfo.totalMemory()/unitMb%>(M)</td>
                                                </tr>
                                                <tr bgcolor="#FFFFFF">
                                                    <td align="right"><%= iCount++ %>&nbsp;</td>
                                                    <td>FreeMemory</td>
                                                    <td><%=runtimeInfo.freeMemory()/unitMb%>(M)</td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <!-- 正文 end -->
                    </table>
                </td>

                <!-- 侧边 begin -->

                <td width="7px" height="100%" valign="right" rowspan=2 background="../images/dts_rbg.gif">&nbsp;</td>
            </tr>
            <!-- 侧边 end -->
            </tbody>
        </table>

    </div>
</div>
</body>
</html>