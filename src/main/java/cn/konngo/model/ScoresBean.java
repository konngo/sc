package cn.konngo.model;


import java.util.Date;
import java.io.Serializable;

/**
  *  
  */
public class ScoresBean implements Serializable {

        //
        private int studentid;

        public int getStudentid() {
            return studentid;
        }

        public void setStudentid(int studentid) {
            this.studentid = studentid;
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
        private double score;

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }



}
