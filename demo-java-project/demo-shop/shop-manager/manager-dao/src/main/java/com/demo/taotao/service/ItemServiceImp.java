package com.demo.taotao.service;

import com.demo.taotao.bean.TbItem;
import com.demo.taotao.mapper.TbItemMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;

/**
 * 商品查询
 *
 * @author brusion
 * @date 2018/5/13
 */
@Service
public class ItemServiceImp implements ItemService {

    @Override
    public TbItem getItemById(Long itemId) {
        SqlSession session = getSession();
        TbItemMapper mapper = session.getMapper(TbItemMapper.class);
        TbItem item = mapper.selectByPrimaryKey(itemId);
        return item;
    }


    public SqlSession getSession() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            return factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
