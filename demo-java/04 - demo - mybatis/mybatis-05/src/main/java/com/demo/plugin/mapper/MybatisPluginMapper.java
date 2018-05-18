package com.demo.plugin.mapper;

import com.demo.plugin.bean.MybatisPlugin;
import com.demo.plugin.bean.MybatisPluginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MybatisPluginMapper {
    int countByExample(MybatisPluginExample example);

    int deleteByExample(MybatisPluginExample example);

    int deleteByPrimaryKey(Integer pluginId);

    int insert(MybatisPlugin record);

    int insertSelective(MybatisPlugin record);

    List<MybatisPlugin> selectByExample(MybatisPluginExample example);

    MybatisPlugin selectByPrimaryKey(Integer pluginId);

    int updateByExampleSelective(@Param("record") MybatisPlugin record, @Param("example") MybatisPluginExample example);

    int updateByExample(@Param("record") MybatisPlugin record, @Param("example") MybatisPluginExample example);

    int updateByPrimaryKeySelective(MybatisPlugin record);

    int updateByPrimaryKey(MybatisPlugin record);
}