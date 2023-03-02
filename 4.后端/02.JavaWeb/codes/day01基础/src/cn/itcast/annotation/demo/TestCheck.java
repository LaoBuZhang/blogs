package cn.itcast.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//1.创建计算机对象
		Calculator c=new Calculator();
		//2.获取字节码文件
		Class cls=c.getClass();
		//3.获取所有方法
		Method[] methods=cls.getMethods();
		
		int number=0;//出现异常的次数
		BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));
		
		for(Method method : methods) {
			//4.判断方法上是否有check注解
			if(method.isAnnotationPresent(Check.class)) {
				//5.有，执行
				try {
					method.invoke(c);
				}catch(Exception e) {
					//6.捕获异常
					//记录到文件中
					
					number++;
					bw.write(method.getName()+"方法出异常了");
					bw.newLine();
					bw.write("异常的名称"+e.getCause().getClass().getSimpleName());
					bw.newLine();
					bw.write("异常的原因"+e.getCause().getMessage());
					bw.newLine();
					bw.write("-----------------------------------------------------");
					bw.newLine();
				}
				
			}
		}
		bw.write("本次测试一共出现"+number+"次异常");
		
		bw.flush();
		bw.close();
	}

}
