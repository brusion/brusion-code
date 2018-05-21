package com.demo.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * 数据测试类
 *
 * @author brusion
 * @date 2018/5/20
 */
public class PersonDao {

    public SqlSession getSession() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            return factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PersonMapper getMapper(SqlSession session) {
        return session.getMapper(PersonMapper.class);
    }

    @Test
    public void insertPerson() {
        PersonObject object = new PersonObject();
        object.setPersonAddress("insert address ");
        object.setPersonName("insert name");
        SqlSession session = getSession();
        session.insert("com.demo.mybatis.PersonMapper.insertPerson", object);
        session.commit();
    }

    @Test
    public void updatePerson() {
        PersonObject object = new PersonObject();
        object.setPersonAddress("update address ");
        object.setPersonName("update name");
        object.setPersonId(13);
        SqlSession session = getSession();
        session.update("com.demo.mybatis.PersonMapper.updatePerson", object);
    }

    @Test
    public void deletePerson() {
        SqlSession session = getSession();
        session.delete("com.demo.mybatis.PersonMapper.deletePerson", 14);
        session.commit();
    }

    @Test
    public void selectPerson() {
        SqlSession session = getSession();
        PersonObject personObject = session.selectOne("com.demo.mybatis.PersonMapper.selectPerson", 15);
        session.commit();
        System.out.println(personObject.toString());
    }

    @Test
    public void selectList() {
        SqlSession session = getSession();
        PersonObject object = new PersonObject();
        object.setPersonName("name");
        List<PersonObject> list = session.selectList("com.demo.mybatis.PersonMapper.selectList");
    }


    @Test
    public void insertByMapper() {
        PersonObject object = new PersonObject();
        object.setPersonName("insert name by mapper");
        object.setPersonAddress("insert address by mapper");
        SqlSession session = getSession();
        PersonMapper mapper = getMapper(session);
        mapper.insertPerson(object);
        session.commit();
    }

    @Test
    public void updateByMapper(){
        PersonObject object = new PersonObject();
        object.setPersonName("update name by mapper");
        object.setPersonAddress("update address by mapper");
        object.setPersonId(9);
        SqlSession session = getSession();
        PersonMapper mapper = getMapper(session);
        mapper.updatePerson(object);
        session.commit();
    }

    @Test
    public void deleteByMapper(){
        SqlSession session = getSession();
        PersonMapper mapper = getMapper(session);
        mapper.deletePerson(10);
        session.commit();
    }

    @Test
    public void selectByMapper(){
        SqlSession session = getSession();
        PersonMapper mapper = getMapper(session);
        PersonObject object = mapper.selectPerson(9);
        session.commit();
        System.out.println(object.toString());
    }

    @Test
    public void selectListByMapper(){
        SqlSession session = getSession();
        PersonMapper mapper = getMapper(session);
        List<PersonObject> list = mapper.selectList();
        System.out.println(list.size());
    }
}
