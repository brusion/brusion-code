package com.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂类
 *
 * @author brusion
 * @date 2018/2/16
 */
public class BeanFactory {

    /**
     *  采用直接创建方式创建业务类
     */
    public UserService createUserService(){
      return   new UserServiceImp();
    }

    /**
     * 采用代理对象方式创建业务方法
     */
    public UserService getUserService(){

        final UserService service = new UserServiceImp();
        final MyAspect aspect = new MyAspect();
        UserService userService = (UserService) Proxy.newProxyInstance(
                BeanFactory.class.getClassLoader(),
                service.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        aspect.befor();
                        Object object = method.invoke(service, args);
                        aspect.after();
                        return object;
                    }
                });

        return   userService;
    }
}