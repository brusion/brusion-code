package com.demo.plugin;

import com.demo.plugin.bean.MybatisPlugin;
import com.demo.plugin.mapper.MybatisPluginMapper;
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
public class PluginTest {

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
    public void insert(){
        SqlSession session = getSession();
        MybatisPluginMapper mapper = session.getMapper(MybatisPluginMapper.class);
        MybatisPlugin plugin = new MybatisPlugin();
        plugin.setPluginAddress("address data from plugin");
        plugin.setPluginTitle("title data from plugin");
        plugin.setPluginName("name data from plugin");
        mapper.insert(plugin);
        session.commit();
    }
}