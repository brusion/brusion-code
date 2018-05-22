package com.demo.mybatis.many2many;

import com.demo.mybatis.SessionUtis;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 多对多
 *
 * @author brusion
 * @date 2018/5/22
 */
public class Many2ManyDao {

    @Test
    public void selectStudent() {
        SqlSession session = SessionUtis.getSession();
        List<Many2manyStudent> student = session.selectList("many2manyMapper.selectStudent", 1);
        System.out.println(student.toString());
    }

    @Test
    public void selectCart() {
        SqlSession session = SessionUtis.getSession();
        List<Many2manyCart> carts = session.selectList("many2manyMapper.selectCart", 1);
        System.out.println(carts.toString());
    }
}
