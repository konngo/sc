package cn.konngo.service;

import cn.konngo.dao.*;
import cn.konngo.model.*;

import java.sql.SQLException;
import java.util.List;

public class UsersService {
    UsersDao dao=new UsersDao();
    StudentsDao studentsDao=new StudentsDao();
    ClassesDao classesDao=new ClassesDao();
    CourseDao courseDao=new CourseDao();
    CourseplanDao courseplanDao=new CourseplanDao();
    ScoresDao scoresDao=new ScoresDao();

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

    //denglu
    public UsersBean login(String username, String password) {
        List<UsersBean> list=dao.list();
        for (UsersBean bean: list) {
            if (bean.getUsername().equals(username)&&bean.getPassword().equals(password)){
                return bean;
            }
        }
        return null;
    }

    public StudentsBean findStudents(UsersBean user) {
        return  studentsDao.findStudent(user.getUsername());
    }

    public ClassesBean findClazz(StudentsBean studentsBean) {
        return  classesDao.findStudent(studentsBean.getClasses());
    }

    public List<CourseplanBean> findCourse(int id) {
        return  courseplanDao.findCourse(id);
    }

    public List<CourseBean> findCoursePlan(int id) {
        return courseDao.findCoursePlan(id);
    }

    public List<ScoresBean> findScore(int id) {
        return scoresDao.findScore(id);
    }
}
