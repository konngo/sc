package cn.konngo.dao;

import cn.konngo.model.StudentsBean;
import cn.konngo.model.UsersBean;
import cn.konngo.util.DBUtil;
import cn.konngo.util.TransforUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 用户持久类
public class UsersDao {
    DBUtil<UsersBean> dbUtil=new DBUtil<>();
    TransforUtil<UsersBean> transforUtil=new TransforUtil<>();


    //获取所有用户
    public List<UsersBean> list()  {
        List<UsersBean> list=new ArrayList<>();
        try {
            String sql="select  * from users";
            list=dbUtil.select(sql,transforUtil,UsersBean.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    // 查找用户信息
    public UsersBean search(Integer id){
        UsersBean usersBean=null;
        String sql ="select * from users where id=?";
        try {
            List<UsersBean> list=dbUtil.select(sql,transforUtil,UsersBean.class,id);
            if (list.size()>0){
                usersBean=list.get(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return usersBean;
    }

    // 删除用户信息
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        String sql ="delete from users  where id="+id;
        return dbUtil.excute(sql);
    }


    // 更新用户信息
    public boolean update(UsersBean usersBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getUpdateSql(usersBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }


    // 添加用户信息
    public boolean insert(UsersBean usersBean) throws SQLException, ClassNotFoundException, IllegalAccessException {
        String sql =transforUtil.getInsertSql(usersBean);
        System.out.println(sql);
        return dbUtil.excute(sql);
    }


}
