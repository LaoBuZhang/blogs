package cn.itcast.reflect;

import java.lang.reflect.Method;

import cn.itcast.domain.Person;

public class ReflectDemo5 {

	public static void main(String[] args) throws Exception
	{
		//��ȡ�����Ĺ���
		Class personClass=Person.class;
		
		String name=personClass.getName();
		System.out.println(name);
	}
}
