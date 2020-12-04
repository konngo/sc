package cn.konngo.model;


import java.util.Date;
import java.io.Serializable;

/**
  *  
  */
public class CourseplanBean implements Serializable {

        //
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        //
        private int courseid;

        public int getCourseid() {
            return courseid;
        }

        public void setCourseid(int courseid) {
            this.courseid = courseid;
        }
        //
        private int classesid;

        public int getClassesid() {
            return classesid;
        }

        public void setClassesid(int classesid) {
            this.classesid = classesid;
        }
        //
        private String teacher;

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }
        //
        private String times;

        public String getTimes() {
            return times;
        }

        public void setTimes(String times) {
            this.times = times;
        }
        //
        private String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }



}
