package cn.itcast.reflect;

import java.lang.reflect.Constructor;

import cn.itcast.domain.Person;

public class ReflectDemo3 {

	public static void main(String[] args) throws Exception
	{
		//��ȡ���췽���Ĺ���
		Class personClass=Person.class;
		
		//���εĹ��췽��
		Constructor constructor =personClass.getConstructor(String.class,int.class);
		System.out.println(constructor);
		
		Object person=constructor.newInstance("����",23);
		System.out.println(person);
		
		System.out.println("--------------");
		
		//�����εĹ��췽��
		Constructor constructor1 =personClass.getConstructor();
		System.out.println(constructor1);
		
		Object person1=constructor1.newInstance();
		System.out.println(person1);
		
		//�򻯵Ĳ���
		Object o=personClass.newInstance();
		System.out.println(o);
		
		constructor1.setAccessible(true);
	}
}
