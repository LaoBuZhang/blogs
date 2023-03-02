package cn.itcast.reflect;

import cn.itcast.domain.Person;

public class ReflectDemo1 {

	/*
	 * ��ȡClass����ķ�ʽ��
	 * 1. Class.forName("ȫ����")        ���ֽ����ļ����ؽ��ڴ棬����Class����
	 * 2. ����.class                 ͨ������������class��ȡ
	 * 3. ����.getClass()            getClass()������Object���ж�����
	 */
	
	public static void main(String[] args)throws Exception
	{
		
		//1.
		Class cls1=Class.forName("cn.itcast.domain.Person");
		System.out.println(cls1);
		
		//2.
		Class cls2=Person.class;
		System.out.println(cls2);
		
		//3.
		Person p=new Person();
		Class cls3=p.getClass();
		System.out.println(cls3);
	}
	
}
