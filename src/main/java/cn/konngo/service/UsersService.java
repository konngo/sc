package cn.konngo.service;

import cn.konngo.dao.UsersDao;
import cn.konngo.model.UsersBean;

import java.sql.SQLException;
import java.util.List;

public class UsersService {
    UsersDao dao=new UsersDao();

    // 获取所有用户
    public List<UsersBean> list(){
        return dao.list();
    }

    // 查找指定用户
    public UsersBean find(int id){
        return dao.search(id);
    }

    // 删除指定用户
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    // 修改指定用户
    public boolean update(UsersBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.update(bean);
    }

    // 添加用户
    public boolean insert (UsersBean bean) throws IllegalAccessException, SQLException, ClassNotFoundException {
        return dao.insert(bean);
    }
}
