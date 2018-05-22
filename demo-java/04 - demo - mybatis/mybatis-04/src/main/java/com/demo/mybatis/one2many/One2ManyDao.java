package com.demo.mybatis.one2many;

import com.demo.mybatis.SessionUtis;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 一对多
 *
 * @author brusion
 * @date 2018/5/21
 */
public class One2ManyDao {

    @Test
    public void selectClasses(){
        SqlSession session = SessionUtis.getSession();
      One2manyClasses classes =  session.selectOne("one2manyMapper.selectClasses",1);
        System.out.println(classes.toString());
    }
    @Test
    public void selectClasses2(){
        SqlSession session = SessionUtis.getSession();
        One2manyClasses classes = session.selectOne("one2manyMapper2.selectClasses",1);
        System.out.println(classes.toString());
    }
}
