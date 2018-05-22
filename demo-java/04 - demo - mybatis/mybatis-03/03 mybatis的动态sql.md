## mybatis的动态SQL操作
* 实现步骤
* 1、项目搭建（maven配置）
* 2、数据库创建
* 3、java实体创建
* 4、mapper文件创建
* 5、配置文件创建
* 6、测试：数据操作
## 一、项目配置
### 1.1、maven配置
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

### 1.2、数据库表创建
```
create table mybatis_dynamic(
  dynamic_id int(3) auto_increment not null primary key,
  dynamic_name varchar(200),
  dynamic_title varchar(200),
  dynamic_desc varchar(200)
)
```
### 1.3、java实体创建
* get，set方法省略
```
public class DynamicObject {
    private Integer dynamicId;
    private String dynamicName;
    private String dynamicTitle;
    private String dynamicDesc;
}
```

### 1.4、配置文件创建
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <typeAliases>
        <typeAlias type="com.demo.mybatis.DynamicObject" alias="DynamicObject"/>
    </typeAliases>

    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"></transactionManager>
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
        <mapper resource="mapper/DynamicMapper.xml"/>
    </mappers>
</configuration>
```
### 1.5、创建获取SqlSession方法
```
    public SqlSession getSession() {
        SqlSession session = null;
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            return factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
            session.rollback();
            return null;
        }
    }
```
### 1.6、mapper配置文件映射配置
```
<mapper namespace="DynamicMapper">

    <resultMap id="dynamicResult" type="DynamicObject">
        <id property="dynamicId" column="dynamic_id"/>
        <result property="dynamicName" column="dynamic_name"/>
        <result property="dynamicTitle" column="dynamic_title"/>
        <result property="dynamicDesc" column="dynamic_desc"/>
    </resultMap>
```

## 二、具体操作

### 2.1、数据插入
#### 2.1.1、mapper配置
```
    <insert id="insertDynamic" parameterType="DynamicObject">
        insert mybatis_dynamic (dynamic_name,dynamic_title,dynamic_desc)
        values (#{dynamicName},#{dynamicTitle},#{dynamicDesc})
    </insert>
```
#### 2.1.2、代码操作
```
    @Test
    public void insert() {
        SqlSession session = getSession();
        DynamicObject object = new DynamicObject();
        object.setDynamicDesc("insert desc from insert method");
        object.setDynamicName("insert name from insert method");
        object.setDynamicTitle("insert title from insert method");
        session.insert("DynamicMapper.insertDynamic", object);
        session.commit();
    }
```
#### 2.1.3、执行的sql语句
```
Preparing: insert mybatis_dynamic (dynamic_name,dynamic_title,dynamic_desc) values (?,?,?) 
Parameters: insert name from insert method(String), insert title from insert method(String), insert desc from insert method(String)
Updates: 1
```

### 2.2、数据模糊查询
* 有三种方式：使用if，where，choose标签
#### 2.2.1、mapper配置
```
<select id="selectByLike" parameterType="DynamicObject" resultMap="dynamicResult">
        select * from mybatis_dynamic where 1=1
        <if test="dynamicName != null"> and dynamic_name = #{dynamicName}</if>
        <if test="dynamicTitle != null"> and dynamic_title = #{dynamicTitle}</if>
        <if test="dynamicDesc != null"> and dynamic_desc = #{dynamicDesc}</if>

    </select>

    <select id="selectByWhere" parameterType="DynamicObject" resultMap="dynamicResult">
         select * from mybatis_dynamic
         <where>
             <if test="dynamicName != null"> and dynamic_name = #{dynamicName}</if>
             <if test="dynamicTitle != null"> and dynamic_title = #{dynamicTitle}</if>
             <if test="dynamicDesc != null"> and dynamic_desc = #{dynamicDesc}</if>
         </where>
    </select>

    <select id="selectByChoose" parameterType="DynamicObject" resultMap="dynamicResult">
         select * from mybatis_dynamic
         <where>
             <choose>
                 <when test="dynamicName != null"> and dynamic_name = #{dynamicName}</when>
                 <when test="dynamicTitle != null"> and dynamic_title = #{dynamicTitle}</when>
                 <when test="dynamicDesc != null"> and dynamic_desc = #{dynamicDesc}</when>
                 <otherwise>and 1==2</otherwise>
             </choose>
         </where>
    </select>
```

#### 2.2.2、代码操作
```
    @Test
       public void selectByLike() {
           SqlSession session = getSession();
           DynamicObject object = new DynamicObject();
           object.setDynamicName("insert name from insert method");
           object.setDynamicTitle("insert title from insert method");
           List<DynamicObject> select = session.selectList("DynamicMapper.selectByLike", object);
           System.out.println(select.toString());
           session.commit();
       }
   
   
       @Test
       public void selectByWhere() {
           SqlSession session = getSession();
           DynamicObject object = new DynamicObject();
           object.setDynamicName("insert name from insert method");
           List<DynamicObject> select = session.selectList("DynamicMapper.selectByWhere", object);
           System.out.println(select.toString());
           session.commit();
       }
   
       @Test
       public void selectByChoose() {
           SqlSession session = getSession();
           DynamicObject object = new DynamicObject();
           object.setDynamicName("insert name from insert method");
           List<DynamicObject> select = session.selectList("DynamicMapper.selectByChoose", object);
           System.out.println(select.toString());
           session.commit();
       }
```

#### 2.2.3、执行的sql
```
//selectByLike
select * from mybatis_dynamic where 1=1 and dynamic_name = ? and dynamic_title = ? 
Parameters: insert name from insert method(String), insert title from insert method(String)
Total: 5

//selectByWhere
Preparing: select * from mybatis_dynamic WHERE dynamic_name = ? 
Parameters: insert name from insert method(String)
Total: 5

//selectByChoose
 Preparing: select * from mybatis_dynamic WHERE dynamic_name = ? 
 Parameters: insert name from insert method(String)
 Total: 5
```
#### 2.2.4、说明：
* where标签只选取有值的字段，choose只选取一个有值的字段

### 2.3、set标签
* 采用set标签，只更新有值的数据

#### 2.3.1、mapper配置
```
    <update id="updateSet" parameterType="DynamicObject">
        update mybatis_dynamic
      <set>
          <if test="dynamicName != null">dynamic_name = #{dynamicName},</if>
          <if test="dynamicTitle != null">dynamic_title = #{dynamicTitle},</if>
          <if test="dynamicDesc != null">dynamic_desc = #{dynamicDesc}</if>
      </set>
        where dynamic_id =#{dynamicId}
    </update>
```

#### 2.3.2、测试
```
    @Test
    public void updateSet() {
        SqlSession session = getSession();
        DynamicObject object = new DynamicObject();
        object.setDynamicId(3);
        object.setDynamicName("update set name");
        session.update("DynamicMapper.updateSet", object);
        session.commit();
    }
```
#### 2.3.3、执行sql语句
```
 Preparing: update mybatis_dynamic SET dynamic_name = ? where dynamic_id =? 
 Parameters: update set name(String), 3(Integer)
 Updates: 1
```

### 2.4、foreach标签
* 采用循环获取数据

#### 2.4.1、mapper配置
```
    <select id="selectForeach" resultMap="dynamicResult">
        select * from mybatis_dynamic where dynamic_id in
        <foreach collection="list" item="dynamicId" separator="," open="(" close=")">
            #{dynamicId}
        </foreach>
    </select>
```

#### 2.4.2、测试：
```
    @Test
    public void selectForeach() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(5);
        list.add(6);

        SqlSession session = getSession();
        List<DynamicObject> objectList = session.selectList("DynamicMapper.selectForeach", list);
        System.out.println(objectList.toString());
    }
```
#### 2.4.3、执行后sql
```
Preparing: select * from mybatis_dynamic where dynamic_id in ( ? , ? , ? ) 
Parameters: 3(Integer), 5(Integer), 6(Integer)
Total: 3
```

### 2.5、include标签
* 引用其他sql

#### 2.5.1、mapper配置
```
    <insert id="includeInsert" parameterType="DynamicObject">
        insert into mybatis_dynamic
        <include refid="key"/>
        values
        <include refid="value"/>
    </insert>

    <sql id="key">
        <trim suffixOverrides="," prefix="(" suffix=")">
            <if test="dynamicName != null">dynamic_name,</if>
            <if test="dynamicTitle != null">dynamic_title,</if>
            <if test="dynamicDesc != null">dynamic_desc</if>
        </trim>
    </sql>

    <sql id="value">
        <trim suffixOverrides="," prefix="(" suffix=")">
            <if test="dynamicName != null">#{dynamicName},</if>
            <if test="dynamicTitle != null">#{dynamicTitle},</if>
            <if test="dynamicDesc != null">#{dynamicDesc}</if>
        </trim>
    </sql>
```
#### 2.5.2、测试
```
    @Test
    public void includeInsert(){
        SqlSession session = getSession();
        DynamicObject object = new DynamicObject();
        object.setDynamicName("insert  name by include");
        object.setDynamicTitle("insert  title by include");
        session.update("DynamicMapper.includeInsert", object);
        session.commit();
    }
```

#### 2.5.3、执行后sql：
```
Preparing: insert into mybatis_dynamic ( dynamic_name, dynamic_title ) values ( ?, ? ) 
Parameters: insert  name by include(String), insert  title by include(String)
Updates: 1
```
