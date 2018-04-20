### 注入各种不同的数据类型
* 1、常量注入
* 2、Bean Id注入
* 3、集合注入：set，list，map
* 4、数组注入：一维数组，二维数组
* 5、Properties注入

### 一、常量注入（constant 包）
* int，String类型：直接通过数据注入的方式注入
* boolean类型：直接通过name注入，设置值有：true，yes，on，1设置后布尔值都是true
    
### 一、Bean Id注入（idBean 包）
* ﻿引用其他对象的id值对应的数据设置为当前实体对象的数据

### 一、集合注入：set，list，map（listBean 包）
* ﻿给实体定义成员变量，并创建setter方法

### 一、properties注入 （properties 包）
* ﻿给实体定义Properties属性，通过setter方法设置数据