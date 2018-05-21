# mybatis的crud操作
* 采用两种方式：
* 1、通过sqlSession操作mapper映射文件
* 2、采用mapper接口操作映射文件

## 一、基本数据准备
* 1、数据库表创建，maven配置
* 2、java实体创建
* 3、mapper映射文件创建
* 4、mybatis配置文件设置
### 1.1、数据库表创建，maven配置
#### 1.1.1、数据库表创建
```
create table mybatis_person (
person_id int(3) auto_increment not null primary key,
person_name varchar(200),
person_address varchar(200)
)
```
#### 1.1.2、maven配置
```
 <dependencies>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.5</version>
        </dependency>

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
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.0</version>
        </dependency>

        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.0</version>
        </dependency>

    </dependencies>
```

### 1.2、java实体创建
* get，set方法省略
```
public class PersonObject {
    private int personId;
    private String personName;
    private String personAddress;
}
```

### 1.3、mapper映射文件创建
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.demo.mybatis.PersonMapper">

    <resultMap id="personResult" type="PersonObject">
        <id property="personId" column="person_id"/>
        <result property="personName" column="person_name"/>
        <result property="personAddress" column="person_address"/>
    </resultMap>

    <insert id="insertPerson" parameterType="PersonObject">
        insert into mybatis_person (person_name,person_address) values (#{personName},#{personAddress})
    </insert>

    <update id="updatePerson" parameterType="PersonObject">
        update mybatis_person set person_name = #{personName} , person_address= #{personAddress}
        where person_id =#{personId}
    </update>

    <delete id="deletePerson" parameterType="int">
        delete from mybatis_person where person_id = #{personId}
    </delete>

    <select id="selectPerson" parameterType="int" resultMap="personResult">
        select * from mybatis_person where person_id = #{personId}
    </select>

    <select id="selectList" resultMap="personResult" >
           select * from mybatis_person
    </select>

</mapper>
```
* type="PersonObject"：采用了别名配置，在mybatis配置文件中配置
* insert：配置insert语句
* select：配置select语句
* delete：配置delete语句
* update：配置update语句

### 1.4、mybatis配置文件设置
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <typeAliases>
        <!--定义别名-->
        <typeAlias type="com.demo.mybatis.PersonObject" alias="PersonObject"/>
    </typeAliases>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url"
                          value="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&amp;characterEncoding=UTF-8"/>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper resource="mapper/PersonMapper.xml"/>
    </mappers>
</configuration>
```
* typeAliases：别名配置
* environments：环境配置
* mapper：mapper映射文件配置

## 二、测试：采用sqlSession操作映射文件

### 2.1、工具类创建
```
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

    public PersonMapper getMapper(SqlSession session) {
        return session.getMapper(PersonMapper.class);
    }
```
### 2.2、数据插入
```
    @Test
    public void insertPerson() {
        PersonObject object = new PersonObject();
        object.setPersonAddress("insert address ");
        object.setPersonName("insert name");
        SqlSession session = getSession();
        session.insert("com.demo.mybatis.PersonMapper.insertPerson", object);
        session.commit();
    }
```
* 执行的sql语句
```
Preparing: insert into mybatis_person (person_name,person_address) values (?,?) 
Parameters: insert name(String), insert address (String)
```

### 2.3、update操作

```
    @Test
    public void updatePerson() {
        PersonObject object = new PersonObject();
        object.setPersonAddress("update address ");
        object.setPersonName("update name");
        object.setPersonId(13);
        SqlSession session = getSession();
        session.update("com.demo.mybatis.PersonMapper.updatePerson", object);
    }
```

* 执行sql语句
```
Preparing: update mybatis_person set person_name = ? , person_address= ? where person_id =? 
Parameters: update name(String), update address (String), 13(Integer)
```
### 2.4、delete操作
```
    @Test
    public void deletePerson() {
        SqlSession session = getSession();
        session.delete("com.demo.mybatis.PersonMapper.deletePerson", 14);
        session.commit();
    }
```
* 执行后sql语句
```
Preparing: delete from mybatis_person where person_id = ? 
Parameters: 14(Integer)
```

### 2.5、select操作
```
    @Test
    public void selectPerson() {
        SqlSession session = getSession();
        PersonObject personObject = session.selectOne("com.demo.mybatis.PersonMapper.selectPerson", 15);
        session.commit();
        System.out.println(personObject.toString());
    }

    @Test
    public void selectList() {
        SqlSession session = getSession();
        PersonObject object = new PersonObject();
        object.setPersonName("name");
        List<PersonObject> list = session.selectList("com.demo.mybatis.PersonMapper.selectList");
    }
```
* 执行后sql语句
```
Preparing: select * from mybatis_person where person_id = ? 
Parameters: 15(Integer)
Total: 1
```
```
Preparing: select * from mybatis_person 
Parameters: 
     Total: 3
```

## 三、测试：采用mapper接口操作映射文件
### 3.1、创建mapper接口

```
public interface PersonMapper {

    void insertPerson(PersonObject person);

    void updatePerson(PersonObject person);

    void deletePerson(int personId);

    PersonObject selectPerson(int personId);

    List<PersonObject> selectList();
}
```

* mapper接口方法参数，返回值，方法名与mapper配置文件配置需要一一对应

### 3.2、测试操作
#### 3.2.1、insert操作
```
 @Test
    public void insertByMapper() {
        PersonObject object = new PersonObject();
        object.setPersonName("insert name by mapper");
        object.setPersonAddress("insert address by mapper");
        SqlSession session = getSession();
        PersonMapper mapper = getMapper(session);
        mapper.insertPerson(object);
        session.commit();
    }
```

#### 3.2.2、update操作
```
    @Test
    public void updateByMapper(){
        PersonObject object = new PersonObject();
        object.setPersonName("update name by mapper");
        object.setPersonAddress("update address by mapper");
        object.setPersonId(9);
        SqlSession session = getSession();
        PersonMapper mapper = getMapper(session);
        mapper.updatePerson(object);
        session.commit();
    }
```

#### 3.2.3、delete操作
```
    @Test
    public void deleteByMapper(){
        SqlSession session = getSession();
        PersonMapper mapper = getMapper(session);
        mapper.deletePerson(10);
        session.commit();
    }
```
#### 3.2.4、select操作
```
    @Test
    public void selectByMapper(){
        SqlSession session = getSession();
        PersonMapper mapper = getMapper(session);
        PersonObject object = mapper.selectPerson(9);
        session.commit();
        System.out.println(object.toString());
    }

    @Test
    public void selectListByMapper(){
        SqlSession session = getSession();
        PersonMapper mapper = getMapper(session);
        List<PersonObject> list = mapper.selectList();
        System.out.println(list.size());
    }
```