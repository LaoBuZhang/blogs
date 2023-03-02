package cn.itcast.annotation;

import java.lang.reflect.Method;

@Pro(className="cn.itcast.annotation.Demo1",methodName="show")
public class ReflectTest {

	public static void main(String[] args) throws Exception{
		/*
		 	前提：不改变任何代码，可以创建任意类的对象，可以执行任意方法
		 */
		
		//1.获取注解
		//1.1获取该类的字节码文件对象
		Class reflectTestClass=ReflectTest.class;
		
		//2.获取上边的注解对象
		//在内存中生成了一个该注解接口的子类实现对象
		//相当于Pro下边注释里的代码
		Pro an=(Pro) reflectTestClass.getAnnotation(Pro.class);
		
		//3.调用注解对象中定义的抽象方法，获取返回值
		String className=an.className();
		String methodName=an.methodName();
		
		//4.加载该类进内存
		Class cls=Class.forName(className);
		//5.创建对象
		Object obj=cls.newInstance();
		//6.获取对象方法
		Method method=cls.getMethod(methodName);
		//7.执行方法
		method.invoke(obj);
	}

}
