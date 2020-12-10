package cn.konngo.model;


import java.util.Date;
import java.io.Serializable;

/**
  *  班级
  */
public class ClassesBean implements Serializable {

        //编号
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
        //课程名称
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        //专业
        private String major;

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }
        //课时
        private int nums;

        public int getNums() {
            return nums;
        }

        public void setNums(int nums) {
            this.nums = nums;
        }
        //入学年份
        private String years;

        public String getYears() {
            return years;
        }

        public void setYears(String years) {
            this.years = years;
        }
        //辅导员
        private String fudaoyuan;

        public String getFudaoyuan() {
            return fudaoyuan;
        }

        public void setFudaoyuan(String fudaoyuan) {
            this.fudaoyuan = fudaoyuan;
        }



}
