package com.demo.constructor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author brusion
 * @date 2018/8/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/constructor.xml"})
public class ConstructorObjectTest {

    @Autowired
    public ConstructorObject constructorObject_name;
    @Autowired
    public ConstructorObject constructorObject_type;
    @Autowired
    public ConstructorObject constructorObject_index;
    @Autowired
    public ConstructorObject constructorObject_reflection;

    @Test
    public void getBeanByName() {
        constructorObject_name.getData();
    }

    @Test
    public void getBeanByType() {
        constructorObject_type.getData();
    }

    @Test
    public void getBeanByIndex() {
        constructorObject_index.getData();
    }

    @Test
    public void getBeanByReflection() {
        constructorObject_reflection.getData();
    }

}