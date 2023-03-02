package cn.itcast.reflect;

import java.lang.reflect.Method;

import cn.itcast.domain.Person;

public class ReflectDemo4 {

	public static void main(String[] args) throws Exception
	{
		//获取方法的功能
		Class personClass=Person.class;
		
		Method eat_method=personClass.getMethod("eat");
		Person p=new Person();
		
		eat_method.invoke(p);
		
		Method eat_method2=personClass.getMethod("eat",String.class);
		eat_method2.invoke(p,"饭");
		
		
		System.out.println("--------------");
		
		//获取所有public方法
		Method[] methods=personClass.getMethods();
		for(Method method : methods)
		{
			System.out.println(method);
			String name=method.getName();
			System.out.println(name);
		}

	}
}
