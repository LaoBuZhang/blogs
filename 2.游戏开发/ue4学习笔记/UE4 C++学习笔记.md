# UE4 C++学习笔记

## UPROPERTY的作用

将变量公开到编辑器或者蓝图

在UE4的编辑器中：

1. VisibleAnywhere：声明此关键词后，该变量会出现在蓝图编辑器的右边的主编辑器右下，但只显示不可编辑
2. VisibleDefaultsOnly：主编辑器不显示，蓝图编辑器显示，不可编辑
3. EditDefaultsOnly：主编辑器不显示，蓝图编辑器中显示并且可编辑
4. EditAnyWhere：主编辑器和蓝图编辑器中均可编辑
5. EditInstanceOnly：以后再说

