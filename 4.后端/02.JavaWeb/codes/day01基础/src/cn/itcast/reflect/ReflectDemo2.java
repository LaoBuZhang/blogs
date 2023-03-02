package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {

	public static void main(String[] args) throws Exception
	{
		//��ȡ��Ա�����Ĺ���
		Class personClass=Person.class;
		
		//Field[] getFields()  ��ȡ����public���εı���
		Field[] fields=personClass.getFields();
		
		for(Field field :fields)
		{
			System.out.println(field);
		}
		
		System.out.println("----------------");
		
		//Field[] getField(String name)  ��ȡ����Ϊname�ı���
		Field a=personClass.getField("a");
		Person p=new Person();
		Object value=a.get(p);//��ȡa��ֵ
		System.out.println(value);
		a.set(p, "����");//����p.a��ֵΪ"����"
		System.out.println(p);
		
		System.out.println("====================");
		
		//Field[] getDeclaredFields()  ��ȡ���г�Ա���������������η�
		Field[] fieldss=personClass.getDeclaredFields();
		for(Field field :fieldss)
		{
			System.out.println(field);
		}
		
		System.out.println("----------------");
		
		//Field[] getDeclaredField(String name)
		Field d=personClass.getDeclaredField("d");
		d.setAccessible(true);//��������
		Object value2=d.get(p);
		System.out.println(value2);
	}
}
