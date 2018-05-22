# mybatis的多表操作
* 数据操作流程
* 1、数据库创建
* 2、java实体对象创建
* 3、mapper文件配置
* 4、测试：数据获取

## 一、一对一
* 一个Student对象中包含一个Address对象
* student对象通过association引用address

### 1.1、数据库表创建
```
create table mybatis_one2one_addresses(
one2one_addr_id int(3) auto_increment not null primary key,
one2one_street varchar(20) not null,
one2one_city varchar(20) not null,
one2one_state varchar(20) not null,
one2one_zip varchar(10),
one2one_country varchar(20));

create table mybatis_one2one_students(
one2one_stud_id int(3)auto_increment not null primary key,
one2one_name varchar(20) not null,
one2one_email varchar(20),
one2one_dob date,
one2one_phone varchar(15),
one2one_addr_id int references addresses(one2one_addr_id));

insert into mybatis_one2one_addresses(one2one_addr_id,one2one_street,one2one_city,one2one_state,one2one_zip,one2one_country) values(1,'redSt','kunshan','W','12345','china');
insert into mybatis_one2one_addresses(one2one_addr_id,one2one_street,one2one_city,one2one_state,one2one_zip,one2one_country) values(2,'blueST','kunshan','W','12345','china');

insert into mybatis_one2one_students(one2one_stud_id,one2one_name,one2one_email,one2one_phone,one2one_addr_id) values(1,'John','john@gmail.com','123-456-7890',1);
insert into mybatis_one2one_students(one2one_stud_id,one2one_name,one2one_email,one2one_phone,one2one_addr_id) values(2,'Paul','paul@gmail.com','111-222-3333',2);
```
* 注意：因为是student对象中包含address，表创建，数据插入都要先处理Address表

### 1.2、java实体对象创建
* get，set方法省略
```
public class One2OneAddress {
    private int addrId;
    private String addrStreet;
    private String addrCity;
    private String addrState;
    private String addrZip;
    private String addrCountry;
}
```
```
public class One2OneStudent {
    private int stuId;
    private String stuName;
    private String stuEmail;
    private String stuDob;
    private String stuPhone;
    private One2OneAddress stuAddress = new One2OneAddress();
}
```
* 注意：在student类中Address属性直接new一个是为了防止在toString时空指针异常

### 1.3、mapper映射文件创建：在resource/mapper
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="one2oneMapper">
    <resultMap id="one2oneAddress" type="com.demo.mybatis.one2one.One2OneAddress">
        <id property="addrId" column="one2one_addr_id"/>
        <result property="addrStreet" column="one2one_street"/>
        <result property="addrCity" column="one2one_city"/>
        <result property="addrState" column="one2one_state"/>
        <result property="addrZip" column="one2one_zip"/>
        <result property="addrCountry" column="one2one_country"/>
    </resultMap>

    <resultMap id="one2oneStudent" type="com.demo.mybatis.one2one.One2OneStudent">
        <id property="stuId" column="one2one_stud_id"/>
        <result property="stuName" column="one2one_name"/>
        <result property="stuEmail" column="one2one_email"/>
        <result property="stuDob" column="one2one_dob"/>
        <result property="stuPhone" column="one2one_phone"/>
        <association property="stuAddress" resultMap="one2oneAddress"/>
    </resultMap>

    <select id="selectStudent" parameterType="int" resultMap="one2oneStudent">
        select * from mybatis_one2one_students left outer join mybatis_one2one_addresses
        on mybatis_one2one_students.one2one_addr_id = mybatis_one2one_addresses.one2one_addr_id
        where one2one_stud_id = #{stuId}
    </select>

    <select id="selectStudentShot" parameterType="int" resultMap="one2oneStudent">
        select * from mybatis_one2one_students student left outer join mybatis_one2one_addresses address
        on student.one2one_addr_id = address.one2one_addr_id
        where one2one_stud_id = #{stuId}
    </select>

</mapper>
```
#### 1.3.1、配置说明：association property="stuAddress" resultMap="resultMap="one2oneAddress""
*  association：表示 has-one
*  property="stuAddress"：为在java实体对象中属性名称
*  resultMap="one2oneAddress"：表示引用id为one2oneAddress的映射配置

#### 1.3.2、配置id说明：selectStudentShot
* mybatis_one2one_students student：表示将mybatis_one2one_students数据库表简称为student
* student.one2one_addr_id = address.one2one_addr_id：通过student表中的addrId取Address表中对应的id值

### 1.4、测试：从数据库中获取数据
```
    @Test
    public void selectStudent() {
        SqlSession session = SessionUtis.getSession();
        One2OneStudent student = session.selectOne("one2oneMapper.selectStudent", 1);
        System.out.println(student.toString());
    }

    @Test
    public void selectStudentShot() {
        SqlSession session = SessionUtis.getSession();
        One2OneStudent student = session.selectOne("one2oneMapper.selectStudentShot", 1);
        System.out.println(student.toString());
    }
```

## 二、一对多
* 一个classes对象中包含多个person对象
* classes映射文件通过collection引用person对象

### 2.1、数据库表创建
```
create table mybatis_one2many_person(
one2many_person_id int(3) auto_increment not null primary key,
one2many_name varchar(100),
one2many_email varchar(100),
one2many_phone varchar(15));

create table mybatis_one2many_classes(
one2many_classes_id int(3) auto_increment not null primary key,
one2many_name varchar(100) not null,
one2many_description varchar(512),
one2many_start_date date ,
one2many_end_date date ,
one2many_person_ids int references mybatis_one2many_tutors (one2many_person_id));


insert into mybatis_one2many_person
(one2many_name,one2many_email,one2many_phone)
values('test name','zs@briup.com','123-456-7890');

insert into mybatis_one2many_person
(one2many_name,one2many_email,one2many_phone)
values('test name','ls@briup.com','111-222-3333');

insert into mybatis_one2many_classes
(one2many_name,one2many_description,one2many_person_ids) values
('JavaSE','JavaSE',1);

insert into mybatis_one2many_classes
(one2many_name,one2many_description,one2many_person_ids) values
('JavaEE','JavaEE',2);

insert into mybatis_one2many_classes
(one2many_name,one2many_description,one2many_person_ids) values
('MyBatis','MyBatis',1);
```
* classes中包含多个person，表创建，数据插入都需要先确保有person表和person数据

### 2.2、java实体创建
* get，set方法省略
```
public class One2manyPerson {
    private int personId;
    private String personName;
    private String personEmail;
    private String personPhone;
}
public class One2manyClasses {
    private int classId;
    private String className;
    private String classDescription;
    private Date startDate;
    private Date endDate;
    private List<One2manyPerson> personList = new ArrayList<One2manyPerson>();
}
```
* classes中包含多个person，采用集合方式体现

### 2.3、mapper映射文件创建

#### 2.3.1、方式一：直接关联对象
* classes获取person数据直接采用resultMap方式获取
```
<mapper namespace="one2manyMapper">
    <resultMap id="one2manyPerson" type="com.demo.mybatis.one2many.One2manyPerson">
        <id property="personId" column="one2many_person_id"/>
        <result property="personName" column="one2many_name"/>
        <result property="personEmail" column="one2many_email"/>
        <result property="personPhone" column="one2many_phone"/>
    </resultMap>


    <resultMap id="one2manyClasses" type="com.demo.mybatis.one2many.One2manyClasses">
        <id property="classId" column="one2many_classes_id"/>
        <result property="className" column="one2many_name"/>
        <result property="classDescription" column="one2many_description"/>
        <result property="startDate" column="one2many_start_date"/>
        <result property="endDate" column="one2many_end_date"/>
        <collection property="personList" resultMap="one2manyPerson"/>
    </resultMap>

    <select id="selectClasses" parameterType="int" resultMap="one2manyClasses">
        select * from mybatis_one2many_classes classes
        left outer join mybatis_one2many_person
         on classes.one2many_person_ids = mybatis_one2many_person.one2many_person_id
        where classes.one2many_classes_id =#{classId}
    </select>

</mapper>
```

#### 2.3.2、方式二：间接关联
* 在classes关联person数据采用sql查询方式获取

```
<mapper namespace="one2manyMapper2">
    <resultMap id="one2manyPerson" type="com.demo.mybatis.one2many.One2manyPerson">
        <id property="personId" column="one2many_person_id"/>
        <result property="personName" column="one2many_name"/>
        <result property="personEmail" column="one2many_email"/>
        <result property="personPhone" column="one2many_phone"/>
    </resultMap>

    <select id="selectPerson" resultMap="one2manyPerson" parameterType="int">
        select * from mybatis_one2many_person where one2many_person_id =#{personId}
    </select>

    <resultMap id="one2manyClasses" type="com.demo.mybatis.one2many.One2manyClasses">
        <id property="classId" column="one2many_classes_id"/>
        <result property="className" column="one2many_name"/>
        <result property="classDescription" column="one2many_description"/>
        <result property="startDate" column="one2many_start_date"/>
        <result property="endDate" column="one2many_end_date"/>
        <collection property="personList" column="one2many_person_ids" select="selectPerson"/>
    </resultMap>

    <select id="selectClasses" parameterType="int" resultMap="one2manyClasses">
        select * from mybatis_one2many_classes
        where one2many_classes_id =#{classId}
    </select>

</mapper>
```

### 2.4、测试：数据获取
```
    @Test
    public void selectClasses(){
        SqlSession session = SessionUtis.getSession();
      One2manyClasses classes =  session.selectOne("one2manyMapper.selectClasses",1);
        System.out.println(classes.toString());
    }
    @Test
    public void selectClasses2(){
        SqlSession session = SessionUtis.getSession();
        One2manyClasses classes = session.selectOne("one2manyMapper2.selectClasses",1);
        System.out.println(classes.toString());
    }
```
* 采用方式1和方式2都是一样的效果，只是mapper写法的区别

## 三、多对多
* 一个cart对象包含多个student对象
* 一个student对象包含多个cart对象
* cart中包含student集合，student中包含cart集合
* 采用一个中间表，包含cart的id对应的student的id

### 3.1、数据库表创建
```
create table mybatis_many2many_cart (
   many2many_cart_id int(3) auto_increment not null primary key,
   many2many_cart_code varchar(50) not null,
   many2many_cart_name varchar(50) not null);

create table mybatis_many2many_student (
   many2many_student_id int(3) auto_increment not null primary key,
   many2many_name varchar(50) not null,
   many2many_gender varchar(50) ,
   many2many_major varchar(50) ,
   many2many_grade varchar(50));

create table mybatis_many2many_other (
  many2many_other_id  int(3) auto_increment not null primary key,
  many2many_student_id int references mybatis_many2many_student(many2many_student_id),
  many2many_cart_id int references mybatis_many2many_cart(many2many_cart_id));


insert into mybatis_many2many_cart
(many2many_cart_name,many2many_cart_code) values
('JavaSE',1);
insert into mybatis_many2many_cart
(many2many_cart_name,many2many_cart_code) values
('JavaEE',2);
insert into mybatis_many2many_cart
(many2many_cart_name,many2many_cart_code) values
('MyBatis',1);

insert into mybatis_many2many_student
(many2many_name,many2many_gender,many2many_major,many2many_grade)
 values('John','johncom','1890','123-7890');
insert into mybatis_many2many_student
(many2many_name,many2many_gender,many2many_major,many2many_grade)
values('Paul','paulcom','111-333','123-90');

insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(1,1);
insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(1,2);
insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(1,3);
insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(2,1);
insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(2,2);
insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(2,3);
```
* 中间表other在创建和数据插入需要等cart和student先创建和插入

### 3.2、java实体对象创建
* 省略get，set方法
```
public class Many2manyCart {
    private int cartId;
    private String carCode;
    private String cartName;
    private List<Many2manyStudent> studentList = new ArrayList<Many2manyStudent>();
}
public class Many2manyStudent {
    private int stuId;
    private String stuName;
    private String stuGender;
    private String stuMajor;
    private String stuGrade;
    private List<Many2manyCart> cartList = new ArrayList<Many2manyCart>();
}
```
* 多个对象采用集合方式实现

### 3.3、mapper配置文件创建
```
<mapper namespace="many2manyMapper">

    <resultMap id="many2manyStudent" type="com.demo.mybatis.many2many.Many2manyStudent">
        <id property="stuId" column="many2many_student_id"/>
        <result property="stuName" column="many2many_name"/>
        <result property="stuGender" column="many2many_gender"/>
        <result property="stuMajor" column="many2many_major"/>
        <result property="stuGrade" column="many2many_grade"/>
    </resultMap>
    <resultMap id="many2manyCart" type="com.demo.mybatis.many2many.Many2manyCart">
        <id property="cartId" column="many2many_cart_id"/>
        <result property="carCode" column="many2many_cart_code"/>
        <result property="cartName" column="many2many_cart_name"/>
    </resultMap>

    <resultMap id="otherStudent" type="com.demo.mybatis.many2many.Many2manyStudent" extends="many2manyStudent">
        <collection property="cartList" resultMap="many2manyCart"/>
    </resultMap>

    <resultMap id="otherCart" type="com.demo.mybatis.many2many.Many2manyCart" extends="many2manyCart">
        <collection property="studentList" resultMap="many2manyStudent"/>
    </resultMap>

    <select id="selectStudent" parameterType="int" resultMap="otherStudent">
        select * from
        mybatis_many2many_cart cart,mybatis_many2many_student student ,mybatis_many2many_other other

        where
          student.many2many_student_id = #{stuId}
        and
          student.many2many_student_id = other.many2many_student_id
        and
          other.many2many_cart_id = cart.many2many_cart_id
    </select>


    <select id="selectCart" parameterType="int" resultMap="otherCart">
        select * from
        mybatis_many2many_cart cart,mybatis_many2many_student student ,mybatis_many2many_other other

        where
          cart.many2many_cart_id = #{cartId}
        and
           cart.many2many_cart_id = other.many2many_cart_id
        and
          other.many2many_student_id = student.many2many_student_id
    </select>

</mapper>
```
* otherCart：用于走cart的中间表，通过collection引入student
* selectCart：返回参数otherCart，是需要给otherCart重新组装成多个对象

### 3.4、测试：数据使用
```
    @Test
    public void selectStudent() {
        SqlSession session = SessionUtis.getSession();
        List<Many2manyStudent> student = session.selectList("many2manyMapper.selectStudent", 1);
        System.out.println(student.toString());
    }

    @Test
    public void selectCart() {
        SqlSession session = SessionUtis.getSession();
        List<Many2manyCart> carts = session.selectList("many2manyMapper.selectCart", 1);
        System.out.println(carts.toString());
    }
```
