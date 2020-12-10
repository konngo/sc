package cn.konngo.dao;

import cn.konngo.model.ClassesBean;
import cn.konngo.model.CourseBean;
import cn.konngo.model.CourseplanBean;
import cn.konngo.util.DBUtil;
import cn.konngo.util.TransforUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
  *  课程 持久层
  */
public class CourseDao  {
    DBUtil<CourseBean> dbUtil=new DBUtil<>();
    TransforUtil<CourseBean> transforUtil=new TransforUtil<>();


    //获取所有课程
    public List<CourseBean> list(String where )  {
        List<CourseBean> list=new ArrayList<>();
        try {
            String sql="select  * from course "+where;
            list=dbUtil.select(sql,transforUtil,CourseBean.class);
        }catch (Exception e){
            e.printStackTrace();
        }
            return list;
        }

    // 查找课程信息
    public CourseBean search(Integer id){
        CourseBean courseBean=null;
        String sql ="select * from course where id=?";
        try {
            List<CourseBean> list=dbUtil.select(sql,transforUtil,CourseBean.class,id);
            if (list.size()>0){
                courseBean=list.get(0);
            }
        }catch (Exception e){
             e.printStackTrace();
        }
        return courseBean;
    }

    // 删除课程信息
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        String sql ="delete from course  where id="+id;
        return dbUtil.excute(sql);
    }


    // 更新课程信息
    public boolean update(CourseBean courseBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getUpdateSql(courseBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }


    // 添加课程信息
    public boolean insert(CourseBean courseBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getInsertSql(courseBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }


    public List<CourseBean> findCoursePlan(int id) {
        List<CourseBean> list=new ArrayList<>();
        String sql ="select course.* from course,courseplan where course.id=courseplan.courseid and courseplan.classesid='"+id+"'";
        System.out.println(sql);
        try {
            list=dbUtil.select(sql,transforUtil,CourseBean.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}