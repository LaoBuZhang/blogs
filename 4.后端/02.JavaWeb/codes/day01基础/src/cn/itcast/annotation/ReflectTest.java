package cn.itcast.annotation;

import java.lang.reflect.Method;

@Pro(className="cn.itcast.annotation.Demo1",methodName="show")
public class ReflectTest {

	public static void main(String[] args) throws Exception{
		/*
		 	ǰ�᣺���ı��κδ��룬���Դ���������Ķ��󣬿���ִ�����ⷽ��
		 */
		
		//1.��ȡע��
		//1.1��ȡ������ֽ����ļ�����
		Class reflectTestClass=ReflectTest.class;
		
		//2.��ȡ�ϱߵ�ע�����
		//���ڴ���������һ����ע��ӿڵ�����ʵ�ֶ���
		//�൱��Pro�±�ע����Ĵ���
		Pro an=(Pro) reflectTestClass.getAnnotation(Pro.class);
		
		//3.����ע������ж���ĳ��󷽷�����ȡ����ֵ
		String className=an.className();
		String methodName=an.methodName();
		
		//4.���ظ�����ڴ�
		Class cls=Class.forName(className);
		//5.��������
		Object obj=cls.newInstance();
		//6.��ȡ���󷽷�
		Method method=cls.getMethod(methodName);
		//7.ִ�з���
		method.invoke(obj);
	}

}
