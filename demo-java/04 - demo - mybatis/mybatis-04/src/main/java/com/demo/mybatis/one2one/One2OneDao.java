package com.demo.mybatis.one2one;

import com.demo.mybatis.SessionUtis;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 一对一
 *
 * @author brusion
 * @date 2018/5/21
 */
public class One2OneDao {

    @Test
    public void selectStudent() {
        SqlSession session = SessionUtis.getSession();
        One2OneStudent student = session.selectOne("one2oneMapper.selectStudent", 1);
        System.out.println(student.toString());
    }

    @Test
    public void selectStudentShot() {
        SqlSession session = SessionUtis.getSession();
        One2OneStudent student = session.selectOne("one2oneMapper.selectStudentShot", 1);
        System.out.println(student.toString());
    }
}
