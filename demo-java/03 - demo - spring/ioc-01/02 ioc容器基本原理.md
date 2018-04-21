# spring IOC容器基本原理
##### 本篇内容
* 1、ioc代码简单实现
* 2、ioc容器配置（id，name）
* 3、实例化Bean：构造器，工厂

## 一、IOC代码的简单实现
* ﻿核心思想：创建java实体对象，将实体对象注册到Spring的容器，使用时再从容器中获取对象。

### 1.1、代码简单实现
#### 1.1.1、定义接口：定义实体具体业务
```$xslt
package com.demo.ioc;

/**
 * @author brusion
 * @date 2018/4/16
 */
public interface BeanApi {
    void sayHello();
}
```
#### 1.1.2、定义实体：实现具体接口操作
```$xslt
package com.demo.ioc;

/**
 * @author brusion
 * @date 2018/4/16
 */
public class Bean implements BeanApi {

    @Override
    public void sayHello() {
        System.out.println("hello spring");
    }
}
```

#### 1.1.3、将实体添加到配置文件：注册到Spring容器中（Spring-config.xml）
```$xslt
 <bean id="bean" class="com.demo.ioc.Bean"/>
```

#### 1.1.4、测试：从Spring容器中取出注册的对象，并调用对象的方法
```$xslt
    @Test
    public void sayHello() {
        //简单使用ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Bean bean = (Bean) context.getBean("bean");
        bean.sayHello();
    }
```

#### 1.1.5、 配置说明
* 标签bean：声明当前配置为实体对象
* 属性id：实体对象注册到Spring容器中的id值（id值唯一）
* 属性class：实体对象具体的类路径

### 1.2、ioc容器详解
#### 1.2.1 BeanFactory
* spring IOC容器的核心就是BeanFactory
* BeanFactory提供的ioc容器的基本接口
* ApplicationContext接口是对BeanFactory的扩展

#### 1.2.1 BeanFactory的具体实现类
* XmlBeanFactory：已经过时的，提供通过path和File方式获取配置文件
* ClassPathXmlApplicationContext：提供从path方式获配置文件
* FileSystemXmlApplicationContext：提供从File的方式获取配置文件


## 二、IOC容器配置（id，name,class）
* 将实体注册到Spring容器有机制方式：通过id，通过name，通过别名，直接通过class类型
* Spring从容器中获取实体优先级：id，name，别名，class
* 核心：在将实体注册到Spring容器中使用不同方式注册，并根据不同方式获取实体对象

### 2.1、代码实现Spring的ioc容器配置
#### 2.1.1、配置文件：将实体注册到Spring容器中
```$xslt
    <!--使用id方式注册-->
    <bean id="bean" class="com.demo.ioc.Bean"/>

    <!--使用Class类方式注册-->
    <bean class="com.demo.ioc.Bean"/>

    <!--使用name方式注册-->
    <bean name="byName" class="com.demo.ioc.Bean"/>
```
#### 2.1.2、测试：从容器中获取实体对象
```$xslt
    @Test
    public void getBean() {
        //使用不同方式获取到实体对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        Bean byName = (Bean) context.getBean("byName");
        Bean byClass = context.getBean(Bean.class);

        byClass.sayHello();
//        byName.sayHello();
    }
```
#### 2.1.3 注意：
* 在测试使用class获取对象时需要将注释吊name，id在容器中的配置，因为Spring会优先匹配id和name

### 2.2、Spring中配置文件中实体注册规则：
#### 2.2.1、id命名
* 每个实体可以有一个或多个id在容器中，但是id不能同名。
* 第一个id称为标识符，其余id称为别名
* 不指定id必须配置实体class（可以通过class获取到实体）

#### 2.2.2、name命名
* 当没有配置id时，name就是实体在容器中的标识符
* 同时指定id和name时，id是标识符，name是别名
* 指定多个name时需要用逗号，分号，顿号，空格任意一种隔开
* 多个实体可以定义相同的name

### 2.3、实体bean在Spring中的命名规则
* bean的命名遵循xml命名规则一般由：字面，数字，下划线组成
* bean的命名一般采用驼峰命名

## 三、实例化Bean：构造器，工厂
* bean实例化一般采用构造器方式或工厂类方式

### 3.1、采用构造器实例化对象
* 核心：实体类创建构造方法，在配置文件中给实体配置对应的参数进行实例化
#### 3.1.1、代码实现构造器实例化对象
##### 3.1.1.1、创建带参构造方法的实体类
```$xslt
/**
 * 定义带参构造方法用于在xml中添加数据
 *
 * @author brusion
 * @date 2018/4/16
 */
public class BeanData {
    private String data;

    public BeanData(String data) {
        this.data = data;
    }

    public void getData() {
        System.out.println("get data:" + data);
    }
}
```
##### 3.1.1.2、将对象注册到容器，并是容器中添加参数用于实例化对象
```$xslt
    <!--给带参实体添加数据-->
    <bean id="dataBean" class="com.demo.ioc.BeanData">
        <constructor-arg index="0" value="test data from xml"/>
    </bean>
```
##### 3.1.1.3、从容器时候获取到注册对象
```$xslt
    @Test
    public void getTestData() {
        //使用构造器方式创建实体
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BeanData dataBean = (BeanData) context.getBean("dataBean");
        dataBean.getData();
    }
```
##### 3.1.1.4、配置文件说明
* 标签constructor-arg：申明构造方法
* 属性index：设置构造方法中第几个参数
* 属性value：设置构造方法第几个参数对应的值

#### 3.2、采用工厂类实例化对象
* 核心：创建工厂类，并在配置文件中将工厂类注册到容器，并配置工厂类中对象构造方法值

##### 3.2.1、代码实现工厂类方式实例化对象
###### 3.2.1.1、创建工厂类
```$xslt
public class StaticBeanFactory {
    public static BeanData newInstance(String data) {
        return new BeanData(data);
    }
}
```
###### 3.2.1.2、将工厂对象注册到Spring容器中
```$xslt
    <!--使用静态工厂类方式配置实体-->
    <bean id="staticFactory" class="com.demo.ioc.StaticBeanFactory" factory-method="newInstance">
        <constructor-arg index="0" value="factory bean data from xml"/>
    </bean>
```
###### 3.2.1.3、测试：从Spring容器中直接获取实体bean对象
```$xslt
    @Test
    public void getStaticFactory() {
        //使用静态工厂类方式创建实体
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BeanData dataBean = (BeanData) context.getBean("staticFactory");
        dataBean.getData();
    }
```
###### 3.2.1.4、配置说明：
* 属性factory-method：工厂类中创建实体对象的方法
* 标签constructor-arg：实体对象构造方法配置
* 属性index：实体对象构造方法第几个参数
* 属性value：实体对象构造方法参数对应的值