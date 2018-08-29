
* 1、访问消费方
* 2、通过Eureka中的服务名称获取消费服务

## 一、Hystrix特性
* 1、资源隔离（线程池隔离和信号量隔离）机制：限制调用分布式服务的资源使用，某一个调用的服务出现问题不会影响其它服务调用。
* 2、限流机制：限流机制主要是提前对各个类型的请求设置最高的QPS阈值，若高于设置的阈值则对该请求直接返回，不再调用后续资源。
* 3、熔断机制：当失败率达到阀值自动触发降级（如因网络故障、超时造成的失败率真高），熔断器触发的快速失败会进行快速恢复。
* 4、降级机制：超时降级、资源不足时（线程或信号量）降级 、运行异常降级等，降级后可以配合降级接口返回托底数据。
* 5、缓存支持：提供了请求缓存、请求合并实现
* 6、通过近实时的统计/监控/报警功能，来提高故障发现的速度
* 7、通过近实时的属性和配置热修改功能，来提高故障处理和恢复的速度

## 二、服务消费搭建
* 采用maven方式创建：best-consumer
### 2.1、maven配置
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
    <artifactId>best-consumer</artifactId>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-eureka-server</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-feign</artifactId>
        </dependency>
    </dependencies>
</project>
```
##### 说明：
* spring-cloud-starter-feign：添加feign库依赖，包含了Hystrix对应功能
### 2.2、创建启动类
```
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
```
##### 说明：
* @SpringBootApplication：标记为springBoot应用
* @EnableFeignClients：启用Feign远程调用
* @EnableDiscoveryClient：启用服务注册与发现功能

### 2.3、创建远程调用类
```
@FeignClient(name = "best-provide", fallback = UserRemote.UserRemoteHystrix.class)
public interface UserRemote {
    @RequestMapping("/index")
    String index();
    @Component
    public class UserRemoteHystrix implements UserRemote {
        @Override
        public String index() {
            return " hystrix data ： " + getClass().toString();
        }
    }
}
```
##### 说明：
* 1、@FeignClient：开启远程调用
* 2、name = "best-provide"：远程服务名称（在Eureka注册的名称）
* 3、fallback = UserRemote.UserRemoteHystrix.class：远程服务调用失败熔断时返回的类
* 4、@RequestMapping("/index")：远程服务的接口地址（必须要与远程模块一致）
* 5、UserRemoteHystrix：熔断类，当远程调用失败时数据从熔断类中获取

### 2.4、添加接口
* 通过接口类将远程调用的数据返回
```
@RestController
public class UserController {
    @Autowired
    private UserRemote userRemote;
    @RequestMapping("/consumer")
    public String indexTest() {
        return userRemote.index();
    }
}
```
### 2.5、添加配置文件
```
spring.application.name=best-consumer
server.port=2222
feign.hystrix.enabled=true
eureka.client.serviceUrl.defaultZone=http://localhost:2000/eureka/
    
```
##### 说明：
* feign.hystrix.enabled：开启远程调用的熔断功能

### 2.6、测试
* 1、启动应用：best-eureka，best-provide，best-provide-cluster，best-consumer
* 2、查看注册中心服务：
```
http://localhost:2000/
```
* 3、服务接口查看负载均衡效果：
```
http://localhost:2222/consumer
```
* 4、关闭两个服务查看熔断效果：
```
http://localhost:2222/consumer
```