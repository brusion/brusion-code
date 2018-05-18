package com.demo;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * 数据库操作类
 *
 * @author brusion
 * @date 2018/5/14
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

    @Test
    public void insertPerson() {
        SqlSession session = getSession();
        PersonObject person = new PersonObject();
        person.setPersonName("insertPerson method name");
        person.setPersonAddress("insertPerson method address");
        session.insert("com.demo.PersonMapper.insertPerson",person);
    }
}
