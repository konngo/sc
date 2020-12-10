package cn.konngo.model;


import java.util.Date;
import java.io.Serializable;

/**
  *  排课安排
  */
public class CourseplanBean implements Serializable {

        //排课ID
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        //课程号
        private int courseid;

        public int getCourseid() {
            return courseid;
        }

        public void setCourseid(int courseid) {
            this.courseid = courseid;
        }
        //班级号
        private int classesid;

        public int getClassesid() {
            return classesid;
        }

        public void setClassesid(int classesid) {
            this.classesid = classesid;
        }
        //授课教师
        private String teacher;

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }
        //授课时间
        private String times;

        public String getTimes() {
            return times;
        }

        public void setTimes(String times) {
            this.times = times;
        }
        //授课地点
        private String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }


    @Override
    public String toString() {
        return "CourseplanBean{" +
                "id=" + id +
                ", courseid=" + courseid +
                ", classesid=" + classesid +
                ", teacher='" + teacher + '\'' +
                ", times='" + times + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
