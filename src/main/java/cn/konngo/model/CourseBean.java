package cn.konngo.model;


import java.util.Date;
import java.io.Serializable;

/**
  *  课程
  */
public class CourseBean implements Serializable {

        //课程号
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        //课程名
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        //学时
        private String times;

        public String getTimes() {
            return times;
        }

        public void setTimes(String times) {
            this.times = times;
        }
        //学分
        private String scores;

        public String getScores() {
            return scores;
        }

        public void setScores(String scores) {
            this.scores = scores;
        }

    @Override
    public String toString() {
        return "CourseBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", times='" + times + '\'' +
                ", scores='" + scores + '\'' +
                '}';
    }
}
