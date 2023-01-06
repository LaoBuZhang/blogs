

## SQL

## MySQL的安装

有两种方式安装，一种是下载官网的zip包，然后自己配置，另一种是直接使用installer（推荐）

[mysql下载地址](https://dev.mysql.com/downloads/)



在安装时可能会遇到一些问题

解决方法：

1. 卸载从前版本，然后重启电脑（重要）
2. [MySql自动安装时启动服务失败](https://blog.csdn.net/qq_37361010/article/details/117286893?ops_request_misc=&request_id=&biz_id=102&utm_term=Unknown error: 发生一个或多个错误。Retry&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-4-117286893.142^v68^js_top,201^v4^add_ask,213^v2^t3_esquery_v3&spm=1018.2226.3001.4187)





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

         6. varchar 字符串类型

            - name varchar(20),            长度最大为20

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

