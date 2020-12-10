package cn.konngo.dao;

import cn.konngo.model.CourseBean;
import cn.konngo.model.CourseplanBean;
import cn.konngo.util.DBUtil;
import cn.konngo.util.TransforUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
  *  排课安排 持久层
  */
public class CourseplanDao  {
    DBUtil<CourseplanBean> dbUtil=new DBUtil<>();
    TransforUtil<CourseplanBean> transforUtil=new TransforUtil<>();


    //获取所有排课安排
    public List<CourseplanBean> list (String where)  {
        List<CourseplanBean> list=new ArrayList<>();
        try {
            String sql="select  * from courseplan " +where;
            list=dbUtil.select(sql,transforUtil,CourseplanBean.class);
        }catch (Exception e){
            e.printStackTrace();
        }
            return list;
        }

    // 查找排课安排信息
    public CourseplanBean search(Integer id){
        CourseplanBean courseplanBean=null;
        String sql ="select * from courseplan where id=?";
        try {
            List<CourseplanBean> list=dbUtil.select(sql,transforUtil,CourseplanBean.class,id);
            if (list.size()>0){
                courseplanBean=list.get(0);
            }
        }catch (Exception e){
             e.printStackTrace();
        }
        return courseplanBean;
    }

    // 删除排课安排信息
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        String sql ="delete from courseplan  where id="+id;
        return dbUtil.excute(sql);
    }


    // 更新排课安排信息
    public boolean update(CourseplanBean courseplanBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getUpdateSql(courseplanBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }


    // 添加排课安排信息
    public boolean insert(CourseplanBean courseplanBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getInsertSql(courseplanBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }

    public List<CourseplanBean> findCourse(int id) {
        List<CourseplanBean> list=new ArrayList<>();
        String sql ="select * from courseplan where courseplan.classesid='"+id+"'";
        System.out.println(sql);
        try {
            list=dbUtil.select(sql,transforUtil,CourseplanBean.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}