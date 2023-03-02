package cn.itcast.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//1.�������������
		Calculator c=new Calculator();
		//2.��ȡ�ֽ����ļ�
		Class cls=c.getClass();
		//3.��ȡ���з���
		Method[] methods=cls.getMethods();
		
		int number=0;//�����쳣�Ĵ���
		BufferedWriter bw=new BufferedWriter(new FileWriter("bug.txt"));
		
		for(Method method : methods) {
			//4.�жϷ������Ƿ���checkע��
			if(method.isAnnotationPresent(Check.class)) {
				//5.�У�ִ��
				try {
					method.invoke(c);
				}catch(Exception e) {
					//6.�����쳣
					//��¼���ļ���
					
					number++;
					bw.write(method.getName()+"�������쳣��");
					bw.newLine();
					bw.write("�쳣������"+e.getCause().getClass().getSimpleName());
					bw.newLine();
					bw.write("�쳣��ԭ��"+e.getCause().getMessage());
					bw.newLine();
					bw.write("-----------------------------------------------------");
					bw.newLine();
				}
				
			}
		}
		bw.write("���β���һ������"+number+"���쳣");
		
		bw.flush();
		bw.close();
	}

}
