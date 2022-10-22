---
title: CSS3学习笔记
date: 2022-03-14 23:20:35
tags: 
     - CSS3
     - 前端
---

# CSS学习笔记

CSS3主要用来美化网页，给标签添加一些属性，也可以制作简单动画

<!--more-->

## 1、什么是CSS

如何学习

​	1.CSS是什么

​	2.CSS怎么用

​	3.**CSS选择器（终点+难点）**

​	4.美化网页（文字，阴影，超链接，列表，渐变……）

​	5.盒子模型

​	6.浮动

​	7.定位

​	8.网页动画（特效效果）

### 1.1、什么是CSS

Cascading Style Sheet 层叠级联样式表

CSS：表现（美化网页）

字体、颜色、边距、网页定位……

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <!-- 规范 ：与HTML写在一起时，在<style>中编写CSS代码，每一个声明最好使用分号结尾
    语法：
        选择器{
            声明1;
            声明2;
            声明3;
        }
    -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <h1>我是标题</h1>

</body>
</html>
~~~

~~~css
h1{
    color: red;
}
~~~

![请添加图片描述](https://img-blog.csdnimg.cn/568764608d2c4c5c98595a058f6666b7.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_20,color_FFFFFF,t_70,g_se,x_16)

### 1.2、发展史

CSS1.0

CSS2.0    DIV（块）+CSS，HTML与CSS结构分离的思想哎ing，网页变得简单，SEO

CSS2.1    浮动，定位

CSS3.0    圆角，阴影，动画……浏览兼容性~

### 1.3、快速入门

1.在当CSS代码与HTML写在一起时，CSS代码写在  style 标签中，其中 style 标签写在 header 中

在练习时为了方便可以使用此写法

**此时称之为内部样式表**

2.建议使用以下规范写法

**此时称之为外部样式表**

![请添加图片描述](https://img-blog.csdnimg.cn/98f7d48ed9a7468e8dfe2682d4ec959b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_20,color_FFFFFF,t_70,g_se,x_16)




css的优势：

​	1.内容和表现分离

​	2.网页结构表现统一，可以实现复用

​	3.样式丰富

​	4.建议使用独立于HTML的css文件

​	5.利用SEO，容易被搜索引擎收录





### 1.4、css的3种导入方式

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
	
	<!-- 外部样式 -->
    <link rel="stylesheet" href="css/style.css">

    <!-- 内部样式 -->
    <style>
        h1{
            color: green;
        }
    </style>
</head>
<body>
    
    <!-- 样式优先级：就近原则（谁里元素更近就听谁的，一般行内是最近的，外部和内部看谁的代码更靠下） -->

    <!-- 行内样式：在标签元素中，编写一个style属性，编写样式即可 -->
    <h1 style="color: red;">我是标题</h1>
</body>
</html>
~~~

~~~css
/*外部样式*/
h1{
    color: yellow;
}
~~~

拓展：外部样式两种写法

- 链接式：

  html

  ~~~html
  <!-- 外部样式 -->
  <link rel="stylesheet" href="css/style.css">
  ~~~

- 导入式

  @import是CSS 2.1特有的！

  ~~~html
  <style>
      @import url("css/style.css");
  </style>
  ~~~

## 2、*选择器

​	作用：选择页面上的某一个或者某一类元素

### 2.1、*基本选择器

1. 标签选择器：选择一类标签      标签{}

   ~~~html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>Document</title>
   
       <style>
           /*标签选择器:会选择到页面上所有的这个标签的元素*/
           h1{
               color: #ff00c8;
               background: yellow;
               border-radius: 24px; 
           }
           p{
               font-size: 80px;
           }
       </style>
   
   </head>
   <body>
       <h1>laobuzhang</h1>
       <h1>老部长</h1>
       <p>帅</p>
   </body>
   </html>
   ~~~

2. 类选择器 class：选择所有class属性一致的标签，可跨标签      .类名{}

   ~~~html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>Document</title>
   
       <style>
           /*类选择器格式  .class的名称{}
           好处，可以多个标签归类，是同一个class，可以复用，可以跨标签定义为同类
           */
           .lao{
               color: blue;
           }
           .bu{
               color: red;
           }
       </style>
   </head>
   <body>
       
   
       <h1 class="lao">laobuzhang1</h1>
       <h1 class="bu">laobuzhang2</h1>
       <h1>laobuzhang3</h1>
       <p class="lao">132</p>
   </body>
   </html>
   ~~~

3. id 选择器：全局唯一      #id名称{}

   ~~~html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>Document</title>
   
       <style>
           /* id选择器格式： #id名称{} 
           id必须保证全局唯一（不会报错，会警告）
   
           优先级：id选择器>class选择器>标签选择器
           */
           #lao{
               color: pink;
           }
           .bu{
               color: purple;
           }
           h1{
               color: black;
           }
       </style>
   </head>
   <body>
       
       <h1 id="lao">laobuzhang1</h1>
       <h1 class="bu">laobuzhang2</h1>
       <h1>laobuzhang3</h1>
       <p id="zhang">132</p>
   
   </body>
   </html>
   ~~~



**优先级：**id选择器>class选择器>标签选择器



### 2.2、层次选择器

1. 后代选择器：在某个元素的后边       祖爷爷  爷爷  爸爸  你

   ~~~css
   /* 后代选择器 */
   body p{
   	background: red;
   }
   /* body中所有p标签都选择 */
   ~~~

2. 子选择器：一代，儿子

   ~~~css
   /* 子选择器 */
   body>p{
   	background: yellow;
   }
   /* body中第一层级的p标签都选择 */
   ~~~

3. 相邻兄弟选择器（弟弟选择器）：同辈，只选一个，相邻的下边那一个

   ~~~css
   /* 相邻兄弟选择器 */
   .active+p{
   	background: green;
   }
   /* 选择类为active的标签的下边一个p标签 */
   ~~~

4. 通用选择器

   ~~~css
   /* 通用选择器 */
   .active~p{
   	background: pink;
   }
   /* 选择类为active的标签下边的所有同级p标签，不包括自己 */
   ~~~

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <style>
        /* p{
            background: blue;
        } */

        /* 后代选择器 */
        /* body p{
            background: red;
        } */

        /* 子选择器 */
        /* body>p{
            background: yellow;
        } */

        /* 相邻兄弟选择器 */
        /* .active+p{
            background: green;
        } */

        /* 通用选择器 */
        /* .active~p{
            background: pink;
        } */
    </style>
</head>
<body>
    
    <p>p0</p>
    <p class="active">p1</p>
    <p>p2</p>
    <p>p3</p>

    <ul>
        <li>
            <p>p4</p>
        </li>
        <li>
            <p>p5</p>
        </li>
        <li>
            <p>p6</p>
        </li>
    </ul>

	<p class="active">p7</p>
	<p>p8</p>

</body>
</html>
~~~

### 2.3、结构伪类选择器

~~~css
/* ul的第一个子元素 */
ul li:first-child{
	background: purple;
}

/* ul的最后一个子元素 */
ul li:last-child{
	background: rgb(0, 255, 136);
}

/* 选中p1 
p:nth-child(1) 选中p的父级元素中的第n个元素（括号内为n的值），且只有选中的也是p元素才生效
*/
p:nth-child(1){
	background: rgb(255, 30, 0);
}
p:nth-child(2){
	background: rgb(255, 30, 0);
}

/* 选中p1 
p:nth-of-type(2) 选中p的父级元素中的第n个p元素（括号内为n的值）
*/
p:nth-of-type(2){
	background: yellow;
}
~~~





~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <style>
        /* ul的第一个子元素 */
        ul li:first-child{
            background: purple;
        }

        /* ul的最后一个子元素 */
        ul li:last-child{
            background: rgb(0, 255, 136);
        }

        /* 选中p1 
        p:nth-child(1) 选中p的父级元素的第n个元素（括号内为n的值），且只有选中的也是p元素才生效
        */
        p:nth-child(1){
            background: rgb(255, 30, 0);
        }
        p:nth-child(2){
            background: rgb(255, 30, 0);
        }

        /* 选中p1 
        p:nth-of-type(2) 选中p的父级元素的第n个p元素（括号内为n的值）
        */
        p:nth-of-type(2){
            background: yellow;
        }
        
    </style>
</head>
<body>
    <h1>h1</h1>
    <p>p1</p>
    <p>p2</p>
    <p>p3</p>

    <ul>
        <li>li1</li>
        <li>li2</li>
        <li>li3</li>
    </ul>
</body>
</html>
~~~

**以下代码结果如图：**

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <style>
        /* ul的第一个子元素 */
        ul li:first-child{
            background: purple;
        }

        /* ul的最后一个子元素 */
        ul li:last-child{
            background: rgb(0, 255, 136);
        }

        /* 选中p1 
        p:nth-child(1) 选中p的父级元素中的第n个元素（括号内为n的值），且只有选中的也是p元素才生效
        */
        p:nth-child(1){ /* 不生效 */
            background: rgb(255, 30, 0);
        }
        p:nth-child(2){ /* 生效 */
            background: rgb(255, 30, 0);
        }

        /* 选中p1 
        p:nth-of-type(2) 选中p的父级元素中的第n个p元素（括号内为n的值）
        */
        p:nth-of-type(2){
            background: yellow;
        }
        
    </style>
</head>
<body>
    <h1>h1</h1>
    <p>p1</p>
    <p>p2</p>
    <p>p3</p>

    <ul>
        <li>li1</li>
        <li>li2</li>
        <li>li3</li>
    </ul>
</body>
</html>
~~~

![请添加图片描述](https://img-blog.csdnimg.cn/8824661c9bbc4f4f901a23ba1f7d96e2.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_20,color_FFFFFF,t_70,g_se,x_16)


### 2.4、*属性选择器（常用）

id+class  结合

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <style>
        .demo a{
            float: left;
            display: block;
            height: 50px;
            width: 50px;
            border-radius: 10px;
            background: blue;
            text-align: center;
            color: red;
            text-decoration: none;
            margin-right: 5px;
            font: bold 20px/50px Arial;
        }

        /* 选择存在某属性的元素  
        a[]{}
            [] 中可填：1.属性
                       2.属性=属性值（可为正则表达式）
                       3.属性*=属性值
                       4.属性^=属性值
        			   5.属性$=属性值
        		只填属性： 包含该属性即可
                = 绝对等于
                *= 包含该属性即可
                ^= 以该属性值开头
                $= 以该属性结尾
        */
        
        /* 选中id属性为last的 */
        a[id=last]{
            background: yellow;
        }
        /* 选中class中包含links的元素 */
        a[class*="links"]{
            background: green;
        }

        /* 选中href中以http开头的元素 */
        a[href^=http]{
            background: pink;
        }

        /* 选中href中以jpg结尾的元素 */
        a[href$=jpg]{
            background: rgb(0, 225, 255);
        }
        
    </style>
</head>
<body>
    

    <p class="demo">
        <a href="http://www.baidu.com" class="links item first" id="first">1</a>
        <a href="" class="links item active" target="_blank" title="test">2</a>
        <a href="../1.我的第一个css程序/index.HTML" class="links item">3</a>
        <a href="../1.我的第一个css程序/index.png" class="links item">4</a>
        <a href="../1.我的第一个css程序/index.jpg" class="links item">5</a>
        <a href="abc" class="links item">6</a>
        <a href="/a.pdf" class="links item">7</a>
        <a href="/abc.pdf" class="links item">8</a>
        <a href="abc.doc" class="links item">9</a>
        <a href="abcd.doc" class="item last" id="last">10</a>
    </p>
</body>
</html>
~~~

**效果：**

![请添加图片描述](https://img-blog.csdnimg.cn/8f4296c13c4042ed9b9624b9798da13f.png)


## 3、美化网页元素

### 3.1、为什么要美化网页

1. 有效传递信息
2. 页面漂亮，吸引用户
3. 凸显页面主题
4. 提高用户体验



span标签：重点要突出的字使用span标签套出来

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <style>
        #title1{
            font-size: 50px;
        }
    </style>
</head>
<body>

    <!-- 用其他的随意单词也行，但是约定俗称用span -->
    欢迎学习<span id="title1">Java</span>
    
</body>
</html>
~~~



### 3.2、字体样式

**主要使用font属性**

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <!-- 
        font-family 字体
        font-size 字体大小
        font-weight 字体粗细
     -->
    <style>
        body{
            font-family: 楷体;
        }
        h1{
            font-size: 50px;
        }
        .p1{
            font-size: 2em;
            /* 1em=元素中文本的1个垂直高度 */
            font-weight: bold;
        }
        .p2{
            color: red;
        }
        .p3{
            font-weight: 900;
        }

        /* 直接全写上：斜体 粗细 大小/行高 字体 */
        .p4{
            font: oblique bolder 15px/30px "楷体";
        }
    </style>
</head>
<body>

    <h1>故事介绍</h1>
    <p class="p1">美国，1899年。当警察开始打击残余亡命之徒的帮派时，蛮荒的西部时代迎来了最后的黄昏。</p>
    <p class="p2">不愿投降或是屈服的人，只有死路一条。</p>
    <p class="p3">亚瑟·摩根和范德林德帮众在黑水镇的一次抢劫行动遭遇了始料不及的意外，他们不得不逃离这个西部小镇。</p>
    <p class="p4">联邦侦探和全国顶尖的赏金猎人在他们的身后穷追不舍，亚瑟一行人必须在广袤蛮荒的美国腹地上四处劫掠、挣扎求生。</p>
    <p>而帮派内部的矛盾分化日渐加深，摆在亚瑟面前的将是他无法避免的抉择：</p>
    <p>究竟是选择自己的理想，还是选择效忠于抚养了自己的帮派。</p>

    <p>
        Do you fear the force of the wind,
        The slash of the rain?
        Go face them and fight them,
        Be savage again.
        Go hungry and cold like the wolf,
        Go wade like the crane:
        The palms of your hands will thicken,
        The skin of your cheek will tan,
        You'll grow ragged and weary and swarthy,
        But you'll walk like a man!
    </p>

</body>
</html>
~~~



### 3.3、文本样式

1. 颜色    color  rgb rgba
2. **文本对齐方式    text-align=center**
3. **首行缩进    text-indent: 2em**
4. **行高**    line-height: 单行文字上下居中：行高=块高
5. 装饰（下划线，删除线……）text-decoration:
6. 文本和图片水平对齐    vertical-align: middle;

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <!-- 
        颜色：
            单词
            rgb(a,b,c)
            rgba(a,b,c,d)  d:0~1 透明度
            #RGB
            
        text-align ：排版，居中
        text-indent : 首行缩进
        height ： 块高
        line-height ： 行高
     -->
    <style>
        h1{
            color: #0180ff;
            color: rgb(255, 0, 255);
            color: rgba(0, 255, 255, 0.9);
            text-align: center;
        }
        .p1{
            text-indent: 2em;
        }
        .p3{
            background: red;
            height: 200px;
            /* 行高等于块高度时即可实现上下居中 */
            line-height: 200px;
        }

        /* 三种装饰 */
        .l1{
            text-decoration: underline;
        }
        .l2{
            text-decoration: line-through;
        }
        .l3{
            text-decoration: overline;
        }

        /* 图片和文字水平对齐 */
        img,span{
            vertical-align: middle;
        }
    </style>
</head>
<body>

    <p class="l1">123</p>
    <p class="l2">456</p>
    <p class="l3">789</p>
    <h1>故事介绍</h1>
    <p class="p1">美国，1899年。当警察开始打击残余亡命之徒的帮派时，蛮荒的西部时代迎来了最后的黄昏。</p>
    <p class="p2">不愿投降或是屈服的人，只有死路一条。</p>
    <p class="p3">亚瑟·摩根和范德林德帮众在黑水镇的一次抢劫行动遭遇了始料不及的意外，他们不得不逃离这个西部小镇。</p>
    <p class="p4">联邦侦探和全国顶尖的赏金猎人在他们的身后穷追不舍，亚瑟一行人必须在广袤蛮荒的美国腹地上四处劫掠、挣扎求生。</p>
    <p>而帮派内部的矛盾分化日渐加深，摆在亚瑟面前的将是他无法避免的抉择：</p>
    <p>究竟是选择自己的理想，还是选择效忠于抚养了自己的帮派。</p>

    <p>
        Do you fear the force of the wind,
        The slash of the rain?
        Go face them and fight them,
        Be savage again.
        Go hungry and cold like the wolf,
        Go wade like the crane:
        The palms of your hands will thicken,
        The skin of your cheek will tan,
        You'll grow ragged and weary and swarthy,
        But you'll walk like a man!
    </p>


    <p>
        <img src="../9.文本样式/image/a.png" alt="">
        <span>asdasasdasd</span>
    </p>
</body>
</html>
~~~



### 3.4、阴影

~~~css
/* 阴影：阴影颜色 水平偏移 垂直偏移 阴影半径 */
#price{
	text-shadow: rgb(0, 225, 255) 5px 0px 2px;
}
~~~



### 3.5、超链接伪类

鼠标与链接的交互

1. link-设置a对象在未被访问前的样式表属性。
2. visited-设置a对象在其链接地址已被访问过时的样式表属性。
3. hover–设置对象在其鼠标悬停时的样式表属性。
4. active-设置对象在被用户激活（在鼠标点击与释放之间发生的事件）时的样式表属性。

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <!-- 正确的顺序：a:link、a:visited、a:hover、a:active -->
    <style>
        /* 默认颜色 */
        a{
            text-decoration: none;
        }

        /* 未访问的链接 */
        a:link{
            color: blue;
        }

        /* 已访问的链接 */
        a:visited{
            color: pink;
        }
        /* 是否被访问储存在缓存中。。。 */

        /* 鼠标悬浮的状态 */
        a:hover{
            color: yellow;
        }

        /* 鼠标按住的状态 */
        a:active{
            color: red;
        }
    </style>
</head>
<body>
    <a href="#">
        <img src="images/a.png" alt="">
    </a>
    <p>
        <a href="#">码出高效：Java开发手册</a>
    </p>
    <p>
        <a href="">作者：孤尽老师</a>
    </p>
    <p>
        ￥99
    </p>
</body>
</html>
~~~



### 3.6、列表

div标签：没有作用的空标签，可以加上id以实现对一整段标签的操作

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <!-- div:没有作用的空标签 -->
    <div id="nav">
        <h2 class="title">全部商品分类</h2>
        <ul>
           <li><a href="#">图书</a>&nbsp;&nbsp;<a href="#">PS4</a>&nbsp;&nbsp;<a href="#">XBOX</a></li>
          <li><a href="#">图书</a>&nbsp;&nbsp;<a href="#">PS4</a>&nbsp;&nbsp;<a href="#">XBOX</a></li>
          <li><a href="#">图书</a>&nbsp;&nbsp;<a href="#">PS4</a>&nbsp;&nbsp;<a href="#">XBOX</a></li>
         <li><a href="#">图书</a>&nbsp;&nbsp;<a href="#">PS4</a>&nbsp;&nbsp;<a href="#">XBOX</a></li>
         <li><a href="#">图书</a>&nbsp;&nbsp;<a href="#">PS4</a>&nbsp;&nbsp;<a href="#">XBOX</a></li>
         <li><a href="#">图书</a>&nbsp;&nbsp;<a href="#">PS4</a>&nbsp;&nbsp;<a href="#">XBOX</a></li>
    </ul>
    </div>

</body>
</html>
~~~



~~~css
#nav{
    width: 250px;
    background: rgb(231, 221, 221);
}


h2{
    font-size: 30px;
    font-weight: bold;
    text-indent: 1em;
    line-height: 35px;
    background: red;
}

/* ul li
list-style:
    none 去掉原点
    citcle 空心圆
    decimal 数字
    square 正方形
*/
ul li{
    height: 30px;
    list-style: none;
    text-indent: 1em;
}
ul{
    background: rgb(231, 221, 221);
}


a{
    text-decoration: none;
    font-size: 15px;
    color: black;
}
a:hover{
    color: orange;
    text-decoration: underline;
}
~~~



### 3.7、背景

- 背景颜色
- 背景图片

~~~css
h2{
    font-size: 20px;
    font-weight: bold;
    text-indent: 3em;
    line-height: 35px;
    /*          颜色      图片                图片位置x，y坐标   图片重复方式*/
    background: red url("../images/箭头2.png") 215px 2px no-repeat;
}
~~~



~~~css
background-image: url("../images/箭头3.png");
background-repeat: no-repeat;
background-position: 180px 4px;
~~~



### 3.8、渐变

[渐变背景网站](https://www.grabient.com/ )

~~~css
body{
	background-color: #4158D0;
	background-image: linear-gradient(232deg, #4158D0 0%, #e101ff 46%, #FFCC70 100%);
}
~~~



### 3.9、设置位置

[先粘一个链接](https://blog.csdn.net/weixin_30978239/article/details/117784262?ops_request_misc=%7B%22request%5Fid%22%3A%22164664819016780264073309%22%2C%22scm%22%3A%2220140713.130102334.pc%5Fall.%22%7D&request_id=164664819016780264073309&biz_id=0&spm=1018.2226.3001.4187)



## 4、盒子模型

### 4.1、什么是盒子模型

![请添加图片描述](https://img-blog.csdnimg.cn/09fb0183d8f8454894faca216a4c61b4.png)


- margin：外边距
- padding：内边距
- border：边框



### 4.2、边框

1. 边框的粗细
2. 边框的样式
3. 边框的颜色

**border标签**

~~~css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <style>
        /* body默认外边距为8 */
        /* 开发规范，初始化 */
        h1,ul,li,a,body{
            margin: 0;
            padding: 0;
            text-decoration: none;
        }


        /* border:粗细 样式 颜色 */
        #app{
            width: 300px;
            border: 1px solid  red;
        }

        h2{
            font-size: 16px;
            background: red;
            line-height: 30px;
            margin: 0;
        }

        form{
            background: rgb(0, 217, 255);
        }

        form div:nth-of-type(1) input{
            border: 3px solid black;
        }
        form div:nth-of-type(2) input{
            border: 3px dashed rgb(81, 255, 0);
        }

    </style>
</head>
<body>
    
    <div id="app">
        <h2>会员登陆</h2>
        <form action="#">
            <div>
                <span>姓名：</span>
                <input type="text">
            </div>
            <div>
                <span>密码：</span>
                <input type="text">
            </div>
            <div>
                <span>邮箱：</span>
                <input type="text">
            </div>
        </form>
    </div>
</body>
</html>
~~~



### 4.3、内外边距

**margin标签**：外边距

**padding标签**：内边距

~~~css
#app{
	/* 上和下和左和右 */
	margin: 0;
            
	/* 上 下 左 右 */
	margin: 0 0 0 0;

	/* 上和下 左和右 */
	margin: 0 auto;

	/* 上边距 */
	margin-top: 30px;
    
    /* padding同理 */
}
~~~



### 4.4、圆角边框

**border-radius属性**，四个值对应四个角

~~~css
/*
    圆圈：圆角=直径
        当圆角=边长 时是圆

*/
div{
    width: 100px;
    height: 100px;
    border: 10px solid red;

    /* 左上 右上 右下 左下 */
    border-radius: 50px 40px 30px 20px;

    /* 左上和右下   右上和左下 */
    border-radius: 50px 30px ;

     /* 四个角 */
     border-radius: 50px;
}
~~~



### 4.5、阴影

**box-shadow属性**，

~~~css
/* x偏移 y偏移 模糊度 颜色 */
box-shadow: 10px 10px 10px yellow;
~~~



## 5、浮动

### 5.1、标准文档流

文档流(Normal flow)也称为常规流，普通流。

从直观上理解，常规流指的是元素按照其在 HTML 中的位置顺序决定排布的过程,主要的形式是自上而下（块级元素）,一行接一行,每一行从左至右（行内元素）。

内联元素不会独占一行，而每个非浮动块级元素都独有一行, 浮动元素则按规则浮在行的一端. 若当时行容不下, 则另起新行再浮动。

浮动元素不占任何正常文档流空间，而浮动元素的定位照样基于正常的文档流，当一个元素脱离正常文档流后，依然在文档流中的其他元素将忽略该元素并填补其原先的空间。

可以将浮动的元素理解为在文档流图层之上的新图层上

**块级元素**：独占一行

~~~
h1~h6  p  div  列表……
~~~

**行内元素：**不独占一行

~~~
span  a  img  strong……
~~~



行内元素可以被包含在块元素中，反之不能



### 5.2、display

~~~css
/*
display属性
    block 变成块元素
    inline 变成行内元素
    inline-block 是块元素，但是可以内联在一行

div默认为块元素
span默认为行内元素
*/
div{
    width: 100px;
    height: 100px;
    border: 1px solid red;
    display: inline-block;
}
span{
    width: 100px;
    height: 100px;
    border: 1px solid red;

    display: inline-block;
}
~~~

这也是一种行内元素排列方式，但是很多情况下都是用float

### 5.3、float

左右浮动float属性，可以设置便签的位置

将float属性打开后，display属性转化为block

~~~css
.layer01{
    border:1px red;
    float:right;
}
~~~



### 5.4、*父级边框塌陷的问题

如图，将几张在div内的img设为float后，div的边框就变成了上边的一小条，img的高度无法再撑开div标签

如果在侧面看，此时img和div属于两个图层

![请添加图片描述](https://img-blog.csdnimg.cn/c5dd094452d54af2ada92771813388a7.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_20,color_FFFFFF,t_70,g_se,x_16)


**解决所用的属性**

**clear: right;**  右侧不许有浮动元素

**clear: left;**     左侧不许有浮动元素

**clear: both;**   两侧不许有浮动元素



**解决方案：**

**1.增加父级元素高度**

~~~css
#father{
    border: 1px #000 solid;
    height: 600px;
}
~~~



**2.在父级标签最后增加一个空的不浮动的div标签在父级标签后边，清除它的浮动，作为底线**（但是一般不建议使用空div标签）

~~~html
<div id="father">
        <div class="layer1"><img src="images/1.jpg" alt=""></div>
        <div class="layer2"><img src="images/2.jpg" alt=""></div>
        <div class="layer3"><img src="images/3.jpg" alt=""></div>
        <div class="layer4">
            浮动的盒子可以向左右浮动
        </div>
        <div class="clear"></div>
    </div>
~~~



~~~css
.clear{
    clear: both;
    margin: 0;
    padding: 0;
}
~~~



**3.overflow**

**overflow**

**清除子元素的浮动对本元素的影响**

即img元素的浮动属性不会再对div产生影响，div依旧可以被img撑开

注意，此时img的浮动属性并未消失

~~~css
#father{
    border: 1px #000 solid;
    overflow: hidden;
}
~~~

**overflow有常用的3个属性值：**

1.hidden

2.scroll

3.auto

在**不限制**父级标签高度时：

- 三个值都会使div被img的高度撑开，其中scroll会出现滚动条

在**限制**父级标签高度后且img高度大于父标签高度时：

1. hidden超出的img被隐藏，无法查看
2. scroll超出的img可通过拖动滚动条查看
3. auto不超出时和hidden一样，超出时和scroll一样



**4.*父类添加一个伪类：after**

原理类似于第2个解决，但是没有使用空div，是**最推荐**的写法

~~~css
#father::after{
    content: '';
    display: block;
    clear: both;
}
~~~



**小结：**

1. 设置父元素高度        简单，但笨重，可能未来img还会超过现定高度
2. 浮动元素后加空div        简单，但不推荐使用空div
3. overflow        一般不会使用scroll属性值，一般用hidden
4. 父类添加伪类：after        最推荐，没有副作用



### 5.5、对比display和float

- display    方向不可控制
- float         需要解决边框塌陷问题



## 6、定位

### 6.1、相对定位

**position: relative;**          使得该类可以开始移动位置

**top，bottom，left，right**

正数表示向内移，负数表示向外移

（top向内就是向下，其他同理）

~~~css
#first{
        background: blue;
        border: 1px dashed rgb(255, 238, 0) ;

        position: relative;
        top: 10px;/* 向下移动10px */
        left: 5px;/* 向右移动10px */
    }
~~~

**注意：**原本的位置会被保留，用来撑开父类标签，即父类标签会被原来未移动时的子类标签撑开



#### *小练习和小知识点（两个inline-block消除间距）

实现以下功能：

鼠标放上变蓝

![请添加图片描述](https://img-blog.csdnimg.cn/0b57358edd0c41e98ce755c404a7283b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_13,color_FFFFFF,t_70,g_se,x_16)


**正解：**

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <style>
        #limit{
            height: 300px;
            width: 300px;
            border: 2px solid red;
            padding: 10px;
            margin: 30px;
        }
        a{
            color: white;
            text-decoration: none;
            text-align: center;
            line-height: 100px;


            display: block;
            height: 100px;
            width: 100px;
            padding: 0;
            margin: 0;
            background: pink;
        }
        a:hover{
            background: blue;
        }
        .a2{
            position: relative;
            left: 200px;
            bottom: 100px;
        }
        .a3{
            position: relative;
        }
        .a4{
            position: relative;
            left: 200px;
            bottom: 100px;
        }
        .a5{
            position: relative;
            left: 100px;
            bottom: 300px;
        }
    </style>

</head>
<body>
    <div id="limit">
        <a href="" class="a1">链接1</a>
        <a href="" class="a2">链接2</a>
        <a href="" class="a3">链接3</a>
        <a href="" class="a4">链接4</a>
        <a href="" class="a5">链接5</a>
    </div>
</body>
</html>
~~~



**坑（直接看下边分析就行）：**

~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <style>
        #limit{
            height: 300px;
            width: 300px;
            border: 2px solid red;
            padding: 10px;
            margin: 30px;
        }
        a{
            color: white;
            text-decoration: none;
            text-align: center;
            line-height: 100px;


            display: inline-block;
            height: 100px;
            width: 100px;
            padding: 0;
            margin: 0;
            background: pink;
        }
        a:hover{
            background: blue;
        }
        .a1{
            vertical-align: top;
        }
        .a2{
            vertical-align: top;
            position: relative;
            left: 100px;
        }
        .a3{
            vertical-align: top;
            position: relative;
            top: 100px;
        }
        .a4{
            vertical-align: top;
            position: relative;
            left: 100px;
            top: 100px;
        }
        .a5{
            vertical-align: top;
            position: relative;
            left: 100px;
            bottom: 100px;
        }
    </style>

</head>
<body>
    <div id="limit">
        <a href="" class="a1">链接1</a>
        <a href="" class="a2">链接2</a>
        <a href="" class="a3">链接3</a>
        <a href="" class="a4">链接4</a>
        <a href="" class="a5">链接5</a>
        
        
        <!-- <a href="" class="a1">链接1</a
        ><a href="" class="a2">链接2</a
        ><a href="" class="a3">链接3</a
        ><a href="" class="a4">链接4</a
        ><a href="" class="a5">链接5</a> -->
    </div>
</body>
</html>
~~~

**坑的效果：**

![请添加图片描述](https://img-blog.csdnimg.cn/f0d5d0b0e13143e28a568e03565a807b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAbGFvYnV6aGFuZw==,size_13,color_FFFFFF,t_70,g_se,x_16)


**分析：**

两端代码的唯一不同就是第一个的a标签display设为block，第二个设为了inline-block

对于block没问题，但是对于inline-block，元素间留白间距出现的原因就是标签段之间的空格。

因此，去掉HTML中的空格，自然间距就木有了。（见坑的注释）

[参考于](https://blog.csdn.net/dgedge0769/article/details/101988117?ops_request_misc=&request_id=&biz_id=102&spm=1018.2226.3001.4187)

### 6.2、绝对定位

基于xxx定位

1. 父级元素没有定位时，基于浏览器定位，可以超出浏览器，超出部分被截断
2. 父级元素存在定位时，通常基于父级元素进行偏移，可以超脱父级元素，不会被截断

向对于某物的位置，进行指定的偏移，它不在标准文档流中，原先的位置不会被保留

~~~css
#father{
    border: 1px solid #666 ;
    position: relative;
}
#second{
    margin: 0px;
    padding: 0px;
    background: red;
    border: 1px dashed rgb(8, 90, 22) ;
    position: absolute;
    left: -10px;
}
~~~



### 6.3、*固定定位fixed

固定不动，可调整相对于浏览器的位置，即使拖动滚动条，可以用来做导航目录栏，头部栏

~~~css
#second{
    margin: 0px;
    padding: 0px;
    background: red;
    border: 1px dashed rgb(8, 90, 22) ;
    position: fixed;
    left: 0px;
}
~~~



### 6.4、z-index

**z-index:**默认是0，最高无限

z-index的值越大，该标签的层级越靠上，会覆盖z-index比它小的标签

若值相同，则在代码中后出现的在上层

~~~css
.tipText,.tipBg{
    position: absolute;
    width: 195px;
    height: 25px;
    top: 90px;
}
.tipText{
    color: white;
    z-index: 999999;
}
.tipBg{
    background: red;
}
~~~



**opacity**：设置透明度，减小上层的透明度可以使下层的元素显露

范围：0~~100，100表示不透明



## 7、动画

网上白嫖代码
源码之家等
