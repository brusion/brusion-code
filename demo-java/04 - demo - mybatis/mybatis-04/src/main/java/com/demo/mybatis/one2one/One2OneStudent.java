package com.demo.mybatis.one2one;

/**
 * @author brusion
 * @date 2018/5/21
 */
public class One2OneStudent {

    /**
     * one2one_stud_id int(3)auto_increment not null primary key,
     * one2one_name varchar(20) not null,
     * one2one_email varchar(20),
     * one2one_dob date,
     * one2one_phone varchar(15),
     * one2one_addr_id int references addresses(one2one_addr_id));
     */

    private int stuId;
    private String stuName;
    private String stuEmail;
    private String stuDob;
    private String stuPhone;
    private One2OneAddress stuAddress = new One2OneAddress();

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

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuDob() {
        return stuDob;
    }

    public void setStuDob(String stuDob) {
        this.stuDob = stuDob;
    }

    public String getStuPhone() {
        return stuPhone;
    }

    public void setStuPhone(String stuPhone) {
        this.stuPhone = stuPhone;
    }

    public One2OneAddress getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(One2OneAddress stuAddress) {
        this.stuAddress = stuAddress;
    }

    @Override
    public String toString() {
        return "One2OneStudent{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuEmail='" + stuEmail + '\'' +
                ", stuDob='" + stuDob + '\'' +
                ", stuPhone='" + stuPhone + '\'' +
                ", stuAddress=" + stuAddress +
                '}';
    }
}
