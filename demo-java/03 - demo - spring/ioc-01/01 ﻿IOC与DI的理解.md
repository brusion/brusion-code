# IOC与DI的理解
## 一、什么是ioc
* ﻿又叫控制反转，是一种思想，并不是具体的技术。
### 例如
* 在传统创建对象方式：Object object = new Object（）；
* 使用ioc以后： Object object = context.getBean(id);
#### 简单理解：将创建对象的过程交给了另外的一个对象。

## 二、什么是DI
* ﻿又叫依赖注入，分为依赖和注入
#### 代码：
```
class B{
    public void say(){}
}


class A{
    
    public void say(B b){
        b.say();
    }
    
    public void test(){
        B b = new B();
        b.say();
    }
}
```
#### 说明：﻿ A依赖B，B注入A
