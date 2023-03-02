package cn.itcast.datasource.druid;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//3.加载配置文件
		Properties pro=new Properties();
		InputStream is=DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
		pro.load(is);
		//4.获取连接池对象
		DataSource ds=DruidDataSourceFactory.createDataSource(pro);
		
		//5.获取连接
		Connection conn=ds.getConnection();
		System.out.println(conn);
	}

}
