﻿
## 一、概念
* 服务中心又称注册中心，管理各种服务功能包括服务的注册、发现、熔断、负载、降级等，比如dubbo admin后台的各种功能。
### 1、spring cloud Eureka：
* 是spring cloud Netfix微服务套件中的一部分，基于netfix eureka做了二次封装，主要完成微服务的治理功能。它主要用来实现各个微服务实例的自动化注册与发现。
为了解决微服务架构中的访问实例维护问题，产生了大量的服务治理框架和产品，这些框架和产品的实现都围绕服务注册与服务发现机制来完成对微服务应用实例的自动化管理。
### 2、Eureka由两个组件组成：
* Eureka服务器和Eureka客户端。Eureka服务器用作服务注册服务器。Eureka客户端是一个java客户端，用来简化与服务器的交互、作为轮询负载均衡器，并提供服务的故障切换支持。Netflix在其生产环境中使用的是另外的客户端，它提供基于流量、资源利用率以及出错状态的加权负载均衡。
#### 2.1、服务注册：
* 登记服务单元提供的服务，及端口号，版本号，通讯协议一些附加信息，注册中心按服务名分类组织服务清单。
* 服务中心需要以心跳的方式监测清单中的服务是否可用。

#### 2.2、服务发现：
* 服务之间的调用通过服务名发起请求调用实现，因此服务调用方在调用提供方接口的时候不知道具体服务实例位置。调用方需要向服务注册中心咨询服务并获取所有服务的实例清单，实现对具体服务的访问。

### 2、spring cloud Eureka实现：
* 使用Netfix Eureka来实现服务注册与发现，包含了服务组件和客户端组件，服务端与客户端都是采用java编写，所以eureka主要适用于java实现的分布式系统，或与jvm兼容用于构建的系统。

### 3、Eureka服务端（注册中心）：
* 1、提供服务注册和发现
* 2、支持高可用配置，依托于强一致性提供良好的服务实例可用性，可以应对不同的故障场景。
* 3、如果eureka以集群模式部署，当前集群中有分片出现故障时，eureka就转入自我保护模式，运行分片故障期间继续提供服务的发现和注册，当故障分片恢复运行时，集群中的其他分片会把他们的状态再次同步回来。

### 4、Eureka客户端：
* 1、服务提供方
* 2、将自身服务注册到Eureka，从而使服务消费方能够找到
* 3、主要处理服务的注册与发现。客户端服务通过注解和参数配置的方式嵌入在客户端中。程序运行时eureka客户端想注册中心注册自身提供的服务并周期性发送心跳更新服务状态。

### 5、Eureka Consumer
* 1、服务消费方
* 2、从Eureka获取注册服务列表，从而能够消费服务

## 二、eureka 注册中心搭建
* 采用maven方式搭建：采用model方式开发对应服务
### 1、创建基础项目best-spring-cloud
#### 1.1、项目pom文件配置 
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!--添加springBoot的基础依赖-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.3.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <groupId>base.cloud</groupId>
    <version>1.0-SNAPSHOT</version>
    <artifactId>best-spring-cloud</artifactId>
    <packaging>pom</packaging>
    <!--统一指定版本号-->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
        <spring-cloud.version>Dalston.RELEASE</spring-cloud.version>
    </properties>
    
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```
##### 说明：
* 项目基础框架指定了项目的版本号，添加一些基础依赖

### 2、eureka搭建：

#### 2.2、pom配置
```<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>best-spring-cloud</artifactId>
        <groupId>base.cloud</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>best-eureka</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-server</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter</artifactId>
        </dependency>
    </dependencies>
</project>
```
##### 说明：
* spring-cloud-starter-eureka-server：添加eureka对应的依赖库
* spring-cloud-starter：添加spring cloud基础依赖库
##### 注意：
* 在项目基础配置中有添加org.springframework.boot依赖，所以本model不用再次添加依赖

#### 2.3、创建启动类
```/**
 * 注册中心启动类
 *
 * @author brusion
 * @date 2018/8/25
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
```
##### 说明：
* @SpringBootApplication：标识当前类为springBoot应用
* @EnableEurekaServer：标识当前类为Eureka服务类
* SpringApplication.run()：spring应用的启动方法（可以有多种方式）

#### 2.4、配置文件：application.properties
```
spring.application.name=best-eureka
server.port=2000
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
eureka.client.serviceUrl.defaultZone=http://localhost:${server.port}/eureka/
```
##### 说明：
* spring.application.name：指定当前应用的名称
* server.port：指定当前应用的访问端口
* eureka.client.register-with-eureka：表示是否将自己注册到eureka
* eureka.client.fetch-registry：表示是否从eureka获取注册信息
* eureka.client.serviceUrl.defaultZone：设置eureka交互地址

### 2.5、测试
* 1、启动应用
* 2、访问地址：
```
http://localhost:2000/
```

## 三、总结
* eureka搭建：
#### 1、添加maven依赖：
* org.springframework.boot
* spring-cloud-starter-eureka-server
* spring-cloud-starter
#### 2、创建启动类，并需要添加注解
* @SpringBootApplication
* @EnableEurekaServer
#### 3、添加配置文件