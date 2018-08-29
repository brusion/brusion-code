* Hystrix-dashboard是一款针对Hystrix进行实时监控的工具，通过Hystrix Dashboard我们可以在直观地看到各Hystrix Command的请求响应时间, 请求成功率等数据。
## 一、监控搭建
* 采用maven方式搭建：best-dashboard
### 1、添加maven配置
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
    <artifactId>best-dashboard</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-hystrix</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-netflix-hystrix-dashboard</artifactId>
            <version>1.2.5.RELEASE</version>
        </dependency>
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
###### 说明：
* spring-cloud-starter-hystrix：熔断依赖
* spring-cloud-netflix-hystrix-dashboard：监控库依赖
* spring-boot-starter-actuator：监控的配置数据加载

### 2、创建启动类
```
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class DashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }
}
```
##### 说明：
* @EnableHystrixDashboard：开启熔断
* @EnableCircuitBreaker：数据处理开启

### 3、配置文件
```
spring.application.name=best-dashboard
server.port=2333
feign.hystrix.enabled=true
eureka.client.serviceUrl.defaultZone=http://localhost:2000/eureka/
```
### 4、测试
* 1、启动应用
* 2、查看注册中心服务启动：http://localhost:2000/
* 3、访问监控首页：http://localhost:2333/hystrix
* 4、监控测试:
* 4.1、在输入框输入：http://localhost:2333/hystrix.stream
* 4.2、点击monitor按钮