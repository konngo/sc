package cn.konngo.model;


import java.util.Date;
import java.io.Serializable;

/**
  *  成绩
  */
public class ScoresBean implements Serializable {

        //学生编号
        private int studentid;

        public int getStudentid() {
            return studentid;
        }

        public void setStudentid(int studentid) {
            this.studentid = studentid;
        }
        //课程编号
        private int courseid;

        public int getCourseid() {
            return courseid;
        }

        public void setCourseid(int courseid) {
            this.courseid = courseid;
        }
        //成绩
        private String  score;

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }



}
