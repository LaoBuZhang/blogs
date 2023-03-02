week1

[题目地址](https://vjudge.csgrandeur.cn/contest/505193#problem)



## A

#### 位运算

主要考察快速幂

这里贴上快速幂的板子

~~~c++
ll power(ll x,ll y,ll mod)
{
	ll ans=1;
	ll base=x;
	while(y)
	{
		if(y&1)ans=ans*base%mod;
		base=base*base%mod;
		y>>=1;
	}
	return ans;
}
~~~





## B

#### 位运算

对于一个二进制数的某一位，在经过多次二进制运算后，该位的值只与该位的初始值和运算有关，和其它位的初始值无关

由此，我们可以先用所有位都是1的二进制数和所有位都是0的二进制数先进行题述运算，然后再由最终的得到的数来判断初始数的该位应为1还是为0（最终得到的数每一位都尽可能要为1，这样才能使该数最大）

由于我们的初始值有限制，所以取0或1的策略就是能取0则取0，否则取1



~~~c++
#include<bits/stdc++.h>
#define ll long long
#define inf 0x3f3f3f3f

using namespace std;
int n,m;
int ans;
int ling=0;//每一位都为0
int yi=-1;//每一位都为1

int main()
{
	cin>>n>>m;
	for(int i=1;i<=n;i++)
	{
		string s;
		int t;
		cin>>s>>t;
		if(s[0]=='A')
		{
			ling=ling&t;
			yi=yi&t;
		}
		else if(s[0]=='O')
		{
			ling=ling|t;
			yi=yi|t;
		}
		else
		{
			ling=ling^t;
			yi=yi^t;
		}
	}
	
	for(int j=29;j>=0;j--)
	{
		if(ling>>j&1)ans+=(1<<j);
		else if((yi>>j&1)&&((1<<j)<=m))
		{
			ans+=1<<j;
		}
	}
	cout<<ans;
	return 0;
}
~~~



## C

#### 二维前缀和

求二维前缀和有两种方法

**方法一：**

~~~c++
for (int i = 1; i <= n; i ++)
    for (int j = 1; j <= n; j ++)
        s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
// a[i][j] 为原二维数组（下标范围 1~n）
// s[i][j] 为二维前缀和的结果
~~~



**方法二：**

~~~c++
for (int i = 1; i <= n; i ++)
    for (int j = 1; j <= n; j ++) s[i][j] = s[i][j - 1] + a[i][j];
for (int j = 1; j <= n; j ++)
    for (int i = 1; i <= n; i ++) s[i][j] += s[i - 1][j];
~~~



两种方法比较一下，方法一有一个劣势，可以注意到，它的递推式中总共有4项，如果再类比到三维前缀和，采用同样容斥思想，递推式中就总共有8项。一般地，采用容斥计算k维前缀和的复杂度为 O(2^k\*n^k) 当k较大时2^k就是一个很大的常数因子了，而方法二扩展到k维的复杂度为 O(k\*n^k)。在高维前缀和中会用到方法二的思想。



## D

#### 差分

利用差分，初始所有身高都设为最高，若两头牛能互相看见，则将这段区间全部减一即可（即差分的首位减一，末位加一）

~~~c++
#include<iostream>
#include<map>
#define ll long long
#define inf 0x3f3f3f3f

using namespace std;
int n,I,H,R;
int h[10005];
int a[10005],b[10005];
map<pair<int,int>,int>v;

int main()
{
	cin>>n>>I>>H>>R;
	h[1]=H;
	for(int i=1;i<=R;i++)
	{
		int a,b;
		cin>>a>>b;
		if(a>b)swap(a,b);
		
		if(v[make_pair(a,b)])continue;
		v[make_pair(a,b)]=1;
		
		h[a+1]--;
		h[b]++;
	}
	int sum=0;
	for(int i=1;i<=n;i++)
	{
		sum=sum+h[i];
		cout<<sum<<endl;
	}
	return 0;
}
~~~





## E

#### 二分答案（小数）

#### 前缀和



带精度的小数二分

前缀和：

枚举并固定右端点i，则要求区间的最大和，由于sum=s[r]-s[l]，现在r已经固定为i，只需要左端点的值s[l]最小即可

~~~c++
#include<iostream>
#define ll long long
#define inf 0x3f3f3f3f

using namespace std;
int n,f;
double lef=-1e6,rig=1e6,jing=1e-5;
double a[100005],b[100005];

double pre[100005];
bool check(double now)
{
	double minn=1e10;
	for(int i=1;i<=n;i++)
	{
		b[i]=a[i]-now;
	}
	for(int i=1;i<=n;i++)
	{
		pre[i]=pre[i-1]+b[i];
	}
	//若某一段区间的平均值大于now，则b中该段区间的和大于0
	for(int i=f;i<=n;i++)
	{
		minn=min(minn,pre[i-f]);//minn记录从1到i的前缀和最小值
		if(pre[i]-minn>=0)
		{
			return true;
		}
	}
	return false;
}
double erfen()
{
	while(rig-lef>jing)
	{
		double mid=(rig+lef)/2;
		if(check(mid))lef=mid;
		else rig=mid;
	}
	return rig;
}
int main()
{
	cin>>n>>f;
	for(int i=1;i<=n;i++)
	{
		cin>>a[i];
	}
	double ans=erfen();
	cout<<(int)((ans)*1000);
	return 0;
}
~~~



## F

#### 二分答案

#### 差分

~~~c++
#include<iostream>
#define ll long long
#define inf 0x3f3f3f3f

using namespace std;
ll n;
ll m;
ll r[1000005];
ll d[1000005];
ll s[1000005];
ll t[1000005];

ll pre[1000005];
ll pree[1000005];
bool check(int end)
{
	for(int i=1;i<=n;i++)
	{
		pree[i]=pre[i];
	}
	for(int i=1;i<=end;i++)
	{
		pree[s[i]]-=d[i];
		pree[t[i]+1]+=d[i];
	}
	ll sum=0;
	for(int i=1;i<=n;i++)
	{
		sum=sum+pree[i];
		if(sum<0)return false;
	}
	return true;
}
int erfen(int l,int r)
{
	int ans=0;
	while(l<=r)
	{
		int mid=(l+r)>>1;
		if(check(mid))
		{
			ans=mid;
			l=mid+1;
		}
		else r=mid-1;
	}
	return ans;
}
int main()
{
	cin>>n>>m;
	for(int i=1;i<=n;i++)
	{
		cin>>r[i];
	}
	for(int i=1;i<=n;i++)pre[i]=r[i]-r[i-1];
	for(int i=1;i<=m;i++)
	{
		cin>>d[i]>>s[i]>>t[i];
	}
	if(check(m))
	{
		cout<<"0";
		return 0;
	}
	int ans=erfen(1,m);
	cout<<"-1"<<endl<<ans+1;
	return 0;
}
~~~



## G

#### 离散化

#### map

#### 排序

~~~c++
#include<bits/stdc++.h>
#define ll long long
#define inf 0x3f3f3f3f

using namespace std;
int n,m;
int a[200005];
int b[200005];
unordered_map<int,int>num;
struct node
{
	int b,c;
	int id;
}e[200005];
bool cmp(node a,node b)
{
	if(num[a.b]!=num[b.b])
	{
		return num[a.b]>num[b.b];
	}
	return num[a.c]>num[b.c];
}
int main()
{
	cin>>n;
	for(int i=1;i<=n;i++)
	{
		cin>>a[i];
		num[a[i]]++;
	}
	cin>>m;
	for(int i=1;i<=m;i++)
	{
		cin>>e[i].b;
		e[i].id=i;
	}
	for(int i=1;i<=m;i++)
	{
		cin>>e[i].c;
	}
	sort(e+1,e+1+m,cmp);
	cout<<e[1].id;
	return 0;
}
~~~



## H

#### RMQ

#### ST算法



ST算法基于倍增的思想，可以再O(nlogn)预处理后，O(1)求出区间最值

其中，f\[i\]\[j\]表示

~~~c++
void ST_prework_max()
{
	for(int i=1;i<=n;i++)
	{
		f[i][0]=h[i];
	}
	int t=log(n)/log(2)+1;
	for(int j=1;j<t;j++)
	{
		for(int i=1;i<=n-(1<<j)+1;i++)
		{
			f[i][j]=max(f[i][j-1],f[i+(1<<(j-1))][j-1]);
		}
	}
}
int ST_query_max(int l,int r)//求h数组l到r的最大值
{
	int k=log(r-l+1)/log(2);
	return max(f[l][k],f[r-(1<<k)+1][k]);
}
~~~



## I

#### 贪心

**题意：**

 一个为n的字符序列，通过每次只能取首或者尾，形成一个新的字符串，要求字典序最小；

**贪心思路**

每次比较首尾，取字典序小的，若相等，则首位指针同时++和--，知道不相等，取字典序小的一边的所有



~~~c++
#include<iostream>
#include<string>
#define ll long long
#define inf 0x3f3f3f3f

using namespace std;
int n;
char s[2005];
string ans;

int op(int l,int r)
{
	while(l<r)
	{
		if(s[l]<s[r])return 1;
		else if(s[l]>s[r])return 2;
		l++;
		r--;
	}
	return 1;
}
int main()
{
	cin>>n;
	for(int i=1;i<=n;i++)
	{
		cin>>s[i];
	}
	int l=1;
	int r=n;
	int num=0;
	for(int i=1;i<=n;i++)
	{
		if(op(l,r)==1)cout<<s[l++];
		else cout<<s[r--];
		num++;
		if(num==80)
		{
			num=0;
			cout<<endl;
		}
	}
	return 0;
}
~~~



## J

#### 贪心

#### priority_queue实现小根堆

**题意**

农夫约翰为了修理栅栏，要将一块很长的木板切割成N块。准备切成的木块的长度为L1， L2,…Ln,未切割前木板的长度恰好为切割后木板长度的总和。每次切割木板时，需要的开销为这块木板的长度。例如长度为21的木板要切成长度为5，8，8的三块木板。长21的木板切成长为13和8的木板时，开销为21.再将长度为13的板切成长度为5和8的板时，开销为13.于是合计开销时34.请求出按照目标要求将木板切割完最小的开销是多少。


**贪心思路**

每次选择最小的两块木板相加，并将结果加入待选择木板列中，直到只剩下一块木板为止。



~~~c++
#include<iostream>
#include<cmath>
#include<algorithm>
#include<queue>
#define ll long long
#define inf 0x3f3f3f3f
using namespace std;
int n;
int l[20005];
bool cmp(int a,int b)
{
	return a>b;
}
priority_queue<int,vector<int>,greater<int> >q;//priority_queue实现小根堆（默认为大根堆）
ll ans=0;

int main()
{
	cin>>n;
	for(int i=1;i<=n;i++)
	{
		cin>>l[i];
		q.push(l[i]);
	}
	while(q.size()>1)
	{
		int a=q.top();
		q.pop();
		int b=q.top();
		q.pop();
		ans+=a+b;
		q.push(a+b);
	}
	cout<<ans;
	return 0;
}
~~~



## k

#### 贪心

#### 区间覆盖



**题意:**

就是雷达放x轴上，探测范围为d为半径的圆，小岛在第一第二象限，要你用最少的雷达数覆盖所有小岛。如果其中有一个岛找不到就输出-1。

**贪心思路**

可以先转化为区间问题：以岛为圆心，作半径为d的圆，该圆与x轴的交点间的范围就是要探测该岛雷达可以放置的位置。把这些范围用一条一条的线段表示。

把这些线段的左端点按从小到大的顺序排列，为了尽可能使雷达数少，我们可以遍历一条一条的线段，然后记下当前线段的最小右端点，如果接下来出现的线段的左端点比该最小右端点大，则加一个雷达。



~~~c++
#include<iostream>
#include<cmath>
#include<algorithm>
#define ll long long
#define inf 0x3f3f3f3f

using namespace std;
int n;
double d;
struct node
{
	double x,y;
	double len;
	double l,r;
}e[1005];
int num=0;
bool cmp(node a,node b)
{
	return a.l<b.l;
}

int main()
{
	while(1)
	{
		num++;
		bool flag=true;
		cin>>n>>d;
		if(n==0&&d==0)break;
		for(int i=1;i<=n;i++)
		{
			cin>>e[i].x>>e[i].y;
			e[i].len=sqrt(d*d-e[i].y*e[i].y);
			e[i].l=e[i].x-e[i].len;
			e[i].r=e[i].x+e[i].len;
			if(e[i].y>d)
			{
				flag=false;
			}
		}
		if(!flag)
		{
			cout<<"Case "<<num<<": -1"<<endl;
		}
		else
		{
			sort(e+1,e+1+n,cmp);
			int ans=0;
			double now=-1e9;
			for(int i=1;i<=n;i++)
			{
				if(e[i].l>now)
				{
					ans++;
					now=e[i].r;
				}
				else if(e[i].r<now)
				{
					now=e[i].r;
				}
			}
			cout<<"Case "<<num<<": "<<ans<<endl;
		}	
	}
	return 0;
}
~~~



## L

#### 二分答案

#### 前缀和

#### 离散化

#### vector去重和排序

**题意**
有 n 个单位的三叶草，每单位三叶草占据一个 1 × 1 的土地，每块土地的位置由其左下角的下标确定，并且下标 x 和 y 都是整数，且 1 ≤ x , y ≤ 10000 。

农夫约翰希望为他的奶牛们建立一个畜栏。其中畜栏必须是正方形，且至少要包含 C CC 单位的三叶草。

要求出至少包含 C CC 单位的三叶草情况下，畜栏的最小边长。

注意：每个区域可能会有多个单位的三叶草，所以输入的时候，可能会出现多个相同区域坐标。

**vector**

~~~c++
vector<int>st;
sort(st.begin(),st.end());//排序
st.erase(unique(st.begin(),st.end()),st.end());//去重 
~~~

PS：因为unique是判断当前元素是否等于上一个元素，所以要去重的容器必须是经过排序的有序容器。

关于vector去重和unique的用法在[这篇博客](https://blog.csdn.net/sandalphon4869/article/details/98209093)里讲的比较清楚

**离散化**

当数组范围过大时直接前缀和会超空间

可以很明显地想到用前缀和去维护每个二维区间的三叶草数量，预处理后，可以在O(1)的时间复杂度下求出某个区间的三叶草数量。

因为坐标的范围是[1,10000]，直接开二维数组暴力遍历的情况是不现实的，于是要进行坐标的优化。

观察题面n≤500，可以知道 x，y 的所有坐标离散化到一个数组后，数组的元素个数最大也只有 1000 。于是我们可以离散化所有的坐标，并存储到一个数组（有序且无重复，可以用vector+去重+sort，因为后续需要随机访问，所以不用set，或者set存储后再存到普通数组里边）里，再用这个数组进行前缀和的计算，这样复杂度就大大降低了。


**二分策略：**

二分答案

check函数在坐标数组中寻找差值小于mid的两个x和y值（即使比mid小也可，应为mid长的话一定可以包括这个区间），计算前缀和，判断是否满足即可



~~~c++
#include<iostream>
#include<vector>
#include<algorithm>
#define ll long long
#define inf 0x3f3f3f3f

using namespace std;
int n,c;
struct node
{
	int x,y;
}e[505];
vector<int>st;
int sum[1005][1005];

bool check(int l)
{
	for(int x1=0,x2=1;x2<st.size();x2++)
	{
		while(st[x2]+1-st[x1+1]>l)x1++;
		for(int y1=0,y2=1;y2<st.size();y2++)
		{
			while(st[y2]+1-st[y1+1]>l)y1++;
			if(sum[x2][y2]-sum[x1][y2]-sum[x2][y1]+sum[x1][y1]>=c)
			{
				return true;
			}
		}
	}
	return false;
}
int erfen(int l,int r)
{
	int ans=10000;
	int num=0;
	while(l<=r)
	{
		int mid=(l+r)>>1;
		if(check(mid))
		{
			r=mid-1;
			ans=mid;
		}
		else
		{
			l=mid+1;
		}
	}
	return ans;
}
int find(int x)
{
	return lower_bound(st.begin(),st.end(),x)-st.begin();
}
int main()
{
	cin>>c>>n;
	st.push_back(0);
	for(int i=1;i<=n;i++)
	{
		cin>>e[i].x>>e[i].y;
		st.push_back(e[i].x);
		st.push_back(e[i].y);
	}
	sort(st.begin(),st.end());
	st.erase(unique(st.begin(),st.end()),st.end());//去重 
	for(int i=1;i<=n;i++)
	{
		int x=find(e[i].x);
		int y=find(e[i].y);
		sum[x][y]++;
	}
	for(int i=1;i<st.size();i++)
	{
		for(int j=1;j<st.size();j++)
		{
			sum[i][j]+=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
		}
	}
	int ans=erfen(1,10000);
	cout<<ans;
	return 0;
}
~~~



## M

#### ST算法返回最值索引



**ST返回最大值的索引**

~~~c++
void ST_prework()
{
	for(int i=1;i<=n;i++)f[i][0]=i;
	int t=log(n)/log(2)+1;
	for(int j=1;j<t;j++)
	{
		for(int i=1;i<=n-(1<<j)+1;i++)
		{
			int x=f[i][j-1];
			int y=f[i+(1<<(j-1))][j-1];
			f[i][j]=sum[x]>sum[y]?x:y;
		}
	}
}
int ST_query(int l,int r)//返回最大值的位置 
{
	int k=log(r-l+1)/log(2);
	int x=f[l][k];
	int y=f[r-(1<<k)+1][k];
	return sum[x]>sum[y]?x:y;
}
~~~



**思路**

枚举左端点，寻找最大的右端点，加入优先队列，同时次大的右端点也可能比当前队列中的更有，需要判断一下

~~~c++
#include<bits/stdc++.h>
#define ll long long
#define inf 0x3f3f3f3f

using namespace std;
int n,k,l,r;
ll ans;
int a[500005];
int sum[500005];
int f[500005][30];
struct node
{
	int num,lid,rid,w,data;
	bool operator <(node i)const
	{
		return data<i.data;
	}
};
priority_queue<node>q;
void add(int po,int i,int left,int right)
{
	node tmp;
	tmp.w=po;
	tmp.num=i;//记录和弦左端点 
	tmp.lid=left;
	tmp.rid=right;
	tmp.data=sum[po]-sum[i-1];//和弦的美妙度 
	q.push(tmp);
}

void ST_prework()
{
	for(int i=1;i<=n;i++)f[i][0]=i;
	int t=log(n)/log(2)+1;
	for(int j=1;j<t;j++)
	{
		for(int i=1;i<=n-(1<<j)+1;i++)
		{
			int x=f[i][j-1];
			int y=f[i+(1<<(j-1))][j-1];
			f[i][j]=sum[x]>sum[y]?x:y;
		}
	}
}
int ST_query(int l,int r)//返回最大值的位置 
{
	int k=log(r-l+1)/log(2);
	int x=f[l][k];
	int y=f[r-(1<<k)+1][k];
	return sum[x]>sum[y]?x:y;
}
int main()
{
	cin>>n>>k>>l>>r;
	for(int i=1;i<=n;i++)
	{
		cin>>a[i];
		sum[i]=sum[i-1]+a[i];
	}
	ST_prework();
	for(int i=1;i+l-1<=n;i++)
	{
		//从i位置到i+l和i+r位置
		//ST找到max(sum[i+l~i+r])
		//然后 max(sum[i+l~i+r])-sum[i]; 为一个满足条件的和弦 
		add(ST_query(i+l-1,min(i+r-1,n)),i,i+l-1,min(i+r-1,n));
	}
	while(k--)
	{
		int d=q.top().w;//当前和弦右端点的位置 
		int left=q.top().lid;
		int right=q.top().rid;
		int e=q.top().data;
		int id=q.top().num;
		q.pop();
		ans+=e;
		
		//次大的右端点也可能比当前队列中的大 
		if(d>left)
		{
			add(ST_query(left,d-1),id,left,d-1);
		}
		if(d<right)
		{
			add(ST_query(d+1,right),id,d+1,right);
		}
	}
	cout<<ans;
	return 0;
}
~~~





## N

#### 数学推理

具体推理如下链接

[题解 P2512 [HAOI2008\]糖果传递 - wyhwyh - 洛谷博客 (luogu.com.cn)](https://www.luogu.com.cn/blog/wyhqwq/solution-p2512)



~~~c++
#include<bits/stdc++.h>
#define ll long long
#define inf 0x3f3f3f3f

using namespace std;
ll n;
ll a[1000005];
ll c[1000005];
ll ave;

int main()
{
	cin>>n;
	for(int i=1;i<=n;i++)
	{
		cin>>a[i];
		ave+=a[i];
	}
	ave/=n;
	for(int i=1;i<=n;i++)
	{
		c[i]=c[i-1]-a[i-1]+ave;
	}
	sort(c+1,c+1+n);
	ll mid=c[(n+1)/2];
	ll ans=0;
	for(int i=1;i<=n;i++)
	{
		ans+=abs(mid-c[i]);
	}
	cout<<ans;
	return 0;
}
~~~





## O

#### 贪心

#### dfs



**题意**

有1，5，10，20，50，100，200，500，1000，2000十种面值的钱币各ci个，现在要凑出p元，问最多可以用多少钱币凑出



**贪心思路**

按贪心的思想，**用尽可能多的小面值钱币**，前提是小面值钱币可以凑出当前需要的钱数，所以从大面值的开始决策，比如现在到第idx个面值的钱币，要凑x元，又用1~idx-1的钱币可以凑出的总金额为y元，那么当前面值我需要用(x - y) / c[i]个，当然如果这个值小于0，就不用当前面值的钱币，注意如果c[i]不能整除(x- y)，则需要多用一个idx的钱币，因为剩下的钱不够，比如有 10 20 20 50 50，现在要凑110，110 - 10 - 20 - 20 = 60，50不能整除60，则就需要两个50的，因为只用一个50的话，剩下的凑不出60，还有一点要注意的是20不能整除50，200不能整除500，因此我们算个数的时候有时需要多加一个，比如20 20 20 50，现在要凑50，因为剩下3个20，一共可以凑60，按照贪心策略那个单独的50就不会被选了，因此这里需要强制选一个50，200和500同理


~~~c++
#include<iostream>
#define ll long long
#define inf 0x3f3f3f3f3f3f3f3f


using namespace std;
ll t;
ll c[20]={0,1,5,10,20,50,100,200,500,1000,2000};
ll p;
ll num[20];
ll sum=0;
ll all=0;
ll ans; 
ll min(ll a,ll b)
{
	return a<b?a:b;
}
void dfs(int cur,ll tot,ll cnt)
{
	if(tot<0)return;
	if(cur==0)
	{
		if(tot==0)ans=min(ans,cnt);
		return;
	}
	ll tmp=min((ll)num[cur],tot/c[cur]);//当前的面值的硬币能拿就拿 
	dfs(cur-1,tot-tmp*c[cur],cnt+tmp);
	if(tmp)dfs(cur-1,tot-(tmp-1)*c[cur],cnt+tmp-1);
	//20不是50的因子，200不是500的因子，但是20却是50+50的因子，200却是500+500的因子，这意味着拿50和500的时候，还要考虑拿少一个硬币的情况
}
int main()
{
	cin>>t;
	while(t--)
	{
		sum=0;
		all=0;
		ans=inf;
		cin>>p;
		for(int i=1;i<=10;i++)
		{
			cin>>num[i];
			sum+=num[i]*c[i];
			all+=num[i];
		}
		if(p>sum)
		{
			cout<<-1<<endl;
		}
		else
		{
			dfs(10,sum-p,0);
			if(ans==inf)cout<<-1<<endl;
			else
			{
				cout<<all-ans<<endl;
			}
		}
	}
	return 0;
}
~~~

