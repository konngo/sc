package cn.konngo.dao;

import cn.konngo.model.StudentsBean;
import cn.konngo.util.DBUtil;
import cn.konngo.util.TransforUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
  *  学生 持久层
  */
public class StudentsDao  {
    DBUtil<StudentsBean> dbUtil=new DBUtil<>();
    TransforUtil<StudentsBean> transforUtil=new TransforUtil<>();


    //获取所有学生
    public List<StudentsBean> list()  {
        List<StudentsBean> list=new ArrayList<>();
        try {
            String sql="select  * from students";
            list=dbUtil.select(sql,transforUtil,StudentsBean.class);
        }catch (Exception e){
            e.printStackTrace();
        }
            return list;
        }

        // 条件查询
    public List<StudentsBean> list(String where) {
        List<StudentsBean> list=new ArrayList<>();
        try {
            String sql="select  * from students "+where;
            System.out.println(sql);
            list=dbUtil.select(sql,transforUtil,StudentsBean.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    // 查找学生信息
    public StudentsBean search(Integer id){
        StudentsBean studentsBean=null;
        String sql ="select * from students where id=?";
        try {
            List<StudentsBean> list=dbUtil.select(sql,transforUtil,StudentsBean.class,id);
            if (list.size()>0){
                studentsBean=list.get(0);
            }
        }catch (Exception e){
             e.printStackTrace();
        }
        return studentsBean;
    }

    // 删除学生信息
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        String sql ="delete from students  where id="+id;
        return dbUtil.excute(sql);
    }


    // 更新学生信息
    public boolean update(StudentsBean studentsBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getUpdateSql(studentsBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }


    // 添加学生信息
    public boolean insert(StudentsBean studentsBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getInsertSql(studentsBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }

    public StudentsBean findStudent(String username) {
        StudentsBean usersBean=null;
        String sql ="select * from students where sno='"+username+"'";
        try {
            List<StudentsBean> list=dbUtil.select(sql,transforUtil,StudentsBean.class);
            if (list.size()>0){
                usersBean=list.get(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return usersBean;
    }


}