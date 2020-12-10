package cn.konngo.util;

import cn.konngo.exception.DBTransforException;
import cn.konngo.model.UsersBean;

import javax.management.OperationsException;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 转换工具
public class TransforUtil<T>{
    /**
     *  数据库结果集转换到对象
     */
    public List<T> transfor(ResultSet rs,Class<T> clazz) throws DBTransforException {
        List<T> list=new ArrayList<>();
        try {
            while (rs.next()){
                T t=  clazz.newInstance();
                Field fields[]=t.getClass().getDeclaredFields();
                for (Field f:fields){
                    f.setAccessible(true);
                    Object value=getFiledValue(rs,f);
                    f.set(t,value);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 从request中提取对象
     */
    public  T requestTransforBean(HttpServletRequest request,Class<T> clazz) throws IllegalAccessException, InstantiationException, SQLException, ParseException {
        T t=  clazz.newInstance();
        Field fields[]=t.getClass().getDeclaredFields();
        for (Field f:fields){
            f.setAccessible(true);
            if (request.getParameter(f.getName())!=null&&request.getParameter(f.getName())!=""){
                System.out.println(f.getName());
                System.out.println(request.getParameter(f.getName()));
                System.out.println(getFiledValueByRequest(request,f));
                f.set(t,getFiledValueByRequest(request,f));
            }
        }
        return t;
    }

    /**
     *  从请求中获取属性值
     */
    private Object getFiledValueByRequest(HttpServletRequest request,Field f) throws SQLException, ParseException {
        String clazz=f.getGenericType().toString();
        if (clazz.equals("class java.lang.String")){
            return request.getParameter(f.getName());
        }
        if (clazz.equals("class java.lang.Integer")||clazz.equals("int")){
            return Integer.parseInt(request.getParameter(f.getName()));
        }
        if (clazz.equals("class java.lang.Double")){
            return Double.parseDouble(request.getParameter(f.getName()));
        }
        if (clazz.equals("class java.lang.Boolean")){
            return Boolean.parseBoolean(request.getParameter(f.getName()));
        }
        if (clazz.equals("class java.lang.Date")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.parse(request.getParameter(f.getName()));
        }
        return null;
    }

    /**
     *  从结果集获取属性值
     */
    private Object getFiledValue(ResultSet rs,Field f) throws SQLException {
        String clazz=f.getGenericType().toString();
        if (clazz.equals("class java.lang.String")){
            return rs.getString(f.getName());
        }
        if (clazz.equals("class java.lang.Integer")||clazz.equals("int")){
            return rs.getInt(f.getName());
        }
        if (clazz.equals("class java.lang.Double")){
            return rs.getDouble(f.getName());
        }
        if (clazz.equals("class java.lang.Boolean")){
            return rs.getBoolean(f.getName());
        }
        if (clazz.equals("class java.lang.Date")){
            return rs.getDate(f.getName());
        }
        return null;
    }

    /**
     *  获取更新sql
     */
    public String getUpdateSql(T bean) throws IllegalAccessException {
        String sql="update ";
        String name=bean.getClass().getSimpleName().toLowerCase().replace("bean","");
        sql+=name;
        sql+=" set ";
        Field []fields=bean.getClass().getDeclaredFields();
        boolean flag=true;
        int id=0;
        for (Field f:fields) {
            f.setAccessible(true);
            if (f.getName().equals("id")){
                id= (int) f.get(bean);
                continue;
            }
            if(!flag){sql+=" ,  ";}
            sql=sql+f.getName()+"='"+f.get(bean).toString()+"' ";
            flag=false;
        }
        sql+=" where id="+id;
        return sql;
    }

    /**
     *  获取插入sql
     */
    public String getInsertSql(T bean) throws IllegalAccessException {
        // insert into
        String sql="insert into ";
        String name=bean.getClass().getSimpleName().toLowerCase().replace("bean","");
        sql+=name;
        sql+=" ( ";
        String left ="";
        String right=" ) values (";
        Field []fields=bean.getClass().getDeclaredFields();
        boolean flag=true;
        for (Field f:fields) {
            f.setAccessible(true);
            if (f.getName().equals("id")){
                continue;
            }
            if(!flag){
                left+=",";
                right+=",";
            }
            left+=f.getName();
            right=right+"'"+f.get(bean).toString()+"'";
            flag=false;
        }
        sql=sql+left+right;
        sql+=")";
        return sql;
    }


}
