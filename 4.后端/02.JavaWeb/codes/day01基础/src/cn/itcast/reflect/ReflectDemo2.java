package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {

	public static void main(String[] args) throws Exception
	{
		//获取成员变量的功能
		Class personClass=Person.class;
		
		//Field[] getFields()  获取所有public修饰的变量
		Field[] fields=personClass.getFields();
		
		for(Field field :fields)
		{
			System.out.println(field);
		}
		
		System.out.println("----------------");
		
		//Field[] getField(String name)  获取名字为name的变量
		Field a=personClass.getField("a");
		Person p=new Person();
		Object value=a.get(p);//获取a的值
		System.out.println(value);
		a.set(p, "张三");//设置p.a的值为"张三"
		System.out.println(p);
		
		System.out.println("====================");
		
		//Field[] getDeclaredFields()  获取所有成员变量，不考虑修饰符
		Field[] fieldss=personClass.getDeclaredFields();
		for(Field field :fieldss)
		{
			System.out.println(field);
		}
		
		System.out.println("----------------");
		
		//Field[] getDeclaredField(String name)
		Field d=personClass.getDeclaredField("d");
		d.setAccessible(true);//暴力反射
		Object value2=d.get(p);
		System.out.println(value2);
	}
}
