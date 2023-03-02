# c++ lower_bound与upper_bound



**正常使用时数列必须时是升序**

lower_bound会找出序列中第一个**大于等于**x的数

若x比数列所有的数都大，会返回最后一个数后边的一个地址指针



upper_bound会找出序列中第一个**大于**x的数

若x大于等于数列最小的数，会返回最后一个数后边的一个地址指针

~~~c++
lower_bound(a+1,a+1+n,x);
~~~





**对降序数列使用：**

lower_bound会找出序列中第一个**小于等于**x的数

若x比数列所有的数都小，会返回最后一个数后边的一个地址指针



upper_bound会找出序列中第一个**小于**x的数

若x小于等于数列最小的数，会返回最后一个数后边的一个地址指针

~~~c++
bool cmp(int a,int b){return a > b;}
lower_bound(a+1,a+1+n,x,cmp);
~~~

