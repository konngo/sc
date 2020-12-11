package cn.konngo.servlet;

import cn.konngo.dao.StudentsDao;
import cn.konngo.model.*;
import cn.konngo.service.UsersService;
import cn.konngo.util.TransforUtil;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  用户servlet
 */
@WebServlet("/users")
public class UsersServlet  extends HttpServlet {
    UsersService service=new UsersService();
    TransforUtil<UsersBean> trans=new TransforUtil<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        if (method.equals("login")){
            login(request,response);
        }else if(method.equals("list")){
            list(request,response);
        }else if(method.equals("saveorupdate")){
            try {
                saveorupdate(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(method.equals("delete")){
           delete(request,response);
        }else if(method.equals("edit")){
            String id =request.getParameter("id");
            UsersBean bean=service.find(Integer.parseInt(id));
            request.setAttribute("users",bean);
            request.getRequestDispatcher("usersedit.jsp").forward(request,response);
        }else if(method.equals("resetpassword")){
            resetPassword(request,response);
        }else if(method.equals("reg")){
            register(request,response);
        }else if(method.equals("img")){
            createimg(request,response);
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) {
        try {
            UsersBean bean=trans.requestTransforBean(request,UsersBean.class);
            boolean flag=service.insert(bean);
            if(flag){
                request.setAttribute("status","注册成功!");
            }else {
                request.setAttribute("status","服务器异常!");
            }
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void resetPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldpassword=request.getParameter("oldpassword");
        String newpassword=request.getParameter("newpassword");
        String repassword=request.getParameter("repassword");
        String status="";
        UsersBean usersBean= (UsersBean) request.getSession().getAttribute("users");

        if (!newpassword.equals(repassword)){
            status="两次输入密码不一致，请重试";
        } else {
            if (!usersBean.getPassword().equals(oldpassword))   {
                status="旧密码错误！";
            }else {
                usersBean.setPassword(newpassword);
                try {
                    service.update(usersBean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                status="修改成功";
            }
        }
        request.setAttribute("status",status);
        request.getRequestDispatcher("resetpassword.jsp").forward(request,response);
    }

    // 进行删除操作
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");  // 设置request字符编码
        String searchText = request.getParameter("search"); // 获取传入的search字段的内容
        response.setContentType("text/json; charset=utf-8");    // 设置response的编码及格式
        PrintWriter out = response.getWriter();

        String id =request.getParameter("id");
        try {
            service.delete(Integer.parseInt(id));
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        Map<String, Object> resultMap = new HashMap<>();
        List<UsersBean> list=service.list();
        resultMap.put("code", "0");

        String resJSON = JSON.toJSONString(resultMap);     // 转换为json
        out.print(resJSON); // 输出
    }

    // 保存或者修改
    private void saveorupdate(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, SQLException, ClassNotFoundException, InstantiationException, ParseException, IOException {
        String id=request.getParameter("id");
        UsersBean bean=trans.requestTransforBean(request,UsersBean.class);
        if (id==null||id.equals("")){
            service.insert(bean);
        }else {
            service.update(bean);
        }
        response.sendRedirect("success.jsp");
    }


    // 查询所有用户信息返回
    private void list(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");  // 设置request字符编码
        String searchText = request.getParameter("search"); // 获取传入的search字段的内容
        response.setContentType("text/json; charset=utf-8");    // 设置response的编码及格式
        PrintWriter out = response.getWriter();

        Map<String, Object> resultMap = new HashMap<>();
        List<UsersBean> list=service.list();
        resultMap.put("data", list);
        resultMap.put("code", "0");
        resultMap.put("msg", "");
        resultMap.put("count", "1");

        String resJSON = JSON.toJSONString(resultMap);     // 转换为json
        out.print(resJSON); // 输出
    }

    // 创建图片
    private void createimg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");  // 设置request字符编码
        String searchText = request.getParameter("search"); // 获取传入的search字段的内容
        response.setContentType("text/json; charset=utf-8");    // 设置response的编码及格式
        PrintWriter out = response.getWriter();
        String rand=Math.round((Math.random()+1) * 1000)+"";
        request.getSession().setAttribute("rand",rand);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data",rand );
        resultMap.put("code", "0");
        String resJSON = JSON.toJSONString(resultMap);     // 转换为json
        out.print(resJSON); // 输出
    }

    //登录
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String rand=req.getParameter("rand");
        String msg= (String) req.getSession().getAttribute("rand");
        if (!rand.equals(msg)){
            req.setAttribute("status","验证码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

        UsersBean user=service.login(username,password);
        if (user!=null){
            if (user.getType().equals("管理员")){
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }else {

            req.getSession().setAttribute("users",user);
            StudentsBean student=service.findStudents(user);
            if (student!=null){
                req.getSession().setAttribute("students",student);
                ClassesBean clazz=service.findClazz(student);
                if (clazz!=null){
                    req.getSession().setAttribute("classes",clazz);
                    List<CourseBean> list=service.findCoursePlan(clazz.getId());
                    System.out.println(list);
                    System.out.println(clazz.getId()+"clazzid");
                    req.getSession().setAttribute("cp",list);
                    List<CourseplanBean> c=service.findCourse(clazz.getId());
                    System.out.println(c);
                    req.getSession().setAttribute("c",c);
                }
                List<ScoresBean> s=service.findScore(student.getId());
                req.getSession().setAttribute("s",s);
            }
            req.getRequestDispatcher("student.jsp").forward(req,resp);
            }
        }else{
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
