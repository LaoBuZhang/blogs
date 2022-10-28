# Git学习笔记

## 1.版本控制工具

1. 本地版本控制

   适合个人使用，如RCS

2. 集中版本控制

   所有版本都放在服务器上，用户本地只有自己以前所同步的版本，必须联网，如SVN，CVS，VSS

3. 分布式版本控制

   每个用户都有所有的版本信息，每个人都有全部的代码，可不联网时也工作，没有中央服务器，一般有一个共享版本库，如Git

## 2.Git历史

Linux开源项目由众多参与者，维护繁琐，所以最开始与BitKeeper合作来管理和维护代码

社区中很多大佬研究破解BitKeeper

合作破裂，Linux创始人用两周左右开发了Git系统，替代BitKeeper

Linux和Git之父，李纳斯·托兹沃（Linus Benedic Torvalds）1969 芬兰



## 3.Git优点

- 速度
- 简单设计
- 对非线性开发的强力支持
- 完全分布式
- 有能力管理大规模项目



## 4.Git配置

### Git Bash

Unix与Linux风格的命令行，使用最多，推荐

![](.\images\gitBash.png)

### Git CMD

Windows风格的版本命令行

### Git GUI

图形化的Git

### Linux基本命令

1. cd：更改目录
2. cd ..：退回到上一个目录
3. pwd：显示当前路径
4. ls(ll)：列出目录所有文件，加上(ll)会列出更详细的信息
5. touch 文件名：新建一个文件
6. rm 文件名：删除文件
7. mkdir：新建文件夹
8. rm -r 文件夹名：删除文件夹
9. mv 文件名 文件夹名：移动文件到文件夹，需要在同一目录下
10.  reset ：清屏
11. clear：清屏
12. history：查看历史命令
13. help：帮助
14. exit：退出
15. #：注释

### Git环境配置

在git bash或者cmd中

~~~shell
git config -l
git config --system --list
git config --global --list

#查看git配置
~~~

~~~shell
git config --global user,name "用户名"
git config --global user.email 邮箱

#配置用户信息
~~~

### 配置指令别名

1. 打开用户目录，创建一个 .bashrc文件

   若无创建权限，在git bash里输入touch ~/.bashrc是一样的效果

   ![](.\images\创建rc源文件.png)

2. 在.bashrc输入如下内容

   ~~~shell
   #用于输出git提交日志
   alias git-log='git log --pretty=oneline --all --graph --abbrev-commit'
   
   #用于输出当前目录所有文件及基本信息
   alias ll='ls -al'
   ~~~

3. 打开git Bash执行source ~/.bashrc





**Git配置文件存储地址：**

1. git\etc\gitconfig                                  --system的配置
2. C:\User\Administrator\.gitconfig      --global的配置

可以手动修改





## 5.Git基本理论

### Git组成

本地由三个工作区域：

1. 工作目录（Working Directory）
2. 暂存区（Stage/Index）
3. 资源库（Respository或Git Directory）

远程有一个工作区

- 远程git仓库（remote Directory）

- Workspace：工作区，平时存放项目代码的地方
- Index/Stage：暂存区，用于临时存放改动，就是一个文件，保存即将提交到文件列表的信息
- Repository：仓库区（本地仓库），就是安全存放数据的位置，这里由你提交的所有版本的数据。HEAD（位于.git文件夹内）指向最新放入仓库的版本
- Remote：远程仓库，托管代码的服务器



### Git工作流程

![](.\images\git运作模式.png)

![](.\images\git工作流程.png)



##  6.Git文件状态

git中的文件分有几种状态，需要通过几步操作最终提交文件到Git控制的版本中

![](.\images\git文件状态.png)



## 7.Git文件提交流程

通过git add和git commit改变文件状态，并最终通过git push提交文件到远程仓库

![](.\images\git文件提交流程.png)

1. git add  工作区->暂存区
2. git commit 暂存区->本地仓库
3. git psuh 本地仓库->远程仓库



## 8.Git远程仓库

使用代码托管服务

1. github
2. gitee
3. gitlab 需要自己搭建，但是更加安全



### 配置SSH公钥

不用每次都提交都输入账号密码

1. ~~~shell
   ssh-keygen -t rsa
   #生成公钥，若有则覆盖
   ~~~

2. ~~~shell
   cat ~/.ssh/id_rsa.pub
   #查看公钥
   ~~~

3. 在gitee或者github的设置中输入生成的公钥

## 9.Git相关命令

在想创建的位置打开git Bash或者cmd

### 1.创建工程

#### 1.1.在本地创建工程

~~~shell
git init
~~~

生成.git目录说明创建成功

#### 1.2.克隆工程

将工程文件夹复制到当前所在的本地文件夹

~~~shell
git clone 网址

# git clone http://119.3.199.81:8888/neuq202208/team05
~~~

### 2.分支

使用分支可以把工作从开发主线上分离开来进行重大的BUG修改，开发新功能，以免影响主线开发

#### 2.1.查看工程分支

- 查看本地分支

  ~~~shell
  git branch
  ~~~

- 查看远程仓库的所有分支

  ~~~shell
  git branch -a
  ~~~

  

#### 2.2.创建工程分支

- 创建并切换分支(创建后新分支并进入该分支)

  ~~~shell
  git checkout -b 分支名
  
  # git checkout -b laobuzhang
  ~~~

- 创建分支(创建后仍然停留在当前分支)

  ~~~shell
  git branch 分支名
  
  # git branch laobuzhang
  ~~~

#### 2.3.切换分支

- 切换到指定分支

  ~~~shell
  git checkout 分支名
  
  # git checkout laobuzhang
  ~~~

#### 2.4.查看对应的远端分支

~~~shell
git branch -vv
#查看当前分支对应远程的哪个分支
~~~



#### 2.5.合并分支

~~~shell
git merge 分支名称
#将指定的分支合并到当前分支
~~~



#### 2.6.解决冲突

若在两个分支中修改了相同的文件，并且对两个分支执行merge操作，则会产生冲突，此时需要手动解决冲突

执行merge后会报错，并且冲突的文件会被修改为下列样式

![](.\images\解决冲突.png)

- 其中HEAD到====之间的是当前分支中该文件的内容

- ====到>>>dev之间表示dev分支中该文件的内容

此时**手动修改**成想要的内容（记得将git生成的那三行删掉），然后add+commit即可完成合并

在commit后会进入一个merge的信息界面，此时先esc，再输入:wq即可退出该界面



### 3.远程仓库

#### 3.1.和远程仓库建立连接

~~~shell
git remote add origin 远程仓库地址
#将本地git项目和远程仓库建立连接，并将远程仓库起名为origin
~~~

#### 3.2.检查远程仓库

~~~shell
git remote
~~~



### 4.提交文件

#### 4.1.获取远程仓库文件

1. ~~~shell
   git fetch [remote name] [branch name]
   
   #将远程的分支抓取到本地，并作为一个新分支保存再本地
   #若不指定参数，则抓取相连接的分支
   ~~~

2. ~~~shell
   git merge origin/master
   #将fetch下来的分支合并到本地分支
   ~~~

这两步操作可以合并为一步，拉取远程分支到本地

~~~shell
git pull
#git pull == git fetch && git merge
~~~

有冲突时，git pull会报错，需要使用merge手动合并，在idea中比较容易操作

#### 4.2.查看文件状态

- 查看当前是否有新加入的文件或者删除的文件

  ~~~shell
  git status
  ~~~

#### 4.3.提交文件

使用copy con或者直接在文件夹中新建新文件

使用git status查看当前未提交的文件

- 添加指定文件到缓存

  ~~~shell
  git add 文件名
  
  # git add 1.txt
  ~~~

- 添加所有文件到缓存区

  ~~~shell
  git add .\
  ~~~

- 将缓存区内容添加到本地仓库中

  ~~~shell
  git commit -m "日志信息(自己写)"
  
  # git commit -m "init commit"
  ~~~

- 推送到远程仓库

  ~~~shell
  git push [-f] [--set-upstream] [远程仓库名称[本地分支名][:远程仓库分支名]]
  
  #git push origin master:master
  #两个仓库名字一样可以省略
  #git push相当于是将当前分支推送的到远端对应连接的分支
  ~~~
  
  - -f 表示强制覆盖
  - --set-upstream 推送的同时建立和远端仓库的分支建立关联关系，若之前连接过一次，后边就不用再连接

#### 4.4.查看日志

- 查看提交记录的日志

~~~shell
git log --X

#--X处可省略或者填入不同参数
--all 显示所有分支
--pretty=oneline 将提交信息显示为一行
--abbrev-commit 使得输出的commitld更加简短
--graph 以图的形式显示

（配置指令别名后可用git-log，包含上边所有参数）
~~~



### 5.删除

#### 5.1.删除文件

使用del或者直接在文件夹中删除文件

使用git status查看当前未提交的文件

~~~shell
git commit -m 只是git add 之后⽂件在暂存区之后的提交，如果暂存区没有add，是没有效果的。

git commit -am 是之前 提交过到⼯作区的⽇志信息已经存在（git commit -m “⽇志信息” ⽂件名）已经
  执⾏过，再执⾏同样的⽇志信息可以不⽤add，⼀步到位  
~~~

- 提交删除

  ~~~shell
  git commit -am "日志信息(自己写)"
  
  # git commit -am "delete 3.txt"
  ~~~

- 推送到相应的分支

  ~~~shell
  git push origin 分支名
  ~~~

#### 5.2.删除分支

- 删除远程仓库的分支(分支名不带前边的remotes/origin)

  ~~~shell
  git push origin --delete 分支名
  
  # git push origin --delete laobuzhang
  ~~~

- 删除本地分支(不能删除当前所在的分支)

  ~~~shell
  git branch -D 分支名
  
  # git branch -D laobuzhang
  ~~~



### 6.版本回退

~~~shell
git reset --hard commitID

#commitID可以通过git-log查询
~~~

**查看已删除的记录**

回退版本后，当前版本之后的提交都无法在通过git-log查询，此时若想在回去，可以使用git reflog查询到那些后来版本的commitID

然后再次使用git reset回到那些版本



### 7.忽略文件

创建一个.gitignore文件，在里边输入需要忽略的文件

~~~shell
*.a
#忽略所有后缀名为a的文件
~~~



## 10.分支的使用原则与流程

- master （生产）分支

  线上分支，主分支，运行的项目对应的分支

- develop （开发）分支

  从master中拉取的分支，需要开发功能时，从develop分支拉取feature分支，再feature分支上修改，再合并到develop分支上

  开发完成后，将develop分支合并到master分支上

- feature分支

  从develop中拉取，用于开发

- hotfix分支

  从master中拉取，用于修改bug，修改完成后，同时合并到master和develop分支

![](.\images\分支使用原则.png)

## 11.Idea的Git

![](.\images\idea的git1.png)

右上角的三个分别代表pull add+commit 和 push

左下边是分支查看，黄色标签代表当前所查看的分支

右边是各个版本，可以右键某一版本

![](.\images\idea的git2.png)

1. copy revision nymber：复制版本编号，每个版本都有相应编号

2. create patch：创建补丁，方便一次修改多个分支

   [IDEA 使用补丁 patch，idea导入patch](https://blog.csdn.net/LitongZero/article/details/83012196)

3. chery pick：只拉取某些commit

   [idea中，git的cherry-pick](https://blog.csdn.net/qq_23167527/article/details/102595278)

4. check out ''：查看某一版本

5. conpare with local：与本地最新版本进行比较





## 12.Git问题总结

1. error: failed to push some refs to "远程仓库地址"

   共有下面的错误原因：

   1. 分支名不完整
   2. 没有提交代码
   3. 本地与远程产生冲突

   解决方法：

   [提交代码报错 error: failed to push some refs to](https://cloud.tencent.com/developer/article/1773434)

