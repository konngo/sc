package cn.konngo.service;

import cn.konngo.dao.ScoresDao;
import cn.konngo.model.ScoresBean;

import java.sql.SQLException;
import java.util.List;

/**
  *  成绩 业务层
  */
public class ScoresService {
    ScoresDao dao=new ScoresDao();

    // 获取所有成绩
    public List<ScoresBean> list(String where){
        return dao.list(where);
    }

    // 查找指定成绩
    public ScoresBean find(int id){
        return dao.search(id);
    }

    // 删除指定成绩
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    // 修改指定成绩
    public boolean update(ScoresBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.update(bean);
    }

    // 添加成绩
    public boolean insert (ScoresBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.insert(bean);
    }
}
