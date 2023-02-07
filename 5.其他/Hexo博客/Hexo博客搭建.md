---
title: Hexo博客搭建
date: 2022-03-15 01:40:24
tags: 前端
---

# Hexo博客搭建

换了一台电脑，于是从新搭建了一会博客，并且写下这篇博客进行记录，以便于以后使用

<!--more-->



## 1、事前准备

首先在电脑上安装node.js和git

然后可以在cmd处运行下列代码验证并更改淘宝源

~~~powershell
node -v  #检测node版本
npm -v  #检测npm版本
npm config set registry http://registry.npm.taobao.org   #更换淘宝源，切记，不然慢到你吐血
~~~

在cmd处设置git的账号信息

~~~powershell
git config --blobal user.email "这里填你的邮箱"
git config --blobal user.name "这里填你的用户名"
#用户名是啥我也不太清楚，估计是类似注册起名，所以叫啥都行，这个等我查查
~~~





注册一个github或者gitee账号，这里使用gitee，是国内网站，访问较快

之后按照以下步骤操作：

  1.创建一个新仓库

![请添加图片描述](https://img-blog.csdnimg.cn/c7c4290edf0245eba7312e6cc72868e0.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_15,color_FFFFFF,t_70,g_se,x_16)

  2.保留仓库初始界面

![请添加图片描述](https://img-blog.csdnimg.cn/49a358b8fb284dbd9e0bf0f5c73639a5.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_20,color_FFFFFF,t_70,g_se,x_16)

## 2、搭建博客

在cmd中依次执行以下操作

~~~powershell
npm install -g hexo-cli   #安装hexo
hexo -v   #查看hexo版本




cd desktop   #将博客文件保存在桌面上，当然也可以选择其他路径




hexo init myblog  # 这里的myblog是将要生成的文件夹名字，这里代码先换成其他的  ！！！暂时先用下面的命令！！！，下边有解释原因




cd myblog
hexo clean
hexo generate  # 生成各种web资源
hexo server   # 启动本地服务
#在hexo server后生成的网址中可以对当前博客进行预览




npm install --save hexo-deployer-git  # 安装hexo的git插件
~~~

然后打开myblog中的_config.yml文件，下拉都最下边，然后更改如下代码

~~~powershell
deploy:
  	type: git
  	repository: #替换成项目地址#
~~~

这里的项目地址就用之前在gitee里边仓库生成的代码

![请添加图片描述](https://img-blog.csdnimg.cn/b71d08501fdd473c95dbdbab54e826f6.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_20,color_FFFFFF,t_70,g_se,x_16)

最后回到cmd，执行下列命令

~~~powershell
hexo deploy  # 部署
# 要是同步到Gitee仓库，需要手动更新；GitHub会自动更新
~~~



执行完毕后，在仓库的服务选项里开通Gitee Pages服务，然后就会生成博客的网址

![请添加图片描述](https://img-blog.csdnimg.cn/40b1f810dfaa4c4cb8808e0c8e98d110.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_20,color_FFFFFF,t_70,g_se,x_16)



**解释hexo init xxxx**

> hexo init xxxx实际上是如下命令的集成：

```powershell
git clone https://github.com/hexojs/hexo-starter.git myblog
cd myblog
git submodule init
git submodule update
npm i
```

> 在学长写教学文档的时候（2020.12.11）发现21小时前的一个更新hexo-starter的作者把themes下的文件清空了，导致了后面更换主题后执行任何hexo操作都会出现如下错误：
>
> ERROR {
> err: [Error: EISDIR: illegal operation on a directory, read] {
>  errno: -4068,
>  code: 'EISDIR',
>  syscall: 'read'
> }
> } Plugin load failed: %s hexo-theme-landscape
>
> **因此此处暂时先将hexo init xxxx替换成如下命令**（将原仓库替换成一个镜像仓库）：
>
> 即用以下代码代替 hexo init myblog

```powershell
git clone https://gitee.com/weilining/hexo-starter.git myblog
cd myblog
git submodule init
git submodule update
npm i
```





## 3、添加文章

在cmd里执行如下代码

~~~powershell
hexo new "文章名"
~~~

然后就会在myblog\source\\_posts路径下生成对应的md文件，对其进行编辑后，重新执行以下代码即可更新gitee上的仓库

~~~powershell
hexo clean
hexo generate
hexo deploy
~~~



## 4、更换主题

hexo也可以换主题，一般都在GitHub上开源

分别执行以下操作

```powershell
git clone https://github.com/litten/hexo-theme-yilia.git themes/yilia
# 修改一下_config.yml的theme，将其改为新下载的主题名，这里是叫yilia
# 然后还是那几个命令
hexo clean
hexo generate
hexo server
```



## 5、常见问题

1. hexo deploy时报错：fatal: unable to auto-detect email address[解决方法](https://blog.csdn.net/qq_38335037/article/details/81163312)

2. hexo g时报错：err: YAMLException: can not read a block mapping entry; a multiline key may not be an implicit key at line 4, column 1: [解决方法](https://blog.csdn.net/qq_43857095/article/details/108272313)

3. 建成的博客有的文章显示不完全，被截断：

   解决方法：在md文件中不能出现**尖括号**加**标签**的语句，会被识别为某种在网页上操作，如下图，将尖括号删掉后就没事了

   ![请添加图片描述](https://img-blog.csdnimg.cn/df2a94d48d1c428fbf86d0449b8224a1.png)

