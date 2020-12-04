package cn.konngo.model;


import java.util.Date;
import java.io.Serializable;

/**
  *  
  */
public class CourseBean implements Serializable {

        //
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        //
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
        private String scores;

        public String getScores() {
            return scores;
        }

        public void setScores(String scores) {
            this.scores = scores;
        }



}
