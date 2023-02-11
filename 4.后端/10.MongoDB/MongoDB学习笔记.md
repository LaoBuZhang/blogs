# MongoDB



- 理解MongoDB的业务场景、熟悉MongoDB的简介、特点和体系结构、数据类型等。 
- 能够在Windows和Linux下安装和启动MongoDB、图形化管理界面Compass的安装使用 
- 掌握MongoDB基本常用命令实现数据的CRUD 
- 掌握MongoDB的索引类型、索引管理、执行计划。 
- 使用Spring Data MongoDB完成文章评论业务的开发





## 1 MongoDB概念

MongoDB也是NoSQL类型的数据库

==数据库  >  文档=集合=表  >  字段=列==

### 1.1 业务场景

传统的关系型数据库（如MySQL），在数据操作的“三高”需求以及应对Web2.0的网站需求面前，显得力不从心。 

解释：“三高”需求：

- High performance - 对数据库高并发读写的需求。
- Huge Storage - 对海量数据的高效率存储和访问的需求。
-  High Scalability && High Availability- 对数据库的高可扩展性和高可用性的需求。

**而MongoDB可应对“三高”需求。**



MongoDB适合的场景

- 数据量大
- 写入频繁
- 数据价值较低





**什么时候选择MongoDB ：**

在架构选型上，除了上述的三个特点外，如果你还犹豫是否要选择它？可以考虑以下的一些问题： 

应用不需要事务及复杂 join 支持 

新应用，需求会变，数据模型无法确定，想快速迭代开发 应用需要2000-3000以上的读写QPS（更高也可以） 

应用需要TB甚至 PB 级别数据存储 

应用发展迅速，需要能快速水平扩展 

应用要求存储的数据不丢失 

应用需要99.999%高可用 

应用需要大量的地理位置查询、文本查询 

如果上述有1个符合，可以考虑 MongoDB，2个及以上的符合，选择 MongoDB 绝不会后悔。





## 1.2 MongoDB简介

MongoDB是一个开源、高性能、无模式的文档型数据库，当初的设计就是用于简化开发和方便扩展，是NoSQL数据库产品中的一种。是最 像关系型数据库（MySQL）的非关系型数据库。

它支持的数据结构非常松散，是一种类似于 JSON 的 格式叫BSON，所以它既可以存储比较复杂的数据类型，又相当的灵活。

MongoDB中的记录是一个文档，它是一个由字段和值对（field:value）组成的数据结构。MongoDB文档类似于JSON对象，即一个文档认为就是一个对象。字段的数据类型是字符型，它的值除了使用基本的一些类型外，还可以包括其他文档、普通数组和文档数组。





## 1.3 体系结构

MySQL和MongoDB对比

![image-20221027224226487](images/image-20221027224226487.png)



![image-20221027224254186](images/image-20221027224254186.png)







### 1.4 数据类型

MongoDB的最小存储单位就是文档(document)对象。文档(document)对象对应于关系型数据库的行。数据在MongoDB中以 BSON（Binary-JSON）文档的格式存储在磁盘上。

BSON（Binary Serialized Document Format）是一种类json的一种二进制形式的存储格式，简称Binary JSON。BSON和JSON一样，支持 内嵌的文档对象和数组对象，但是BSON有JSON没有的一些数据类型，如Date和BinData类型。 

BSON采用了类似于 C 语言结构体的名称、对表示方法，支持内嵌的文档对象和数组对象，具有轻量性、可遍历性、高效性的三个特点，可 以有效描述非结构化数据和结构化数据。这种格式的优点是灵活性高，但它的缺点是空间利用率不是很理想。

 Bson中，除了基本的JSON类型：string,integer,boolean,double,null,array和object，mongo还使用了特殊的数据类型。这些类型包括 date,object id,binary data,regular expression 和code。



**MongoDB数据类型**

![image-20221027224527254](images/image-20221027224527254.png)







### 1.5 MongoDB特点

MongoDB主要有如下特点： 

**（1）高性能：** 

MongoDB提供高性能的数据持久性。特别是, 

对嵌入式数据模型的支持减少了数据库系统上的I/O活动。 

索引支持更快的查询，并且可以包含来自嵌入式文档和数组的键。（文本索引解决搜索的需求、TTL索引解决历史数据自动过期的需求、地 理位置索引可用于构建各种 O2O 应用） 9

mmapv1、wiredtiger、mongorocks（rocksdb）、in-memory 等多引擎支持满足各种场景需求。 

Gridfs解决文件存储的需求。

**（2）高可用性：** 

MongoDB的复制工具称为副本集（replica set），它可提供自动故障转移和数据冗余。

 **（3）高扩展性：**

 MongoDB提供了水平可扩展性作为其核心功能的一部分。 

分片将数据分布在一组集群的机器上。（海量数据存储，服务能力水平扩展） 

从3.4开始，MongoDB支持基于片键创建数据区域。在一个平衡的集群中，MongoDB将一个区域所覆盖的读写只定向到该区域内的那些 片。 

**（4）丰富的查询支持：** 

MongoDB支持丰富的查询语言，支持读和写操作(CRUD)，比如数据聚合、文本搜索和地理空间查询等。 

**（5）其他特点：**

如无模式（动态模式）、灵活的文档模型、



## 2 单机部署



### 2.1 windows

1. 下载安装包

   [MongoDB](https://www.mongodb.com/try#community)

2. 解压

3. 启动，有两种方式

   1. **命令行参数启动**

      在文件夹内新建\data\db，作为数据库地址

      在bin目录运行cmd

      ~~~shell
      mongod --dbpath=..\data\db
      ~~~

   2. **配置文件启动**

      文件夹内新建\config\mongod.conf

      写入

      ~~~bash
      storage:
          #The directory where the mongod instance stores its     data.Default Value is "\data\db" on Windows.
          dbPath: D:\02_Server\DBServer\mongodb-win32-x86_64-2008plus-ssl-4.0.1\data #这个写数据库地址，即db文件夹
      ~~~

      运行

      ~~~bash
      mongod -f ../config/mongod.conf
      或
      mongod --config ../config/mongod.conf
      ~~~

      

更多详细参数配置

~~~bash
systemLog:
destination: file
#The path of the log file to which mongod or mongos should send all diagnostic logging information
path: "D:/02_Server/DBServer/mongodb-win32-x86_64-2008plus-ssl-4.0.1/log/mongod.log"
logAppend: true
storage:
journal:
enabled: true
#The directory where the mongod instance stores its data.Default Value is "/data/db".
dbPath: "D:/02_Server/DBServer/mongodb-win32-x86_64-2008plus-ssl-4.0.1/data"
net:
#bindIp: 127.0.0.1
port: 27017
setParameter:
enableLocalhostAuthBypass: false
~~~





### 2.2 shell连接

在命令提示符输入以下shell命令即可完成登陆 

~~~shell
mongo
或
mongo --host=127.0.0.1 --port=27017
~~~



查看已经有的数据库 

~~~shell
show databases
~~~



退出mongodb 

~~~shell
exit
或者
^+c
~~~



更多参数可以通过帮助查看： 

~~~shell
mongo --help
~~~



提示： 

MongoDB javascript shell是一个基于javascript的解释器，故是支持js程序的。





### 2.3 图形化界面连接

到MongoDB官网下载MongoDB Compass， 

地址：[MongoDB Compass Download](https://www.mongodb.com/try/download/compass)





### 2.4 Linux

目标：在Linux中部署一个单机的MongoDB，作为生产环境下使用。 

提示：和Windows下操作差不多。 

步骤如下： 

（1）先到官网下载压缩包 mongod-linux-x86_64-4.0.10.tgz 。 

（2）上传压缩包到Linux中，解压到当前目录：

~~~bash
tar -xvf mongodb-linux-x86_64-4.0.10.tgz
~~~

（3）移动解压后的文件夹到指定的目录中：

~~~bash
mv mongodb-linux-x86_64-4.0.10 /usr/local/mongodb
~~~

（4）新建几个目录，分别用来存储数据和日志：

~~~bash
#数据存储目录
mkdir -p /mongodb/single/data/db
#日志存储目录
mkdir -p /mongodb/single/log
~~~

（5）新建并修改配置文件

~~~bash
vi /mongodb/single/mongod.conf
~~~

配置文件的内容如下：

~~~yaml
systemLog:
    #MongoDB发送所有日志输出的目标指定为文件
    # #The path of the log file to which mongod or mongos should send all diagnostic logging information
    destination: file
    #mongod或mongos应向其发送所有诊断日志记录信息的日志文件的路径
    path: "/mongodb/single/log/mongod.log"
    #当mongos或mongod实例重新启动时，mongos或mongod会将新条目附加到现有日志文件的末尾。
    logAppend: true
storage:
    #mongod实例存储其数据的目录。storage.dbPath设置仅适用于mongod。
    ##The directory where the mongod instance stores its data.Default Value is "/data/db".
    dbPath: "/mongodb/single/data/db"
    journal:
    #启用或禁用持久性日志以确保数据文件保持有效和可恢复。
    enabled: true
processManagement:
    #启用在后台运行mongos或mongod进程的守护进程模式。
    fork: true
net:
    #服务实例绑定的IP，默认是localhost
    bindIp: localhost,192.168.0.2
    #bindIp
    #绑定的端口，默认是27017
    port: 27017
~~~

（6）启动MongoDB服务

~~~bash
/usr/local/mongodb/bin/mongod -f /mongodb/single/mongod.conf
~~~

（7）分别使用mongo命令和compass工具来连接测试。

提示：如果远程连接不上，需要配置防火墙放行，或直接关闭linux防火墙

~~~bash
#查看防火墙状态
systemctl status firewalld
#临时关闭防火墙
systemctl stop firewalld
#开机禁止启动防火墙
systemctl disable firewalld
~~~

（8）停止关闭服务

（一）快速关闭方法（快速，简单，数据可能会出错）

~~~bash
#通过进程编号关闭节点
kill -2 54410
~~~

（二）标准的关闭方法（数据不容易出错，但麻烦）：

~~~bash
//客户端登录服务，注意，这里通过localhost登录，如果需要远程登录，必须先登录认证才行。
mongo --port 27017
//#切换到admin库
use admin
//关闭服务
db.shutdownServer()
~~~





## 3 基本常用命令



### 3.1 数据库操作

#### 3.1.1 选择和创建数据库

选择和创建数据库的语法格式：

~~~bash
use 数据库名称
~~~

如果数据库不存在则自动创建，例如，以下语句创建 spitdb 数据库：

~~~shell
use articledb
~~~

查看有权限查看的所有的数据库命令

~~~bash
show dbs
或
show databases
~~~



>注意: 在 MongoDB 中，集合只有在内容插入后才会创建! 就是说，创建集合(数据表)后要再插入一个文档(记录)，集合才会真正创建。

刚开始创建时位于内存，只有插入数据后才进入磁盘



查看当前使用的数据库

~~~设立了、
db
~~~

MongoDB 中默认的数据库为 test，如果你没有选择数据库，集合将存放在 test 数据库中。



有一些数据库名是保留的，可以直接访问这些有特殊作用的数据库。 

- admin： 从权限的角度来看，这是"root"数据库。要是将一个用户添加到这个数据库，这个用户自动继承所有数据库的权限。一些特 定的服务器端命令也只能从这个数据库运行，比如列出所有的数据库或者关闭服务器。 
- local: 这个数据永远不会被复制，可以用来存储限于本地单台服务器的任意集合 
- config: 当Mongo用于分片设置时，config数据库在内部使用，用于保存分片的相关信息。



#### 3.1.2 数据库的删除

~~~shell
db.dropDatabase()
~~~

提示：主要用来删除已经持久化的数据库



### 3.2 集合操作

#### 3.2.1 集合的显示创建

基本语法格式：

~~~shell
db.createCollection(name)
~~~

name: 要创建的集合名称



例如：创建一个名为 mycollection 的普通集合。

~~~shell
db.createCollection("mycollection")
~~~



查看当前库中的表：show tables命令

~~~shell
show collections
或
show tables
~~~



#### 3.2.2 集合的隐式创建 

当向一个集合中插入一个文档的时候，如果集合不存在，则会自动创建集合。 

详见 **文档的插入** 章节。 

提示：通常我们使用隐式创建文档即可。



#### 3.2.3 集合的删除

~~~shell
db.collection.drop()
或
db.集合.drop()
~~~

返回值 

如果成功删除选定集合，则 drop() 方法返回 true，否则返回 false。





### 3.3 文档的CRUD

在MongoDB中，collection相当于**关系型数据库的Table**

#### 3.3.1 文档的插入

（1）单个文档插入

~~~shell
db.collection.insert(
    <document or array of documents>,
    {
        writeConcern: <document>,
        ordered: <boolean>
    }
)
~~~

参数

![image-20221028160710041](images/image-20221028160710041.png)



【示例】 要向comment的集合(表)中插入一条测试数据：

~~~shell
db.comment.insert({"articleid":"100000","content":"今天天气真好，阳光明
媚","userid":"1001","nickname":"Rose","createdatetime":new Date(),"likenum":NumberInt(10),"state":null})
~~~

提示： 

1）comment集合如果不存在，则会隐式创建 

2）mongo中的数字，默认情况下是double类型，如果要存整型，必须使用函数NumberInt(整型数字)，否则取出来就有问题了。 

3）插入当前日期使用 new Date() 

4）插入的数据没有指定 _id ，会自动生成主键值 

5）如果某字段没值，可以赋值为null，或不写该字段。





注意： 

1. 文档中的键/值对是有序的。 
2. 文档中的值不仅可以是在双引号里面的字符串，还可以是其他几种数据类型（甚至可以是整个嵌入的文档)。 
3. MongoDB区分类型和大小写。 
4. MongoDB的文档不能有重复的键。 
5.  文档的键是字符串。除了少数例外情况，键可以使用任意UTF-8字符。



（2）批量插入

~~~shell
db.collection.insertMany(
    [ <document 1> , <document 2>, ... ],
    {
        writeConcern: <document>,
        ordered: <boolean>
    }
)
~~~



【示例】 

批量插入多条文章评论：

~~~shell
db.comment.insertMany([
	{"_id":"1","articleid":"100001","content":"我们不应该把清晨浪费在手机上，健康很重要，一杯温水幸福你我他。","userid":"1002","nickname":"相忘于江湖","createdatetime":new Date("2019-08-05T22:08:15.522Z"),"likenum":NumberInt(1000),"state":"1"},
	{"_id":"2","articleid":"100001","content":"我夏天空腹喝凉开水，冬天喝温开水","userid":"1005","nickname":"伊人憔悴","createdatetime":new Date("2019-08-05T23:58:51.485Z"),"likenum":NumberInt(888),"state":"1"},
	{"_id":"3","articleid":"100001","content":"我一直喝凉开水，冬天夏天都喝。","userid":"1004","nickname":"杰克船长","createdatetime":new Date("2019-08-06T01:05:06.321Z"),"likenum":NumberInt(666),"state":"1"},
	{"_id":"4","articleid":"100001","content":"专家说不能空腹吃饭，影响健康。","userid":"1003","nickname":"凯撒","createdatetime":new Date("2019-08-06T08:18:35.288Z"),"likenum":NumberInt(2000),"state":"1"},
	{"_id":"5","articleid":"100001","content":"研究表明，刚烧开的水千万不能喝，因为烫嘴。","userid":"1003","nickname":"凯撒","createdatetime":new Date("2019-08-06T11:01:02.521Z"),"likenum":NumberInt(3000),"state":"1"}
]);
~~~



提示：

 插入时指定了 _id ，则主键就是该值。 

如果某条数据插入失败，将会终止插入，但已经插入成功的数据不会回滚掉。 

因为批量插入由于数据较多容易出现失败，因此，可以使用try catch进行异常捕捉处理，测试的时候可以不处理。



#### 3.3.2 文档的查询

~~~shell
db.collection.find(<query>, [projection])
~~~



（1）查询所有

~~~shell
db.comment.find()
或
db.comment.find({})
~~~



（2）根据id查询一个

~~~shell
db.comment.find({userid:'1003'})
~~~

如果你只需要返回符合条件的第一条数据，我们可以使用findOne命令来实现，语法和find一样。

~~~shell
db.comment.findOne({userid:'1003'})
~~~



（3）投影查询

如果要查询结果返回部分字段，则需要使用投影查询（不显示所有字段，只显示指定的字段）。 在参数中将需要查询的字段设为1即可，不想要的字段可以设置为0

_id会默认显示，可以设为0不显示

如：查询结果只显示 _id、userid、nickname :

~~~shell
>db.comment.find({userid:"1003"},{userid:1,nickname:1})
{ "_id" : "4", "userid" : "1003", "nickname" : "凯撒" }
{ "_id" : "5", "userid" : "1003", "nickname" : "凯撒" }
~~~







#### 3.3.3 文档的更新

更新的语法

~~~shell
db.collection.update(query, update, options)
//或
db.collection.update(
	<query>,
	<update>,
	{
		upsert: <boolean>,
		multi: <boolean>,
		writeConcern: <document>,
		collation: <document>,
		arrayFilters: [ <filterdocument1>, ... ],
		hint: <document|string> // Available starting in MongoDB 4.2
	}
)
~~~



（1）覆盖的修改 

如果我们想修改_id为1的记录，点赞量为1001，输入以下语句：

~~~shell
db.comment.update({_id:"1"},{likenum:NumberInt(1001)})
~~~

执行后，我们会发现，这条文档除了likenum字段其它字段都不见了





（2）局部修改 

**在想要修改的字段前加$set:，并在外边加上{}**

为了解决这个问题，我们需要使用修改器$set来实现，命令如下： 

我们想修改_id为2的记录，浏览量为889，输入以下语句：

~~~shell
db.comment.update({_id:"2"},{$set:{likenum:NumberInt(889)}})
~~~



（3）批量的修改 

在option参数中加入{multi:true}

更新所有用户为 1003 的用户的昵称为 凯撒大帝 。

~~~shell
//默认只修改第一条数据
db.comment.update({userid:"1003"},{$set:{nickname:"凯撒2"}})
//修改所有符合条件的数据
db.comment.update({userid:"1003"},{$set:{nickname:"凯撒大帝"}},{multi:true})
~~~

提示：如果不加后面的参数，则只更新符合条件的第一条记录



（4）列值增长的修改 

如果我们想实现对某列值在原有值的基础上进行增加或减少，可以使用 $inc 运算符来实现。 

需求：对3号数据的点赞数，每次递增1

~~~shell
db.comment.update({_id:"3"},{$inc:{likenum:NumberInt(1)}})
~~~



#### 3.3.4 删除文档

~~~shell
db.集合名称.remove(条件)
~~~



以下语句可以将数据全部删除，请慎用

~~~shell
db.comment.remove({})
~~~



如果删除_id=1的记录，输入以下语句

~~~shell
db.comment.remove({_id:"1"})
~~~





### 3.4 分页查询

#### 3.4.1 统计查询count

~~~shell
db.collection.count(query, options)
~~~



（1）统计所有记录数： 

统计comment集合的所有的记录数：

~~~shell
db.comment.count()
~~~



（2）按条件统计记录数：

 例如：统计userid为1003的记录条数

~~~~shell
db.comment.count({userid:"1003"})
~~~~



#### 3.4.2 分页列表查询

~~~shell
db.COLLECTION_NAME.find().limit(NUMBER).skip(NUMBER)
~~~



如果你想返回指定条数的记录，可以在find方法后调用limit来返回结果(TopN)，默认值20，例如：

~~~shell
db.comment.find().limit(3)
~~~

skip方法同样接受一个数字参数作为跳过的记录条数。（前N个不要）,默认值是0

~~~shell
db.comment.find().skip(3)
~~~



分页查询

每次跳过前边页的数量，limit中写每页的数量即可

~~~shell
//第一页
db.comment.find().skip(0).limit(2)
//第二页
db.comment.find().skip(2).limit(2)
//第三页
db.comment.find().skip(4).limit(2)
~~~



#### 3.4.3 排序查询sort

sort() 方法对数据进行排序，sort() 方法可以通过参数指定排序的字段，并使用 1 和 -1 来指定排序的方式，其中 1 为升序排列，而 -1 是用 于降序排列。

~~~shell
db.COLLECTION_NAME.find().sort({KEY:1})
或
db.集合名称.find().sort(排序方式)
~~~



例如： 对userid降序排列，并对访问量进行升序排列

~~~shell
db.comment.find().sort({userid:-1,likenum:1})
#排序中的条件靠前的优先级高
~~~



#### 3.4.4 条件的执行顺序

提示： skip(), limilt(), sort()三个放在一起执行的时候，执行的顺序是先 sort(), 然后是 skip()，最后是显示的 limit()，和命令编写顺序无关。



### 3.5 文档的更多查询

#### 3.5.1 正则表达式条件查询

MongoDB的模糊查询是通过正则表达式的方式实现的。格式为：

~~~shell
db.collection.find({field:/正则表达式/})
或
db.集合.find({字段:/正则表达式/})
~~~



提示：正则表达式是js的语法，直接量的写法。

 例如，我要查询评论内容包含“开水”的所有文档，代码如下：

~~~shell
db.comment.find({content:/开水/})
~~~



如果要查询评论的内容中以“专家”开头的，代码如下：

~~~shell
db.comment.find({content:/^专家/})
~~~



#### 3.5.2 比较查询

<, <=, >, >= 这个操作符也是很常用的，格式如下:

~~~shell
db.集合名称.find({ "field" : { $gt: value }}) // 大于: field > value
db.集合名称.find({ "field" : { $lt: value }}) // 小于: field < value
db.集合名称.find({ "field" : { $gte: value }}) // 大于等于: field >= value
db.集合名称.find({ "field" : { $lte: value }}) // 小于等于: field <= value
db.集合名称.find({ "field" : { $ne: value }}) // 不等于: field != value
~~~



示例：查询评论点赞数量大于700的记录

~~~shell
db.comment.find({likenum:{$gt:NumberInt(700)}})
~~~





#### 3.5.3 包含查询

包含使用$in操作符。 

示例：查询评论的集合中userid字段包含1003或1004的文档

只有userid属于集合中的其中一个才会被查询到

~~~shell
db.comment.find({userid:{$in:["1003","1004"]}})
~~~



不包含使用$nin操作符。 

示例：查询评论集合中userid字段不包含1003和1004的文档

~~~shell
db.comment.find({userid:{$nin:["1003","1004"]}})
~~~





#### 3.5.4 条件连接查询and or

我们如果需要查询同时满足两个以上条件，需要使用$and操作符将条件进行关联。（相 当于SQL的and） 格式为：

~~~shell
$and:[ { },{ },{ } ]
~~~



示例：查询评论集合中likenum大于等于700 并且小于2000的文档：

~~~shell
db.comment.find({$and:[{likenum:{$gte:NumberInt(700)}},{likenum:{$lt:NumberInt(2000)}}]})
~~~





如果两个以上条件之间是或者的关系，我们使用 操作符进行关联，与前面 and的使用方式相同 格式为：

~~~shell
$or:[ { },{ },{ } ]
~~~



示例：查询评论集合中userid为1003，或者点赞数小于1000的文档记录

~~~shell
db.comment.find({$or:[ {userid:"1003"} ,{likenum:{$lt:1000} }]})
~~~





### 3.6 常用命令总结

~~~shell
选择切换数据库：use articledb
插入数据：db.comment.insert({bson数据})
查询所有数据：db.comment.find();
条件查询数据：db.comment.find({条件})
查询符合条件的第一条记录：db.comment.findOne({条件})
查询符合条件的前几条记录：db.comment.find({条件}).limit(条数)
查询符合条件的跳过的记录：db.comment.find({条件}).skip(条数)
修改数据：db.comment.update({条件},{修改后的数据}) 或db.comment.update({条件},{$set:{要修改部分的字段:数据})
修改数据并自增某字段值：db.comment.update({条件},{$inc:{自增的字段:步进值}})
删除数据：db.comment.remove({条件})
统计查询：db.comment.count({条件})
模糊查询：db.comment.find({字段名:/正则表达式/})
条件比较运算：db.comment.find({字段名:{$gt:值}})
包含查询：db.comment.find({字段名:{$in:[值1，值2]}})或db.comment.find({字段名:{$nin:[值1，值2]}})
条件连接查询：db.comment.find({$and:[{条件1},{条件2}]})或db.comment.find({$or:[{条件1},{条件2}]})
~~~







## 4 索引-index

### 4.1 概述

索引支持在MongoDB中高效地执行查询。如果没有索引，MongoDB必须执行全集合扫描，即扫描集合中的每个文档，以选择与查询语句匹配的文档。这种扫描全集合的查询效率是非常低的，特别在处理大量的数据时，查询可以要花费几十秒甚至几分钟，这对网站的性能是非常致命的。

如果查询存在**适当的索引**，MongoDB可以使用该索引**限制必须检查的文档数**。

MongoDB索引使用B树数据结构（确切的说是B-Tree，MySQL是B+Tree）



### 4.2 索引的类型

#### 4.2.1 单字段索引

MongoDB支持在文档的单个字段上创建用户定义的升序/降序索引，称为单字段索引（Single Field Index）。

对于**单个字段索引和排序操作**，索引键的排序顺序（即升序或降序）并不重要，因为MongoDB可以在任何方向上遍历索引。

![image-20221029220013853](images/image-20221029220013853.png)





#### 4.2.2 复合索引

MongoDB还支持多个字段的用户定义索引，即复合索引（Compound Index）。

**复合索引中列出的字段顺序具有重要意义。**

例如，如果复合索引由 { userid: 1, score: -1 } 组成，则索引首先按userid正序排序，然后在每个userid的值内，再在按score倒序排序。

![image-20221029220144030](images/image-20221029220144030.png)



#### 4.2.3 其他索引

地理空间索引（Geospatial Index）、文本索引（Text Indexes）、哈希索引（Hashed Indexes）。

**地理空间索引（Geospatial Index）**

为了支持对地理空间坐标数据的有效查询，MongoDB提供了两种特殊的索引：返回结果时使用平面几何的二维索引和返回结果时使用球面几何的二维球面索引。

**文本索引（Text Indexes）**

MongoDB提供了一种文本索引类型，支持在集合中搜索字符串内容。这些文本索引不存储特定于语言的停止词（例如“the”、“a”、“or”），而将集合中的词作为词干，只存储根词。

**哈希索引（Hashed Indexes）**

为了支持基于散列的分片，MongoDB提供了散列索引类型，它对字段值的散列进行索引。这些索引在其范围内的值分布更加随机，但只支持相等匹配，不支持基于范围的查询。





### 4.3 索引的管理



#### 4.3.1 索引的查看

返回一个集合中的所有索引的数组。

~~~shell
db.collection.getIndexes()
~~~





结果

~~~shell
> db.comment.getIndexes()
[
	{
		"v" : 2,
		"key" : {
				"_id" : 1
		},
		"name" : "_id_",
		"ns" : "articledb.comment"
	}
]
~~~

结果中显示的是默认 _id 索引。

默认_id索引：


MongoDB在创建集合的过程中，在 \_id 字段上创建一个唯一的索引，默认名字为` _id_` ，该索引可防止客户端插入两个具有相同值的文档，您不能在_id字段上删除此索引。

注意：该索引是唯一索引，因此值不能重复，即 _id 值不能重复的。在分片集群中，通常使用 _id 作为片键。



#### 4.3.2 索引的创建

~~~shell
db.collection.createIndex(keys, options)
~~~



参数

![image-20221029220908554](images/image-20221029220908554.png)



options选项：

![image-20221029221004743](images/image-20221029221004743.png)







（1）单字段索引示例：对 userid 字段建立索引：

~~~shell
db.comment.createIndex({userid:1})


#运行结果如下
{
	"createdCollectionAutomatically" : false,
	"numIndexesBefore" : 1,
	"numIndexesAfter" : 2,
	"ok" : 1
}
~~~



（2）复合索引：对 userid 和 nickname 同时建立复合（Compound）索引：

~~~shell
db.comment.createIndex({userid:1,nickname:-1})



#运行结果如下
{
	"createdCollectionAutomatically" : false,
	"numIndexesBefore" : 2,
	"numIndexesAfter" : 3,
	"ok" : 1
}
~~~



#### 4.3.3 索引的移除

删除一个

~~~shell
db.collection.dropIndex(index)
#index可填{userid:1},表示删除userid的升序索引
#也可以填索引名字(可查询时看name字段) "name"
~~~

![image-20221029221757261](images/image-20221029221757261.png)



删除所有

~~~shell
db.collection.dropIndexes()
~~~

提示： _id 的字段的索引是无法删除的，只能删除非 _id 字段的索引。





### 4.4 索引的使用

#### 4.4.1 执行计划

分析查询性能（Analyze Query Performance）通常使用执行计划（解释计划、Explain Plan）来查看查询的情况，如查询耗费的时间、是否基于索引查询等。

使用一下语句可以查看执行计划

~~~shell
db.collection.find(query,options).explain(options)
~~~



查看结果（此时没有加索引）：

~~~shell
{
	"queryPlanner" : {
		"plannerVersion" : 1,
		"namespace" : "articledb.comment",
		"indexFilterSet" : false,
		"parsedQuery" : {
			"userid" : {
			"$eq" : "1003"
			}
		},
		"winningPlan" : {
			"stage" : "COLLSCAN",
			"filter" : {
				"userid" : {
					"$eq" : "1003"
				}
			},
			"direction" : "forward"
		},
		"rejectedPlans" : [ ]
	},
	"serverInfo" : {
		"host" : "9ef3740277ad",
		"port" : 27017,
		"version" : "4.0.10",
		"gitVersion" : "c389e7f69f637f7a1ac3cc9fae843b635f20b766"
	},
	"ok" : 1
}
~~~

关键点看： `"stage" : "COLLSCAN"`, 表示全集合扫描

加上索引后会变成：` "stage" : "IXSCAN"`，表示基于索引的扫描





#### 4.4.2 涵盖的查询

Covered Queries

当查询条件和查询的投影仅包含索引字段时，MongoDB直接从索引返回结果，而不扫描任何文档或将文档带入内存。 这些覆盖的查询可以非常有效。







## 5 SpringBoot整合MongoDB



### 5.1 依赖和配置

加入依赖

~~~xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
~~~



配置文件配置MongoDB设置

~~~yml
spring:
	#数据源配置
	data:
		mongodb:
		# 主机地址
		host: 192.168.40.141
		# 数据库
		database: articledb
		# 默认端口是27017
		port: 27017
		#也可以使用uri连接
		#uri: mongodb://192.168.40.134:27017/arti
~~~



### 5.2 代码编码编写

和MySQL差不多，需要实体类，dao类，service类，impl类（懒省事可以不要）



#### 5.2.1 实体类

一般放在po包下

**注意以下几点：**

该类需要可序列化，即加上implements Serializable

类的默认名称为对应文档名首字母大写

_id字段的默认名称为id



**注解：**

**类前：**



`@Document(collection="mongodb 对应 collection 名")`

若类名按照默认则不需要添加，指定对应的文档名



`@CompoundIndex( def = "{'userid': 1, 'nickname': -1}")`

给该文档添加索引





**变量前：**

`@Id`

若`_id`字段按照默认命名则不需要添加，指定`_id`字段对应的变量



`@Field("字段名")`

命名不按规则是需要手动指定对应的字段



`@Indexed`

添加单字段的索引



#### 5.2.2 dao类

直接继承即可使用

~~~java
public interface CommentRepository extends MongoRepository<Comment,String> {
}
~~~





#### 5.2.3 Service类

无特别，使用dao对象来调用接口即可





### 5.3 根据上级ID查询

即类似评论中的上下级关系

![image-20221030221112037](images/image-20221030221112037.png)



需要在dao类中自己增加方法

（1）CommentRepository新增方法定义

~~~java
//根据父id，查询子评论的分页列表
Page<Comment> findByParentid(String parentid, Pageable pageable);
~~~

（2）CommentService新增方法

page是引入的依赖中的

~~~java
/**
* 根据父id查询分页列表
* @param parentid
* @param page
* @param size
* @return
*/
public Page<Comment> findCommentListPageByParentid(String parentid,int page ,int size){
	return commentRepository.findByParentid(parentid, PageRequest.of(page-1,size));
}

~~~

（3）junit测试用例：

~~~java
/**
* 测试根据父id查询子评论的分页列表
*/
@Test
public void testFindCommentListPageByParentid(){
	Page<Comment> pageResponse = commentService.findCommentListPageByParentid("3", 1, 2);
	System.out.println("----总记录数："+pageResponse.getTotalElements());
	System.out.println("----当前页数据："+pageResponse.getContent());
}
~~~



### 5.4 MongoTemplate类

若要给某个字段增加1，则正常需要以下代码

效率比较低

~~~java
/**
* 点赞-效率低
* @param id
*/
public void updateCommentThumbupToIncrementingOld(String id){
	Comment comment = CommentRepository.findById(id).get();
	comment.setLikenum(comment.getLikenum()+1);
	CommentRepository.save(comment);
}
~~~





可以使用MongoTemplate类（外来依赖中的）来快速实现对某一个字段的操作

不同的方法需要不同的参数

在下例中需要Query，Update和文档名三个参数

Query指定修改的数据，即_id等于指定id的

Update存储相应的修改操作

最后还要指定文档名

~~~java
//注入MongoTemplate
@Autowired
private MongoTemplate mongoTemplate;
/**
* 点赞数+1
* @param id
*/
public void updateCommentLikenum(String id){
	//查询对象
	Query query=Query.query(Criteria.where("_id").is(id));
    
	//更新对象
	Update update=new Update();
	//局部更新，相当于$set
	// update.set(key,value)
	//递增$inc
	// update.inc("likenum",1);
	update.inc("likenum");
    
	//参数1：查询对象
	//参数2：更新对象
	//参数3：集合的名字或实体类的类型Comment.class
	mongoTemplate.updateFirst(query,update,"comment");
}
~~~





# MongoDB集群和安全

## 6 副本集

### 6.1 副本集概念

即使用多台服务器构成集群，防止一台服务区宕机就寄

类似redis的**主从复制**



**主从复制和副本集区别**
主从集群和副本集最大的区别就是**副本集没有固定的“主节点”**；

整个集群会选出一个“主节点”，当其挂掉后，又在剩下的从节点中选中其他节点为“主节点”，

副本集总有一个活跃点(主、primary)和一个或多个备份节点(从、secondary)。





### 6.2 副本集的三个角色

副本集有两种类型三种角色两种类型：

**两种类型：**

主节点（Primary）类型：数据操作的主要连接点，可读写。

次要（辅助、从）节点（Secondaries）类型：数据冗余备份节点，可以读或选举。

**三种角色：**

**主要成员（Primary）**：主要接收所有写操作。就是主节点。

**副本成员（Replicate）**：从主节点通过复制操作以维护相同的数据集，即备份数据，不可写操作，但可以读操作（但需要配置）。是默认的一种从节点类型。

**仲裁者（Arbiter）**：不保留任何数据的副本，只具有投票选举作用。当然也可以将仲裁服务器维护为副本集的一部分，即副本成员同时也可以是仲裁者。也是一种从节点类型。





### 6.3 副本集架构

副本集名称：myrs

不同的角色使用不同的端口号来实现副本集

![image-20221030223339895](images/image-20221030223339895.png)





### 6.4 副本集的创建

#### 6.4.1 创建主节点

建立存放数据和日志的目录

~~~bash
#-----------myrs
#主节点
mkdir -p /mongodb/replica_sets/myrs_27017/log \ &
mkdir -p /mongodb/replica_sets/myrs_27017/data/db
~~~

新建或修改配置文件：

~~~bash
vim /mongodb/replica_sets/myrs_27017/mongod.conf
~~~

~~~yml
systemLog:
	#MongoDB发送所有日志输出的目标指定为文件
	destination: file
	#mongod或mongos应向其发送所有诊断日志记录信息的日志文件的路径
	path: "/mongodb/replica_sets/myrs_27017/log/mongod.log"
	#当mongos或mongod实例重新启动时，mongos或mongod会将新条目附加到现有日志文件的末尾。
	logAppend: true
storage:
	#mongod实例存储其数据的目录。storage.dbPath设置仅适用于mongod。
	dbPath: "/mongodb/replica_sets/myrs_27017/data/db"
	journal:
	#启用或禁用持久性日志以确保数据文件保持有效和可恢复。
	enabled: true
processManagement:
	#启用在后台运行mongos或mongod进程的守护进程模式。
	fork: true
	#指定用于保存mongos或mongod进程的进程ID的文件位置，其中mongos或mongod将写入其PID
	pidFilePath: "/mongodb/replica_sets/myrs_27017/log/mongod.pid"
	net:
	#服务实例绑定所有IP，有副作用，副本集初始化的时候，节点名字会自动设置为本地域名，而不是ip
	#bindIpAll: true
	#服务实例绑定的IP
	bindIp: localhost,192.168.0.2
	#bindIp
	#绑定的端口
	port: 27017
replication:
	#副本集的名称
	replSetName: myrs
~~~

启动节点服务

~~~bash
[root@bobohost replica_sets]# /usr/local/mongodb/bin/mongod -f /mongodb/replica_sets/myrs_27017/mongod.conf
about to fork child process, waiting until server is ready for connections.
forked process: 54257
child process started successfully, parent exiting
~~~



#### 6.4.2 创建副本节点

将上文中的所有27017改为27018即可



#### 6.4.3 创建仲裁节点

将上文中的所有27017改为27019即可



### 6.5 副本集的连接

#### 6.5.1 连接主节点

使用客户端命令连接任意一个节点，但这里尽量要连接主节点(27017节点)：

~~~bash
/usr/local/mongodb/bin/mongo --host=180.76.159.126 --port=27017
~~~



结果，连接上之后，很多命令无法使用，，比如 show dbs 等，必须初始化副本集才行

~~~bash
rs.initiate(configuration)
~~~

configuration不填使用默认配置即可



提示：
1）“ok”的值为1，说明创建成功。

2）命令行提示符发生变化，变成了一个从节点角色，此时默认不能读写。稍等片刻，回车，变成主节点





#### 6.5.2 查看副本集配置

返回包含当前副本集配置的文档。

~~~bash
rs.conf(configuration)
~~~

configuration不填使用默认配置即可



提示：副本集配置的查看命令，本质是查询的是 system.replset 的表中的数据





#### 6.5.3 查看副本集状态

返回包含状态信息的文档。此输出使用从副本集的其他成员发送的心跳包中获得的数据反映副本集的当前状态。

~~~bash
rs.status()
~~~



#### 6.5.4 连接副本从节点

在主节点添加从节点，将其他成员加入到副本集

~~~bash
rs.add(host)

#rs.add("180.76.159.126:27018")
~~~

将指定的进程添加为副本从节点



#### 6.5.5 连接仲裁节点

~~~bash
rs.addArb(host)
~~~





 ### 6.6 从节点读操作

从节点只可以读，不可以写，但是默认的是与不能读，需要设置一下

**客户端连接从节点**，然后执行

~~~bash
rs.slaveOk()
#或，参数默认为true，设为false后表示不能读
rs.slaveOk(true)
~~~

此时从节点也能读了，数据会自动同步





### 6.7 仲裁节点读操作

仲裁者节点，不存放任何业务数据的，可以登录查看，即不能读也不能写

只存放副本集配置等数据。



### 6.8 主节点选举原则

MongoDB在副本集中，会自动进行主节点的选举，主节点选举的触发条件：

1） 主节点故障

2） 主节点网络不可达（默认心跳信息为10秒）

3） 人工干预（rs.stepDown(600)）



一旦触发选举，就要根据一定规则来选主节点。



选举规则是根据票数来决定谁获胜：

- **票数最高，且获得了“大多数”成员的投票支持的节点获胜**。“大多数”的定义为：假设复制集内投票成员数量为N，则大多数为 N/2 + 1。例如：3个投票成员，则大多数的值是2。当复制集内存活成员数量不足大多数时，整个复制集将无法选举出Primary，复制集将无法提供写服务，处于只读状态。

- 若票数相同，且都获得了“大多数”成员的投票支持的，**数据新的节点获胜**。数据的新旧是通过操作日志oplog来对比的。





在获得票数的时候，优先级（priority）参数影响重大。

可以通过设置优先级（priority）来设置额外票数。优先级即权重，取值为0-1000，相当于可额外增加0-1000的票数，优先级的值越大，就越可能获得多数成员的投票（votes）数。指定较高的值可使成员更有资格成为主要成员，更低的值可使成员更不符合条件。



默认优先级都是1

但选举节点（仲裁节点），优先级是0，（要注意是，官方说了，选举节点的优先级必须是0，不能是别的值。即不具备选举权，但具有投票权）





### 6.9 故障测试

#### 6.9.1 副本节点故障

主节点和仲裁节点都没啥变化



#### 6.9.2 主节点故障

关闭27017

经过重新选举，从节点27018变为主节点

再次开启27017，依旧是27018主节点，27017变为从节点



#### 6.9.3 仲裁节点和主节点故障

先关掉仲裁节点27019，关掉现在的主节点27018

登录27017后，发现，27017仍然是从节点，副本集中没有主节点了，导致此时，副本集是只读状态，无法写入。

为啥不选举了？因为27017的票数，没有获得大多数，即没有大于等于2，它只有默认的一票（优先级是1）

如果要触发选举，随便加入一个成员即可。

- 如果只加入27019仲裁节点成员，则主节点一定是27017，因为没得选了，仲裁节点不参与选举，但参与投票。（不演示）
- 如果只加入27018节点，会发起选举。因为27017和27018都是两票，则按照谁数据新，谁当主节
  点。





#### 6.9.4 仲裁节点和从节点故障

先关掉仲裁节点27019，

关掉现在的副本节点27018

10秒后，27017主节点自动降级为副本节点。（服务降级）

副本集不可写数据了，已经故障了。







### 6.10 compass连接副本集

填写从节点端口号下边就选secondary

填写主节点端口号下边就选primary

![image-20221031154020786](images/image-20221031154020786.png)



### 6.11 SpringData连接副本集

配置文件中使用uri的写法

~~~yml
spring:
#数据源配置
data:
mongodb:
	# 主机地址
	# host: 180.76.159.126
	# 数据库
	# database: articledb
	# 默认端口是27017
	# port: 27017
	#也可以使用uri连接
	#uri: mongodb://192.168.40.134:27017/articledb

	# 副本集的连接字符串
	uri: mongodb://180.76.159.126:27017,180.76.159.126:27018,180.76.159.126:27019/articledb?connect=replicaSet&slaveOk=true&replicaSet=myrs
~~~



uri格式

~~~yml
mongodb://host1,host2,host3/数据库名称?
connect=replicaSet&slaveOk=true&replicaSet=副本集名字
~~~







## 7 分片集群-Sharded Cluster



### 7.1 分片概念

分片(sharding)是指将数据拆分，将其分散存在不同的机器上的过程。有时也用分区(partitioning)来表示这个概念。将数据分散到不同的机器上，不需要功能强大的大型计算机就可以储存更多的数据，处理更多的负载。



### 7.2 分片集群的组件

MongoDB分片群集包含以下组件：

- 分片（存储）：每个分片包含分片数据的子集。 每个分片都可以部署为副本集。
- mongos（路由）：mongos充当查询路由器，在客户端应用程序和分片集群之间提供接口。
- config servers（“调度”的配置）：配置服务器存储群集的元数据和配置设置。 从MongoDB 3.4开始，必须将配置服务器部署为副本集（CSRS）。

![image-20221031154833720](images/image-20221031154833720.png)



### 7.3 分片集群架构目标

两个分片节点副本集（3+3）+一个配置节点副本集（3）+两个路由节点（2），共11个服务节点。

![image-20221031154943970](images/image-20221031154943970.png)



### 7.4 分片（存储）节点副本集的创建

#### 7.4.1 创建第一套副本集

和前边创建副本集一样

==将副本集名称命名为myshardrs01==

==配置文件最后两行有所修改==



配置文件

~~~yml
systemLog:
	#MongoDB发送所有日志输出的目标指定为文件
	destination: file
	#mongod或mongos应向其发送所有诊断日志记录信息的日志文件的路径
	path: "/mongodb/sharded_cluster/myshardrs01_27018/log/mongod.log"
	#当mongos或mongod实例重新启动时，mongos或mongod会将新条目附加到现有日志文件的末尾。
	logAppend: true
storage:
	#mongod实例存储其数据的目录。storage.dbPath设置仅适用于mongod。
	dbPath: "/mongodb/sharded_cluster/myshardrs01_27018/data/db"
	journal:
	#启用或禁用持久性日志以确保数据文件保持有效和可恢复。
	enabled: true
processManagement:
	#启用在后台运行mongos或mongod进程的守护进程模式。
	fork: true
	#指定用于保存mongos或mongod进程的进程ID的文件位置，其中mongos或mongod将写入其PID
	pidFilePath: "/mongodb/sharded_cluster/myshardrs01_27018/log/mongod.pid"
net:
	#服务实例绑定所有IP，有副作用，副本集初始化的时候，节点名字会自动设置为本地域名，而不是ip
	#bindIpAll: true
	#服务实例绑定的IP
	bindIp: localhost,192.168.0.2
	#bindIp
	#绑定的端口
	port: 27018
replication:
	#副本集的名称
	replSetName: myshardrs01
sharding:
	#分片角色，configsvr表示该副本集为配置副本集，shardsvr表示该副本集为分片副本集
	clusterRole: shardsvr
~~~





#### 7.4.2 创建第二套副本集

同上，命名改为myshardrs02即可

（练习时在同一台机器上）记得端口号要用不一样的



### 7.5 配置节点副本集的创建

副本集名称改为myconfigrs

副本集角色改为configsvr

配置节点副本集一般是由一个主节点和两个从节点构成（不要仲裁节点）

（练习时在同一台机器上）记得端口号要用不一样的





w

### 7.6 路由节点的创建

#### 7.6.1 路由节点创建并连接配置节点

不在使用mongod的服务，开始使用mongos的服务



第一步：准备存放数据和日志的目录：

~~~bash
#不在创建data用来存储数据
mkdir -p /mongodb/sharded_cluster/mymongos_27017/log
~~~



mymongos_27017节点：

最后一行需要指定配置副本集的地址

新建或修改配置文件：

~~~bash
vi /mongodb/sharded_cluster/mymongos_27017/mongos.conf
~~~

~~~yml
systemLog:
	#MongoDB发送所有日志输出的目标指定为文件
	destination: file
	#mongod或mongos应向其发送所有诊断日志记录信息的日志文件的路径
	path: "/mongodb/sharded_cluster/mymongos_27017/log/mongod.log"
	#当mongos或mongod实例重新启动时，mongos或mongod会将新条目附加到现有日志文件的末尾。
	logAppend: true
processManagement:
	#启用在后台运行mongos或mongod进程的守护进程模式。
	fork: true
	#指定用于保存mongos或mongod进程的进程ID的文件位置，其中mongos或mongod将	写入其PID
	pidFilePath: /mongodb/sharded_cluster/mymongos_27017/log/mongod.pid"
net:
	#服务实例绑定所有IP，有副作用，副本集初始化的时候，节点名字会自动设置为本地域名，而不是ip
	#bindIpAll: true
	#服务实例绑定的IP
	bindIp: localhost,192.168.0.2
	#bindIp
	#绑定的端口
	port: 27017
sharding:
	#指定配置节点副本集
	configDB: myconfigrs/180.76.159.126:27019,180.76.159.126:27119,180.76.159.126:27219
~~~





启动mongos：

~~~bash
/usr/local/mongodb/bin/mongos -f /mongodb/sharded_cluster/mymongos_27017/mongos.conf
~~~





此时只连接了配置副本集，并未连接分片副本集





#### 7.6.3 连接分片节点

添加分片副本集

~~~bash
sh.addShard("IP:Port")
~~~



添加第一套分片副本集

~~~bash
sh.addShard("myshardrs01/192.168.0.2:27018,180.76.159.126:27118,180.76.159.126:27218")
~~~



查看分片状态

~~~~八十、
sh.status()
~~~~





#### 7.6.4 开启分片功能

首先让库开启分片功能

~~~bash
sh.enableSharding("库名")
~~~



让某个集合开启分片

~~~bash
sh.shardCollection(namespace, key, unique)
~~~

![image-20221031163100196](images/image-20221031163100196.png)



**shard key** 是每条记录**都必须包含**的,且**建立了索引**的**单个字段或复合字段**,MongoDB按照片键将数据划分到不同的 数据块 中,并将 数据块 均衡地分布到所有分片中.为了按照片键划分数据块,MongoDB使用 基于哈希的分片方式（随机平均分配）或者基于范围的分片方式（数值大小分配） 。



用什么字段当片键都可以，如：nickname作为片键，但一定是必填字段。



> 分片规则一：哈希策略

对于 基于哈希的分片 ,MongoDB计算一个字段的哈希值,并用这个哈希值来创建数据块.

在使用基于哈希分片的系统中,拥有**”相近”片键**的文档 **很可能不会** 存储在**同一个数据块**中,因此数据的分离性更好一些.



使用nickname作为片键，根据其值的哈希值进行数据分片

~~~bash
sh.shardCollection("articledb.comment",{"nickname":"hashed"})
~~~



>分片规则二：范围策略

对于 基于范围的分片 ,MongoDB按照片键的范围把数据分成不同部分.假设有一个数字的片键:想象一个从负无穷到正无穷的直线,每一个片键的值都在直线上画了一个点.MongoDB把这条直线划分为更短的不重叠的片段,并称之为 数据块 ,**每个数据块包含了片键在一定范围内的数据.**

在使用片键做范围划分的系统中,拥有**”相近”片键**的文档**很可能**存储在**同一个数据块**中,因此也会存储在同一个分片中



如使用作者年龄字段作为片键，按照点赞数的值进行分片：

~~~bash
sh.shardCollection("articledb.author",{"age":1})
~~~

注意的是：
1）一个集合只能指定一个片键，否则报错。

2）一旦对一个集合分片，分片键和分片值就不可改变。 如：不能给集合选择不同的分片键、不能更新分片键的值。

3）根据age索引进行分配数据。





### 7.7 添加第二个路由节点

和之前一样，只改端口号和名字即可





### 7.8 compass连接分片集群

连接两个路由节点之一即可





### 7.9 SpringData连接分片集群

也是使用uri

写入路由节点的地址和数据库名称

~~~yml
spring:
#数据源配置
data:
mongodb:
	# 主机地址
	# host: 180.76.159.126
	# 数据库
	# database: articledb
	# 默认端口是27017
	# port: 27017
	#也可以使用uri连接
	#uri: mongodb://192.168.40.134:27017/articledb

	# 副本集的连接字符串
	uri: mongodb://180.76.159.126:27017,180.76.159.126:27117/articledb
~~~





## 8 安全认证

### 8.1 安全认证

默认情况下，MongoDB实例启动运行时是没有启用用户访问权限控制的，也就是说，在实例本机服务器上都可以随意连接到实例进行各种操作，MongoDB不会对连接客户端进行用户验证，这是非常危险的。



1）启用访问控制：

为了强制开启用户访问控制(用户验证)，则需要在MongoDB实例启动时使用选项 --auth 或在指定启动配置文件中添加选项 auth=true 



2）角色：

在MongoDB中通过角色对用户授予相应数据库资源的操作权限，每个角色当中的权限可以显式指定，也可以通过继承其他角色的权限，或者两都都存在的权限。



3）权限：

权限由指定的数据库资源(resource)以及允许在指定资源上进行的操作(action)组成。

- 资源(resource)包括：数据库、集合、部分集合和集群；
-  操作(action)包括：对资源进行的增、删、改、查(CRUD)操作。





> 角色说明

![image-20221031201255898](images/image-20221031201255898.png)





### 8.2 单实例环境

#### 8.2.1 添加用户

先在没有开启安全认证时操作



> 添加用户

创建两个管理员用户，一个是系统的超级管理员 myroot ，一个是admin库的管理用户myadmin ：

~~~bash
#切换到admin库
use admin

#创建系统超级用户 myroot,设置密码123456，设置角色root
db.createUser({user:"myroot",pwd:"123456",roles:["root"]})

#创建专门用来管理admin库的账号myadmin，只用来作为用户权限的管理
db.createUser({user:"myadmin",pwd:"123456",roles：[{role:"userAdminAnyDatabase",db:"admin"}]})


#查看已经创建了的用户的情况：
db.system.users.find()

#删除用户
db.dropUser("myadmin")

#修改密码
db.changeUserPassword("myroot", "123456")
~~~





提示：

1）本案例创建了两个用户，分别对应超管和专门用来管理用户的角色，事实上，你只需要一个用户即可。如果你对安全要求很高，防止超管泄漏，则不要创建超管用户。

2）和其它数据库（MySQL）一样，权限的管理都差不多一样，也是将用户和权限信息保存到数据库对应的表中。Mongodb存储所有的**用户信息在admin 数据库**的集合system.users中，保存用户名、密码和数据库信息。

3）如果不指定数据库，则创建的指定的权限的用户在所有的数据库上有效，如 {role: "userAdminAnyDatabase", db:""}







> 认证测试

~~~bash
#切换到admin
> use admin

#密码输错
> db.auth("myroot","12345")
Error: Authentication failed.
0

#密码正确
> db.auth("myroot","123456")
1
~~~





#### 8.2.2 开启认证功能

1）参数方式

在启动时指定参数 --auth ，如：

~~~bash
/usr/local/mongodb/bin/mongod -f /mongodb/single/mongod.conf --auth
~~~



2）配置文件方式

在mongod.conf配置文件中加入：

vim /mongodb/single/mongod.conf

~~~yml
security:
	#开启授权认证
	authorization: enabled
~~~







> 登录

~~~bash
#切换到admin
> use admin

#密码输错
> db.auth("myroot","12345")
Error: Authentication failed.
0

#密码正确
> db.auth("myroot","123456")
1
~~~





若某用户只对某一数据库有效，则需要先切换到该数据库才能登录该用户



#### 8.2.3 SpringData认证

使用username配置和password配置即可

或者使用uri配置，格式为`username:password@hostname/dbname`

~~~yml
spring:
	#数据源配置
	data:
		mongodb:
		# 主机地址
		# host: 180.76.159.126
		# 数据库
		# database: articledb
		# 默认端口是27017
		# port: 27017
		#帐号
		# username: bobo
		#密码
		# password: 123456
		#单机有认证的情况下，也使用字符串连接
		uri: mongodb://bobo:123456@180.76.159.126:27017/articledb
~~~







### 8.3 副本集

创建keyfile文件，作为不同的角色直接通信的认证



#### 8.3.1 创建副本集认证的key文件

第一步：生成一个key文件到当前文件夹中。

可以使用任何方法生成密钥文件。例如，以下操作使用openssl生成密码文件，然后使用chmod来更改文件权限，仅为文件所有者提供读取权限

~~~bash
[root@bobohost ~]# openssl rand -base64 90 -out ./mongo.keyfile
[root@bobohost ~]# chmod 400 ./mongo.keyfile #该命令可以不执行
[root@bobohost ~]# ll mongo.keyfile
-r--------. 1 root root 122 8月 14 14:23 mongo.keyfile
~~~



提示：
所有副本集节点都必须要用同一份keyfile，一般是在一台机器上生成，然后拷贝到其他机器上，且必须有读的权限，否则将来会报错

一定要保证密钥文件一致，文件位置随便。但是为了方便查找，建议每台机器都放到一个固定的位置，都放到和配置文件一起的目录中。

这里将该文件分别拷贝到多个目录中：

~~~bash
[root@bobohost ~]# cp mongo.keyfile /mongodb/replica_sets/myrs_27017
[root@bobohost ~]# cp mongo.keyfile /mongodb/replica_sets/myrs_27018
[root@bobohost ~]# cp mongo.keyfile /mongodb/replica_sets/myrs_27019
~~~



#### 8.3.2 修改配置文件指定keyfile

分别编辑几个服务的mongod.conf文件，添加相关内容：

/mongodb/replica_sets/myrs_27017/mongod.conf

~~~yml
security:
	#KeyFile鉴权文件
	keyFile: /mongodb/replica_sets/myrs_27017/mongo.keyfile
	#开启认证方式运行
	authorization: enable
~~~



另外两个也是如此（端口号需要改一下）







后边的操作和单实例环境一样





#### 8.3.3 SpringData副本集认证

和正常的连接副本集一样，只需要在uri中加上账号信息即可

~~~yml
spring:
	#数据源配置
	data:
	mongodb:
	#副本集有认证的情况下，字符串连接
	uri: mongodb://bobo:123456@180.76.159.126:27017,180.76.159.126:27018,180.76.159.126:27019/articledb?connect=replicaSet&slaveOk=true&replicaSet=myrs
~~~



### 8.4 分片副本集

每个副本集都放置keyfile文件即可