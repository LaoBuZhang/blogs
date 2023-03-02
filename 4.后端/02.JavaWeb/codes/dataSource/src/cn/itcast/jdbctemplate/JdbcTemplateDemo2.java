package cn.itcast.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.itcast.domain.Emp;
import cn.itcast.utils.JdbcUtils;

public class JdbcTemplateDemo2 {

	
	private JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());
	//Junit单元测试，可以让方法独立执行
	
	@Test
	public void test1() {
		String sql="update account set money = 10000 where id=1";
		int count =template.update(sql);
		System.out.println(count);
	}
	
	@Test
	public void test2() {
		String sql="insert into account values(?,?,?)";
		int count=template.update(sql,3,"lisi",null);
		System.out.println(count);
	}
	
	@Test
	public void test3() {
		String sql="delete from account where id= ?";
		int count=template.update(sql,2);
		System.out.println(count);
	}
	
	@Test
	public void test4() {
		String sql="select * from account where id=?";
		Map<String,Object>map=template.queryForMap(sql,1);
		System.out.println(map);
		//{id=1, name=wangwu, money=10000.0}
	}
	
	@Test
	public void test5() {
		String sql="select * from account where id=? or id=?";
		List<Map<String,Object>>list=template.queryForList(sql,1,2);
		for(Map<String,Object>stringObjectMap : list)System.out.println(stringObjectMap);
		//{id=1, name=wangwu, money=10000.0}
		//{id=2, name=zhansan, money=5000.0}
	}
	
	@Test
	public void test6() {
		String sql="select * from account";
		List<Emp>list=template.query(sql,new RowMapper<Emp>() {
			
			@Override
			public Emp mapRow(ResultSet rs,int i) throws SQLException{
				Emp emp=new Emp();
				int id=rs.getInt("id");
				String name=rs.getString("name");
				Double money=rs.getDouble("money");
				emp.setId(id);
				emp.setMoney(money);
				emp.setName(name);
				return emp;
				
			}
		});
		for(Emp emp:list)System.out.println(emp);
	}
	
	@Test
	public void test6_1() {
		String sql="select * from account";
		List<Emp>list=template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
		for(Emp emp:list)System.out.println(emp);
	}
	
	@Test
	public void test7() {
		String sql="select count(id) from account";
		Long total=template.queryForObject(sql, Long.class);
		System.out.println(total);
	}
}
