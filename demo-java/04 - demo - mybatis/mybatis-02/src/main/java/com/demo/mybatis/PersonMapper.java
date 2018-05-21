package com.demo.mybatis;

import java.util.List;

/**
 * @author brusion
 * @date 2018/5/20
 */
public interface PersonMapper {

    void insertPerson(PersonObject person);

    void updatePerson(PersonObject person);

    void deletePerson(int personId);

    PersonObject selectPerson(int personId);

    List<PersonObject> selectList();
}
