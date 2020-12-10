package cn.konngo.service;

import cn.konngo.dao.ClassesDao;
import cn.konngo.model.ClassesBean;

import java.sql.SQLException;
import java.util.List;

/**
  *  班级 业务层
  */
public class ClassesService {
    ClassesDao dao=new ClassesDao();

    // 获取所有班级
    public List<ClassesBean> list(String where){
        return dao.list(where);
    }

    // 查找指定班级
    public ClassesBean find(int id){
        return dao.search(id);
    }

    // 删除指定班级
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    // 修改指定班级
    public boolean update(ClassesBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.update(bean);
    }

    // 添加班级
    public boolean insert (ClassesBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.insert(bean);
    }
}
