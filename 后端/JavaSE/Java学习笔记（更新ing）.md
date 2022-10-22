---
title: Java学习笔记（更新ing）
date: 2022-03-14 21:25:51
tags: Java



---

# **Java学习笔记（有c基础）（更新ing）**

本笔记建立在有c语言基础上进行



<!--more-->

## 1.DOS命令

### 什么是DOS？

	在控制台输入指令并且让计算机完成某些操作，这些命令称之为DOS命令

### 如何使用

	首先是打开输入DOS指令的终端，现阶段以Windows系统为操作系统
	windows+r可以打开运行，输入cmd即可进入命令行界面

![请添加图片描述](https://img-blog.csdnimg.cn/3ef0f31a6f4c4caf902679eca0a618e6.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_13,color_FFFFFF,t_70,g_se,x_16)
![请添加图片描述](https://img-blog.csdnimg.cn/4eccb55480db42f18e5e06b1064993d5.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)

### 命令行介绍

在最前面的一串是当前所处的位置
	

	输入：  硬盘名字+:  即可跳转到对应硬盘（不需要区分大小写）

![请添加图片描述](https://img-blog.csdnimg.cn/28188fecf46b476baee99957dc394873.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)

### 常用DOS命令

![请添加图片描述](https://img-blog.csdnimg.cn/bf184b04ede649baa2a1e01509f26adf.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_12,color_FFFFFF,t_70,g_se,x_16)
以dir为示范：
![请添加图片描述](https://img-blog.csdnimg.cn/1dba47b3b9074595948966bd52130269.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)
	

	其他的操作可自行尝试，更多的操作后续学习

## 2.第一个Java程序

### 输出Hellow World！

	我们先不使用专业文本编辑器

#### 创建java文件

	新建一个txt文件，后缀名修改为java，命名为Main
	输入以下代码，Ctrl+s进行保存

```java
public class Main  //Main为类名，即这个地方的类名要与文件名保持一致，相对固定的写法
{
        public static void main(String[] args)//相当于c语言的定义main函数，相对固定的写法
        {
                System.out.print("Hellow World!");//主函数的操作，输出Hellow World!
        }
}
```

#### 运用DOS命令编译程序

	首先移动到java文件所在的位置，如下图所示：

![请添加图片描述](https://img-blog.csdnimg.cn/0b4fff8313544260b7bb369037dfad9f.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)
HellowWorld.java文件即为我们的代码文件

	输入  javac 文件名（加后缀） 可对文件进行编译，如图

![请添加图片描述](https://img-blog.csdnimg.cn/8c030f9a72e843438ca7adf4e08720ca.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)
	

	无报错说明编译成功，同时编译后会自动生成一个同名的class文件
	（图中的class文件是我之前运行时生成的）

#### 运用DOS命令运行程序

	输入java 文件名（不加后缀） 运行程序，如图

![请添加图片描述](https://img-blog.csdnimg.cn/44c210967d2b4b66af26dfc6861f92a6.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)

### 练习

[洛谷签到题](https://www.luogu.com.cn/problem/P1000)

	注意，洛谷的Java评测默认类名为Main

在这里我贴上代码：

```java
public class Main{
        public static void main(String[] args){
                System.out.print("                ********\n");
                System.out.print("               ************\n");
                System.out.print("               ####....#.\n");
                System.out.print("             #..###.....##....\n");
                System.out.print("             ###.......######              ###            ###\n");
                System.out.print("                ...........               #...#          #...#\n");
                System.out.print("               ##*#######                 #.#.#          #.#.#\n");
                System.out.print("            ####*******######             #.#.#          #.#.#\n");
                System.out.print("           ...#***.****.*###....          #...#          #...#\n");
                System.out.print("           ....**********##.....           ###            ###\n");
                System.out.print("           ....****    *****....\n");
                System.out.print("             ####        ####\n");
                System.out.print("           ######        ######\n");
                System.out.print("##############################################################\n");
                System.out.print("#...#......#.##...#......#.##...#......#.##------------------#\n");
                System.out.print("###########################################------------------#\n");
                System.out.print("#..#....#....##..#....#....##..#....#....#####################\n");
                System.out.print("##########################################    #----------#\n");
                System.out.print("#.....#......##.....#......##.....#......#    #----------#\n");
                System.out.print("##########################################    #----------#\n");
                System.out.print("#.#..#....#..##.#..#....#..##.#..#....#..#    #----------#\n");
                System.out.print("##########################################    ############\n");
        }
}
```

## 3.注释

### 单行注释

	与c语言一样，用 // 来单行注释

### 多行注释

	与c语言一样，用/*   */来多行注释

### 文档注释

	用于整体的描述一个类，写在类前

基本格式：

```java
/**
*语句1
*语句2
*语句3
*/
```

### 中文

	在UTF-8的编码模式下，中文会报错，此时需要修改编码模式为ANSI
	具体方法为：
	在记事本界面左上角一次点击->文件->另存为->(右下角编码)ANSI->选择新地址
	（可选择原地址然后选择覆盖）

## 4.Java基本语法

### 导包

	类似c的头文件，有些内置函数需要导包后方可使用

举例：

```java
import java.util.Scanner;//一般用于输入
import java.util.Scanner;//用于和数组相关的函数
import java.util.*;//包含所有util名下的所有包，类似c++的万能头
```



### package和import

**package** 的作用就是 c++ 的 **namespace** 的作用，防止名字相同的类产生冲突。Java 编译器在编译时，直接根据 package 指定的信息直接将生成的 class 文件生成到对应目录下。如 package aaa.bbb.ccc 编译器就将该 .java 文件下的各个类生成到 ./aaa/bbb/ccc/ 这个目录。

**import** 是为了简化使用 package 之后的实例化的代码。假设 ./aaa/bbb/ccc/ 下的 A 类，假如没有 import，实例化A类为：new aaa.bbb.ccc.A()，使用 import aaa.bbb.ccc.A 后，就可以直接使用 new A() 了，也就是编译器匹配并扩展了 aaa.bbb.ccc. 这串字符串。



### 关键字与保留字

	1.关键字，与c类似
	2.保留字，在以后的Java版本中可能会作为关键字的单词，不能作为变量名使用，
	现有保留字如下

![请添加图片描述](https://img-blog.csdnimg.cn/9b258f2790f0493988a62adfe04d6288.png)

### 专业的文本编辑器

VSCode，Notepad++，UltraEdit，EditPlus
![请添加图片描述](https://img-blog.csdnimg.cn/03c12056b79f4a85a454fc3b18ee8729.png)

### 标识符

	即变量名、类名等可以自己命名的部分
	基本与c语言的命名规则一致，但Java加入了 $ 符号也可作为命名中使用的字符

### Java命名规范

![请添加图片描述](https://img-blog.csdnimg.cn/7e2e5fd4947141538e93d85c17aaaf1f.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)

### 变量定义

	基本与c一致（初值等细节待补充）

### 数据类型

#### （1）基本数据类型

##### **整数型：** byte    short    int    long

![请添加图片描述](https://img-blog.csdnimg.cn/c8e4eedb84cc446981cda0960c3134b9.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)
	

	注意：java的数字默认为int型，对long类型的数据赋值时需要在数字后
	加上 l 或者 L

例如：

```java
long x=1005l;
long y=1006L;
```

##### **浮点型：** float double

![请添加图片描述](https://img-blog.csdnimg.cn/8eba7db839c3496e9ac417e65ad07692.png)
	

	注意：java的小数默认为double型，对float类型的数据赋值时需要在数字后
	加上 f 或者 F

例如：

```java
float a=1.5f;
float b=2.5F;
```

##### **字符型：** char

##### **布尔型：** boolean

	注意：Java的boolean类型数据只能为true和false，不能用0和非0数字代替

##### 定义并输出基本数据类型

粘一份代码在此：

```java
public class PrintType
{
    public static void main(String[] args)
    {
        byte a=1;
		System.out.println(a);//println就是在输出末尾自动添加换行

        short b=2;
		System.out.println(b);

        int c=3;
		System.out.println(c);

        long d=4L;
		System.out.println(d);

        float e=5.1F;
		System.out.println(e);

        double f=6.2;
		System.out.println(f);

        boolean g=true;
		System.out.println(g);
    }
}
```

#### （2）引用数据类型

	所有引用类型数据都可以用null作为初值

##### **类：** class

	String类型：String类型在Java中是不可变类，即在创建是赋予的初值不可改变，
	同时，对于每个字符串常量，Java都会将其存放在数据区，若之前有，就直接用
	之前的，若无，则新创立一个

例：

```java
int a=1;//int型是可变类型
int b=1;
```

	以上代码会在内存中存储两个1，分别为变量a和变量b

```java
String s1="hello";
String s2="hello";
```

	以上代码只会在内存中存储一个"hello"，但是s1和s2都引用了"hello"

具体存储方式如下图：

	s0 s1和s2都是对于字符串"hello"的引用，指向的地址相同，

![请添加图片描述](https://img-blog.csdnimg.cn/ecbc0b0359aa496a85c398fcde9fb9c3.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)
 **定义并输出类：**
以String类型为例

```java
String a="Hello"+" World";
System.out.print(a);
```

##### **接口：** interface

##### **数组：** [ ]

### 基本数据类型转换

**自动类型装换**

	容量小的类型转换为容量较大的类型

下图为容量排序：

	其中char byte和short类型之间不能互相转换，计算时都转换成int型，
	（例如，两个byte类型相加得到的是int类型）

![请添加图片描述](https://img-blog.csdnimg.cn/0362e2803b5644cba6fe4b4bbb3adf61.png)
**计算时转换**

	当多种类型数据进行混合运算时，系统会首先将所有数据都转换为容量最大的
	那个数据类型，然后再进行计算

例如：

```java
char a='0';
byte b=1;
short c=2;
int d=a+b+c;//此时a b和c都转换为int类型（char转换为ASCII码），然后再进行计算

int x=1;
short y=2;
long z=3L;
long w=x+y+z;//此时x y和z都转换成long类型，然后再进行相加
```

**和字符串相关的转换**

	1.字符串不能直接转换成基本类型（当然有特殊的方法，后边再说）
	2.任何类型的值和字符串进行连接时，从左向右计算，遇到第一个字符串类型时，
	都会将该字符串右边的部分都转换成字符串类型，左边部分先相加再转换成字符串
	类型，然后再全部相加

例如：

```java
String a=1+2+3+"hello"+1+2+3+'a'+"world";
//则a的值为 6hello123aworld
String b=1+2+3+1+2+3+'a';//因为无String类型，所以一直相加到最后为109，然后转换为String类型
//则b的值为 109
```

**布尔型**
boolean类型数据不能转换成其他任何类型数据

### 隐式转换和显式转换

	自动转换（上述）都是隐式转换

例

```java
byte a=1;
int b=a;//这里的a自动转换成int类型
```

	手动转换（类似c的强制转换）都是显式转换

例

```java
int a=1;
byte b=(byte)a;
```

## 5.运算符

### 算数运算符

	同c

### 赋值运算符

	基本同c
	+=  -= *= /=计算时会进行强制的数据转换

例：

```java
short a=1;
int b=2;
a=a+b;//错误，a+b为int类型，不能向下赋值给a
a=(short)(a+b);//正确，把a+b强制转换成short类型
a+=b;//正确，效果同上句一样
```

### 比较运算符

同c

### 逻辑运算符

逻辑：
	

	&  ，|  ，!  

短路：

	&& ，|| ，^

**判断条件：**
	

	其中，&& 与 &，| 与 || 的判断条件一致，都和c的 && 和 || 一样，^ 同c，! 同c

注意：
![请添加图片描述](https://img-blog.csdnimg.cn/957bcd45220043c5849a57850eac3694.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)

### 位运算符

\>>右移
<<左移
\>>>无符号右移
&与运算
|或运算
^异或运算
~取反运算
以上都同c

**补充：**
以31为例，32位存储
原码：0000 0000 0000 0000 0000 0000 0001 1111    代表数字31
反码：1111 1111 1111 1111 1111 1111 1110 0000        代表数字-32
补码：1111 1111 1111 1111 1111 1111 1110 0001        代表数字-31
**反码:** 

	所有位都取反，为原码的相反数-1

**补码:** 

	反码+1，为原码的相反数

**原码->补码：** 

	取反加一

**补码->原码：** 
	

	减一取反

**\>>与>>>的区别：**

	>>右移后，若原数是负数，则再前边补上1
	>>>右移后，不论正负，直接再前边补上0

如下图：
![请添加图片描述](https://img-blog.csdnimg.cn/02955f711ee24ebe8f5d4551f95f2745.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)

### 三目运算符

同c

### 运算符优先级

![请添加图片描述](https://img-blog.csdnimg.cn/abf59b061a3c4fe48615c675e790f0cb.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_15,color_FFFFFF,t_70,g_se,x_16)
聪明人都加括号

## 6.程序流程控制

### 顺序结构

同c

### 分支结构

**if-slese结构：**
同c
**switch结构**
同c
补充：
![请添加图片描述](https://img-blog.csdnimg.cn/d88d3185daad4b6c90a43e1e66751e83.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)

### 循环结构

**for循环**
基本用法同c
**enhanced for循环**
类似python中的循环，可以较为方便的遍历数组

~~~java
//循环遍历输出number数组
int[] number={1,2,3,4,5,6,7,8,9};
for(int item:number)
{
	System.out.println(item);
}
~~~

**while循环**
同c
**嵌套循环**
同c
**特殊流程控制语句**
break continue return
基本同c

带label的break，可以把label中的所有循环全部停止

~~~java
//loop就是标签
int i;
loop:
	while(true)
	{
		while(true)
		{
			i=cin.nextInt();
			if(i==0)
			{
				break loop;
			}
		}
	}
~~~

## 7.数组

### 一维数组声明

两种方式

```java
int a[];
int[] a;
```

### 一维数组初始化

需要用new分配空间
**动态初始化：**
直接声明数组大小

```java
int[] a=new int[10];//相当于c的int a[10];
a[0]=1;//可直接对数组元素赋值
a[1]=2;
```

**静态初始化：**
直接给数组赋初值

```java
int a[]=new int[]{0,1,2,3};
int[] a={0,1,2,3};
//相当于c的int a[4]={0,1,2,3};
```

**注意：**

	1.数组长度确认后无法改变，同c，下标0->n-1
	2.整数数组初始值默认为0，对象数组初始值默认为null，
	浮点数数组初始值默认为0.0，布尔数组初始值默认为flase
	3.可通过length函数获取数组长度

```java
int[] a=new int[4];
int b=a.length();//b的值为4
```

### 二维数组声明

3种方式

```java
int a[][];
int[] a[];
int[][] a;
```

### 二维数组初始化

	Java的多维数组不必一定是矩形
	需要使用new分配空间

**动态初始化**
直接声明数组大小

```java
int[][] a=new int[3][2];//相当于c的int a[3][2];
```

只声明一维的大小

```java
int[][] a=new int[3][];//二维可以先不确定
```

**静态初始化**
直接给数组赋除值

```java
int[][] a=new int[][]{
	{1,2,3,4},
	{3,9,5},
	{8,8,7,6,5,6}
}
//一维的长度为二维的数组数，a.length=3
//每个二维的长度可以不等，
//a[0].length=4		a[1].length=3		a[2].length=6
```

**易混定义**

```java
int[] x,y[];//这里x是一维数组，y是二维数组
```

### 数组赋值

	1.Class文件存储在方法区
	2.运行的方法，main方法，定义的变量存储在栈内存
	3.new的对象存储在堆内存
	
	首先明确，数组名存储的是数组的地址
	数组名及地址存储在栈中，数组的数据存储在堆中，如下图

![请添加图片描述](https://img-blog.csdnimg.cn/d37588d5722f4da8baf30e9b502d3a1d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)
	

	所以可以将两个数组指向同一个地址

即

```java
int a[]=new int[]{0,1,2,3};//因为数组的数据是new的，所以存在堆内存
int b[]=a;
a[0]=100;//对堆中地址存储的数据进行修改
System.out.print(b[0]);//此时b[0]也变为100
```

## 8.数据输入输出

### 数据输入

**1.导包**
类似c的头文件

```java
import java.util.Scanner;
```

**2.创建对象**
类似c的istream

```java
Scanner cin=new Scanner(System.in);
```

**3.接收数据**
类似c的istream

```java
int a=cin.nextInt();
```

**练习题**
[洛谷A+B Problem](https://www.luogu.com.cn/problem/P1001)
代码如下：

```java
import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		int a=cin.nextInt(),b=cin.nextInt();
		System.out.print(a+b);
	}
}
```

**这里列出不同类型数据的输入：**

```java
int a = scanner .nextInt();//int
float b = scanner.nextFloat();//float
double c = scanner.nextDouble();//double
String d = scanner.next();//遇见第一个有效字符开始扫描，遇见分隔符或结束符扫描结束
String D = scanner.nextLine();//扫描到一行内容并作为一个字符串被获取到
char e = scanner.next().charAt(0);//char
```

### 数据输出

	Java除了有print的输出方式，也有printf的输出方式，用法和c类似

如输出3位小数：

```java
double a=1.2345;
System.out.printf("%.3f",a);
System.out.printf("%0.3f",a);//该写法是错误的，Java中前边不能加0
```

	不过，有些格式Java中没有，比如%lf，编译不会报错，但是输出时会报错
	这个以后补充

## 9.关于进制

**计算机使用的是二进制，那么为什么我们需要学习8进制和16进制？**

	为了更加方便的观察2进制

**2进制转换成8进制**

	将2进制的数字串每3位分隔，每3位看成单独的2进制数字组成的数字位8进制的一位

```java
10进制：97
2进制：001 100 001
8进制： 1   4   1
//001对应1	100对应4	001对应1
```

**2进制转换成16进制**

	将2进制的数字串每4位分隔，每4位看成单独的2进制数字组成的数字位16进制的一位

```java
10进制：97
2进制：0110 0001
16进制： 6    1
//0110对应6		0001对应1
```

**java的进制表示**

	前边加0b或者0B表示2进制
	前边加0表示8进制
	前边加0x或者0X表示16进制

```java
int a=0b1100001;
int b=0141;
int c=0x61；
//此时输出a，b，c得到的都是97（10进制）
```

## 10.实用方法（函数）

	就我目前的理解，再Java中没有函数，取而代之的是方法

### 1.sort方法

**Arrays.sort(数组名,起始下标,结束下标+1);**
使用方法举例：

```java
int[] a=new int[]{5,4,3,2,1};
Arrays.sort(a,0,5);//从a[0]到a[4]排序
```

**cmp函数**

	等学了方法再补充

### 2.power方法

	需要再前面加上Math
	sqrt函数也是如此

```java
int a=2;
int b=Math.power(a,3);//a的3次幂
double c=Math.sqrt(a);//a的平方根
```

### 3.random随机数

![请添加图片描述](https://img-blog.csdnimg.cn/f759b856f70e45f689dd708cfa31fd76.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)
进阶：得到20到99的随机数
只需随机数加上20即可

```java
int number=r.nextInt(80)+20;
```

## 11.方法

	在面向对象的语言中，函数称为方法，所以，Java的方法其实就类似c的函数
	
	1.和main方法同级
	2.不用在意顺序，前边的方法可以调用后边的方法
	3.使用方法和c的函数一致
	4.形参实参传递等与c一致
	5.方法修改参数时，参数传递基本数据类型变量时不改变原变量，传递引用
	数据类型变量时改变原变量（例：和c一样，传递整数不变，传递数组变）

一个简单的例子:

```java
import java.util.*;
public class Test
{
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		System.out.println(sum(10,20));
		end();
	}
	
	public static int sum(int a,int b)//public static为一般格式，目前的方法都写这个就行
	{
		return a+b;
	}
	
	public static void end()
	{
		System.out.print("程序结束");
	}
}

```

## 12.Debug

这里用eclipse
[这篇博客介绍了eclipse的debug界面](https://blog.csdn.net/weixin_41547486/article/details/79481543?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522164352757316780255224954%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=164352757316780255224954&biz_id=0&spm=1018.2226.3001.4187)

# **以下为面向对象编程**

## 13.类和对象

### 包

1.类似于c的不同的头文件
2.和c一样，java也可以自建包（类似c的.h文件）

**对于包的理解：**

Java程序是基于Class，随着Java类越写越多，难免会出现类重名的现象。为了在使用它们的时候不让编译器混淆，我们给类加上一个限定（前缀），即把它们放在不同包里面，调用时再加上前缀。比如，A班有一个张三，B班也有一个张三，我们要让A班张三做某事时，就把它们分别放到A、B包中，然后调用A.张三即可。这样好处是对同名的类进行了区分；能精确指出我们需要的哪一个；让同名的类在一个程序中共存。

**包的建立：**

1.java没有.h文件，可以直接在某个项目的scr文件夹里边直接新建一个文件夹，然后在文件夹中加入各个类文件（文件夹的名字即为包名，可为中文）
2.在eclipse里边可以直接在左侧右键建立，也可以在新建一个类的时候直接指定它所属的包（若无此包，则会新建）

**包的命名：**

1. 可直接命个名

2. 可在名字中加入 "." ，一个 "."代表一层文件夹

   例如：建立一个包命名为Lao.Bu.Zhang，则会先建立一个名为Lao的文件夹，然后在Lao中建立一个名为Bu的文件夹，然后在Bu中建立一个名为Zhang的包，最后把类放在Zhang里面。

**自建包的引用：**

1.类似c的 #include"自建文件名"，在类的第一行加上下行即表明该类属于此包	

```java
package 包名;
```

2.也可以在使用包中的类时使用 **包名.类名** 的方式

​	如：不在开头加 import Java.util.Scanner;

​	在使用时用 java.util.Scanner 即可（java.util是Scanner的类名）

### 类

**类的创建：**
1.每个成员方法在定义是前边都要加上所有类型public，private等
2.成员数据默认为public类型，前边加上private声明为私有类型

**声明属性的顺序：**

习惯上是：

~~~java
public final static void main(){}
~~~



**同类赋值：**
因为类是引用数据类型，所以赋值时赋的都是该对象在堆中的**地址**

例（假设有一个Student类）：

```java
Student a=new Student();
a.age=18;
a.point=100;

Student b=a;
b.age=20;//对b进行修改，实际上时对a和b共同指向的同一对象进行修改

System.out.print(a.age+","+b.age);//此时输出的都是20
```

**this关键字**
基本同c，this代替当前类的名字（只不过java中没有 **->**，只有 **.**）

例：

```java
public class Student
{
	int age;
	public void setStudent(int age)
	{
		this.age=age;
	}
}
```

**构造方法：**
1.基本同c，若不手动写入，则会默认一个无参构造方法，其它的构造方法都可以和c一样手动建立
2.若手动建立了带参的构造方法，则必需手动建立不带参的构造方法时才可使用（即此时不会再有默认的构造方法）
例：

```java
public class Student
{
	int age;
	public Student(){}
	public Student(int age)
	{
		this.age=age;
	}
}
```

### 标准类

![请添加图片描述](https://img-blog.csdnimg.cn/b2b69820886443e8a641d6cf9819db37.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)

### static

在类中，方法外定义时：

- 前边加上static的是声明为**类变量**或者**类方法**
- 不加static的是声明为实例变量

**类变量和实例变量：**

- 类变量：可以直接通过类名调用，也可以通过对象名调用，不需要实例化对象即可，所有的类变量都放在**静态存储区**，生命周期比对象长。**一个类变量被所有该类的实例共享**。
- 实例变量：实例变量跟随着对象，一起放在**堆**里，生命周期和对象一样长，**每个对象的实例变量都是该实例对象单独拥有。**

**类方法和实例方法：**

- 类方法：和类变量一个特性，但是类方法只能调用类变量，不能调用实例变量（因为此时可能并没有实例对象）
- 实例方法：和实例变量一个特性，实例方法即能调用类变量，又能调用实例变量

**下面是有关类和实例区别的例子：**

Main类：

~~~java
package Static理解;
public class Main {
	public static void main(String[] args) {
	    //这里有两个对象，zhang3和li4，都是在堆里的，两个对象就有两个name，也有两个age
	    //name和age是跟随实例一起放到堆里的，所以它们叫做实例变量
	    People zhang3=new People();//变量zhang3放在栈里，存储的是实例地址，该地址的对象放堆里
	    People li4=new People();//变量li放在栈里，存储的是实例地址，该地址的对象放堆里
	    
	    //通过类名调用类变量
	    System.out.println(People.PEOPLE_NUM);
	    
	    //通过对象名调用类变量
	    System.out.println(zhang3.PEOPLE_NUM);
	    
	    li4.name="li4";
	}
}
~~~

People类：

~~~java
package Static理解;
public class People {
	  //PEOPLE_NUM是一个类变量，所有的类变量都放在静态存储区，所有的people实例共享一个PEOPLE_NUM
	  static public int PEOPLE_NUM;
	  
	  //name和age都是实例变量，实例变量跟随着对象，一起放在堆里
	  public String name;//成员变量，跟对象一起，放在堆里的，生命周期和对象一样长
	  public int age;//成员变量，跟对象一起，放在堆里的，生命周期和对象一样长
	  
	  public People(){
	    People.PEOPLE_NUM=People.PEOPLE_NUM+1;
	  }
	  
}
~~~

Main中输出两个2，因为两次调用构造方法使得PEOPLE_NUM加了两次



### 一个类运用的例子

包名为 类和对象练习
包含Phone和Main两个类

**文件层级**
![请添加图片描述](https://img-blog.csdnimg.cn/e0834d737364427ba1f43e2910bd4675.png)
**Phone类**

```java
package 类和对象练习;

public class Phone {
	/**
	 * Phone的成员数据
	 */
	String brand;
	int price;
	private int productPrice;
	
	
	/**
	 * Phone的构造函数
	 */
	public Phone(){}
	public Phone(String brand,int price,int productPrice)
	{
		this.brand=brand;
		this.price=price;
		setProductPrice(productPrice);
	}
	
	
	/**
	 * 得到Phone的生产价格
	 */
	public int getProductPrice()
	{
		return productPrice;
	}
	public void setProductPrice(int productPrice)
	{
		this.productPrice=productPrice;
	}
	
	
	/**
	 * Phone基本功能
	 */
	public void sell()
	{
		System.out.println(brand);
		System.out.println(price);
	}
	public void call()
	{
		System.out.println("打电话");
	}
	public void message()
	{
		System.out.println("发短信");
	}
}

```

**Main类**

```java
package 类和对象练习;
import java.util.*;
public class Main {
	public static void main(String[] args)
	{
		Scanner cin=new Scanner(System.in);
		/**
		 * Phone a的信息输入和输出
		 */
		Phone a=new Phone();
		a.brand=cin.next();
		a.price=cin.nextInt();
		a.setProductPrice(cin.nextInt());
		
		a.sell();
		System.out.println(a.getProductPrice());
		a.call();
		a.message();
		
		System.out.println();
		
		/**
		 * Phone b的信息输入输出
		 */
		Phone b=new Phone(cin.next(),cin.nextInt(),cin.nextInt());
		b.sell();
		System.out.println(b.getProductPrice());
		b.call();
		b.message();
	}
}

```



### 类的实例化（反射机制）

类实例化有两种方法：

1. 直接new（不做过多赘述，和c一样）
2. 运用反射机制

**字节码（生成的class文件）：**

当某个类第一次出现时，JVM需要找到它的字节码，找到之后，将该类的字节码放入静态存储区

后边再次使用时，只需要去静态存储区调用即可

所以，当某个类在运行时已经出现过第一次，然后删掉该类的class文件，后边再次出现时，也可以使用这个类

**new方法：**

new方法依赖于类名,创建某个类的代码，必须在new代码之前就已经写好

即要在程序中指定类名

**反射机制：**

JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。

使用反射，代码可以不依赖于任何具体的类

**使用方法：**

主要是以下几行代码：

~~~java
Scanner reader=new Scanner(System.in);
String className=reader.nextLine();//输入类的名字，要用全名，即前边带包名
Class c=Class.forName(className);//要求虚拟机读取className类的字节码，将c赋为className类
Object o=c.newInstance();//o作为类c的实例化对象
System.out.println(o);//输出o的地址
~~~

可以发现，在代码中并没有出现要给c的类名，因此，我们c不用受到限制，可以在输入时再指定

**适用场景：**

我们将完全不知道要创建什么类型的对象，这将完全取决于使用程序的用户，我们可以在代码运行的过程中随时把字节码复制到程序目录中，然后加载它们

**运用反射机制，可以**

1. 先运行主程序
2. 然后让Scanner阻塞程序的运行
3. 此时去创建一个新的类
4. 然后可以回头将新创建的类给c

**注意：**

main方法要写成这种形式：

即加上throws Exception，否则会报错，这个先不解释

~~~java
public static void main(String[] args) throws Exception{}
~~~

## 14.Jar包

### 打包

Java程序可以打包成jar包发布

1. 在eclipse左侧想要打包的工程处右键
2. 选择export
3. 选择jar包
4. 选择Main class（Java可以从多个main类中选择一个开始）

其实质是把所选择的java代码全部生成字节码，并压缩成一个压缩包，可以使用解压软件解压，得到所有的字节码

### 运行jar包

用文本建立一个 .bat文件（脚本文件）,或者在jar的文件夹中打开cmd

输入

~~~shell
java -jar jar包名字.jar
pause //停住窗口，并且输出:  请按任意键继续...
~~~

即可运行jar包，效果和运行c++时生成的exe文件类似，生成黑框终端

### 导入jar包

在Eclipse下：

1. 右键想要导入的工程
2. Build Path
3. Add External Archives to Java Build Path
4. 选择要导入的jar包

注意：

- 要使用导入的jar包中的类时要先import导包
- 不建议导入的包中有类名和内部的包重名，此时不会报错，但是会容易混淆，此时再使用同名的方法时会使用内部的类的方法，[具体的说明](https://blog.csdn.net/weixin_34279246/article/details/89038744?ops_request_misc=&request_id=&biz_id=102&spm=1018.2226.3001.4187)
- 不能使用自己写的同名类去覆盖java自带的类，java的类加载机制不会让你成功

### Java的类加载机制

![请添加图片描述](https://img-blog.csdnimg.cn/3796090b144142baa7f99651a620700e.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_20,color_FFFFFF,t_70,g_se,x_16)

3种类加载器先后作用：

1. Bootstrap ClassLoader 负责加载Java自带的一部分类
2. Extension ClassLoader 负责加载一些Java自带的extension类型的类
3. Application ClassLoader 负责加载自己写的类

## 15.String类

**String**
同c一样，java中的String效果上相当于字符数组（char[ ]），但底层原理是字节数组（byte[ ]）

### **String构造方法**
共有4种方法

```java
1.String();//创建空字符串
2.String(char[ ] chs);//用字符数组内容创建字符串
3.String(byte[ ] bys);//用字节数组创建字符串（byte数组存储ASCII码）
4.String s="abs";//直接赋值
```

### **String对象特点**
1.通过new创建的字符串对象，不管内容如何，每一次new的对象的地址都不同，单独存储在堆内存中
例：

```java
char[] chs={'a','b','c'};
String s1=new String(chs);
String s2=new String(chs);
/**
 *s1和s2的内容相同，但是地址不同
 */ 
```

2.通过直接赋值（""）创建String对象，若内容相同，则他们的地址就相同，且都存储在常量池内
例：

```java
String s1="abc";
String s2="abc";
/**
 *在这里s1和s2的地址相同，具体上边讲数据类型时有说
 */
```

具体可以通过下图表示：
![请添加图片描述](https://img-blog.csdnimg.cn/08203a141fc64f7aa0a0599c2e119e4a.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAT2xkX1NlY3JldGFyeQ==,size_20,color_FFFFFF,t_70,g_se,x_16)
### **字符串的比较**
若直接用==进行比较，则比较的是字符串的地址是否相同
若要比较内容，则需使用equals方法

```java
char[] chs={'a','b','c'};
String s1=new String(chs);
String s2="abc";

System.out.println(s1.equals(s2));//输出结果为true
```



### StringBuffer

String和StringBuffer的区别

![请添加图片描述](https://img-blog.csdnimg.cn/c15df8340bf34debaeebf1408f9c6e09.png)

StringBuffer就是一个更强大的String

[这篇StringBuffer博客讲的很好](https://blog.csdn.net/weixin_44519467/article/details/103947361?ops_request_misc=&request_id=&biz_id=102&spm=1018.2226.3001.4187)

## 16.继承

sub class=child class

super class=parent class

**所有类的父类：**

object，该类是初始类，没有父类，不写继承关系的类都继承自object类

![请添加图片描述](https://img-blog.csdnimg.cn/74c8115bc75541ea9bf0ad30c18d0369.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_20,color_FFFFFF,t_70,g_se,x_16)



### **建立继承关系：**

- 在eclipse中创建新类时，直接选择它的superclass

- 在代码中定义类时，加上extends

  ~~~java
  public class A extends B{
      ......
  }//表示A继承自B类
  ~~~

  

### **可继承的类型：**

- 父类没有修饰关键字时，默认为package-private类型，相当于c++中的friend，

  package-private类型，只有父子类在同一个包中时才可以继承

- 父类被public或者protected修饰时

  无条件继承，无论在那个包中，都可以继承



### **上转型对象：**

父类类型（也可以是更高的辈分）的变量使用子类的对象

A是B的父类

~~~java
A a=new B();
//或者
B b=new B();A a=b;
~~~

此时A类对象a是B类对象b的上转型对象

**注意：**

1. A既可以是一般class，还可以是interface、abstract（可以参考文章：[抽象类和接口的功能与区别](http://blog.csdn.net/qq_32331073/article/details/77062666)）

2. 上转型对象不能调用子类新增的属性（就是变量一类的东西）和方法，只能调用子类**继承和隐藏的属性**，子类**继承和重写的方法**

   属性：子类中与父类同名的属性也算作子类新增属性，不能被调用。所以我们在程序中显示调用的那个同名属性事实上是属于父类的被隐藏属性，输出值当然会是父类的值

   方法：上转型对象调用的方法，要么是直接从父类那继承未被重写的方法，要么是被子类重写过的方法，不可能是隐藏方法

3. 上转型对象相对于子类对象，功能被弱化，但是能够强制转化为子类对象，从而具备子类的所有方法与属性

4. 子类对象实例被上转为父类对象，之所以还能够通过重写方法间接操作子类新增的方法与属性，是因为这个对象实例在内存中的本质还是子类类型的，只不过它的能力临时被消弱了

5. 上转型对象和原子类对象所引用的地址相同，使用==或者equals()都会返回true

6. Static静态方法属于类，能够被继承不能被重写



### overriding重写：

子类中与父类完全一样的**方法**（参数数量、类型、位置等完全一样），返回值和异常比父类小或者相同(即为父类的子类)，访问修饰符比父类大或者相同。

**该方法：**

- 子类实例调用时调用子类的
- 上转型对象调用时调用子类的

**方法不能交叉重写**：

子类实例方法不能覆盖父类的静态方法（类方法）；

子类的静态方法也不能覆盖父类的实例方法(编译时报错)



### hiding隐藏：

父类和子类拥有相同名字的**属性**或者方法（ 方法隐藏只有一种形式，就是父类和子类存在相同的**静态方法**）时，父类的同名的属性或者方法形式上不见了，实际是还是存在的。

隐藏是对于静态方法和成员变量（静态变量和实例变量）而言的

  （1）当发生隐藏的时候，声明类型是什么类，就调用对应类的属性或者方法，而不会发生动态绑定，即上转型对象依旧调用父类的属性和方法

  （2） 属性只能被隐藏，不能被覆盖

  （3）变量可以交叉隐藏：子类实例变量/静态变量可以隐藏父类的实例/静态变量



3、隐藏和重写的区别

（1）被隐藏的属性，在子类被强制转换成父类后（上转型变量），访问的是父类中的属性

​          在无强制转换时子类要访问父类的属性使用super关键字

（2）被重写的方法，在子类被强制转换成父类后（上转型变量），调用的还是子类自身的方法

​          子类要是想访问父类的方法，可以使用super关键字



**supper：**

~~~java
public class B extends A{
    int x,y;
    public static int getX(int x)
    {
        return super.x;
    }
}
//此时返回A类的x属性
~~~



### **final：**

在声明方法时加final，表示该方法无法被重写

在声明类前加final，表示该类无法被继承

~~~java
public final class B{
    ......
        public final void getA(){......};
}
~~~





## 17.多态

### 抽象类和抽象方法：

加abstract修饰：

~~~java
abstract public class A{
    abstract public void X();
    abstract public void Y();
    abstract public void Z();
}
~~~

都不用写代码，类似c++的virtual类，用来继承，构成一个框架，可以被子类重写

**注意：**

1. 抽象类不能用new创建实例

2. 可以使用**反射**和上转型对象创建实例

   ~~~java
   //DMFrame是抽象类
   //输入的className类是DMFrame类的后代类
   
   Scanner reader=new Scanner(System.in);
   String className=reader.nextLine();
   Class c=Class.forName(className);
   DMFrame dm=(DMFrame)c.newInstance();
   
   if(!(dm instanceof DMFrame))//没有创建成功
       return;
   ~~~

   

抽象类可以通过反射来上转型不同的子类，由此说抽象类可以作为一个框架，让子类去重写它。



**一个例子：**

Luncher 类（程序入口类）

~~~java
package edu.neuq.DM;
import java.util.Scanner;
public class Luncher {
	public static void main(String[] args) throws Exception {
		//DMFrame dm=new DMFrame();//抽象类不允许实例化，不允许使用new来创建DMFrame实例
		
		Scanner reader=new Scanner(System.in);
		String className=reader.nextLine();
		Class c=Class.forName(className);
		DMFrame dm=(DMFrame)c.newInstance();
		if(!(dm instanceof DMFrame))
			return;
			
		dm.clean();//第一步，清洗
		dm.train();//第二步,训练
		dm.test();//第三步，测试
	}
}
~~~

DMFrame类（抽象类）

~~~java
package edu.neuq.DM;
public abstract class DMFrame {//作为框架的类
	abstract public void clean();
	abstract public void train();
	abstract public void test();
}
~~~

DT类（用来重写抽象类的子类）

~~~java
package edu.neuq.DM;

final public class DT extends DMFrame {//基于决策树的一系列数据挖掘方法

	@Override//加上表示下边是重写，不加也行，但是加了规范
	public void clean() {
		System.out.println("使用DT做了一些数据清洗工作");
	}

	@Override
	public void train() {
		System.out.println("用决策树训练了一个模型");
	}

	@Override
	public void test() {
		System.out.println("对决策树模型进行了测试");
	}
}

~~~



运行时输入：

​	edu.neuq.DM

输出：

​	使用DT做了一些数据清洗工作

​	用决策树训练了一个模型

​	对决策树模型进行了测试





### 接口

接口和抽象类类似，在编译时也会生成字节码

接口中的方法都为抽象方法，等待**实现类**（性质和子类一样）去实现（通过重写去实现）

**接口的创建：**

直接在左侧new里边选择interface即可

**接口的实现：**

1. 在创建类时，给它选择加入的接口，即可使该类的作用是实现该接口

2. 自己打上代码（在1.中eclipse自动生成了）

   ~~~java
   public class A implements B//表示类A实现接口B
   {
   	//重写的代码
   }
   ~~~



**接口和抽象类的区别：**

- 一个子类就是一个父类，只不过比父类多加了些东西
  - 一个类只能有一个父类
- 一个子类的作用是去实现接口
  - 一个类可以实现多个接口



**接口回调：**

类似上转型对象

~~~java
A a=new B();
//A是接口，B是实现A的类
~~~

- a可以调用接口中的方法（已经被B类重写）
- a不可以调用B类中新增的方法



**默认方法：**

在接口设计完成后，一般就不在对其进行修改，因为此举会引起实现类的错误

比如在写好接口和实现类后，如果在接口中增加一个新的方法，则实现类就会报错，必须在实现类中把新增的方法也给重写了

- 若有时不得不添加，则最好添加默认方法

  ~~~java
  default public void A()
  {
      //方法的代码
  }
  ~~~

  此默认方法必须有方法体，且方法的实现即可以写在接口中，也可以由实现类去重写

  此方法即使没有被实现类重写，也不会报错

- 原则：写好的代码只添加，不修改



### 内部类（嵌入类）

**优点：**

- 可读性好
- 封装性好



**定义：**

在类中定义的类，可用static修饰



**特性：**

- 外部类不能调用内部类的方法
- 内部类可以调用外部类的方法



内部类也会生成单独的字节码，并命名为：

​	外部类名$内部类名.class



**使用方法：**

在外部类中创建一个内部类的对象，则可以通过该对象调用

例：

~~~java
//People类中
public Arm arm=new Arm();
class Arm
{
    public void left(){};
}


//Main类中
People p=new People();
p.arm.left();
~~~



**声明static直接使用：**

若内部类声明为static，则可以在Main中直接创建

创建方式为：外类.内类 A=new 外类.内类();

~~~java
//People类中
static class Leg
{
    public void left(){};
}


//Main类中
People.Leg l=new People.Leg();
l.left();
~~~





### 匿名类

在Java中可以起到类似函数指针的作用

也会生成字节码，按顺序命名为

- 外类$1.class
- 外类$2.class
- ......



**使用方法：**

在创建对象时写类的代码

- 通过接口创建匿名类

  ~~~java
  //call接口
  public interface call {
  	public void calling();
  }
  
  //Main类
  public class Main {
  	public static void move1(call a)
  	{
  		System.out.println("move1...");
  		a.calling();
  	}
  	
  	public static void main(String[] args) {
  
  		move1(new call(){//用法1，作为方法的参数
  			@Override
  			public void calling()
  			{
  				System.out.println("calling...");
  			}
  		});
          
          call a=new call(){//用法2，创建实例
  			@Override
  			public void calling() {
  				System.out.println("calling2...");
  			}
  		};
  		
  		a.calling();
  
  	}
  }
  ~~~

- 通过接口创建匿名类

  用法基本同接口一样





## 18.异常

### **异常类**

Throwable类是所有异常类的祖先

Throwable是Object的子类

![请添加图片描述](https://img-blog.csdnimg.cn/e5f09be8b7634f05ae176c44204585ee.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_17,color_FFFFFF,t_70,g_se,x_16)

### **异常的种类**

- Error类
- RuntimeException类
- 其他异常类



**Error：**

- 大部分是硬件错误
- 内存泄漏
- 爆内存（数组开的太大了）



**RuntimeException：**

运行时发生的错误，大部分由程序员引起

例：

1. int a=100/0;
2. Class c=Class.forName("");
   - 这里""中间不填写东西，是一定有RuntimeException中的ClassNotFoundException异常
   - 若填写了一个正确的类名，若不在声明类时加上throw ClassNotFoundException，则仍旧会报错，因为JVM认为这里可能会出错



**throw：**

抛出异常

例：

~~~java
throw ClassNotFoundException
~~~

- 表示该方法可能会有ClassNotFoundException这个异常，先抛出，不让JVM报错
- 在某方法加上这句，会把异常抛给上一级方法（调用当前方法的方法）
- 最后会一直抛到main方法，然后main方法在抛给JVM



### **异常的捕获和处理**

- Try block                必选
- Catch block           必选
- Finally block          可选



**使用方法：**

```java
try{
    //可能发生异常的代码
    Class c=Class.forName("Lao.Bu.zhang.People");
    Object o=c.newInstance();
    System.out.println(o);
}catch(ClassNotFoundException e){//可能发生的异常类1
    //处理异常1的代码
    e.printStackTrace();//打印出异常信息
}catch(InstantiationException e){//可能发生的异常类2
    //处理异常2的代码
    e.printStackTrace();//打印出异常信息
}catch (IllegalAccessException e) {//可能发生的异常类3
    //处理异常3的代码
	e.printStackTrace();//打印出异常信息
}
//后边还可以继续写catch
```

使用try catch对异常进行捕获和处理后后边正常的代码仍然可以执行（用throw的话不会再向后执行）



**自建异常类：**

1. 建立新类时选择父类为Exception即可
2. 建类后加上extends Exception



**自建类的使用：**

1. 先在对应的方法中写出异常的情况
2. 在使用该方法时用try-catch语句对异常进行检测和处理



People类：

~~~java
package Lao.Bu.Exception;
public class People {
	public int age;
	public People(int age) throws AgeException {
		if(age>100||age<0) {//异常的情况
			AgeException e=new AgeException();
			e.age=age;
			throw e;//将异常抛出
		}
		this.age=age;
	}
}
~~~

Main类：

~~~java
package Lao.Bu.Exception;
public class Main {
	public static void main(String[] args) {
		try {
			People p=new People(-1);
			System.out.println("age is "+p.age);
		} catch (AgeException e) {
			System.out.println("年龄异常"+e.age);
			e.printStackTrace();
		}
	}
}
~~~



**finally语句：**

位置和catch一样

无论前边是否发生异常，finally语句中的代码都会执行

若前边有return，finally也会执行

若前边有System.exit(0)（退出程序），则finally不会再执行





## 19.lambda表达式

Lambda表达式是Java SE 8中一个重要的新特性。lambda表达式允许你通过表达式来代替功能接口。 

lambda表达式就和方法一样,它提供了一个正常的参数列表和一个使用这些参数的主体(body,可以是一个表达式或一个代码块)。

 Lambda 表达式可以看作是一个匿名函数。

Lambda用来对接口中的唯一一个方法进行重写

### 基础语法
基本语法: (参数列表) -> 表达式 或 (参数列表) ->{ 代码语句 }

Lambda表达式由三部分组成：

1.paramaters：类似方法中的形参列表，这里的参数是函数式接口里的参数。这里的参数类型可以明确的声明 也可不声明而由JVM隐含的推断。另外当只有一个推断类型时可以省略掉圆括号。
2.->：可理解为“被用于”的意思
3.方法体：可以是表达式也可以代码块，是函数式接口里方法的实现。代码块可返回一个值或者什么都不反 回，这里的代码块块等同于方法的方法体。如果是表达式，也可以返回一个值或者什么都不反回。

~~~java
// 1. 不需要参数,返回值为 2
() -> 2

// 2. 接收一个参数(数字类型),返回其2倍的值
x -> 2 * x

// 3. 接受2个参数(数字),并返回他们的和
(x, y) -> x + y

// 4. 接收2个int型整数,返回他们的乘积
(int x, int y) -> x * y

// 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void) 
(String s) -> System.out.print(s)
~~~



### 函数式接口：
要了解Lambda表达式,首先需要了解什么是函数式接口，函数式接口定义：一个接口有且只有一个抽象方法 。
注意：

1. 如果一个接口只有一个抽象方法，那么该接口就是一个函数式接口

2. 如果我们在某个接口上声明了 注解，那么编译器就会按照函数式接口的定义来要求 该接口，这样如果有两个抽象方法，程序编译就会报错的。所以，从某种意义上来说，只要你保证你的接口中只有一个抽象方法，你可以不加这个注解。加上就会自动进行检测的。

   

**函数式接口定义方法：**


~~~java
@FunctionalInterface
interface NoParameterNoReturn {
//注意：只能有一个方法
	void test();
//可以加其他的default方法
    default void test2() {
		System.out.println("JDK1.8新特性，default默认方法可以有具体的实现");
	}
}
~~~



### Lambda表达式的基本使用

首先，我们实现准备好几个接口：

~~~java
//无返回值无参数
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}
//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(int a,int b);
}
    //有返回值无参数
@FunctionalInterface interface NoParameterReturn {
    int test();
}
//有返回值一个参数
@FunctionalInterface interface OneParameterReturn {
    int test(int a);
}
//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn { 
    int test(int a,int b);
}
~~~



我们在上面提到过，**Lambda表达式本质是一个匿名函数**，函数的方法是：**返回值** **方法名** **参数列表** **方法体**。在**Lambda表达式**中我们只需要关心：**参数列表 方法体**。
具体使用见以下示例代码：

~~~java
public class TestDemo {
    public static void main(String[] args) {
        NoParameterNoReturn noParameterNoReturn = () -> {
            System.out.println("无参数无返回值");
        };
        
        noParameterNoReturn.test();
        OneParameterNoReturn oneParameterNoReturn = (int a) -> {
            System.out.println("无参数一个返回值：" + a);
        };
        oneParameterNoReturn.test(10);
        
        MoreParameterNoReturn moreParameterNoReturn = (int a, int b) -> {
            System.out.println("无返回值多个参数：" + a + " " + b);
        };
        moreParameterNoReturn.test(20, 30);
        NoParameterReturn noParameterReturn = () -> {
            System.out.println("有返回值无参数！");
            return 40;
        };
        //接收函数的返回值
        int ret = noParameterReturn.test();
        System.out.println(ret);
        OneParameterReturn oneParameterReturn = (int a) -> {
            System.out.println("有返回值有参数！");
            return a;
        };

        ret = oneParameterReturn.test(50);
        System.out.println(ret);

        MoreParameterReturn moreParameterReturn = (int a, int b) -> {
            System.out.println("有返回值多个参数！");
            return a + b;
        };
        ret = moreParameterReturn.test(60, 70);
        System.out.println(ret);
    }
}
~~~



**语法精简**

1. 参数类型可以省略，如果需要省略，每个参数的类型都要省略。
2. 参数的小括号里面只有一个参数，那么小括号可以省略
3. 如果方法体当中只有一句代码，那么大括号可以省略
4. 如果方法体中只有一条语句，其是return语句，那么大括号可以省略，且去掉return关键字。



举例

~~~java
public static void main(String[] args) {
    MoreParameterNoReturn moreParameterNoReturn = (a, b) -> {
        System.out.println("无返回值多个参数，省略参数类型：" + a + " " + b);
    };
    moreParameterNoReturn.test(20, 30);

    OneParameterNoReturn oneParameterNoReturn = a -> {
        System.out.println("无参数一个返回值,小括号可以省略：" + a);
    };
    oneParameterNoReturn.test(10);

    NoParameterNoReturn noParameterNoReturn = () ->
            System.out.println("无参数无返回值，方法体中只有一行代码");
    noParameterNoReturn.test();

    //方法体中只有一条语句，且是return语句
    NoParameterReturn noParameterReturn = () -> 40;
    int ret = noParameterReturn.test();
    System.out.println(ret);
}
~~~





## 20.线程

**程序**：是为完成特定任务，用某种语言编写的一组指令的集合，即指一段静态的代码，静态对象。
**进程**：是程序的一次执行过程，或是正在运行的一个程序，是一个动态的过程，有它自身的产生，存在和消亡的过程。-------生命周期
**线程**：进程可进一步细化为线程，是一个程序内部的一条执行路径



### 创建线程的方式

- 继承自Thread类

  1. 创建一个继承自Thread的新类
  2. 重写Thread中的run方法
  3. 在main方法中创建该新类的对象
  4. 调用该对象的start方法

  ~~~java
  //创建的子类
  public class MyThread extends Thread{
      @Override
      public void run(){
          //要执行的代码
      }
  }
  
  //方法中
  MyThread my=new MyThread();
  my.start();//启动一个线程并运行其run方法
  ~~~

- 实现Runnable接口

  1. 创建一个实现Runnable的类
  2. 实现run方法
  3. 在main方法中创建该新类的对象
  4. 将此对象作为参数传递到Thread类中的构造器中，创建Thread类的对象
  5. 通过Thread类的对象调用start（）
  
- 使用SWingWorker

  ~~~java
  SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
  	@Override
  	protected Void doInBackground() throws Exception {
  		// Simulate doing something useful.
      	for (int i = 0; i <= 10; i++) {
  			Thread.sleep(1000);
      		System.out.println('Running ' + i);
      	}
      	return null;
  	}
  };
  worker.execute();
  ~~~

  



**比较创建线程的两种方式：**
开发中，优先选择实现Runnable接口的方式
原因：

1. 实现的方式没有类的单继承性的局限性

2. 实现的方式更适合用来处理多个线程有共享数据的情况

   

联系：Thread也是实现自Runnable，两种方式都需要重写run()方法，将线程要执行的逻辑声明在run中



### Sleep(int a)

使线程暂停a毫秒再继续执行

~~~java
try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
~~~



### synchronized

- 声明在方法前，表示该方法同时只能被一个线程调用，禁止多个线程同时访问

  ~~~java
  synchronized static public show(){}//show禁止多个线程同时访问
  ~~~

- 包裹住代码块，表示该代码块禁止多个线程同时访问



## 21.GUI

类库Swing提供了3种顶级容器（窗口）类

- JFrame
- JDialog
- JApplet



控件都是JComponent的子类



### 窗口的创建

1. 直接实例化JFrame

   ~~~java
   JFrame jf=new JFrame();
   ~~~

2. 创建新类继承JFrame

   

### 窗口的属性设置

~~~java
this.setLayout(new FlowLayout());//设置控件的排列方式

		
this.setTitle("this is frame");//设置窗口标题
this.setSize(500,400);//设置窗口大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口的退出方式
this.setVisible(true);//使窗口可视
~~~



### 控件

**常用控件：**

- **JMenuBar**    菜单条，在标题条下边的菜单条，JMenuBar 类根据 JMenu 添加的顺序从左到右显示，并建立整数索引。
- **JMenu**    菜单，JMenuBar种并无菜单，需要用add方法添加菜单
- **JMenuItem**    菜单项，菜单种并没有东西，需要用add方法在JMenu中添加菜单项
- **JPanel**    面板控件，相当于小窗口，可以将多个控件添加在JPanel里边，然后整体操作
- **JButton**    按钮，可以用listener执行事件
- **JTextField**    文本框，可以输入或者写入文本
- **JTexArea**    文本区，可以写入多行
- **JLabel**    标签，可以写入文本
- **JCheckBox**    选择框，
- **JRadioButton**    单项选择框，
- **JComboBox**    下拉列表，
- **JPasswordField**    密码框，



**控件的添加：**

- 对于JMenuBar，使用setJMenuBar方法

  ~~~java
  this.setJMenuBar(jmb);//jmb是一个JMenuBar的实例
  ~~~

- 对于其他控件,都使用add方法

  ~~~java
  this.add(控件实例);
  ~~~



**一个例子：**

~~~java
package Lao.Bu.zhang;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class LayoutShowMain extends JFrame{

	public LayoutShowMain() {
		
		this.setLayout(new FlowLayout());
		
		this.add(this.getPanel1());
		this.add(this.getPanel2());
		this.add(this.getPanel3());
		
		this.setSize(300,200);
		this.setTitle("Eclipse");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public JPanel getPanel1() {
		JPanel jp=new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(new JButton("button1"));
		jp.add(new JButton("button2"));
		jp.add(new JButton("button3"));
		return jp;
	}
	
	public JPanel getPanel2() {
		JPanel jp=new JPanel();
		jp.setLayout(new GridLayout(3,2));
		jp.add(new JButton("1"));
		jp.add(new JButton("2"));
		jp.add(new JButton("3"));
		jp.add(new JButton("4"));
		jp.add(new JButton("5"));
		jp.add(new JButton("6"));
		return jp;
	}
	
	public JPanel getPanel3() {
		JPanel jp=new JPanel();
		jp.setLayout(new BorderLayout());
		jp.add(new JButton("north"),BorderLayout.NORTH);
		jp.add(new JButton("west"),BorderLayout.WEST);
		jp.add(new JButton("east"),BorderLayout.EAST);
		jp.add(new JButton("south"),BorderLayout.SOUTH);
		jp.add(new JButton("okey"),BorderLayout.CENTER);
		return jp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LayoutShowMain lsm=new LayoutShowMain();
	}

}
~~~



### 按钮事件

用匿名方法对按钮的addActionListener方法进行重写，以实现点击按钮执行事件

~~~java
jb.addActionListener(new ActionListener() {//jb使一个按钮实例
    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        //要执行的事件
    }
});
~~~





## 22.IO流文件操作

### 文件的打开

(FileOpen)

建立File类的实例，并且构造方法写入路径（相对/绝对）

打开的文件可以是文件夹或者合法文件

~~~java
File f=new File("E:\\codes");//分割符要用双\
~~~

**几种常用方法：**

~~~java
System.out.println(f.getName());//文件名
System.out.println(f.isFile());//是否是合法文件
System.out.println(f.exists());//是否存在
System.out.println(f.isDirectory());//是否是文件夹
System.out.println(f.isAbsolute());//是否是绝对路径
f.delete();//删除打开的文件，不要对有用的文件使用，会真的删掉文件，并且不会进入回收站

String[] name=f.list();
for(String s:name)
{
    System.out.println(s);
}//得到文件列表并输出
~~~



### 字节流

**输入流：**

FileInputStream类，从文件读入

常用方法：

- read(byte数组);

  顺序读取（即下一次读取从上一次读取的结束位置开始），每次读的长度为byte数组长度，并且将读入的东西都赋值给byte数组，返回值为读的长度，若读到末尾了则返回-1

**输出流：**

FileOutputStream类，向文件输出

常用方法：

- write(byte数组,起始位置,写入长度);

  将byte数组写入打开的文件



**例子：**

~~~java
package Lao.Bu.zhang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOStream {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("IStream.txt");//可填路径，也可填File实例，但是需要自己事先创建
		//从文件读入
		
		FileOutputStream fos=new FileOutputStream("OStream.txt");//运行后会自动生成
		//向文件输出
		
		byte[] buffer=new byte[1024];
		int i;
		StringBuffer sb=new StringBuffer();
		while((i=fis.read(buffer))!=-1) {//read顺序读取，每次读的长度为1024，并且将读入的东西都赋值给buffer，返回值为都的长度，若读到末尾了则返回-1
			String s=new String(buffer,0,i);//写入，从buffer[0]开始，长度为i
			System.out.println(i);
			
			sb.append(s);
			fos.write(buffer,0,i);
		}
		//System.out.println(sb.toString());
		
		fis.close();
		fos.close();
		
	}
}

~~~





### Object流

和字节流类似，对应的类分别为ObjectOutputStream和ObjectInputStream，对应的方法分别为readObject和writeObject

**注意：**

- Object流是高级流，需要建立在字符流的基础上
- 若想将某一个类写入文件，则对应的类需要实现Seriable接口，表示该类可被序列化



**例子：**

ObjectStream类：

~~~java
package Lao.Bu.zhang;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStream {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		FileOutputStream fos=new FileOutputStream("ObOStream.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		Person p=new Person();
		p.age="19";
		p.name="LaoBuzhang";
		
		oos.writeObject(p);
		
		fos.close();
		oos.close();
		
		
		
		FileInputStream fis=new FileInputStream("ObOStream.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		Person p1=(Person)ois.readObject();
		System.out.println(p1.name);
		System.out.println(p1.age);
		
		fis.close();
		ois.close();
	}

}
~~~

Person类：

~~~java
package Lao.Bu.zhang;

import java.io.Serializable;

public class Person implements Serializable{

	public String name;
	public String age;
}

~~~



### 字符流

和字节流类似，对应的类分别为FileReader和FileWriter，对应的方法分别为read和write



**字节流和字符流的区别：**

字节流是以字节为单位进行操作的，而字符流是以字符为单位进行操作的。 

我们都知道一个英文字母占一个字节，一个中文汉字占两个字节，而一个英文字母与一个中文汉字我们都称之为一个字符，所以说我们要根据文件中所存储的数据内容的不同而选择不同的操作方法。 

使用字节流存储中文时会出现问题



**例子：**

~~~java
package Lao.Bu.zhang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class CharStream {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileReader fr=new FileReader("FR.txt");
		FileWriter fw=new FileWriter("FW.txt");
		
		char[] buffer=new char[1024];
		int i;
		StringBuffer sb=new StringBuffer();

		while((i=fr.read(buffer))!=-1){
			String s=new String(buffer,0,i);
			sb.append(s);
			fw.write(buffer, 0, i);
		}
		System.out.println(sb.toString());
		fr.close();
		fw.close();
	}

}

~~~



**写出的汉字是乱码：**

更改运行时的编码模式：

 在需要更改的项目代码空白处右键---------RunAS--------------Run Configurations...------------Common---------Encoding中改为“GBK”或者“UTF-8”

实测改成UTF-8可解决







## 23.网络编程

**主机名：**

就是网址：例如www.baidu.com

**IP地址：**

由4个0-255的数字组成，中间用.隔开

例如：123.34.32.111

**端口号：**

在某个IP地址中程序的编号，唯一标识计算机上的程序，是一个0-65535的数字

### InetAddress类

该类代表ip地址，下面还有两个子类，分别是Inet4Address和Inet6Address他们分别代表IPV4地址和IPV6地址



可以使用IP地址创建InetAddress对象(getByName，getAllByName，getByAddress方法都可以通过IP地址创建InetAddress对象)



**通过主机名的到全名（主机名+ip地址）**

~~~java
package Lao.Bu.zhang;

import java.net.InetAddress;

public class IPLuncher {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		InetAddress[] names=InetAddress.getAllByName("www.baidu.com");
		for(InetAddress name:names) {
			System.out.println(name);
		}
	}
}
~~~





### Socket

socket=ip+port number（端口号）

中间用:隔开

例如：123.34.32.111:80



通过socket可以唯一定位互联网上的进程:

1. 通过ip找到主机
2. 通过端口号找到该主机上的程序



Socket是标准计算机通讯程序接口



**使用要求：**

socket是同步通信，双方必须同时在线，两个socket同时运行

（异步通讯，可以只有一方在线，如qq）



**服务器端：**

用ServerSocket类

- 可以为当前程序指定一个端口号

  ~~~java
  ServerSocket sc=new ServerSocket(10087);//当前程序的端口好被设置为10087
  ~~~

- 可以接收客户端的连接请求

  ~~~java
  Socket socket=sc.accept();//accept是阻塞的方法，直到有客户端连接，accept会返回一个Socket
  ~~~

  

**客户端：**

客户端就用Socket类

请求连接服务器端：

~~~java
Socket socket=new Socket("localhost",10087);//引号内填写服务器端的IP,localhost代表本地IP,后边填写要连接的服务器端口号
~~~



**服务器端和客户端之间的通信：**

可以使用输入输出流互相接受和发送信息

Socket的输入输出流方法：

客户端上的使用：

1. getInputStream方法可以得到一个输入流，客户端的Socket对象上的getInputStream方法得到输入流其实就是从服务器端发回的数据。
2. getOutputStream方法得到的是一个输出流，客户端的Socket对象上的getOutputStream方法得到的输出流其实就是发送给服务器端的数据。

服务器端上的使用：

1. getInputStream方法得到的是一个输入流，服务端的Socket对象上的getInputStream方法得到的输入流其实就是从客户端发送给服务器端的数据流。

2. getOutputStream方法得到的是一个输出流，服务端的Socket对象上的getOutputStream方法得到的输出流其实就是发送给客户端的数据。

   

以上方法返回的都是InputStream或者OutputStream，创建这两个类的实例，并用以上方法为实例赋值，就可以得到信息的流

~~~java
InputStream is=socket.getInputStream();
OutputStream os=socket.getOutputStream();
~~~



**实例：**

要求实现服务器端和客户端之间的通信，两者可以轮流发送一条讯息



Server类：

~~~java
package Lao.Bu.zhang;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub

		ServerSocket sc=new ServerSocket(10087);
		System.out.println("server start!");
		
		Socket socket=sc.accept();
		System.out.println("client is coming");
		
		InputStream is=socket.getInputStream();
		OutputStream os=socket.getOutputStream();
		
		Scanner cin=new Scanner(System.in);
		
		while(true) {
			byte[] buffer1=new byte[1024];//服务端先接收一条消息
			int i=is.read(buffer1);
			String s=new String(buffer1,0,i);
			System.out.println(s);
			
			
			
			System.out.println("input:");
			
			String s1=cin.nextLine();//服务端再发送一条信息
			byte[] buffer2=s1.getBytes();
			os.write(buffer2);
		}
	}

}
~~~



Client类：

~~~java
package Lao.Bu.zhang;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Socket socket=new Socket("localhost",10087);
		InputStream is=socket.getInputStream();
		OutputStream os=socket.getOutputStream();
		System.out.println("client start and connect to server!");
		
		Scanner cin=new Scanner(System.in);
		
		while(true) {
			System.out.println("input:");//客户端先发送一条消息
			
			String s=cin.nextLine();
			byte[] buffer1=s.getBytes();
			os.write(buffer1);
			
			
			
			byte[] buffer2=new byte[1024];//客户端再接受一条消息
			int i=is.read(buffer2);
			String s2=new String(buffer2,0,i);
			System.out.println(s2);
		}
		
	}

}
~~~





### RMI

[RMI详解](https://blog.csdn.net/xinghun_4/article/details/45787549?ops_request_misc=%7B%22request%5Fid%22%3A%22165163541916782391833249%22%2C%22scm%22%3A%2220140713.130102334.pc%5Fall.%22%7D&request_id=165163541916782391833249&biz_id=0&spm=1018.2226.3001.4187)

**定义：**

RMI（Remote Method Invocation）为远程方法调用，是允许运行在一个Java虚拟机的对象调用运行在另一个Java虚拟机上的对象的方法。 这两个虚拟机可以是运行在相同计算机上的不同进程中，也可以是运行在网络上的不同计算机中。



**RMI构成：**

1. 第一个是RMIService即JDK提供的一个可以独立运行的程序（bin目录下的rmiregistry）

2. 第二个是RMIServer即我们自己编写的一个java项目，这个项目对外提供服务

3. 第三个是RMIClient即我们自己编写的另外一个java项目，这个项目远程使用RMIServer提供的服务。



**RMI过程：**

1. 首先，RMIService必须先启动并开始监听对应的端口。
2. 其次，RMIServer将自己提供的服务的实现类注册到RMIService上，并指定一个访问的路径（或者说名称）供RMIClient使用。
3. 最后，RMIClient使用事先知道（或和RMIServer约定好）的路径（或名称）到RMIService上去寻找这个服务，并使用这个服务在本地的接口调用服务的具体方法。



**详细过程：**

1. 首先，在一个JVM中启动rmiregistry服务，启动时可以指定服务监听的端口，也可以使用默认的端口。
2. 其次，RMIServer在本地先实例化一个提供服务的实现类，然后通过RMI提供的Naming，Context，Registry等类的bind或rebind方法将刚才实例化好的实现类注册到RMIService上并对外暴露一个名称。
3. 最后，RMIClient通过本地的接口和一个已知的名称（即RMIServer暴露出的名称）再使用RMI提供的Naming，Context，Registry等类的lookup方法从RMIService那拿到实现类。这样虽然本地没有这个类的实现类，但所有的方法都在接口里了，想怎么调就怎么调吧。



**注意：**
值得注意的是理论上讲RMIService，RMIServer，RMIClient可以部署到3个不同的JVM中，这个时候的执行的顺序是RMIService---RMIServer—RMIClient。另外也可以由RMIServer来启动RMIService这时候执行的顺序是RMIServer—RMIService—RMIClient。

实际应用中很少有单独提供一个RMIService服务器，开发的时候可以使用Registry类在RMIServer中启动RMIService。





**实例：**

文件结构：（Content类是有两个int型成员变量s1和s2的普通类，就不再写出）

![请添加图片描述](https://img-blog.csdnimg.cn/706de85cdb44442986a23fa31085cb59.png)





1. 定义一个远程接口：FaultDetection类（两个project中的这个类一样）

   ~~~java
   package Lao.Bu.zhang;
   
   
   /* 
    * 在Java中，只要一个类extends了java.rmi.Remote接口，即可成为存在于服务器端的远程对象，供客户端访问并提供一定的服务。
    * JavaDoc描述：Remote 接口用于标识其方法可以从非本地虚拟机上调用的接口。任何远程对象都必须直接或间接实现此接口。
    * 只有在“远程接口” （扩展 java.rmi.Remote 的接口）中指定的这些方法才可被远程调用。 
    */
   
   
   import java.rmi.Remote;
   import java.rmi.RemoteException;
   
   public interface FaultDetection extends Remote{
   	
       
   　　　　//extends了Remote接口的类或者其他接口中的方法若是声明抛出了RemoteException异常，则表明该方法可被客户端远程访问调用。
   
   	public boolean detect(Content c) throws RemoteException;
   
   }
   
   ~~~

2. 远程接口实现类：FaultDetectionlmpl类

   ~~~java
   package Lao.Bu.zhang;
   
   import java.rmi.RemoteException;
   import java.rmi.server.UnicastRemoteObject;
   
   
   /*
    * 远程对象必须实现java.rmi.server.UniCastRemoteObject类，这样才能保证客户端访问获得远程对象时，
    * 该远程对象将会把自身的一个拷贝以Socket的形式传输给客户端，此时客户端所获得的这个拷贝称为“存根”（Stub），
    * 而服务器端本身已存在的远程对象则称之为“骨架”（Skeleton）。其实此时的存根是客户端的一个代理，用于与服务器端的通信，
    * 而骨架也可认为是服务器端的一个代理，用于接收客户端的请求之后调用远程方法来响应客户端的请求。
    */ 
    
   
   /* java.rmi.server.UnicastRemoteObject构造函数中将生成stub和skeleton */
   public class FaultDetectionlmpl extends UnicastRemoteObject implements FaultDetection{
   
       
       // 这个实现必须有一个显式的构造函数，并且要抛出一个RemoteException异常
   	protected FaultDetectionlmpl() throws RemoteException {
   		super();
   	}
   
   	@Override
   	public boolean detect(Content c) throws RemoteException {
   		// TODO Auto-generated method stub
   		System.out.println("be called");
   		if(c.s1+c.s2>100)return true;
   		else return false;
   	}
   
   	
   }
   
   ~~~

3. 服务端：Server类

   ~~~java
   package Lao.Bu.zhang;
   
   import java.rmi.Naming;
   import java.rmi.registry.LocateRegistry;
   import java.rmi.registry.Registry;
   
   
   /* 注册远程对象,向客户端提供远程对象服务 
    * 远程对象是在远程服务上创建的，你无法确切地知道远程服务器上的对象的名称
    * 但是，将远程对象注册到RMI Service之后，客户端就可以通过RMI Service请求
    * 到该远程服务对象的stub了，利用stub代理就可以访问远程服务对象了
    */
   
   
   public class Server {
   
   	public static void main(String[] args) throws Exception{
   		// TODO Auto-generated method stub
   
   		Registry registry=LocateRegistry.createRegistry(10086);
               /* 本地创建并启动RMI Service，被创建的Registry服务将在指定的端口上侦听到来的请求 
                * 实际上，RMI Service本身也是一个RMI应用，我们也可以从远端获取Registry:
                *     public interface Registry extends Remote;
                *     public static Registry getRegistry(String host, int port) throws RemoteException;
                */
           
           
   		FaultDetection fd=new FaultDetectionlmpl();//在本地先实例化一个提供服务的实现类，生成stub和skeleton,并返回stub代理引用
   
   
   		Naming.bind("rmi://localhost:10086/fd",fd);//将fd注册到RMIService上并对外暴漏一个名称，将stub代理（fd）绑定到Registry服务的URL上
           
   		System.out.println("Start up rmi server");
   	}
   
   }
   
   ~~~

4. 客户端：Client类

   ~~~java
   package Lao.Bu.zhang;
   
   import java.rmi.Naming;
   
   /* 客户端向服务端请求远程对象服务 */
   public class Client {
   
   	public static void main(String[] args) throws Exception{
   		// TODO Auto-generated method stub
   
   		FaultDetection fd=(FaultDetection)Naming.lookup("rmi://localhost:10086/fd");
           /* 从RMI Registry中请求stub
            * 如果RMI Service就在本地机器上，URL就是：rmi://localhost:1099/hello
            * 否则，URL就是：rmi://RMIService_IP:1099/hello
            */
           
           
   		
   		Content c=new Content();
   		c.s1=11;
   		c.s2=13;
   		System.out.println(fd.detect(c));//通过stub调用远程接口实现
   	}
   
   }
   
   ~~~

   







## 24.容器

[JAVA容器分类](https://blog.csdn.net/weixin_42574142/article/details/87125363?ops_request_misc=%7B%22request%5Fid%22%3A%22165164543816780357211844%22%2C%22scm%22%3A%2220140713.130102334.pc%5Fall.%22%7D&request_id=165164543816780357211844&biz_id=0&spm=1018.2226.3001.4187)

[Java容器常用方法](https://blog.csdn.net/a2011480169/article/details/52047600?ops_request_misc=%7B%22request%5Fid%22%3A%22165164543816780357211844%22%2C%22scm%22%3A%2220140713.130102334.pc%5Fall.%22%7D&request_id=165164543816780357211844&biz_id=0&spm=1018.2226.3001.4187)

类比C++的STL库，但是包含内容有所不同

可以使用迭代器进行数据访问，比循环快，而且占用内存小



例子：

~~~java
package 容器;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class arrayList{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List al=new ArrayList();
		al.add("ab");
		al.add("cd");
		al.add("ef");
		al.add(10000);
		al.add(3.1415926535897);
		
		System.out.println(al.get(1));
		
		Iterator itr=al.iterator();
		while(itr.hasNext()) {
			Object s=itr.next();
			System.out.println(s);
		}
	}

}

~~~







## 25.泛型

[java 泛型详解](https://blog.csdn.net/s10461/article/details/53941091?ops_request_misc=%7B%22request%5Fid%22%3A%22165166498016781683919923%22%2C%22scm%22%3A%2220140713.130102334.pc%5Fall.%22%7D&request_id=165166498016781683919923&biz_id=0&spm=1018.2226.3001.4187)

泛型，即“参数化类型”。就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参）。



例子：

~~~java
package 泛型;

public class G<e,f> {

	public e a;
	public f funcA(e input1,f input2) {
		return input2;
	}
	
	
	public static void main(String[] args) {
		G<String,Integer> g=new G<String,Integer>();
		int a=g.funcA("lao", 3);
		System.out.println(a);
	}
}

~~~

