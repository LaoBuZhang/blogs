package cn.itcast.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import cn.itcast.junit.Caculator;

public class CaculatorTest {

	
	@Before
	public void init()
	{
		System.out.println("init...");
	}
	
	@After
	public void close()
	{
		System.out.println("close...");
	}
	
	/*
	 * ����add����
	 */
	@Test
	public void testAdd()
	{
		System.out.println("testAdd...");
		
		Caculator c=new Caculator();
		
		int result=c.add(1,2);
		
		//���ԣ��ж���������Ԥ�ڽ���Ƿ�һ��
		Assert.assertEquals(5, result);
	}
	
	/*
	 * ����add����
	 */
	@Test
	public void testSub()
	{
		System.out.println("testSub...");
		
		Caculator c=new Caculator();
		
		int result=c.sub(1,2);
		
		Assert.assertEquals(-1, result);
	}
}
