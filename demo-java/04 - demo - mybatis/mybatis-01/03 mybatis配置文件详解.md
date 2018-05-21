## 一、mybatis配置文件
* mybatis配置文件所有属性：
* properties，settings，typeAliases，typeHandlers，objectFactory，plugins，environments

#### 1.1 properties
* 都是外部化，可替代属性，可以配置在一个java文件中或通过properties元素的子元素配置
```
    <properties resource="">
        <property name="username" value="root"/>
    </properties>
```
* resource:文件路径
* value：可以直接写死，也可以被动态替换（value="${username}"）

##### 注意：如果一个属性存在多个地方：
* mybatis会通过当前properties中指定的属性，或指定路径中文件配置的属性

#### 1.2 settings
* 用于设置和改变mybatis运行中的行为
```
    <settings>
        <setting name="cancheEnabled" value="true"/>
    </settings>
```

##### 1.2.1、完整settings配置
```
    <settings>  
      <setting name="cacheEnabled" value="true"/>  
      <setting name="lazyLoadingEnabled" value="true"/>  
      <setting name="multipleResultSetsEnabled" value="true"/>  
      <setting name="useColumnLabel" value="true"/>  
      <setting name="useGeneratedKeys" value="false"/>  
      <setting name="autoMappingBehavior" value="PARTIAL"/>  
      <setting name="defaultExecutorType" value="SIMPLE"/>  
      <setting name="defaultStatementTimeout" value="25"/>  
      <setting name="defaultFetchSize" value="100"/>  
      <setting name="safeRowBoundsEnabled" value="false"/>  
      <setting name="mapUnderscoreToCamelCase" value="false"/>  
      <setting name="localCacheScope" value="SESSION"/>  
      <setting name="jdbcTypeForNull" value="OTHER"/>  
      <setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode,toString"/>  
    </settings>  
```

##### 1.2.2、settings元素支持的属性讲解：
###### 1.2.2.1、 cacheEnabled
* 描述：该配置影响的所有映射器中配置的缓存的全局开关
* 可用值：true | false
* 默认值：false

###### 1.2.2.2、 lazyLoadingEnabled
* 描述：延迟加载的全局开关。当开启时，所有关联对象都会延迟加载。 特定关联关系中可通过设置fetchType属性来覆盖该项的开关状态
* 可用值：true | false
* 默认值：false

###### 1.2.2.3、 aggressiveLazyLoading
* 描述：当启用时，对任意延迟属性的调用会使带有延迟加载属性的对象完整加载；反之，每种属性将会按需加载。
* 可用值：true | false
* 默认值：false

###### 1.2.2.4、 multipleResultSetsEnabled
* 描述：是否允许单一语句返回多结果集（需要兼容驱动）。
* 可用值：true | false
* 默认值：false

###### 1.2.2.5、 useColumnLabel
* 描述：使用列标签代替列名。不同的驱动在这方面会有不同的表现， 具体可参考相关驱动文档或通过测试这两种不同的模式来观察所用驱动的结果。
* 可用值：true | false
* 默认值：false

###### 1.2.2.6、 useGeneratedKeys
* 描述：允许 JDBC 支持自动生成主键，需要驱动兼容。 
* 如果设置为 true 则这个设置强制使用自动生成主键，尽管一些驱动不能兼容但仍可正常工作（比如 Derby）。
* 可用值：true | false
* 默认值：false

###### 1.2.2.7、 autoMappingBehavior
* 描述：指定 MyBatis 应如何自动映射列到字段或属性。 
* NONE 表示取消自动映射；
* PARTIAL 只会自动映射没有定义嵌套结果集映射的结果集。 
* FULL 会自动映射任意复杂的结果集（无论是否嵌套）。
* 可用值：NONE, PARTIAL, FULL
* 默认值：PARTIAL

###### 1.2.2.8、 defaultExecutorType
* 描述：配置默认的执行器。
* SIMPLE 就是普通的执行器；
* REUSE 执行器会重用预处理语句（prepared statements）； 
* BATCH 执行器将重用语句并执行批量更新。
* 可用值：SIMPLE REUSE BATCH
* 默认值：SIMPLE

###### 1.2.2.9、 defaultStatementTimeout
* 描述：设置超时时间，它决定驱动等待数据库响应的秒数。
* 可用值：Any positive integer
* 默认值：Not Set (null)

###### 1.2.2.10、 safeRowBoundsEnabled
* 描述：允许在嵌套语句中使用分页（RowBounds）。
* 可用值：true | false
* 默认值：false

###### 1.2.2.11、 mapUnderscoreToCamelCase
* 描述：是否开启自动驼峰命名规则（camel case）映射，即从经典数据库列名 A_COLUMN 到经典 Java 属性名 aColumn 的类似映射。
* 可用值：true | false
* 默认值：false

###### 1.2.2.12、 localCacheScope
* 描述：Cache）防止循环引用（circular references）和加速重复嵌套查询
* SESSION，这种情况下会缓存一个会话中执行的所有查询
* STATEMENT，本地会话仅用在语句执行上，对相同SqlSession 的不同调用将不会共享数据。
* 可用值：SESSION | STATEMENT
* 默认值：SESSION

###### 1.2.2.13、 jdbcTypeForNull
* 描述：当没有为参数提供特定的 JDBC 类型时，为空值指定 JDBC 类型。 某些驱动需要指定列的 JDBC 类型，多数情况直接用一般类型即可，比如 NULL、VARCHAR 或 OTHER。
* 可用值：JdbcType enumeration. Most common are: NULL, VARCHAR and OTHER
* 默认值：OTHER

###### 1.2.2.14、 lazyLoadTriggerMethods
* 描述：指定哪个对象的方法触发一次延迟加载。
* 可用值：A method name list separated by commas
* 默认值：equals,clone,hashCode,toString

#### 1.3 typeAliases
* 别名是一个较短的java类型名称，用于在xml配置使用时方便使用
```
    <typeAliases>
        <typeAlias type="" alias=""/>
    </typeAliases>
```
* typeAlias:配置一个别名对象
* type：对应的java实体对象
* alias：java实体对象对应的别名
* java内部有内置别名

#### 1.4 typeHandlers
```
    <typeHandlers>
        <typeHandler handler="" javaType="" jdbcType=""/>
    </typeHandlers>
```
* typeHandler :配置类处理器
* handler:类处理器对象（可以自定义类实现TypeHandler）
* javaType：处理java类型数据
* jdbcType：处理jdbc类型数据

#### 1.5 objectFactory
* mybatis创建对象的新实例对象会使用对象工厂来完成
```
    <objectFactory type="">
        <property name="" value=""/>
    </objectFactory>
```
* Type：自定义对象工厂类（继承DefaultObjectFactory）
* name：构造方法参数名称
* value：构造方法参数对应数据

#### 1.6 plugins
* 映射语句的拦截方法配置
```
<plugins>
    <plugin interceptor="">
        <property name="" value=""/>
    </plugin>
</plugins>
```
* interceptor:自定义的拦截对象（实现Interceptor）
* name：
* value：
* mybatis运行被拦截的方法如下：
```
    Executor(update,query,flushStatements,commit,rollback,getTransaction,close,isClosed)
    ParameterHandler(getParameterObejct,setParameters)
    ResultSetHandler(handlerResultSets,handlerOutputParameters)
    StatementHandler(prepare,parameterize,batch,update,query)
```

#### 1.7 environments
* 运行环境配置
```
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
```
* environments：默认运行环境id
* environment：定义每个运行环境id
* transactionManager：事务管理器配置（JDBC，MANAGED）
* dataSource：数据源配置（UPOOLED，POOLED，JNDI）

#### 1.8 mapper
* 配置mapper映射文件地址
```
    <mappers >
        <mapper resource="mapper/PersonMapper.xml"/>
    </mappers>
```

## 二、mybatis映射文件
* cache-ref ：引用外部缓存配置
* cache ：缓存配置
* resultMap：java实体与数据表库映射配置
* sql：可以被其他语句重用的sql语句块
* insert
* update
* delete 
* select
```



    <delete id="deleteDeptById" parameterType="integer" >
        delete from test_dept where dept_id =#{deptId}
    </delete>


    <update id="updateDept" parameterType="dept" >
        update test_dept set dept_name =#{deptName},dept_address=#{deptAddress} where dept_id = #{deptId}
    </update>


    <!--
       通过id查询单个对象
   -->
    <select id="selectDeptById" parameterType="integer"  resultMap="deptResultMap">
        select * from test_dept where dept_id = #{deptId}
    </select>
```
### 2.1、insert，update，delete，select
#### 2.1.1、简单使用
* 配置数据库查询insert语句
```
 <insert id="insertDept" parameterType="dept">
        insert into test_dept (dept_name,dept_address) values (#{deptName},#{deptAddress})
 </insert>
```
* id：命名空间的标识
* parameterType：sql语句的参数类型
* 标签值：sql语句拼接
* .#{xx}:对应java属性替换

#### 2.1.2、语句配置说明
* id ：命名空间标识可以被其他语句引用
* parameterType：sql语句的参数（java实体对象全类名或别名）
* timeout：设置超时时间，如果没有由驱动器决定
* flushCache (true|false)：每次调用时是否清除缓存
* statementType (STATEMENT|PREPARED|CALLABLE)：使用Statement，PreparedStatement，CallableStatement（默认第一个）
* keyProperty：设置需要自动生成键值的列
* useGeneratedKeys (true|false)：
* keyProperty：设置需要自动生成键值的列
* resultType ：结果类型
* order (BEFORE|AFTER) :可以设置成BEFORE或AFTER
* 参数 BEFORE:先选择主键，再设置keyProperty，再执行insert语句
* 参数 AFTER：先执行insert语句，再执行selectKey语句

### 2.2、sql：可以被其他语句重用的sql语句块
* 用于定义可以被其他语句引用的sql语句块
```
    <insert id="includeInsert" parameterType="DynamicObject">
        insert into test_dynamic
        <include refid="key"></include>
          values
        <include refid="value"></include>
    </insert>

    <sql id="key" >
        <trim suffixOverrides="," prefix="(" suffix= ")">
            <if test="dynamicName !=null">dynamic_name,</if>
            <if test="dynamicTitle != null">dynamic_title,</if>
            <if test="dynamicDesc != null">dynamic_desc,</if>
        </trim>
    </sql>
```

### 2.3、resultMap：java实体与数据表库映射配置
* java实体与数据库表映射配置
```
    <resultMap id="personResult" type="com.demo.PersonObject">
        <id property="personId" column="person_id"/>
        <result property="personName" column="person_name"/>
        <result property="personAddress" column="person_address"/>
    </resultMap>
```
#### 2.3.1、resultMap 属性 
* constructor：实例化的时候通过构造器将结果集注入到类中
* id：结果集ID，将结果集标记为id方便调用
* result：注入一股java实体属性
* association：复杂类型联合，许多查询结果合成这个类型(可以引用自身，或从其他地方引用)
* collection：复杂类型集合（能引用自身，或从其他地方引用）
* discriminator：使用一个结果值决定使用哪个resultMap

### 2.4、cache-ref ：引用外部缓存配置
### 2.5、cache ：缓存配置


