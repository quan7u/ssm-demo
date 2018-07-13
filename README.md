

# 基于ssm的仿微博系统

## 项目简介

这是我的第一个ssm项目，做了快有一个半月，本着做一个大作业顺便熟悉框架顺便找实习的小项目....的想法

前端框架用的是Bootstrap

做完也不想就这样扔在一边，就拿上来分享一下吧

整体来说，代码应该是比较乱的，毕竟第一次搭建框架，然后各种补逻辑业务，改数据库设计

文件上传用了百度的插件 [WebUploader ](http://fex.baidu.com/webuploader/)

消息提醒用的是轮询，公告功能用了websocket

restful是后来接触到的，所以没有加上

深切体会到按需求即学即用，还好至少把功能都实现了哈

## 运行环境

关系数据库系统：MySQL5.5

JDK版本：1.8

浏览器：Chrome

Maven：apache-maven-3.5.3

Tomcat：apache-tomcat-8.5.30

IDE：Eclipse Neon.3 Release (4.6.3)

## 快速开始 

##### 1 克隆项目到本地

```shell
git clone https://github.com/yrucrew/ssm-demo.git
```

##### 2 在Eclipse中导入项目

> File——Import——General——Existing Projects into Workspace

第一次构建项目会比较慢 耐心等会

##### 3 创建数据库 建表

创建数据库 运行sql文件

> /weibo/src/main/resources/sql/weibo.sql

修改成你的数据库配置

> /weibo/src/main/resources/db.properties

##### 4 在Tomcat中配置虚拟路径

把图片上传到web项目目录外

![配置虚拟路径保存上传图片](F:\Default\weibo\readme-img\配置虚拟路径保存上传图片.png)

![Tomcat配置](F:\Default\weibo\readme-img\Tomcat配置.png)

##### 5 （可选）把默认头像放到作为存储上传图片的目录下

/weibo/src/main/resources/img/default.png

这样注册时就会默认选中头像啦（看得比较舒服 你也可以自己配置

##### 6 首次使用

启动Tomcat然后可以发微博啦！！！！

> 前台http://localhost:8080/weibo/login.action
>
> 后台http://localhost:8080/weibo/signin.action 默认admin admin（已写入sql

Ps：你的数据库是没有其他数据的 自行注册吧

## 实例

### 登录页

![登录页](F:\Default\weibo\readme-img\登录页.png)

### 首页

![首页](F:\Default\weibo\readme-img\首页.png)

### 消息提醒

![消息提醒](F:\Default\weibo\readme-img\消息提醒.png)

### 收到的赞

![收到的赞](F:\Default\weibo\readme-img\收到的赞.png)

### 评论

![回复测试](F:\Default\weibo\readme-img\回复测试.png)

### 后台

（只做了个公告哈哈，CRUD不想写啊啊啊啊

![后台](F:\Default\weibo\readme-img\后台.png)

### 公告功能

![公告功能](F:\Default\weibo\readme-img\公告功能.png)