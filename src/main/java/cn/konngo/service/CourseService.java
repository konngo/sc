package cn.konngo.service;

import cn.konngo.dao.CourseDao;
import cn.konngo.model.CourseBean;

import java.sql.SQLException;
import java.util.List;

/**
  *  课程 业务层
  */
public class CourseService {
    CourseDao dao=new CourseDao();

    // 获取所有课程
    public List<CourseBean> list(String where ){
        return dao.list(where);
    }

    // 查找指定课程
    public CourseBean find(int id){
        return dao.search(id);
    }

    // 删除指定课程
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    // 修改指定课程
    public boolean update(CourseBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.update(bean);
    }

    // 添加课程
    public boolean insert (CourseBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.insert(bean);
    }
}
