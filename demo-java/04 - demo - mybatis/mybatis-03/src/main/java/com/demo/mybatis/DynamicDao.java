package com.demo.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态sql
 *
 * @author brusion
 * @date 2018/5/22
 */
public class DynamicDao {

    public SqlSession getSession() {
        SqlSession session = null;
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            return factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
            session.rollback();
            return null;
        }
    }


    @Test
    public void insert() {
        SqlSession session = getSession();
        DynamicObject object = new DynamicObject();
        object.setDynamicDesc("insert desc from insert method");
        object.setDynamicName("insert name from insert method");
        object.setDynamicTitle("insert title from insert method");
        session.insert("DynamicMapper.insertDynamic", object);
        session.commit();
    }

    @Test
    public void selectByLike() {
        SqlSession session = getSession();
        DynamicObject object = new DynamicObject();
        object.setDynamicName("insert name from insert method");
        object.setDynamicTitle("insert title from insert method");
        List<DynamicObject> select = session.selectList("DynamicMapper.selectByLike", object);
        System.out.println(select.toString());
        session.commit();
    }


    @Test
    public void selectByWhere() {
        SqlSession session = getSession();
        DynamicObject object = new DynamicObject();
        object.setDynamicName("insert name from insert method");
        List<DynamicObject> select = session.selectList("DynamicMapper.selectByWhere", object);
        System.out.println(select.toString());
        session.commit();
    }

    @Test
    public void selectByChoose() {
        SqlSession session = getSession();
        DynamicObject object = new DynamicObject();
        object.setDynamicName("insert name from insert method");
        List<DynamicObject> select = session.selectList("DynamicMapper.selectByChoose", object);
        System.out.println(select.toString());
        session.commit();
    }

    @Test
    public void updateSet() {
        SqlSession session = getSession();
        DynamicObject object = new DynamicObject();
        object.setDynamicId(3);
        object.setDynamicName("update set name");
        session.update("DynamicMapper.updateSet", object);
        session.commit();
    }

    @Test
    public void selectForeach() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(5);
        list.add(6);

        SqlSession session = getSession();
        List<DynamicObject> objectList = session.selectList("DynamicMapper.selectForeach", list);
        System.out.println(objectList.toString());
    }

    @Test
    public void includeInsert(){
        SqlSession session = getSession();
        DynamicObject object = new DynamicObject();
        object.setDynamicName("insert  name by include");
        object.setDynamicTitle("insert  title by include");
        session.update("DynamicMapper.includeInsert", object);
        session.commit();
    }
}
