package cn.itcast.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * Druid连接池的工具类
 */
public class JdbcUtils {

	//1.定义成员变量DataSource
	private static DataSource ds;
	
	static {
		
		try {
			//1.加载配置文件
			Properties pro=new Properties();
			pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
			
			//2.获取DataSource
			ds=DruidDataSourceFactory.createDataSource(pro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取连接
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	/*
	 * 释放资源
	 */
	public static void close(Statement stmt,Connection conn) {
		close(null,stmt,conn);
	}
	
	public static void close(ResultSet rs,Statement stmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();//归还连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 获取连接池方法
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	
}
