### Spring cloud基本搭建
## 项目说明
* best-eureka：spring-cloud注册中心
* best-provide：服务提供者
* best-provide-cluster：服务提供负载均衡
* best-consumer：服务消费者
* best-dashboard：服务监控
* best-zuul：spring cloud网关服务

## 地址访问（不含网关）
* 依次启动项目（best-zuul不启动）
#### 访问注册中心：http://localhost:2000/
#### 访问服务提供者数据：http://localhost:2111/index
#### 访问消费者提供数据并有负载均衡，服务熔断效果：http://localhost:2222/index
#### 服务服务监控：http://localhost:2333/hystrix

## 地址访问（含网关）
* 依次启动所有项目
#### 访问注册中心：http://localhost:2000/
#### 访问服务提供者数据有负载均衡效果：http://localhost:8088/best/provide/index
#### 访问消费者提供数据并有负载均衡，服务熔断效果：http://localhost:8088/best/consumer/index
#### 服务服务监控：http://localhost:8088/best/dashboard/hystrix