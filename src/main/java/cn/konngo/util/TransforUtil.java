package cn.konngo.util;

import cn.konngo.exception.DBTransforException;

import javax.management.OperationsException;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
