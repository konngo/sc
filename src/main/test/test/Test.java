package test;

import cn.konngo.dao.UsersDao;
import cn.konngo.model.UsersBean;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        UsersBean usersBean=new UsersBean();
        usersBean.setId(1);
        usersBean.setPassword("123123");
        usersBean.setUsername("admin2");
        usersBean.setType("学生");
        try {
            new UsersDao().insert(usersBean);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
