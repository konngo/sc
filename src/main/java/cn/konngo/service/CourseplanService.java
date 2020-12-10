package cn.konngo.service;

import cn.konngo.dao.CourseplanDao;
import cn.konngo.model.CourseBean;
import cn.konngo.model.CourseplanBean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
  *  排课安排 业务层
  */
public class CourseplanService {
    CourseplanDao dao=new CourseplanDao();

    // 获取所有排课安排
    public List<CourseplanBean> list(String  where){
        return dao.list(where);
    }

    // 查找指定排课安排
    public CourseplanBean find(int id){
        return dao.search(id);
    }

    // 删除指定排课安排
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    // 修改指定排课安排
    public boolean update(CourseplanBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.update(bean);
    }

    // 添加排课安排
    public boolean insert (CourseplanBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.insert(bean);
    }


}
