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
	 * 测试add方法
	 */
	@Test
	public void testAdd()
	{
		System.out.println("testAdd...");
		
		Caculator c=new Caculator();
		
		int result=c.add(1,2);
		
		//断言，判断输出结果和预期结果是否一致
		Assert.assertEquals(5, result);
	}
	
	/*
	 * 测试add方法
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
