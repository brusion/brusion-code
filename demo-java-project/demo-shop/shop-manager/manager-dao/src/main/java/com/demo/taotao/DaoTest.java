package com.demo.taotao;

import com.demo.taotao.bean.TbItem;
import com.demo.taotao.mapper.TbItemMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @author brusion
 * @date 2018/5/18
 */
public class DaoTest {

    public SqlSession getSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        return factory.openSession();
    }

    @Test
    public void insert() throws IOException {
        SqlSession session = getSession();
        TbItemMapper mapper = session.getMapper(TbItemMapper.class);
        TbItem item = mapper.selectByPrimaryKey((long) 1145177);
        System.out.println(item.toString());
    }
}
