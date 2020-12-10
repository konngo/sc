package cn.konngo.service;

import cn.konngo.dao.StudentsDao;
import cn.konngo.model.StudentsBean;

import java.sql.SQLException;
import java.util.List;

/**
  *  学生 业务层
  */
public class StudentsService {
    StudentsDao dao=new StudentsDao();

    // 获取所有学生
    public List<StudentsBean> list(){
        return dao.list();
    }

    // 查找指定学生
    public StudentsBean find(int id){
        return dao.search(id);
    }

    // 删除指定学生
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    // 修改指定学生
    public boolean update(StudentsBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.update(bean);
    }

    // 添加学生
    public boolean insert (StudentsBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.insert(bean);
    }

    public List<StudentsBean> list(String where) {return dao.list(where);
    }
}
