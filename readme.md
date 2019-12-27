# RRIMS

餐馆订餐信息管理系统

## 2019年12月14日 13点27分

准备工作

1.测试整合spring的applicationContext.xml配置文件

2.测试log4j日志功能

3.测试springJDBC

4.连接数据库

5.xyz.cym2018.servlet mapping

## 2019年12月15日 19点18分

1.为web应用添加Filter:org.springframework.web.filter.CharacterEncodingFilter
>自动处理网页编码

## 2019年12月16日 15点45分

> 阅读spring文档.

## 2019年12月18日 14点24分

> 在springMVC配置上卡了3天
>
> springMVC 包括两个容器,第一个是spring(父)容器,第二个是springMVC(子)容器
>
> springMVC子容器负责扫描controller,spring父容器负责初始化子容器,扫描其他bean类,事务增强
>
>将controller扫描至spring容器,或者springMVC容器配置错误,会导致无法访问controller
>
> 参考: [(csdn)叫我吕小布:springmvc不进入Controller导致404](https://blog.csdn.net/qq_36769100/article/details/71746449)

## 2019年12月19日 12点52分
> 经过对比后,决定采用Hibernate框架,
>
> 做出一个非常简陋的注册页面和用户列表页面.
>
> 意味着springMVC框架搭建完毕,前后端交互,数据库连接都已经解决
>
> 剩下的进度应该会很快
>
> 前端留在最后

## 2019年12月27日 09点36分
> 1.注册
>> 用户名
>>
>> 密码
>> 
>> 用户类型(商家/用户)
>
> 2.用户视图
>> 商家列表
>>
>> 点餐
>>
>> 提交订单
>
> 3.商家视图
>
>> 商店维护
>>>
>>> 菜单
>>>
>>> 数据统计
>>
>> 订单处理
>>> 确认订单
>>>
>>> 取消订单
>
> 4.订单
>> 生成(用户)>>取消(用户)
>>
>> 生成(用户)>>确认(商家)>>完成(用户)
>
> 5.数据结构
>
> 表名|字段1|字段2|字段3|字段4
> -|-|-|-|-
> 用户表|userid|username|password|type|
> 店铺表|shopid|shopname|uid|
> 商品表|goodsid|name|price|state|shopid|
> 订单表|orderid|shopid|userid|goodsid|



## 对SpringMVC框架的理解
> 原生javaEE项目:
>> jsp页面显示
>>
>> web.xml决定处理请求的servlet
>>
>>servlet处理请求,返会数据
> 
>SpringMVC项目:
>
>> 所有的http请求都交给springMVC的servlet 'DispatcherServlet' 处理
>>
>> DispatcherServlet决定处理请求的Controller (或者静态请求还给web容器处理)
>>
>> 由控制反转生成Controller需要的参数