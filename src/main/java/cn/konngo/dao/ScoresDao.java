package cn.konngo.dao;

import cn.konngo.model.CourseplanBean;
import cn.konngo.model.ScoresBean;
import cn.konngo.util.DBUtil;
import cn.konngo.util.TransforUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
  *  成绩 持久层
  */
public class ScoresDao  {
    DBUtil<ScoresBean> dbUtil=new DBUtil<>();
    TransforUtil<ScoresBean> transforUtil=new TransforUtil<>();


    //获取所有成绩
    public List<ScoresBean> list(String where)  {
        List<ScoresBean> list=new ArrayList<>();
        try {
            String sql="select  * from scores "+where;
            list=dbUtil.select(sql,transforUtil,ScoresBean.class);
        }catch (Exception e){
            e.printStackTrace();
        }
            return list;
        }

    // 查找成绩信息
    public ScoresBean search(Integer id){
        ScoresBean scoresBean=null;
        String sql ="select * from scores where id=?";
        try {
            List<ScoresBean> list=dbUtil.select(sql,transforUtil,ScoresBean.class,id);
            if (list.size()>0){
                scoresBean=list.get(0);
            }
        }catch (Exception e){
             e.printStackTrace();
        }
        return scoresBean;
    }

    // 删除成绩信息
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        String sql ="delete from scores  where id="+id;
        return dbUtil.excute(sql);
    }


    // 更新成绩信息
    public boolean update(ScoresBean scoresBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getUpdateSql(scoresBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }


    // 添加成绩信息
    public boolean insert(ScoresBean scoresBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getInsertSql(scoresBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }

    public List<ScoresBean> findScore(int id) {
        List<ScoresBean> list=new ArrayList<>();
        String sql ="select * from scores where studentid='"+id+"'";
        System.out.println(sql);
        try {
            list=dbUtil.select(sql,transforUtil,ScoresBean.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


}