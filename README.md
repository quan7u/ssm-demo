

# 基于ssm的仿微博系统

[![Build Status](https://travis-ci.org/yrucrew/ssm-demo.svg?branch=master)](https://travis-ci.org/yrucrew/ssm-demo)
[![version](https://img.shields.io/badge/version-0.8-red.svg)]() [![License](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/yrucrew/ssm-demo/blob/master/LICENSE)

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

# **注意** Document base 必须与 上传相关代码

# 「存储图片的物理路径」String pic_path一致

# 如果修改path 请对应修改jsp

把图片上传到web项目目录外

![配置虚拟路径保存上传图片](https://github.com/yrucrew/ssm-demo/blob/master/readme-img/%E9%85%8D%E7%BD%AE%E8%99%9A%E6%8B%9F%E8%B7%AF%E5%BE%84%E4%BF%9D%E5%AD%98%E4%B8%8A%E4%BC%A0%E5%9B%BE%E7%89%87.png?raw=true)

![Tomcat配置](https://github.com/yrucrew/ssm-demo/blob/master/readme-img/Tomcat%E9%85%8D%E7%BD%AE.png?raw=true)

##### 5 （可选）把默认头像放到作为存储上传图片的目录下

/weibo/src/main/resources/img/default.png

这样注册时就会默认选中头像啦（看得比较舒服 你也可以自己配置

##### 6 首次使用

启动Tomcat然后可以发微博啦！！！！

> 前台http://localhost:8080/weibo/login.action
>
> 后台http://localhost:8080/weibo/signin.action 默认admin admin（已写入sql

Ps：你的数据库是没有其他数据的 自行注册吧

## 示例

### 登录页

![登录页](https://github.com/yrucrew/ssm-demo/blob/master/readme-img/%E7%99%BB%E5%BD%95%E9%A1%B5.png?raw=true)

### 首页

![首页](https://github.com/yrucrew/ssm-demo/blob/master/readme-img/%E9%A6%96%E9%A1%B5.png?raw=true)

### 消息提醒

![消息提醒](https://github.com/yrucrew/ssm-demo/blob/master/readme-img/%E6%B6%88%E6%81%AF%E6%8F%90%E9%86%92.png?raw=true)

### 收到的赞

![收到的赞](https://github.com/yrucrew/ssm-demo/blob/master/readme-img/%E6%94%B6%E5%88%B0%E7%9A%84%E8%B5%9E.png?raw=true)

### 评论

![回复测试](https://github.com/yrucrew/ssm-demo/blob/master/readme-img/%E5%9B%9E%E5%A4%8D%E6%B5%8B%E8%AF%95.png?raw=true)

### 后台

（只做了个公告哈哈，CRUD不想写啊啊啊啊

![后台](https://github.com/yrucrew/ssm-demo/blob/master/readme-img/%E5%90%8E%E5%8F%B0.png?raw=true)

### 公告功能

![公告功能](https://github.com/yrucrew/ssm-demo/blob/master/readme-img/%E5%85%AC%E5%91%8A%E5%8A%9F%E8%83%BD.png?raw=true)
