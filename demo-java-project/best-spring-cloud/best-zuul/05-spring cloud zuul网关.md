* Spring Cloud Zuul路由是微服务架构的不可或缺的一部分，提供动态路由，监控，弹性，安全等的边缘服务。Zuul是Netflix出品的一个基于JVM路由和服务端的负载均衡器。
## 一、网关搭建

### 1、maven配置
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
    <artifactId>best-zuul</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zuul</artifactId>
            <version>1.2.0.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka</artifactId>
        </dependency>
    </dependencies>
</project>
```
##### 说明：
* spring-cloud-starter-zuul：添加zuul网关依赖
### 2、启动类
```
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
```
##### 说明：
* EnableZuulProxy：开启网关路由

### 3、配置文件
```
spring.application.name=best-zuul
server.port=8088
eureka.client.serviceUrl.defaultZone=http://localhost:2000/eureka/

zuul.routes.api-a.path=/best/provide/**
zuul.routes.api-a.serviceId=best-provide

zuul.routes.api-b.path=/best/provide/cluster/**
zuul.routes.api-b.serviceId=best-provide-cluster

zuul.routes.api-c.path=/best/consumer/**
zuul.routes.api-c.serviceId=best-consumer

zuul.routes.api-d.path=/best/dashboard/**
zuul.routes.api-d.serviceId=best-dashboard
```
##### 说明：
* zuul.routes.api-a.path：服务对象对应的路由地址路由地址
* zuul.routes.api-a.serviceId：服务对象

### 4、测试：
* 1、启动应用:best-eureka，best-provide，best-provide-cluster，best-consumer，best-dashboard
* 2、访问注册中心查看访问启动情况:http://localhost:2000/
* 3、访问服务接口：http://localhost:8088/best/provide/index
* 4、访问消费接口:http://localhost:8088/best/consumer/consumer
* 5、访问监控页面：http://localhost:8088/best/dashboard/hystrix
