## 常用api讲解
### 一、SqlSessionFactoryBuilder
* 此类提供了几种不同创建SqlSessionFactory的方法
* 常用方法有以下几个方法：一般使用xml配置文件的Reader实例
```
SqlSessionFactory build(Reader reader) 
SqlSessionFactory build(Reader reader, String environment) 
SqlSessionFactory build(Reader reader, Properties properties) 
SqlSessionFactory build(Reader reader, String env, Properties props) 
public SqlSessionFactory build(Configuration config)
```

#### 1.2、Reader
* 提供了对数据读取的操作方法

```
    private static final int maxSkipBufferSize = 8192;
    private char skipBuffer[] = null;
    
    abstract public int read(char cbuf[], int off, int len) throws IOException;
    protected Reader() 
    protected Reader(Object lock) 
    public int read(java.nio.CharBuffer target) throws IOException 
    public int read() throws IOException
    public int read(char cbuf[]) throws IOException 
    public long skip(long n) throws IOException 
    public boolean ready() throws IOException 
    public boolean markSupported() 
    public void mark(int readAheadLimit) throws IOException 
    public void reset() throws IOException 
    abstract public void close() throws IOException;
```

#### 1.3、Resources
* 提供了从类路径，文件系统，web url加载资源操作类

#### 1.4、Configuration
* 包含了配置文件中所有的数据封装

### 二、SqlSessionFactory
* 由SqlSessionFactoryBuilder提供方法创建
* 提供了创建SqlSession对象的方法

#### 2.1、创建一个SqlSession对象需要考虑的3个方面
* 1、事务：是否为会话使用事务（是否自动提交）
* 2、连接：是从数据源获取连接还是自己创建连接
* 3、执行：批量操作还是单条操作

#### 2.2、为什么不使用xml的方式创建SqlSessionFactory对象
* mybatis提供了一个配置类（Configuration）提供了与xml文件相同的配置选项
* Mapper配置映射类包含了sql映射注解的java类，从而避免了使用xml文件

#### 2.3、SqlSessionFactory特点：
* 一旦创建就会存在应用程序的整个运行生命周期（需要做单例）
* 作用域：一个应用的生命周期

#### 2.4、openSession() 创建的session：
* 1、将会启用一个事务作用域（即不会主动提交，需要手动提交）
* 2、一个连接对象将从正在生效的运行环境所配置的数据中获取
* 3、事务隔离级别是由驱动或数据源使用的默认级别
* 4、PreparedStatements不会被重用，也不会进行批量更新

#### 2.5、ExecutorType参数：
* SIMPLE：不做特殊的事情，只为每个执行语句创建一个PreparedStatements
* REUSE：这个类型的执行器重用PreparedStatements
* BATCH：这个执行器会批量更新sql语句


#### 2.6、sqlSessionFactory源码：      
```
public interface SqlSessionFactory {
    SqlSession openSession();

    SqlSession openSession(boolean var1);

    SqlSession openSession(Connection var1);

    SqlSession openSession(TransactionIsolationLevel var1);

    SqlSession openSession(ExecutorType var1);

    SqlSession openSession(ExecutorType var1, boolean var2);

    SqlSession openSession(ExecutorType var1, TransactionIsolationLevel var2);

    SqlSession openSession(ExecutorType var1, Connection var2);

    Configuration getConfiguration();
}
```

### 三、SqlSession
* sqlSession包含了所有的执行数据库sql语句，事务操作，获取mapper方法

#### 3.1、SqlSession特点：
* 每个线程都有一个SqlSession实例，sqlSession不是共享的，也不是线程安全的
* 作用域：是Request或method
* 在一次会话结束时需要将sqlSession关闭

#### 3.2、SqlSession主要功能：
* sqlSession类可以划分以下几个功能：SQL语句执行，事务控制，缓存操作，sqlSession关闭，mapper使用

##### 3.2.1 SqlSession的sql语句功能
```
<T> T selectOne(String statement, Object parameter);
```
* 1、基本操作是通过传入映射文件对应的sql语句与对应的参数获取到对象

* 2、SqlSession在sql操作方法中有以下几个方法：
```
  <E> List<E> selectList(String statement, Object parameter, RowBounds rowBounds);
  <K, V> Map<K, V> selectMap(String statement, Object parameter, String mapKey, RowBounds rowBounds);
  void select(String statement, Object parameter, RowBounds rowBounds, ResultHandler handler);
  <T> Cursor<T> selectCursor(String statement, Object parameter, RowBounds rowBounds);
```
* 3、RowsBounds：可以设置指定数量的结果集
```
 public RowBounds() 
 public RowBounds(int offset, int limit) 
```
* 4、ResultHandler：允许按照喜欢的方式对每条记录进行操作，可以添加集合进行数据统计
```
  void handleResult(ResultContext<? extends T> resultContext);
```

##### 3.2.2 SqlSession的事务控制方法
```
  void commit();
  void commit(boolean force);
  void rollback();
  void rollback(boolean force);
```
* 参数forceWie是否自动提交：mybatis默认不会自动提交

##### 3.2.3 SqlSession的清除会话缓存
```
  void clearCache();
```
* sqlSession有一个本地缓存，缓存在每次提交回滚和关闭时进行清除。

##### 3.2.4 SqlSession确保Session关闭
```
void close()
```
* sqlSession使用完成后要进行关闭

##### 3.2.5 SqlSession使用mapper
```
  <T> T getMapper(Class<T> type);
```
* 通过使用mapper接口执行mapper文件中的映射语句
* mapper中方法名称，参数名称，参数数量与配置文件中方法名称，参数名称，参数数量相互对应
* mapper中也可以使用RowsBounds来限制查询结果