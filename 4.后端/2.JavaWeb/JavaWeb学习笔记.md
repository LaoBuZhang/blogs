---
title: JavaWeb学习笔记
date: 2022-04-03 22:11:53
tags: 
    - JavaWeb
    - 后端

---

# JavaWeb学习笔记



<!--more-->



## Junit单元测试

- 测试分类：
  1. 黑盒测试：不写代码，给输入值，看能否输出期望的值
  2. 白盒测试：需要写代码，关注程序的具体执行流程
- Junit使用：白盒测试
  - 步骤
    1. 定义一个测试类（测试用例）
       - 建议：
         - 测试类名：被测试的类名Test       CaculatorTest
         - 包名：xxx.xxx.xxx.text                  cn.incast.test
    2. 定义测试方法：可以独立运行
       - 建议：
         - 方法名：test测试的方法名            testAdd()
         - 返回值：void
         - 参数列表：空参
    3. 给方法加@Test
    4. 导入junit依赖环境
  - 判定结果：
    - 红色：失败
    - 绿色：成功
    - 一般我们会使用断言操作来处理结果
      - Assert.assertEquals(期望的结果,运算的结果);
  - 补充：
    - @Before
      - 修饰的方法会在测试方法之前被执行
    - @After
      - 修饰的方法会在测试方法之后被执行





## 反射：框架设计的灵魂

- 框架：半成品软件。可以在框架的基础上进行软件开发，简化编码

- 概念：将类的各个组成部分封装成其他对象，这就叫反射机制

  - 好处：
    1. 可以在程序的运行过程中，操作这些对象
    2. 可以解耦，提高程序的可扩展性

- 获取Class对象的方式(案例文件cn.itcast.reflect.ReflectDemo1,下边几个都是同包)：

  1. Class.forName("全类名")        将字节码文件加载进内存，返回Class对象
     - 多用于配置文件，将类名定义在配置文件中，读取文件，加载类
  2. 类名.class                                  通过类名的属性class获取
     - 多用于参数的传递
  3. 对象.getClass()                          getClass()方法在Object类中定义着
     - 多用于对象的获取字节码的方式

  - 结论：

    ​	同一个字节码文件（*.class）在一次程序运行过程中，只会被加载一次，不论哪一种方式获取的Class对象都是同一个

- Class对象功能：

  - 获取功能：
    1. 获取成员变量们(ReflectDemo2)
       - Field[] getFields()                                    获取所有public修饰的变量（全名）
       - Field[] getField(String name)                获取名字为name的变量
       - Field[] getDeclaredFields()                    获取所有成员变量，不考虑修饰符
       - Field[] getDeclaredField(String name)
    2. 获取构造方法们(ReflectDemo3)
       - Constructor<?>[] getConstructors()                                       获取所有public修饰的构造方法
       - Constructor<T> getConstructor(构造方法的参数列表)        获取所有public修饰的有指定参数列表的构造方法（全名）
       - Constructor<?>[] getDeclaredConstructors()
       - Constructor<T> getDeclaredConstructor(构造方法的参数列表)
    3. 获取成员方法们(ReflectDemo4)
       - Method[] getMethods()                                                 获取所有public修饰的方法
       - Method getMethod(方法名,方法的参数列表)              获取指定的public修饰的方法
       - Method[] getDeclaredMethods()
       - Method getDeclaredMethod(方法名,方法的参数列表)
    4. 获取类名(ReflectDemo5)
       - String getName();
  - Field:成员变量
    - 操作：
      1. 设置值
         - void set(Object obj,Object value)
      2. 获取值
         - get(Object obj)
      3. 忽略访问权限修饰符的安全检查
         - setAccessible(true)     暴力反射，使得可以访问private的变量
  - Constructor:构造方法
    - 创建对象：
      - T newInstance(构造方法的参数列表)
      - 如果使用空参构造方法创建对象，操作可以简化：Class对象的newInstance方法
    - 暴力反射
      - 用法同上，连代码都一样
  - Method:方法对象
    - 执行方法:
      - Object invoke(方法的参数列表)
    - 获取方法的名称（非全名）
      - String gatName

**案例：**

- 需求：写一个框架，不能改变类的任何代码，实现创建任意类的对象，并执行任意方法
  - 实现：
    1. 配置文件（输入也行）
    2. 反射
  - 步骤：
    1. 将需要创建的对象的全类名和需要执行的方法定义在配置文件中
    2. 在程序中加载读取配置文件
    3. 使用反射技术来加载类文件进内存
    4. 创建对象
    5. 执行方法





## 注解

- 概念：说明程序的，给计算机看的

- 注释：用文字描述程序，给程序员看的

- 概念描述：

  1. JDK1.5后的新特性
  2. 用来说明程序

- 作用分类：

  1. 编写文档：通过代码里标识的注解生成文档【生成文档doc文档】
  2. 代码分析：通过代码里标识的注解对代码进行分析【使用反射】
  3. 编译检查：通过代码里标识的注解让编译器能够实现基本的编译检查【Override】

- JDK中预定的一些注解（AnnoDemo1&2）

  - @Override    ：检测被该注解标注的方法是否是继承自父类（接口）的
  - @Deprecated    ：该注解标注的内容，表示已经过时,在eclipse中该内容会被横线杠掉
  - @SuppresWarnings    ：压制警告，可以让标记下所有的警告（黄色感叹号）消失
    - 一般传递参数all            @SuppressWarnings("all")

- 自定义注解

  - 格式

    ​	元注解

    ​	public @interface 注解名称{

    ​		属性列表;

    ​	}

  - 创建

    ​	new的时候选择annotation即可

  - 本质：注解本质上就是一个接口，该接口默认继承Annotation接口

    - public interface MyAnno extends java.lang.annotation.Annotation{}

  - 属性：接口中的抽象方法

    - 要求
      1. 属性的返回值类型只有下列取值（注意没有void，class等）
         - 基本数据类型
         - String
         - 枚举（）
         - 注解
         - 以上类型的数组
      2. 定义了属性，在使用时需要给属性赋值
         - 不同属性间用,隔开
           - @MyAnno(age=12,name="zhang3")		
         - 若不想赋值，可以定义为default类型
           - 在@interface中   String name() default "zhang3";
         - 如果**只有一个**属性需要赋值，并且属性的**名称是value**，则可以省略value，直接定义值即可
           - @Myanno(12);
         - 数组赋值时，值使用{}包裹，如果数组只有一个值，则{}可以省略

  - 元注解：用于描述注解的注解（MyAnno2）

    - @Target：描述注解能够作用的位置（以一个名为value的枚举类型数组的形式）

      - @Target(value= {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})

      - ELementType取值：
        - TYPE：可以作用在类上
        - METHOD：可以作用于方法上
        - FIELD：可以作用于成员变量上

    - @Retention：描述注解被保留的阶段

      - @Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会被保留到class字节码文件中，并被JVM读取到

    - @Documented：描述注解是否被抽取到api文档中

    - @Inherited：描述注解是否被子类继承（若父类有此注解，则子类不用写也有此注解）

- 在程序使用（解析）注解：获取注解中定义的属性值（ReflectTest）

  1. 获取注解定义的位置的对象        （Class，Method，Field）
  2. 获取指定的注解
     - getAnnotation(Class）//在内存中生成了一个该注解接口的子类实现的对象
  3. 调用注解中的抽象方法获取配置的属性值

- 小结：

  1. 以后大多数时候，我们会使用注解，而不是自定义注解
  2. 注解给谁看：
     - 编译器
     - 解析程序
  3. 注解不是程序的一部分，可以理解成注解就是一个标签



## JaveWeb介绍

1. 什么是JavaWeb？
   - 使用Java语言开发互联网项目（开发网站）
2. 总览
   1. 数据库
   2. 网页前端
   3. web核心技术
   4. 旅游管理系统



## 数据库

1. 数据库基本概念
2. MySQL数据库软件
3. SQL



### 数据库的基本概念

1. DataBase简称DB
2. 什么是数据库：
   - 用于存储和管理数据的仓库
3. 数据库的特点：
   1. 持久化存储数据。其实数据库就是一个文件系统
   2. 方便存储和管理数据
   3. 使用同意的方式操作数据库--SQL
4. 常见的数据库软件



### MySQL数据库软件

**下载和安装：**

[链接在这里](https://blog.csdn.net/weixin_42869365/article/details/83472466?ops_request_misc=%7B%22request%5Fid%22%3A%22165093655516781483737698%22%2C%22scm%22%3A%2220140713.130102334..%22%7D&request_id=165093655516781483737698&biz_id=0&spm=1018.2226.3001.4187)

跟着课程下载的版本是5.5.40



**配置：**

- MySQL服务启动
  1. 手动
  2. cmd-->services.msc  打开服务窗口，找到MySQL，打开关闭
  3. 管理员运行cmd-->services.msc-->net stop mysql(停止)-->net start mysql(启动)
- mysql登录
  1. mysql -uroot -proot
  2. mysql -hIP -uroot -p连接目标的密码                       登录别的IP的mysql
  3. mysql --host=ip --user=root --password=root
- mysql退出
  1. exit
  2. quit
- mysql目录结构
  1. 安装目录
     - 配置文件   my.ini
  2. 数据目录
     - 几个概念
       - 数据库：文件夹
       - 表：文件
       - 数据





## SQL

### **什么是SQL**

Structured Query Language：结构化查询语言

其实就是定义了操作所有关系型数据库的规则。每一种数据库操作的方式存在不一样的地方，称为”方言”

只有在cmd登录MySQL之后，在mysql目录下写的语句才是sql

### **通用语法**

1. SQL语句刻意单行或多行书写，以分号结尾
2. 可以使用空格和缩进来增强语句的可读性
3. mysql数据库的sql语句不区分大小写，关键字建议使用大写
4. 三种注释
   - 单行注释：-- 注释内容 （必须加空格）或 # 注释内容（mysql独有，可以不加空格）
   - 多行注释：/* 注释 */



### **sql分类**

1. DDL（Data Definition Language）数据定义语言

   用来定义数据库对象：数据库，表，列等。关键字：create，drop，alter等

2. DML（Data Manipulation Language）数据操作语言

   用来对数据库种表的数据进行增删改。关键字：insert，delete，update等

3. DQL（Data Query Language）数据查询语言

   用来查询数据库中表的记录（数据）。关键字：select，where等

4. DCL（Data Control Language）数据控制语言

   用来定义数据库的访问权限和安全级别，及创建用户。关键字：GRANT，REVOKE等



### DDL：操作数据库、表

1. 操作数据库：CRUD

   1. C(Create):创建
      - 创建数据库：
        - create database 数据库名称;
      - 创建数据库，判断不存在，在创建：
        - create database if not exists 数据库名称;
      - 创建数据库，并指定字符集：
        - create database 数据库名称 character set 字符集名;
      - 综合操作：
        - create database if not exists 数据库名称 character set 字符集名称(如gbk，utf8（在这里边没有-）);
   2. R(Retrieve):查询
      - 查询所有数据库的名称：
        - show databases;
      - 查询某个数据库的字符集：查询某个数据库的创建语句
        - show create database 数据库名称;
   3. U(Update):修改
      - 修改数据库的字符集
        - alter database 数据库名称 character set 字符集名称;
   4. D(Delete):删除
      - 删除数据库
        - drop database 数据库名称;
      - 判断数据库存在，在删除
        - drop database if exists 数据库名称;
   5. 使用数据库
      - 查询当前正在使用的数据库名称
        - select database();
      - 使用数据库
        - use 数据库名称;

2. 操作表

   1. C(Create):创建

      1. 语法：

         create table 表名(

         ​		列名1 数据类型1,

         ​		列名2 数据类型2,

         ​		......

         ​		列名n 数据类型n

         );

         - 注意：最后一行，不需要加逗号

      2. 数据库类型：

         1. int 整数类型

            - age int,

         2. double 小数类型

            - score double(5,2),           一共5位，小数点后边2位，最大数：999.99

         3. date 日期，只包含年月日，yyy-MM-dd

         4. datetime 日期，包含年月日时分秒，yyyy-MM-dd HH:mm:ss

         5. timestamp 时间戳类型，包含年月日时分秒 ，yyyy-MM-dd HH:mm:ss

            如果将来不给这个字段赋值，或者赋值位null，咋默认使用当前的系统时间来自动赋值

         6. carchar 字符串类型

            - name varcgar(20),            长度最大为20

      3. 创建一张表

         ~~~sql
         create table student(
         	id int,
             name varchar(32),
             age int,
             score double(4,1),
             birthday date,
             insert_time timestamp
         );
         ~~~

      4. 复制一张表

         ~~~sql
         create table stu like student; -- 创建一个名为stu的表，格式和student一样（相当于是复制了student表）
         ~~~

         

   2. R(Retrieve):查询

      - 查询某个数据库中所有表的名称
        - show tables;
      - 查询表结构
        - desc 表名;

   3. U(Update):修改

      1. 修改表名

         ~~~sql
         alter table 表名 rename to 新的表名;
         ~~~

      2. 修改表的字符集

         ~~~sql
         alter table 表名 character set 字符集名称;
         ~~~

      3. 添加一列

         ~~~sql
         alter table 表名 add 列名 数据类型;
         ~~~

      4. 修改列的名称，类型

         ~~~sql
         alter table 表名 change 列名 新列名 新数据类型; -- 修改某一列的名字，且可以更换新的数据类型
         alter table 表名 modify 列名 新数据类型; -- 修改某一列的数据类型
         ~~~

      5. 删除列

         ~~~sql
         alter table 表名 drop 列名;
         ~~~

   4. D(Delete):删除

      - drop table 表名;
      - drop table if exists 表名;





### DML：增删改表中数据

1. **添加数据**

   - 语法

     ~~~sql
     insert into 表名(列名1,列名2,...列名n) values(值1,值2,...值n);
     -- insert into student(id,name,age) values(1,'老部长',19);
     
     insert into 表名 values(值1,值2,...值n);-- 不加列名后需要给所有的列都添加值
     -- insert into student values(2,"亚瑟摩根",36,99.9,"2018-10-26",null);
     ~~~

   - 注意

     1. 列名和值要一一对应

     2. 除了数字类型，其他类型需要使用引号（单双都可以）引起来

     3. 日期用yyyy-MM-dd

        ~~~java
        insert into 表名 values(1,"亚瑟摩根",36,99.9,"2018-10-26",null);
        ~~~

        

2. **删除数据**

   - 语法

     ~~~sql
     delete from 表名 where 条件;
     -- delete from student where id=1;
     
     delete from 表名;-- 不加条件，删除表中所有的记录（不推荐此方式，效率低）
     -- delete from student;
     
     truncate table 表名;-- 删除表，然后再创建一个一模一样的空表（名字，列等都一样，原表被删除）（效率高）
     -- truncate table student;
     ~~~

     

3. **修改数据**

   - 语法

     ~~~sql
     update 表名 set 列名1=值1,列名2=值2,...列名n=值n where 条件;
     -- update student set age=20,id=3 where id=1;
     
     update 表名 set 列名1=值1,列名2=值2,...列名n=值n;-- 不加条件，所有的记录的对应列的值全部都会修改
     -- update student set age=36,id=2;
     ~~~

     

     





### DQL：查询表中的记录*

1. **语法**

   ~~~sql
   select
   	字段列表
   from
   	表名列表
   where
   	条件列表
   group by
   	分组字段
   having
   	分组之后的条件
   order by
   	排序
   limit
   	分页限定
   ~~~

2. **基础查询**

   1. 多个字段的查询

      ~~~sql
      select 字段名1,字段名2,... form 表名;-- 查询某些字段（列）
      
      select * from 表名;-- 查询列表中所有的记录（所有列）
      ~~~

      

   2. 去除重复

      ~~~sql
      select distinct 字段名1,字段名2,... from 表名;-- 每个所列出字段都一模一样的两行会只保留一行
      ~~~

      

   3. 计算列

      ~~~sql
      select 字段1+字段2 form 表名;-- 加一列两个字段的运算结果，可以和其他字段名一起排列，该新列的名字默认为 字段1+字段2 ，一般只进行数值型运算
      -- select math,english,math+english,name form 表名;
      
      ifnull(字段名,值) -- 标识当该字段为null时，用后边的值替代运算
      -- select math,english,math+ifnull(english,0),name form 表名;
      ~~~

      

   4. 起别名

      ~~~sql
      as 别名 -- as也可以省略
      -- select math,english,math+english as tot,name form 表名;
      -- select math 数学成绩,english 英语成绩,math+english,name form 表名;
      ~~~

      

3. **条件查询**

   1. where 子句后跟条件

   2. 运算符

      - <    >    <=    >=    =    !=    <>(这个也是不等的意思)       (注意，等于只有一个等号)

      - between...and

        ~~~sql
        select * from student where age>=18 and age<=30; 
        select * from student where age between 18 and 30; -- 查询age在18到30之间的
        ~~~

      - in(集合)

        ~~~sql
        select * from student where age=18 and age=19; 
        select * from student where age in(18,19); -- 查询age值在in中(可以写好多)有的
        ~~~

      - like：模糊查询

        ~~~sql
        _  -- 用来代表单个（1个）任意字符
        %  -- 用来代表任意个（可以为0）任意字符
        
        select * from student where name like "老%"; -- 查询name以老开头的
        select * from student where name like "%松%"; -- 查询name中含有松的
        select * from student where name like "_瑟%"; -- 查询name的第二个字符为瑟的
        select * from student where name like "______"; -- 查询name为6个字符的
        ~~~

      - is null

        ~~~sql
        select * from student where age is null; -- 查询age为null的
        ~~~

        注意：null不能用作= 和!= ,即不能用age=null

      - and 或 &&

      - or 或 ||

      - not 或 !
      
        
   
4. **排序查询**

   - 语法

     ~~~sql
     select * from 表名 order by 排序字段1 排序方式,排序字段2 排序方式,排序字段3 排序方式...;
     
     -- select * from student order by age ASC;按age升序查询
     -- select * from student order by age DESC;按age降序查询
     
     -- select * from student order by age DESC,id ASC;
     -- 按age降序查询,age相同时，按照id升序
     ~~~

   - 排序方式

     - ASC 升序，不屑排序方式时，默认时升序
     - DESC 降序

5. **聚合函数**

   - 将一列数据作为一个整体，进行纵向的计算，会自动排除null元素（解决方法，用ifnull，或者选择没有null的列进行计算）

   1. count 计算个数

      ~~~sql
      select count(列名) from 表名;
      
      -- select count(id) from student; 计算student的id列的个数（不是null的行的行数）
      ~~~

   2. max 计算最大值

      ~~~sql
      select max(列名) from 表名;
      
      -- select max(age) from student;
      ~~~

   3. min 计算最小值

   4. sum 计算和

   5. avg 计算平均值

6. **分组查询**

   1. 语法

      ~~~sql
      select 这里填写分组字段或者聚合函数 from 表名 group by 分组字段;
      
      -- select sex,count(id),avg(age) from student group by sex; 按照sex分组，并且结果列出不同的sex，不同的sex的id数量，不同sex的age平均数
      
      -- select sex,count(id),avg(age) from student where age>20 group by sex; 按照sex分组，并且结果列出不同的sex，不同的sex的id数量，不同sex的age平均数,同时只有age>20的记录才会参加分组
      ~~~

   2. 注意：

      1. 分组之后查询的字段：分组字段，聚合函数
      2. where和having的区别
         1. where在分组之前进行限定，不满足条件则不参与分组，having在分组之后进行限定，如果不满足结果，则不会被查询出来
         2. where不可以对聚合函数进行判断，having可以对聚合函数进行判断

7. **分页查询**

   1. 语法

      ~~~sql
      select * from student limit 开始的索引,每页的查询条数;
      
      
      -- select * from student limit 0,3;第一页，查询前三条记录
      -- select * from student limit 3,3;第二页，查询第4-6条记录
      ~~~

   2. 公式：开始的索引=(当前的页码-1)*每页显示的条数

   3. 最后一页数量不够的话则只会查询到剩下的记录

   4. 分页操作limit是一个mysql的方言





### DCL：

1. 管理用户

   1. 添加用户

      - 语法

        ~~~sql
        create user '用户名'@'主机名' identified by '密码';
        
        -- create user 'zhangsan'@'localhost' identified by '123';
        -- 可以在本机cmd使用mysql -uzhangsan -p123; 登录zhangsan的数据库
        ~~~

   2. 删除用户

      - 语法

        ~~~sql
        drop user '用户名'@'主机名';
        ~~~

   3. 修改用户密码

      ~~~sql
      update user set password =password('新密码') where user='用户名';
      
      set password for '用户名'@'主机名' = password('新密码');
      ~~~

      - mysql忘记了root用户的密码
        1. cmd-->net stop mysql   停止mysql服务（需要在管理员模式下运行cmd）
        2. 使用无验证方式启动mysql服务：mysql-->skip-grant-tables
        3. 打开新的cmd窗口，直接输入mysql命令，敲回车，就可以登陆成功
        4. use mysql
        5. update suer set passward = passward('你的新密码') where user = 'root';
        6. 关闭两个cmd窗口
        7. 打开任务管理器，手动结束mysqld.exe 进程
        8. 启动mysql服务
        9. 使用新密码登录

   4. 查询用户

      ~~~sql
      -- 1.切换到mysql数据库
      use mysql;
      -- 2.查询suer表
      select * from user;
      ~~~

      - 通配符：%表示可以在任意主机使用用户登录数据库

2. 授权

   1. 查询权限

      ~~~sql
      show grants for '用户名'@'主机名';
      ~~~

   2. 授予权限

      ~~~sql
      grant 权限列表 on 数据库名.表名 to '用户名'@'主机名';
      
      grant all on *.* to '用户名'@'主机名'; -- 用通配符可以直接授予所有权限
      ~~~

   3. 撤销权限

      ~~~sql
      revoke 权限列表 on 数据库名.表名 from '用户名'@'主机名';
      
      revoke all on *.* from '用户名'@'主机名'; -- 用通配符可以直接撤销所有权限
      ~~~

      

### 约束

对表中数据进行限定，保证数据的正确性、有效性和完整性。

**分类：**

1. 主键约束：primary key
2. 非空约束：not null
3. 唯一约束：unique
4. 外键约束：foreign key



- **非空约束：not null**，某一列的值不能为null

  1. 创建表时添加约束

     ~~~sql
     create table 表名(
     		列名1 类型1,
     		列名2 类型2 not null -- 列名2为非空
     );
     alter table 表名 modify 列名 类型 not null;
     
     -- create table stu(
     -- 		id int,
     -- 		name varchar(20) not null -- name为非空
     -- );
     
     -- alter table stu modify name varchar(20);-- 删除非空约束
     ~~~

  2. 创建表完后，添加非空约束

     ~~~sql
     alter table 表名 modify 列名 类型 not null;
     
     -- alter table stu modify name varchar(20) not null;-- 非空约束
     ~~~

  3. 删除非空约束

     ~~~sql
     alter table 表名 modify 列名 类型;
     
     -- alter table stu modify name varchar(20);-- 删除非空约束
     ~~~

- **唯一约束：unique**，某一列的值不能重复（null也只能有一个）

  1. 创建表时，添加唯一约束

     和非空一样，后边not null换成unique

  2. 创建表完后，添加唯一约束

     和非空一样，后边not null换成unique

  3. 删除唯一约束

     ~~~sql
     alter table 表名 drop index 列名;
     
     -- alter table stu drop index id;-- 删除唯一约束
     ~~~

- **外键约束：foreign key**，让表与表产生关系，从而保证数据的正确性

  1. 创建表时，添加外键

     - 语法

       **外键名称**叫什么都行，但是不能重复

       ~~~sql
       create table 表名(
       	....
           外键列,
           constraint 外键名称 foreign key (外键列名称) references 主表名称(主表列名称)
       )
       
       
       -- 外键列中的值，在主表列中必须都有，主表列中没有的值，外键列中不能有
       ~~~
       
     - 注意

       1. 主表要在外键表之前创建
       2. 添加外键的上一行要加,

  2. 删除外键

     ~~~sql
     alter table 表名 drop foreign key 外键名称;
     ~~~

  3. 创建表之后，添加外键

     ~~~sql
     alter table 表名 add constraint 外键名称 foreign key (外键列名称) references 主表名称(主表列名称);
     ~~~

  4. 级联操作

     级联主表和外键表，可以做到，对主表修改，外键表中自动修改

     1. 添加级联

        - 语法

          ~~~sql
          ALTER TABLE employee DROP FOREIGN KEY dep_employee;-- 添加级联之前需要先将之前的级联删除
          
          alter table 表名 add constraint 外键名称 foreign key (外键字段名称) references 主表名称(主表列名称) on update cascade on delete cascade; -- 同时更新，同时删除
          ~~~

     2. 级联分类

        1. 级联更新：on update cascade

        2. 级联删除：on delete cascade
     
           可以同时写

- **主键约束：primary key**，非空且唯一

  一张表**只能有一个**字段为主键

  主键就是表中记录的唯一标识

  1. 在创建表时添加主键约束

     和非空一样，后边not null换成primary key
     
  2. 创建表完后，添加主键约束

     和非空一样，后边not null换成peimary key

  3. 删除主键约束

     ~~~sql
     alter table 表名 drop primary key;
     
     -- alter table stu drop primary key;-- 删除主键约束
     ~~~

  4. 自动增长

     1. 概念：如果某一列是数值类型的，使用auto_increment可以来完成值的自动增长

        - 比如将id设置为自增长，当添加新行时，若给id赋值为null，则id会自动读取上一行的id值，并且将其加1作为该新行的id值（若其加1已经存在，则继续加1，直到新的id之前没有出现过）

     2. 在创建表时，添加主键约束，并且完成主键自增长

        ~~~sql
        create table 表名(
        		列名1 类型1 primary key auto_increment,-- 完成主键的自动增长
        		列名2 类型2
        );
        ~~~

     3. 在创建表后，添加自增长

        ~~~sql
        alter table 表名 modify 列名 类型 auto_increment;
        ~~~

     4. 删除自增长

        ~~~sql
        alter table 表名 modify 列名 类型;-- 若创建时有主键，则主键属性还在
        ~~~

     



### 数据库的设计范式

1. **多表之间的关系**

   1. 分类

   	1. 一对一
      	- 如：任何身份证
      	- 分析：一个人只有一个人，一个身份证只有一个人
   	2. 一对多（多对一）
      	- 如：部门和员工
      	- 分析：一个部门有多个员工，一个员工只能有一个部门
   	3. 多对多
      	- 如：学生和课程
      	- 分析：一个学生可以选择多门课程，一个课程也可以被很多学生选择
      
   2. 实现关系

      1. 一对多（多对一）

         在多的一方建立外键，指向一的一方的主键

      2. 多对多

         创建第三张中间表，中间表至少包含两个字段，这两个字段作为第三张表的外键，分别指向两张表的主键

      3. 一对一

         1. 建立成一张表
         2. 在任意一方添加外键指向另一方的主键，同时该外键设置唯一约束

2. **数据库设计的范式**

   1. 概念：设计数据库时，需要遵循一些规范，要遵循后边的范式，则必须先遵顼前边的所有范式要求

      目前关系数据库有6中范式：第一范式（1NF），第二范式（2NF），第三范式（3NF），巴斯-科德范式（BCNF），第四范式（4NF），第五范式（5NF，又称完美范式）

      越高的范式数据库冗余越小

   2. 分类：

      1. 第一范式：每一列都是不可分割的原子数据项

      2. 第二范式：在1NF的基础上，非码属性必须完全依赖于候选码（在1NF的基础上消除非主属性对主码的部分函数依赖）

         - 几个概念:

           1. 函数依赖：A-->B，如果通过A属性（属性组）的值，可以确定唯一B属性的值，则称B依赖于A

              例如：学号-->姓名，（学号，课程名称）-->分数

           2. 完全函数依赖：A-->B，如果A是一个属性组，则B属性值的确定需要依赖于A属性组中所有的属性值

              例如：（学号，课程名称）-->分数

           3. 部分函数依赖：A-->B，如果A是一个属性组，则B属性值的确定只需要依赖于A属性组中的某一些值即可

              例如：（学号，课程名称）-->姓名

           4. 传递函数依赖：A-->B，B-->C，如果通过A属性（属性组）的值，可以确定唯一B属性的值，在通过B属性（属性组）的值可以确定唯一C属性的值，则称C传递函数依赖于A

              例如：学号-->系名，系名-->班主任

           5. 码：如果在一张表中，一个属性或属性组，被其他属性所完全依赖，作为称这个属性（属性组）为该表的码

              例如：（学号，课程名称）-->系名，系主任，分数

              - 主属性：码属性组中的所有属性
              - 非主属性：除过码属性组的属性

      3. 第三范式：在2NF的基础上，任何非主属性不依赖与其他非主属性（在2NF基础上消除传递依赖）





### 数据库的备份和还原

1. 命令行

   - 语法

     - 备份:在cmd非sql模式下运行

       ~~~sql
       mysqldump -u用户名 -p密码 数据库名称 > 保存的路径
       ~~~

     - 还原

       1. 登录数据库

       2. 创建数据库

       3. 使用数据库

       4. 执行文件

          ~~~sql
          source 文件路径
          ~~~

     

2. 图形化工具

   转储SQL文件(将数据库备份为.sql文件)-->删除数据库-->运行sql文件（执行sql脚本）



### 多表查询

select *from A,B;的结果为两表的笛卡尔积

- 笛卡尔积：

  - 有两个集合A、B，取这两个集合的所有组成情况

    例如：A表有3行，B表有2行，select \* from A,B;会生成3*2行数据，将A中的3行分别与B中的2行组合

  - 要完成多表查询，需要消除无用的数据

- 多表查询的分类：

  1. 内连接查询

     1. 隐式内连接：用where条件清除无用的数据

        ~~~sql
        select
        	t1.name, -- 用.来区分该列是那个表中的列
        	t1.sex,
        	t2.name
        from
        	stu t1, -- 起一个别名，数据多时方便
        	student t2
        where
        	t1.id=te.id;
        ~~~

     2. 显示内连接

        - 语法

          ~~~sql
          select 字段列表 from 表名1 inner join 表名2 on 条件;
          select 字段列表 from 表名1 join 表名2 on 条件;-- inner可省略
          ~~~

     3. 内连接查询

        1. 从哪些表中查询数据
        2. 条件是什么
        3. 查询哪些字段

  2. 外连接查询

     1. 左外连接

        - 语法

          ~~~sql
          select 字段列表 from 表1 left outer join 表2 on 条件;
          select 字段列表 from 表1 left join 表2 on 条件;-- outer可省略
          ~~~

          左表所有的数据+右表中满足条件的数据，对于不满足条件的左表数据，右表部分用null补齐

     2. 右外连接

        - 语法

          ~~~sql
          select 字段列表 from 表1 right outer join 表2 on 条件;
          select 字段列表 from 表1 right join 表2 on 条件;-- outer可省略
          ~~~

          右表所有的数据+左表中满足条件的数据，对于不满足条件的右表数据，左表部分用null补齐

  3. 子查询
  
     - 概念：查询中嵌套查询，称嵌套查询为子查询
  
       ~~~sql
       select * from student where studnet.age=(select max(age) from studnet);-- 查询student中age最大的一条记录
       ~~~
  
     - 子查询的不同情况
  
       1. 子查询的结果是单行单列的
  
          - 子查询可以作为条件，使用运算符去判断
  
          ~~~sql
          select * from emp where emp.salary < (select avg(salary) from emp);
          ~~~
  
          
  
       2. 子查询的结果是多行单列的
  
          - 子查询可以作为条件，使用运算符in来判断
  
          ~~~sql
          select * from emp where dept_id in(select id from dept where name="财务部" or name="市场部");
          -- dept中在财务部和市场部中id和emp中dept_id相同的满足条件
          ~~~
  
          
  
       3. 子查询的结果是多行多列的
  
          - 子查询可以作为一张虚拟表参与查询
            - 注意：虚拟表的列若是聚合函数，需要起别名后才能单独使用
  
          ~~~sql
          select * from dept t1,(select * form emp where emp.join_date>"2011-11-11") t2 where dept.id=t2.id;-- emp中的join_data大于2011-11-11的记录构成一张虚拟表
          ~~~





### 事务

1. **事务基本介绍**

   1. 概念：

      - 如果一个包含多个步骤的业务操作，被事务管理，那么这些操作要么同时成功，要么同时失败

   2. 操作：

      1. 开启事务：

         ~~~sql
         start transaction;
         ~~~

      2. 回滚：若中间出现错误，则执行回滚，时表回归开启事务时的状态

         ~~~sql
         rollback;
         ~~~

      3. 提交：若无错误，则执行提交，将中间执行的操作的到的数据全部更新到表中

         ~~~sql
         commit;
         ~~~

   3. 例子

      ~~~sql
      start transaction;
      update account set balance=balance-500 where name="zhangsan";
      -- 出错了
      update account set balance=balance+500 where name="lisi";
      
      commit;
      rollback;
      ~~~

   4. mysql数据库中，事务默认自动提交

      - 事务提交的两种方式

        - 自动提交
          - mysql默认自动提交
          - 一条DML语句就会自动提交一次事务
        - 手动提交
          - oracle数据库默认时手动提交事务
          - 需要先开启事务，再提交

      - 修改事务的默认提交方式

        - 查询提交方式

          ~~~sql
          selext @@qutocommit;-- 1代表自动提交，0代表手动提交
          ~~~

        - 修改默认提交方式

          ~~~sql
          set @@autocommit=0;-- 关闭自动提交
          -- 关闭后需要使用commit手动提交
          ~~~

2. 事务的四大特征

   1. 原子性：不可分割的最小操作单位，要么同时成功，要么同时失败
   2. 持久性：当事务提交或回滚后，数据库会持久化的保存数据
   3. 隔离性：多个事务之间，相互独立
   4. 一致性：事务操作前后，数据总量不变

3. 事务的隔离级别

   1. 概念：多个事务之间是隔离的。但是如果多个事务操作同一批数据，则会引发一些问题，设置不同的隔离级别就可以解决这些问题

   2. 存在的问题

      1. 脏读：一个事务读取到另一个事务中没有提交的数据
      2. 不可重复读（虚读）：在同一个事务中，两次读到的数据不一样
      3. 幻读：一个事务操作（DML）数据表中所有记录，另一个事务添加了一条数据，则第一个事务查询不到自己的修改

   3. 隔离级别

      1. read uncommitted：读未提交
         - 产生的问题：脏读、不可重复读、幻读
      2. read committed：读已提交（oracle默认）
         - 产生的问题：不可重复读、幻读
      3. repeatable read：可重复读（mysql默认）
         - 产生的问题：幻读
      4. serializable：串行化
         - 可以解决所有问题

      - 注意：隔离级别从小到大安全性越来越高，但是效率越来越低

      - 数据库查询隔离级别：

        ~~~sql
        select @@tx_isolation;
        ~~~

      - 数据库设置隔离级别（需要重新启动后生效）：

        ~~~sql
        set global transaction isolation level 级别字符串（上边的那四种）;
        ~~~



### JDBC

- **概念**：java database connectivity   java数据库连接，java语言操作数据库
- **JDBC本质**：官方定义的一套操作操作所有关系型数据库的规则，即接口。各个数据库厂商实现这套接口，提供数据库驱动jar包。我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动jar包中的实现类

#### 1. **快速入门**

   - 步骤

     1. 导入驱动jar包

        [eclipse操作步骤](https://blog.csdn.net/phenixyf/article/details/52515598?ops_request_misc=%7B%22request%5Fid%22%3A%22165153944616781483788769%22%2C%22scm%22%3A%2220140713.130102334.pc%5Fall.%22%7D&request_id=165153944616781483788769&biz_id=0&spm=1018.2226.3001.4187)

        iead操作步骤：

        1. 复制jar包（这里是mysql-connector-java-5.1.37-bin.jar）到项目的libs目录下
        2. 右键libs-->add as library

     2. 注册驱动

     3. 获取数据库连接对象 Connection

     4. 定义sql

     5. 获取执行sql语句的对象 Statement

     6. 执行sql，接受返回结果

     7. 处理结果

     8. 释放资源

   - ~~~java
     //1.导入驱动jar包
     
     //2.注册驱动
     Class.forName("com.mysql.jdbc.Driver");
     //3.获取数据库连接对象
     Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
     //4.定义sql语句
     String sql="update account set money =500 where id=1";
     //5.获取执行sql的对象 Statement
     Statement stmt=conn.createStatement();
     //6.执行sql
     int count=stmt.executeUpdate(sql);
     //7.处理结果
     System.out.println(count);
     //8.释放资源
     stmt.close();
     conn.close();
     ~~~

#### 2. **详解各个对象**

   1. DriverManager：驱动管理对象

      - 功能

        1. 注册驱动：告诉程序该使用哪一个数据库驱动jar

           ~~~java
           static void registerDriver(Driver driver)    //注册与给定的驱动程序DriverManager
           
           写代码使用：Class.forName("com.mysql.jdbc.Driver");
           通过源码查看发现：在com.mysql.jdbc.Driver类中存在静态代码块
               static {
           			try{
                           java.sql.DriverManager.registerDriver(new Driver());
                       }catch(SQLException E){
                           throw new RuntimeException("Can't register driver!");
                       }
           	}
           
           注意：mysql5之后的驱动jar包可以省略注册驱动的步骤
           ~~~

        2. 获取数据库连接

           ~~~java
           static Connection getConnection(String url,String user,String password)
           ~~~

           参数：

           - url：指定连接的路径

             ~~~java
             "jdbc:mysql://ip地址(域名):端口号/数据库名称"
             
             //"jdbc:mysql://localhost:3306/db3"
             
             "jdbc:mysql:///数据库名称"  //如果连接的是本机mysql服务器，并且mysql服务器默认端口是3306，则url可以简写
             ~~~

           - user：用户名

           - password：密码

   2. Connection：数据库连接对象

      - 功能

        1. 获取执行sql的对象

           - ~~~java
             Statement createStatement();
             ~~~

           - ~~~java
             PreparedStatement prepareStatement(String sql);
             ~~~

        2. 管理事务

           - 开启事务：

             ~~~java
             setAutoCommit(boolean autoCommit);// 调用该方法设置参数为false,即开启事务
             ~~~

           - 提交事务：

             ~~~java
             commit();
             ~~~

           - 回滚事务：

             ~~~java
             rollback();
             ~~~

             

   3. Statement：执行sql对象

      1. 可以执行任意的sql()

         ~~~java
         boolean execute(String sql);
         ~~~

      2. 执行DML（insert，update，delete）语句或者DDL（create，alter，drop）语句（JdbdDemo1、2、3、4）

         ~~~java
         int executeUpdate(String sql);
         ~~~

         返回值：影响的行数，可以通过这个判断DML语句是否执行成功，若返回值>0则执行成功，反之执行失败（如果是ddl语句则返回0）

      3. 执行DQL（select）语句（JdbdDemo5）

         ~~~java
         ResultSet executeQuery(String sql);
         ~~~

         返回值：ResultSet结果集对象，见下第4条

   4. ResultSet：结果集对象，封装查询对象（JdbcDemo6）

      1. ~~~java
         next(); // 游标向下移动一行
         // 最开始游标指向命名的一行
         ~~~

      2. ~~~java
         getXxx(参数);  // 获取数据
         // Xxx代表数据类型
         // int getInt();
         // 参数有两种类型，int和String，反别代表类的编号和列的名称
         // getInt(3); 获取第三列的值（注意标号是从1开始）
         // getInt("id"); 获取列名为id的一列
         ~~~

      - 常用使用方法

        ~~~java
        while(rs.next()) {
            int id=rs.getInt(1);
            String name=rs.getString("name");
            int money=rs.getInt(3);
            System.out.println(id+"---"+name+"---"+money);
        }
        ~~~

      - 一般创建一个类，类中的成员变量与表中的列对应，然后将表存储在类中

        ~~~java
        //将account表存储在Account类中
        package cn.itcast.jdbc;
        
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.util.List;
        
        import cn.itcast.domain.Account;
        
        
        
        public class JdbcDemo7 {
        
        	public static void main(String[] args) {
        		// TODO Auto-generated method stub
        
        		List<Account> list=new JdbcDemo7().findAll();
        		System.out.println(list);
        		System.out.println(list.size());
        		
        	}
        	
        	public List<Account> findAll(){
        		Connection conn=null;
        		Statement stmt=null;
        		ResultSet rs=null;
        		List<Account> list=null;
        		
        		try {
        			Class.forName("com.mysql.jdbc.Driver");
        			
        			conn=DriverManager.getConnection("jdbc:mysql:///jdbc", "root", "root");
        			
        			String sql="select * from account";
        			
        			stmt=conn.createStatement();
        			
        			rs=stmt.executeQuery(sql);
        			
        			Account acc=null;
        			list=new ArrayList<Account>();
        			
        			while(rs.next()) {
        				int id=rs.getInt("id");
        				String name=rs.getString("name");
        				int money=rs.getInt("money");
        				
        				acc=new Account();
        				
        				acc.setId(id);
        				acc.setName(name);
        				acc.setMoney(money);
        				
        				list.add(acc);
        			}
        			
        
        			
        		} catch (ClassNotFoundException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		} catch (SQLException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}finally {
        			if(rs!=null) {
        				try {
        					rs.close();
        				} catch (SQLException e) {
        					// TODO Auto-generated catch block
        					e.printStackTrace();
        				}
        			}
        			if(stmt!=null) {
        				try {
        					stmt.close();
        				} catch (SQLException e) {
        					// TODO Auto-generated catch block
        					e.printStackTrace();
        				}
        			}
        			if(conn!=null) {
        				try {
        					conn.close();
        				} catch (SQLException e) {
        					// TODO Auto-generated catch block
        					e.printStackTrace();
        				}
        			}
        		}
        		
        		return list;
        	}
        }
        
        ~~~

        

   5. PreparedStatement：执行sql的对象

      1. sql注入问题：在拼接sql时，有一些sql的特殊关键字参与字符串的拼接。会造成安全性问题
         1. 输入任意用户名，输入密码：a' or 'a'='a
         2. sql呈现的效果:  select * from user where username='asda' and password ='a' or 'a'='a';
      2. 解决sql注入问题：使用PreparedStatement对象来解决
      3. 预编译的sql：参数使用?作为占位符
      4. 步骤
         1. 导入驱动jar包
         2. 注册驱动
         3. 获取数据库连接对象 Connection
         4. 定义sql
            - 注意：sql的参数使用 ? 作为占位符。如：select * from user where username=? and password =?;
         5. 获取执行sql语句的对象 PreparedStatement    Connection.prepareStatement(string sql)
         6. 给 ? 赋值：
            - 方法：setXxx(参数1，参数2);
              - 参数1：?的位置编号，从1开始
              - 参数2：?的值
         7. 执行sql，接受返回结果
         8. 处理结果
         9. 释放资源
      5. 注意：后期都会使用PreparedStatement来完成增删改查的所有操作
         1. 可以防止sql注入
         2. 效率更高

   

#### 3. **JDBC工具类**

   通过一个JdbcUtils类来实现JDBC中的大部分代码，减少代码重复性

   可以看到，使用JDBC工具类后代码长度减少（下边的findAll1方法对比 上述findAll方法）

   配置文件：jdbc.propertes

   ~~~propertes
   url=jdbc:mysql:///jdbc
   user=root
   password=root
   driver=com.mysql.jdbc.Driver
   ~~~

   JdbcUtils类

   ~~~java
   package cn.itcast.util;
   
   import java.io.FileNotFoundException;
   import java.io.FileReader;
   import java.io.IOException;
   import java.net.URL;
   import java.sql.Connection;
   import java.sql.DriverManager;
   import java.sql.ResultSet;
   import java.sql.SQLException;
   import java.sql.Statement;
   import java.util.Properties;
   
   /*
    * JDBC工具类
    */
   public class JdbcUtils {
   
       //这里使用配置文件进行值的传入，不用频繁更改代码
   	private static String url;
   	private static String user;
   	private static String password;
   	private static String driver;
   	/*
   	 * 文件的读取，只需要读一次即可拿到这些值。使用静态代码块
   	 */
   	static {
   		//读取资源文件，获取值
   
   		try {
   			//1.创建Properties集合类
   			Properties pro=new Properties();
   			
   			
   			//获取src路径下的文件的方式-->ClassLoader 类加载器
   			ClassLoader classLoader=JdbcUtils.class.getClassLoader();
   			URL res=classLoader.getResource("jdbc.properties");
   			String path=res.getPath();
   			
   			System.out.println(path);
   			
   			
   			//2.加载文件
   			pro.load(new FileReader("src/jdbc.properties"));
   			//3.获取数据，复制
   			url=pro.getProperty("url");
   			user=pro.getProperty("user");
   			password=pro.getProperty("password");
   			driver=pro.getProperty("driver");
   			//4.注册驱动
   			Class.forName(driver);
   		} catch (FileNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		} catch (ClassNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   	}
   	
   	
   	/*
   	 * 获取连接
   	 * @return 连接对象
   	 */
   	public static Connection getConnection() throws SQLException {
   		return DriverManager.getConnection(url, user, password);
   	}
   	
   	
   	/*
   	 * 释放资源
   	 * @param stmt
   	 * @param conn
   	 */
   	public static void close(Statement stmt,Connection conn) {
   		if(stmt!=null) {
   			try {
   				stmt.close();
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   		}
   		
   		if(conn!=null) {
   			try {
   				conn.close();
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   		}
   	}
   	
   	/*
   	 * 释放资源
   	 * @param rs
   	 * @param stmt
   	 * @param conn
   	 */
   	public static void close(ResultSet rs,Statement stmt,Connection conn) {
   		
   		if(rs!=null) {
   			try {
   				rs.close();
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   		}
   		
   		if(stmt!=null) {
   			try {
   				stmt.close();
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   		}
   		
   		if(conn!=null) {
   			try {
   				conn.close();
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   		}
   	}
   	
   }
   
   ~~~

   JdbcDemo7类：

   ~~~java
   package cn.itcast.jdbc;
   
   import java.sql.Connection;
   import java.sql.DriverManager;
   import java.sql.ResultSet;
   import java.sql.SQLException;
   import java.sql.Statement;
   import java.util.ArrayList;
   import java.util.List;
   
   import cn.itcast.domain.Account;
   import cn.itcast.util.JdbcUtils;
   
   
   
   public class JdbcDemo7 {
   
   	public static void main(String[] args) {
   		// TODO Auto-generated method stub
   
   		List<Account> list=new JdbcDemo7().findAll1();
   		System.out.println(list);
   		System.out.println(list.size());
   		
   	}
   	
   	public List<Account> findAll1(){
   		Connection conn=null;
   		Statement stmt=null;
   		ResultSet rs=null;
   		List<Account> list=null;
   		
   		try {
   			conn=JdbcUtils.getConnection();
   			
   			String sql="select * from account";
   			
   			stmt=conn.createStatement();
   			
   			rs=stmt.executeQuery(sql);
   			
   			Account acc=null;
   			list=new ArrayList<Account>();
   			
   			while(rs.next()) {
   				int id=rs.getInt("id");
   				String name=rs.getString("name");
   				int money=rs.getInt("money");
   				
   				acc=new Account();
   				
   				acc.setId(id);
   				acc.setName(name);
   				acc.setMoney(money);
   				
   				list.add(acc);
   			}
   			
   
   			
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}finally {
   			JdbcUtils.close(rs, stmt, conn);
   		}
   		
   		return list;
   	}
   }
   
   ~~~

   练习：通过键盘录入用户名和密码，判断用户是否登录成功

   代码位于JdbcDemo8

#### 4. JDBC控制事务

   1. 事务：一个包含多个步骤的业务操作，如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败

   2. 操作：

      1. 开启事务
      2. 提交事务
      3. 回滚事务

   3. 使用Connection对象来管理事务

      - 管理事务

        - 开启事务：在执行sql之前开启事务

          ~~~java
          setAutoCommit(boolean autoCommit);// 调用该方法设置参数为false,即开启事务
          ~~~

        - 提交事务：当所有sql都执行完后提交事务

          ~~~java
          commit();
          ~~~

        - 回滚事务：在catch中回滚事务

          ~~~java
          rollback();
          ~~~

          



### 数据库连接池

- 概念：其实就是一个容器（集合），存放数据库连接的容器。

  当系统初始化好后，容器被创建，容器中会申请一些连接对象，当用户来访问数据库时，从容器中获取连接对象，用户访问完毕后，会将连接对象归还给容器

- 好处：

  1. 节约资源
  2. 用户访问高效

- 实现：

  1. 标注接口：DataSource     javax.sql包下

     1. 方法：

        - 获取连接

          ~~~sql
          getConnection();
          ~~~

        - 归还连接：如果连接对象Connection是从连接池中获取的，那么调用COnnection.close()方法，则不会在关闭连接了。而是归还连接

     2. 一般我们不去实现它，有数据库厂商来实现

        1. C3P0：数据库连接池技术
        2. Druid：数据库连接池实现技术，由阿里巴巴提供





#### C3P0

**数据库连接池技术**

- 使用步骤（C3P0Demo）

  1. 导入jar包（三个）

     c3p0-0.9.5.2.jar    mchange-commons-java-0.2.12.jar和数据库驱动jar包mysql-connector-java-5.1.37-bin.jar

  2. 定义配置文件：

     - 名称：c3p0.properties  或者  c3p0-config.xml
     - 路径：直接将文件放在src目录下即可

  3. 创建核心对象 数据库连接池对象  ComboPooledDataSource

  4. 获取连接：getConnection



#### Druid

**数据库连接池实现技术，由阿里巴巴提供**

- 使用步骤（DruidDemo）
  1. 导入jar包   druid-1.0.9.jar
  2. 定义配置文件
     - 是propertiesi形式的
     - 可以叫任意名称，可以放在任意目录下
  3. 加载配置文件
  4. 获取数据库连接池对象：通过工厂类来获取    DruidDataSourceFactory
  5. 获取连接：getConnection
- 定义工具类
  1. 定义一个类 JDBCUtils
  2. 提供静态代码块加载配置文件，初始化连接池对象
  3. 提供方法
     1. 获取连接方法：通过数据库连接池获取连接
     2. 释放资源
     3. 获取连接池的方法







### Spring JDBC

- Spring框架对JDBC的简单封装。提供了一个JDBCTemplate对象简化JDBC的开发

- 步骤：

  1. 导入JAR包

  2. 创建JdbcTemplate对象，依赖于数据源DataSource

     ~~~java
     JdbcTemplate template =new JdbcTemplate(ds);
     ~~~

  3. 调用JdbcTemplate的方法来完成CRUD的操作（JdbcTemplateDemo2）

     ~~~java
     update();  //执行DML语句，增删改
     
     queryForMap();    //查询结果将结果封装为map集合,查询的行数只能为1，将列名作为key值，将值作为value，封装成map集合
     
     queryForList();    //查询结果将结果封装为list集合，将每一条记录都封装为Map集合，再将Map集合装在进List集合
     
     query();    //查询结果，将结果封装为JavaBean对象
     //需要一个RowMapper的参数，一般使用BeanPropertyRowMapper实现类，可以完成数据到JavaBean的自动封装
     
     queryForObject();    //查询结果，将结果封装为对象,一般用于执行一些聚合函数
     ~~~

     



### web概念

- JavaWeb：
  - 使用Java语言开发基于互联网的项目
- 软件架构：
  1. C/S：client/server  客户端/服务器端
     - 在用户本地有一个客户端程序，在远程有一个服务器端程序
     - 如：QQ，微信
     - 优点：
       1. 用户体验好
     - 缺点：
       1. 开发安装部署维护麻烦
  2. B/S：browser/server  浏览器/服务器端
     - 只需要一个浏览器，用户通过不同的网址，客户访问不同服务器端的程序
     - 优点：
       1. 开发安装部署维护简单
     - 缺点：
       1. 如果应用过大，用户的体验可能会受到影响
       2. 对硬件要求过高

#### B/S架构详解

- 资源分类：

  1. 静态资源:
     - 使用静态网页开发技术发布的资源
     - 特点：
       1. 所有用户访问，得到的结果一样
       2. 如：文本，图片，音频，视频，HTML，CSS，JavaScript
       3. 用户请求静态资源->服务器发送静态资源->浏览器内置静态资源解析引擎->展示静态资源
  2. 动态资源：
     - 使用动态网络技术发布的资源
     - 特点：
       1. 所有用户访问，得到的结果可能不一样
       2. 如：jsp/servlet，php，asp...
       3. 如果用户请求动态资源，那么服务器会执行动态资源，转换为静态资源，在将静态资源发送给浏览器

  

- 静态资源：
  - HTML：用于搭建基础网页，展示页面的内容
  - CSS：用于美化页面，布局页面
  - JavaScript：控制页面的元素，让页面有一些动态的效果

