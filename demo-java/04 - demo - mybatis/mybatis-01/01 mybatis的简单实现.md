## mybatis 的简单实现
* 1、创建maven项目（采用maven+idea构建项目）
* 2、数据库表创建（data.sql）
* 3、创建java实体对象
* 4、创建mapper映射文件
* 5、创建mybatis配置文件
* 6、创建测试类数据库操作

### 一、数据库创建
```
create table mybatis_person (
person_id int(3) auto_increment not null primary key,
person_name varchar(200),
person_address varchar(200)
)
```
#### 1、说明：
* 1、数据库表名为：mybatis_person
* 2、数据库id为：person_id，id不能为空，并未主键id，自动增长（数据插入时不需要设置id值）
* 3、数据库其他字段：person_name，person_address 都是String类型，长度为200

### 二、maven配置与java实体创建
#### 1、maven库配置
```
 <dependencies>

        <!--mybatis库-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.5</version>
        </dependency>

        <!--数据库连接库-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.45</version>
        </dependency>

        <!--基础包-->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.7</version>
        </dependency>
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.6</version>
        </dependency>
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>1.2</version>
        </dependency>

        <!--log库-->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <!--测试库-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.0</version>
        </dependency>
    </dependencies>
```

#### 2、java实体创建
* 根据数据库字段创建java实体
* 省略get，set方法
```
public class PersonObject {

    private int personId;
    private String personName;
    private String personAddress;
}
```
### 三、创建mapper映射文件：PersonMapper.xml
* 一般在maven项目将映射文件放在：resource下的mapper文件夹下
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.demo.PersonMapper">

    <resultMap id="personResult" type="com.demo.PersonObject">
        <id property="personId" column="person_id"/>
        <result property="personName" column="person_name"/>
        <result property="personAddress" column="person_address"/>
    </resultMap>

    <insert id="insertPerson" parameterType="com.demo.PersonObject">
        insert into mybatis_person (person_name,person_address) values (#{personName},#{personAddress})
    </insert>

</mapper>
```
#### mapper配置文件说明
##### 1、namespace：命名空间
* 配置当前mapper文件的命名空间
* sqlSession需要通过命名空间找到当前mapper对象

##### 2、resultMap：一个实体映射对象
* id="personResult"：指定当前映射实体的id值（当前映射对象id为personResult）
* type：当前实体映射对象对应的java实体对象（当前映射对象对应的实体对象是PersonObject）
* id标签：配置当前映射实体对象对应的java实体对象中的id值，
* property：当前字段在java实体对象中的属性名
* column：当前字段在数据库表中的字段名称
* result：java实体对象中的普通属性配置

### 四、创建mybatis配置文件：mybatis-config.xml
* 一般将文件存放在resource文件夹下面
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp;characterEncoding=UTF-8" />
            </dataSource>
        </environment>
    </environments>

    <mappers >
        <mapper resource="mapper/PersonMapper.xml"/>
    </mappers>
</configuration>
```

#### mybatis配置文件说明
##### 1、数据库环境配置
* 标签 environments：指定数据源环境
* 属性 default：指的是使用哪个数据源（development：表示开发环境）

* 标签 environment：定义数据源的信息
* 属性 id：当前对应的环境（development：表示开发环境）

* 标签 transactionManager：事务配置
* 属性 type：使用的事务类型（JDBC：表示事务由jdbc连接管理，MANAGED：表示事务由容器来管）

* 标签 dataSource：数据库连接
* 属性 type：数据库连接方式（POOLED：表示使用连接池，UNPOOLED：表示不使用连接池）

* 标签 property：配置具体数据库连接池参数
* 属性 drive：数据库驱动
* 属性 url：数据库连接地址
* 属性 username：数据库访问账号
* 属性 password：数据库访问密码

##### 2、mapper配置
* 标签 mappers：定义mapper容器（内部可以哟多个mapper对象）
* 标签 mapper：定义一个具体的mapper对象
* 属性 resource：具体的mapper路径
* 注意：如果没有定义mapper数据对象映射失败

### 五、数据测试：
```
public class PersonDao {

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
    public void insertPerson() {
        SqlSession session = getSession();
        PersonObject person = new PersonObject();
        person.setPersonName("insertPerson method name");
        person.setPersonAddress("insertPerson method address");
        session.insert("com.demo.PersonMapper.insertPerson",person);
    }
}
```

#### 测试代码说明：
* Resources.getResourceAsReader：获取到mybatis配置资源文件
* SqlSessionFactory：用于获取到SqlSession对象
*  session.insert(String,object)：String为mapper文件中的命名空间+配置的sql语句id


### 六、执行后sql语句
```
Preparing: insert into mybatis_person (person_name,person_address) values (?,?) 
Parameters: insertPerson method name(String), insertPerson method address(String)
```

### 七、代码地址
https://github.com/brusion/brusion-code/tree/master/demo-java/04%20-%20demo%20-%20mybatis/mybatis-01