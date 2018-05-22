package com.demo.mybatis.one2many;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author brusion
 * @date 2018/5/21
 */
public class One2manyClasses {
    /**
     * create table mybatis_one2many_classes(
     * one2many_classes_id int(3) auto_increment not null primary key,
     * one2many_name varchar(100) not null,
     * one2many_description varchar(512),
     * one2many_start_date date ,
     * one2many_end_date date ,
     * one2many_person_ids int references mybatis_one2many_tutors (one2many_person_id));
     */

    private int classId;
    private String className;
    private String classDescription;
    private Date startDate;
    private Date endDate;
    private List<One2manyPerson> personList = new ArrayList<One2manyPerson>();

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<One2manyPerson> getPersonList() {
        return personList;
    }

    public void setPersonList(List<One2manyPerson> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "One2manyClasses{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classDescription='" + classDescription + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", personList=" + personList +
                '}';
    }
}