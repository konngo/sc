package cn.konngo.dao;

import cn.konngo.model.ClassesBean;
import cn.konngo.model.CourseBean;
import cn.konngo.model.StudentsBean;
import cn.konngo.util.DBUtil;
import cn.konngo.util.TransforUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
  *  班级 持久层
  */
public class ClassesDao  {
    DBUtil<ClassesBean> dbUtil=new DBUtil<>();
    TransforUtil<ClassesBean> transforUtil=new TransforUtil<>();


    //获取所有班级
    public List<ClassesBean> list(String where)  {
        List<ClassesBean> list=new ArrayList<>();
        try {
            String sql="select  * from classes "+where;
            list=dbUtil.select(sql,transforUtil,ClassesBean.class);
        }catch (Exception e){
            e.printStackTrace();
        }
            return list;
        }

    // 查找班级信息
    public ClassesBean search(Integer id){
        ClassesBean classesBean=null;
        String sql ="select * from classes where id=?";
        try {
            List<ClassesBean> list=dbUtil.select(sql,transforUtil,ClassesBean.class,id);
            if (list.size()>0){
                classesBean=list.get(0);
            }
        }catch (Exception e){
             e.printStackTrace();
        }
        return classesBean;
    }

    // 删除班级信息
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        String sql ="delete from classes  where id="+id;
        return dbUtil.excute(sql);
    }


    // 更新班级信息
    public boolean update(ClassesBean classesBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getUpdateSql(classesBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }


    // 添加班级信息
    public boolean insert(ClassesBean classesBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getInsertSql(classesBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }

    public ClassesBean findStudent(String classes) {
        ClassesBean usersBean=null;
        String sql ="select * from classes where id='"+classes+"'";
        try {
            List<ClassesBean> list=dbUtil.select(sql,transforUtil,ClassesBean.class);
            if (list.size()>0){
                usersBean=list.get(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return usersBean;
    }

}