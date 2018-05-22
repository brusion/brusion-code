package com.demo.mybatis.one2many;

/**
 * @author brusion
 * @date 2018/5/21
 */
public class One2manyPerson {
    /**
     * create table mybatis_one2many_person(
     * one2many_person_id int(3) auto_increment not null primary key,
     * one2many_name varchar(100),
     * one2many_email varchar(100),
     * one2many_phone varchar(15));
     */
    private int personId;
    private String personName;
    private String personEmail;
    private String personPhone;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    @Override
    public String toString() {
        return "One2manyPerson{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personEmail='" + personEmail + '\'' +
                ", personPhone='" + personPhone + '\'' +
                '}';
    }
}
