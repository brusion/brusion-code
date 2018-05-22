## 动态sql详解
### 一、if标签
#### 1.1、使用
```
  <select id="selectByLike" parameterType="DynamicObject" resultMap="dynamicResult">
        select * from mybatis_dynamic where 1=1
        <if test="dynamicName != null"> and dynamic_name = #{dynamicName}</if>
        <if test="dynamicTitle != null"> and dynamic_title = #{dynamicTitle}</if>
        <if test="dynamicDesc != null"> and dynamic_desc = #{dynamicDesc}</if>
    </select>
```
#### 1.2、说明：
* if语句提供一个带功能性可选的文字
* 只有test中的条件满足才会执行if标签中的sql语句

### 二、where语句
#### 2.1、使用
```
    <select id="selectByWhere" parameterType="DynamicObject" resultMap="dynamicResult">
         select * from mybatis_dynamic
         <where>
             <if test="dynamicName != null"> and dynamic_name = #{dynamicName}</if>
             <if test="dynamicTitle != null"> and dynamic_title = #{dynamicTitle}</if>
             <if test="dynamicDesc != null"> and dynamic_desc = #{dynamicDesc}</if>
         </where>
    </select>
```