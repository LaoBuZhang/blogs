---
title: JavaScript学习笔记
date: 2022-06-05 22:11:53
tags: 
    - JavaScript
    - 前端
    - 基础入门


---



# JavaScript



<!--more-->



## 概念

一门客户端脚本语言

- 运行在客户端浏览器的浏览器中，每一个浏览器都有JavaScript的解析引擎
- 脚本语言：不需要编译，直接就可以被浏览器解析执行的语言



## 功能

- 增强用户和HTML页面交互的过程，可以控制HTML元素，让页面有一些动态的效果，增强用户的体验





## 发展史

1. 1992年，Nombase公司，开发出第一门客户端脚本语言，专门用于表单的校验，命名为：C--，后来更名为ScriptEase
2. 1995年，Netscape（网景）公网，开发了一门客户端脚本语言：LiveScript。后来，请来了sun公司的专家，修改LiveScript，命名为JavaScript
3. 1996年，微软抄袭了JavaScript开发出JScript语言
4. 1997年，ECMA（欧洲计算机制造商协会），ECMAScript，就是所有客户端脚本语言的标准。



JavaScript=ECMAScript + JavaScript自己特有的东西（BOM+DOM）





## ECMAScript

### **基本语法：**

1. 与HTML的结合方式

   1. 内部js：script标签内就是js代码

   2. 外部js：script标签src属性引入外部js文件

      ~~~html
      <!DOCTYPE html>
      <html>
          <head>
              <meta charaset="UTF-8">
              <title>
                  Title
              </title>
      
              <!-- 
                  内部JS
                  可以放在任意位置
                  按顺序执行
                  alert是阻塞语句，不按确定，后边的语句就不会执行
              -->
              <script>
                  alert("Hello World")
              </script>
      
      
              <!-- 
                  外部JS 
              -->
              <script src="js/a.js"></script>
          </head>
          <body></body>
      </html>
      ~~~

      

   

### **注释**

   1. 单行注释：  //

   2. 多行注释： /* */

      

   ### **数据类型：**

   1. 原始数据类型（基本数据类型）：
      1. number：整数，小数，NaN（一个不是数字的数字类型）
      2. string：字符和字符串，可单引可双引
      3. boolean：真和假
      4. null：对象为空的占位符
      5. undefined：未定义。如果一个变量没有给初始化值，则会默认赋值为undefined
      
   2. 引用数据类型：对象

      

   

   ### 变量

   java是强类型语言，JS是弱类型语言

   - 强类型就是在开辟存储空间是，定义了空间的数据类型，只能存储固定类型数据
   - 弱类型就是只开辟空间，该空间可以放任意类型的数据

   语法：

   ~~~javascript
   var 变量名=初始化值;
   
   var a=3;
   alert(a);
   a="abc";
   alert(a);
   
   //在html输出num1
   document.write(num1+"<br>");
   
   //可以使用typeof运算符查看变量类型
   document.write(typeof(obj2));//null类型会返回object
   ~~~

   

### **运算符**

JS中，如果运算数不是运算符所要求的类型，那么js会自动将运算数转换为所需的类型

1. 转换为number的转换规则：

   ~~~javascript
   string转number：按照字面值转换，如果字面包含非数字，则转为NaN
   boolean转number：true转1，false转0
   null和undefined都转为NaN
   
   var a=+"123";
   document.write(a+1);//输出124
   
   var a="123";
   document.write(a+1);//输出124
   
   var b=+"123ab";
   document.write(a+1);//输出NaN(NaN+1仍然等于NaN)
   ~~~

2. 转换为boolean类型

   ~~~javascript
   number转boolean：0和NaN为false，其他为true
   string转boolean：除了空字符串，其他都是true
   null和undefined转boolean：都是false
   对象：所有非null对象都是true。
   ~~~
   
   



1. **一元运算符：**只有一个运算数的运算符（类型适用于number，其他类型会转换为number）

   ~~~javascript
   ++ -- + -（正负号可用于类型转换）
   ~~~

2. **算数运算符**：和java一样

3. 赋值运算符

   ~~~javascript
   = += -=
   ~~~

4. **比较运算符**

   ~~~javascript
   其他和java一样
   ===   //全等于，JS特有，如果类型不一样，直接返回false
   ~~~

   可以比较**类型相同**的变量：数字，字符串（按找字典序比较）

   可以比较**类型不同**的变量：先进行类型转换，在比较

5. **逻辑运算符**（适用于boolean类型，其他类型会转换为boolean）

   ~~~javascript
   &&（短路）
   ||（短路）
   !
   ~~~

6. **三元运算符**：? :

   

### **流程控制语句**

1. if else
2. switch
   - switch可接收的数据类型
     - java中：byte int short char 枚举 String
     - JS中：任意原始数据类型，每个case的类型都可以不一样
3. while
4. do while
5. for                            for(var i=1;i<=100;i++){};

7. **JS特殊语法**

   1. 语句以;结尾，如果一行只有一条语句，则可以省略（不建议）

   2. 变量可以用var定义，也可以不使用

      ​        用了是局部变量

      ​        不用是全局变量



### 对象

1. **Function：函数对象**

   - 创建和使用

     ~~~javascript
     //1. var fun=new Function(形式参数列表,方法体);(基本不用)
     var fun1=new Function("a","b","alert(a);");
     fun1(3,4);
     
     /*
     2.
     function 方法名称(形式参数列表){
         方法体
     }
     */
     function fun2(a,b){//形参的类型可以不写
         alert(a+b);
     }
     fun2(3,4);//函数的调用
     
     /*
     3.
     var 方法名=function(形式参数列表){
         方法体
     }
     */
     var fun3=function(a,b){
         alert(a+b);
     }
     fun3(4,5);
     ~~~

   - 属性：

     ~~~javascript
     function fun2(a,b){
         alert(a+b);
     }
     alert(fun2.length);//方法的参数个数
     ~~~

   - 特点

     1. 定义时，形参类型可以不用写，返回值也可以不写

     2. 方法是一个对象，如果定义名称相同的方法，后者会覆盖前者

        ~~~javascript
        function fun2(a,b){
            alert(a+b);
        }
        function fun2(a,b){
            alert(a-b);
        }
        fun2=function(a,b,c){
            alert(a*b*c);
        }
        ~~~

     3. 方法的调用值，只与方法的名称有关，和参数列表无关

        ~~~javascript
        function fun2(a,b){
            alert(a+b);
        }
        fun2(1);//a为1，b为undefined
        fun2();//都为undefined
        fun3(1,2,3);//a为1，b为2，3被内置对象接收
        ~~~

     4. 在方法声明中有一个隐藏的内置对象（数组），arguments，封装所有的实际参数

        ~~~javascript
        function sum(){
            var sum=0;
            for(var i=0;i<arguments.length;i++){
                sum+=arguments[i];
            }
            return sum;
        }
        alert(sum(1,2,3,4,5));
        ~~~

        

2. **Array**

   - 创建

     ~~~javascript
     //数组对象
     
     //1. var arr=new Array(列表元素);
     var arr1=new Array(1,2,3);
     
     //2. var arr=new Array(默认长度);
     var arr2=new Array(5);
     
     //3. var arr=[元素列表];
     var arr3=[1,2,3,4,5];
     
     document.write(arr1+"<br>");
     document.write(arr2+"<br>");
     document.write(arr3+"<br>");
     ~~~

   - 特点

     1. Array元素类型可变
     2. 数组长度可变，越界访问时，越界元素为undefined，同时数组长度自动扩充为越到的地方

   - 属性：length，数组的长度

   - 方法：常用的是join和push

     ~~~javascript
     join(参数);//将数组中的元素按照指定的分隔符拼接为字符串，默认用,分隔
     
     var arr3=[1,2,3,4,5];
     
     document.write(arr3.join("--"));
     
     
     
     
     push();//向数组的末尾添加一个或更多元素，并返回新的长度
     
     arr3.push(6);
     ~~~

     

3. **Boolean**：boolean的包装类

4. **Date**

   - 创建：

     ~~~javascript
     //1. var date=new Date();
     var date=new Date;
     
     document.write(date);
     ~~~

   - 方法：

     ~~~javascript
     //toLocaleString();  返回当前date对象对应的事件本地字符串格式（和系统区域有关）
     
     var date=new Date;
     
     document.write(date.toLocaleString());
     
     
     
     
     
     //getTime();  返回当前日期对象描述的时间到1970年1月1日0点的毫秒值差
     
     document.write(date.getTime());
     ~~~

     

5. **Math**

   - 创建：Math对象不用创建，直接使用，Math.方法名();

   - 方法：

     ~~~Javascript
     PI();//圆周率
     document.write(Math.PI);
     
     random();//0~1之间的随机数，含0不含1
     document.write(Math.random());
     
     cell(x);//向上取整
     document.write(Math.ceil(3.14));
     
     floor(x);//向下取整
     document.write(Math.floor(3.14));
     
     round(x);//四舍五入
     document.write(Math.round(3.14));
     ~~~

     

6. **Number**：number的包装类

7. **String**：string的包装类

8. **RegExp**：正则表达式对象

   1. 正则表达式：定义字符串的组成规则。

      1. 单个字符：[]

         如：[a]  [ab]  [a-zA-z0_9_]

         - 特殊符号代表特殊含义的单个字符：

           \d：单个数字字符 [1-9]

           \w：单个单词字符 [a-zA-Z0-9_]

      2. 量词符号：

         ?：表示出现0次或1次

         *：表示出现0次或多次

         +：表示出现1次或多次

         {m,n}：表示m<=数量<=n

         {,n}：最多n次

         {m,}：最少m次

      3. 开始结束符号

         - ^：开始
         - $：结束

   2. 正则对象：

      - 创建

        ~~~javascript
        //1.  var reg=new RegExp("正则表达式");
        
        //2.  var reg=/正则表达式/;
        ~~~

        

      - 方法

        ~~~javascript
        //test();  验证定义的字符串是否满足正则定义的规范
        
        var reg1=new RegExp("^\\w{1,12}$");
        var reg2=/^\w{1,12}$/;
        
        
        var username="zhangsan";
        var username1="zhangsanasdasdasdadasasdas";
        alert(reg1.test(username));//true
        alert(reg2.test(username1));//false
        ~~~

        

9. **Global**

   - 特点：全局对象，这个Globe中封装的方法不需要对象就可以直接调用

   - 方法：

     - encodeURI();
       decodeURI();

       encodeURIComponent();
       decodeURIComponent();

       ~~~javascript
       encodeURI();//rul编码
       decodeURI();//url解码
       
       encodeURIComponent();//rul编码，编码的字符更多，有些字符在上边两种不会编码，但是这两种会编码
       decodeURIComponent();//url解码
       
       
       
       
       var str1="http://www.baidu.com?wd=老部长";
       var encode1=encodeURI(str1);//http://www.baidu.com?wd=%E8%80%81%E9%83%A8%E9%95%BF
       document.write(encode1+"<br>");
       var str2=decodeURI(encode1);
       document.write(str2+"<br>");
       
       
       var str1="http://www.baidu.com?wd=老部长";
       var encode1=encodeURIComponent(str1);//http%3A%2F%2Fwww.baidu.com%3Fwd%3D%E8%80%81%E9%83%A8%E9%95%BF
       document.write(encode1+"<br>");
       var str2=decodeURIComponent(encode1);
       document.write(str2+"<br>");
       ~~~

       url编码：

       ​	二进制数，每4位记成一个16进制数，没两个16进制数之间用%分割

       ~~~javascript
       1001 1100 1111 0001
       %9   C    %F   1
       ~~~

       

     - parseInt();

       ~~~javascript
       //逐一判断每一个字符是否是数字，知道不是数字为止，将前面数字部分转为number，若第一个都不是数字，返回NaN
       var s="123abc";
       document.write(parseInt(s)+1);//124
       var s1="a123abc";
       document.write(parseInt(s1)+1);//NaN
       ~~~

     - isNaN();

       ~~~javascript
       //判断是否是NaN，不能用正常方法，只要是有NaN参与的比较，就会返回false
       document.write(NaN==NaN);//false
       
       document.write(isNaN("abc"));//true
       ~~~

     - eval();

       ~~~javascript
       //解析JS字符串，并把它作为脚本代码来执行
       var strr="alert(123)";
       document.write(strr);//alert(123)
       eval(strr);//123
       ~~~

       

     

     

     

## DOM

功能：控制html文档的内容

- 获取页面的标签（元素）对象 Element

  ~~~Javascript
  document.getElementById("id值");//通过元素的id获取元素对象
  ~~~

- 操作Element对象：

  1. 设置属性值

     1. 明确获取的对象
     2. 查看API文档，查看有哪些属性可以修改

     ~~~html
     <body>
     
         <img id="light" src="img/1.jpg">
     
         <script>
             var light=document.getElementById("light");
             alert("我要换图片了");
             light.src="img/2.jpg";
         </script>
     </body>
     ~~~

     

  2. 修改标签体内容

     innerHTML属性



## 事件

功能：某些组件被执行了某些操作后，触发某些代码的执行

绑定事件：

1. 直接在html标签上，指定事件的属性，属性值就是js代码
   1. 事件：onclick    单击事件，是标签的一个属性，后边填js代码
2. 通过js获取元素对象，指定事件属性，设置一个函数

~~~html
<!DOCTYPE html>
<html>
    <head>
        <meta charaset="UTF-8">
        <title>事件绑定</title>

        <script>
            function fun(){
                alert("我被点了");
                alert("我又被点了");
            }
        </script>
        
    </head>

    <body>
        <img id="light" src="img/1.jpg" onclick="fun();">



    </body>
</html>
~~~



## BOM

Browser Object Model  浏览器对象模型

- 将浏览器的各个组成部分封装成对象

**组成：**

- Window：窗口对象

  - 特点：

    - Window对象不需要创建可以直接使用。window.方法名();
    - window引用可以省略

  - 方法：

    ~~~javascript
    alert();//显示带有一段消息和一个确认按钮的警告框
    
    
    confirm();//显示带有一段消息和一个确认按钮和一个取消按钮的对话框，按确定返回true，按取消返回false
    
    var flag=confirm("点一下");
     if(flag){
         alert("来了老弟");
     }else{
         alert("别手抖");
     }
    
    
    prompt();//显示可提示用户输入的对话框，可加参数表示输入框之前的描述，返回值为用户输入的值
    
    var s=prompt("请随便输入点啥");
    alert(s);
    ~~~

  - 打开和关闭

    ~~~html
    close();//关闭调用该方法的浏览器窗口
    
    open();//打开一个新的浏览器窗口，参数可设置新窗口的地址,返回值是新窗口的Windows对象
    
    <body>
            <input id="openBtn" type="button" value="打开窗口">
            <input id="closeBtn" type="button" value="关闭窗口">
    
            <script>
                //打开一个新的浏览器窗口
                var openBtn=document.getElementById("openBtn");
                var w;
                openBtn.onclick=function(){
                    w=open("http://www.baidu.com");
                }
                closeBtn.onclick=function(){
                    w.close();
                }
            </script>
        </body>
    ~~~

  - 定时器

    ~~~javascript
    setTimeout("JS代码",毫秒数);//在指定毫秒数后调用函数或者计算表达式，返回值为一个id，表示该定时器的id编号
    clearTimeout();//取消由上者方法设置的timeout，可通过id来关闭定时器
    
    setInterval();//按照指定的周期（以毫秒计）来调用函数或者计算表达式，同样会返回id
    clearInterval();//取消由上者设置的Interval，可通过id来关闭定时器
    
    
    
    var id=setTimeout(fun,3000);
    clearTimeout(id);
    function fun(){
        alert("boom");
    }
    
    var id1=setInterval(fun,2000);
    clearInterval(id1);
    ~~~

    

- Navigator：浏览器对象

- Screen：显示器屏幕对象

- History：历史记录对象

- Location：地址栏对象
