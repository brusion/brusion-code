package com.dmeo.singleton.bean;

/**
 * 采用枚举方式实现单例
 *
 * @author brusion
 * @date 2018/4/19
 */
public class BeanUtils {

    //暴露方法获取实体对象
    public static Bean getBean() {
        return EnumObject.INSTANCE.getBean();
    }

    //采用枚举方式实例化对象
    private enum EnumObject {
        INSTANCE;

        private Bean bean;

        private EnumObject() {
            bean = new Bean();
        }

        public Bean getBean() {
            return bean;
        }
    }
}