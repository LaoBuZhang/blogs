package cn.itcast.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.itcast.utils.JdbcUtils;

/*
 * JdbcTemplate»Î√≈
 */
public class JdbcTemplateDemo1 {

	public static void main(String[] args) {
		JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());
		String sql="update account set money =5000 where id=?";
		int count=template.update(sql,1);
		System.out.println(count);
	}
}
