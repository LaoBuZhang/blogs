package cn.itcast.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {

	public static void main(String[] args) throws Exception{
		

		//1.���������ļ�
		//1.1����Properties����
		Properties pro=new Properties();
		//1.2���������ļ���ת��Ϊһ������
		//1.2.1��ȡclassĿ¼�µ������ļ�
		ClassLoader classLoader=ReflectTest.class.getClassLoader();
		InputStream is=classLoader.getResourceAsStream("pro.properties");
		pro.load(is);
		
		
		//2.��ȡ�����ļ��ж��������
		String className=pro.getProperty("className");
		String methodName=pro.getProperty("methodName");
		
		
		//3.���ظ�����ڴ�
		Class cls=Class.forName(className);
		//4.��������
		Object obj=cls.newInstance();
		//5.��ȡ���󷽷�
		Method method=cls.getMethod(methodName);
		//6.ִ�з���
		method.invoke(obj);
	}

}
