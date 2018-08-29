#### spring cloud 实践目录
* 最近微服务，分布式都比较火，说到微服务不得不说spring boot和spring cloud，本章直说spring cloud

## 一、先来了学习几个概念
#### 1、什么是微服务
* (来自百度百科)微服务架构是一项在云中部署应用和服务的新技术。大部分围绕微服务的争论都集中在容器或其他技术是否能很好的实施微服务，而红帽说API应该是重点。 微服务可以在“自己的程序”中运行，并通过“轻量级设备与HTTP型API进行沟通”。关键在于该服务可以在自己的程序中运行。通过这一点我们就可以将服务公开与微服务架构（在现有系统中分布一个API）区分开来。在服务公开中，许多服务都可以被内部独立进程所限制。如果其中任何一个服务需要增加某种功能，那么就必须缩小进程范围。在微服务架构中，只需要在特定的某种服务中增加所需功能，而不影响整体进程。
##### 1.1、画重点：
* 服务可以在自己的程序中运行
* 个人感觉都是一脸懵逼

#### 2、什么是Spring cloud：
* （来自百度百科）Spring Cloud是一系列框架的有序集合。它利用Spring Boot的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用Spring Boot的开发风格做到一键启动和部署。Spring Cloud并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过Spring Boot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。
##### 2.1、画重点：
* 1、简化了分布式系统基础设施的开发
* 2、只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来
* 3、给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包

#### 3、spring boot和Spring cloud 是什么关系
* 1、Spring Boot 是 Spring 的一套快速配置脚手架，可以基于Spring Boot 快速开发单个微服务，Spring Cloud是一个基于Spring Boot实现的云应用开发工具；
* 2、Spring Boot专注于快速、方便集成的单个个体，Spring Cloud是关注全局的服务治理框架；
* 简单理解：spring boot用于开发单个服务，spring cloud将这些单个服务关联起来

## 二、spring cloud目录
* 本目录基于项目快速开发搭建，可以作为项目的基本框架。
#### [01-spring cloud ﻿eureka服务注册与发现](https://blog.csdn.net/qq_34231253/article/details/82179894)
#### [02-spring cloud provide服务提供者及负载均衡实现](https://blog.csdn.net/qq_34231253/article/details/82183259)
#### [03-spring cloud consumer服务消费者包含添加熔断机制](https://blog.csdn.net/qq_34231253/article/details/82184115)
#### [04-spring cloud dashboard熔断监控](https://blog.csdn.net/qq_34231253/article/details/82184742)
#### [05-spring cloud zuul网关](https://blog.csdn.net/qq_34231253/article/details/82185129)


## 三、代码地址
#### [Github](https://github.com/brusion/brusion-code/tree/master/demo-java-project/best-spring-cloud)

