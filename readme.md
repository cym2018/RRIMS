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
> 2.用户中心
>
> 3.用户视图
>> 商家列表
>>
>> 点餐
>>
>> 提交订单
>
> 4.商家视图
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
>> 表名(直观)|表名(代码)|字段1|字段2|字段3|字段4|字段5
>> :-:|:-:|:-:|:-:|:-:|:-:|:-:
>> 用户表|user|userid|username|password|type|belong
>> 商品表|goods|goodsid|name|price|state|shopid|
>> 订单表|orders|orderid|shopid|userid|goodsid|
> 参见/src/main/resources/DB.txt

## 2019年12月27日 16点34分
> 使用filter登陆验证
> 完成了用户注册,登陆,信息查看,新建店铺功能


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
>
## 2019年12月29日 00点57分
> 完成了主要的功能:
>>注册
>>
>>登陆
>>
>>商店列表
>>
>>菜单
>>
>>订单增删改查,状态维护
>>
>>用户信息查看
>>
>>用户名下商店
>>
>>创建商店
>>
>>菜单增删改查
>
>急需完善
>>页面显示
>>
>>商家确认订单
>>
>>用户签收订单
>>
>>数据/销量统计
>
>可选
>>JavaScript+html+json显示页面,进一步前后端分离
>>
>>使用@Query注解重构代码,增加代码可维护性
>>
>>拒绝订单/退货/售后功能
>>
>>jpa 多对一

## 2019年12月29日 12点54分
> 重构代码,更正拼写,变量命名不规范问题
>
> 修改提示页面,增加导航内容
>
> 修改filter mapping,未登录时允许查看商店列表
```text
			RootController
注册:		/register.jsp
			/register
登陆:		/login.jsp
			/login
			UserController
用户信息:	/user/info
			/user/info/jsp
SellController
新建店铺:	/sell/creat.jsp
			/sell/creat
店铺信息:	/sell/info
			/sell/info.jsp
菜单:		/sell/menu
			/sell/menu.jsp
				SellMenuController
加菜:			/sell/menu/creat.jsp
				/sell/menu/creat
删菜:			/sell/menu/delete
				/message.jsp
选中菜&改菜:	/sell/menu/select
				/sell/menu/update.jsp
				/sell/menu/update
BuyController
店铺列表:	/buy/list
			/buy/list.jsp
选中店铺:	/buy/shop
			/buy/shop.jsp
				BuyShopController
添加购物车:		/buy/shop/add
删除购物车:		/buy/shop/remove
支付:			/buy/shop/pay
```

## 2019年12月29日 15点02分
> 部署
>> [demo](4.cym2018.xyz:8080/)
>>
>> 已知问题:
>>
>> 1.数据库编码导致的不支持中文
>>
>> 2.未知原因导致的不能添加购物车.
>
> 代码结构调整
>> 消除全部警告(忽略unused警告和DAO类中的拼写问题)
>>
>> 重新设计url目录
>>
>> 更新DB.txt到最新
>>
>> 删除多余的配置文件和测试代码

