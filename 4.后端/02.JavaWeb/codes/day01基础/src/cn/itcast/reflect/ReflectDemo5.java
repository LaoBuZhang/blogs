package cn.itcast.reflect;

import java.lang.reflect.Method;

import cn.itcast.domain.Person;

public class ReflectDemo5 {

	public static void main(String[] args) throws Exception
	{
		//获取方法的功能
		Class personClass=Person.class;
		
		String name=personClass.getName();
		System.out.println(name);
	}
}
