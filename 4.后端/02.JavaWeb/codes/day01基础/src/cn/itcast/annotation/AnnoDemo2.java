package cn.itcast.annotation;

import java.sql.Date;

@SuppressWarnings("all")
public class AnnoDemo2 {

	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Deprecated
	public void show1() {
		//��ȱ��
	}
	
	@MyAnno2
	public void show2() {
		//�滻show1�ķ���
	}
	
	@MyAnno(age=12,name="zhang3",per=People.P1,anno2=@MyAnno2,s= {"123","456"})
	public void demo() {
		show1();
		Date date=new Date(0);
		date.getDate();
	}
}
