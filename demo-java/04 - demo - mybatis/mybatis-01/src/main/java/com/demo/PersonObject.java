package com.demo;

/**
 * @author brusion
 * @date 2018/5/18
 */
public class PersonObject {

    private int personId;
    private String personName;
    private String personAddress;

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

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    @Override
    public String toString() {
        return "PersonObject{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personAddress='" + personAddress + '\'' +
                '}';
    }
}
