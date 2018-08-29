## 02-provide服务提供者及负载均衡实现
* 1、服务提供方
* 2、将自身服务注册到eureka，从而使服务的消费方通过服务名称可以找到

## 一、provide服务搭建
* 采用maven方式搭建：best-provide
### 1.1、添加maven依赖
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>best-spring-cloud</artifactId>
        <groupId>base.cloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>best-provide</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-server</artifactId>
        </dependency>
    </dependencies>
</project>
```
#### 说明：
* eureka的服务和eureka注册中心的依赖库一致

### 2、创建启动类
```
@SpringBootApplication
@EnableEurekaServer
public class ProvideApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProvideApplication.class, args);
    }
}
```
##### 说明：
* @SpringBootApplication：标记为SpringBoot应用
* @EnableEurekaServer：标记为Eureka的服务提供者
#### 注意：
##### 为了方便spring扫描应用包，一般将其他代码放在启动类下一级目录

### 3、创建接口类
```
@RestController
public class UserController {
    @RequestMapping("/index")
    public String index() {
        return " index data ： " + getClass().toString();
    }
}
```
##### 说明：
* @RestController：内部包含了@Controller，@ResponseBody接口类就不需要再添加ResponseBody注解
* @RequestMapping("/index")：请求接口路径

### 4、配置文件：application.properties
```
spring.application.name=best-provide
server.port=2111
eureka.client.serviceUrl.defaultZone=http://localhost:2000/eureka/
```
##### 说明：
* 这个配置文件就比较简单了，定义服务名称，端口，注册地址
        
### 5、测试：
* 1、启动应用
* 2、访问注册中心查看是否有best-provide服务：
```
http://localhost:2000/
```
* 3、访问服务接口获取访问数据：
```
http://localhost:2111/index
```

## 二、添加服务负载均衡模块搭建
### 什么是负载均衡：
* （百度百科）负载均衡 建立在现有网络结构之上，它提供了一种廉价有效透明的方法扩展网络设备和服务器的带宽、增加吞吐量、加强网络数据处理能力、提高网络的灵活性和可用性。
* 负载均衡，英文名称为Load Balance，其意思就是分摊到多个操作单元上进行执行，例如Web服务器、FTP服务器、企业关键应用服务器和其它关键任务服务器等，从而共同完成工作任务。

#### 重点：分摊到多个操作单元上进行执行（就是多台服务器执行同一个操作）

* 采用maven方式创建：best-provide-cluster
* maven依赖，启动类，接口，配置文件基本一致
* 不一样为接口返回数据，配置端口不一致
### 1、接口类
```@RestController
public class UserController {
    @RequestMapping("/index")
    public String index() {
        return "index data -2 : " + getClass().toString();
    }
}
```
### 2、配置文件
```
spring.application.name=best-provide
server.port=2122
eureka.client.serviceUrl.defaultZone=http://localhost:2000/eureka/
```
##### 注意：为实现负载均衡必须配置相同服务名称
### 3、测试：
* 1、启动应用
* 2、访问注册中心查看是否有对应模块:
```
http://localhost:2000/
```
* 3、访问接口地址查看是否有数据返回:
```
http://localhost:2122/index
```
