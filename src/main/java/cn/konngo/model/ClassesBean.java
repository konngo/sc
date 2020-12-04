package cn.konngo.model;


import java.util.Date;
import java.io.Serializable;

/**
  *  
  */
public class ClassesBean implements Serializable {

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
        private String major;

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }
        //
        private int nums;

        public int getNums() {
            return nums;
        }

        public void setNums(int nums) {
            this.nums = nums;
        }
        //
        private String years;

        public String getYears() {
            return years;
        }

        public void setYears(String years) {
            this.years = years;
        }
        //
        private String fudaoyuan;

        public String getFudaoyuan() {
            return fudaoyuan;
        }

        public void setFudaoyuan(String fudaoyuan) {
            this.fudaoyuan = fudaoyuan;
        }



}
