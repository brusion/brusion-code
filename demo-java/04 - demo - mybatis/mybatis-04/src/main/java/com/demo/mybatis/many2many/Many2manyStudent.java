package com.demo.mybatis.many2many;

import java.util.ArrayList;
import java.util.List;

/**
 * @author brusion
 * @date 2018/5/21
 */
public class Many2manyStudent {

    /**
     * create table mybatis_many2many_student (
     * many2many_student_id int(3) auto_increment not null primary key,
     * many2many_name varchar(50) not null,
     * many2many_gender varchar(50) ,
     * many2many_major varchar(50) ,
     * many2many_grade varchar(50));
     */
    private int stuId;
    private String stuName;
    private String stuGender;
    private String stuMajor;
    private String stuGrade;
    private List<Many2manyCart> cartList = new ArrayList<Many2manyCart>();

    public List<Many2manyCart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Many2manyCart> cartList) {
        this.cartList = cartList;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade;
    }

    @Override
    public String toString() {
        return "Many2manyStudent{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuMajor='" + stuMajor + '\'' +
                ", stuGrade='" + stuGrade + '\'' +
                ", cartList='" + cartList + '\'' +
                '}';
    }
}
