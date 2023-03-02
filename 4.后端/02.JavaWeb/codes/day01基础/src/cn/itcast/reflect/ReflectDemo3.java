package cn.itcast.reflect;

import java.lang.reflect.Constructor;

import cn.itcast.domain.Person;

public class ReflectDemo3 {

	public static void main(String[] args) throws Exception
	{
		//获取构造方法的功能
		Class personClass=Person.class;
		
		//含参的构造方法
		Constructor constructor =personClass.getConstructor(String.class,int.class);
		System.out.println(constructor);
		
		Object person=constructor.newInstance("张三",23);
		System.out.println(person);
		
		System.out.println("--------------");
		
		//不含参的构造方法
		Constructor constructor1 =personClass.getConstructor();
		System.out.println(constructor1);
		
		Object person1=constructor1.newInstance();
		System.out.println(person1);
		
		//简化的操作
		Object o=personClass.newInstance();
		System.out.println(o);
		
		constructor1.setAccessible(true);
	}
}
