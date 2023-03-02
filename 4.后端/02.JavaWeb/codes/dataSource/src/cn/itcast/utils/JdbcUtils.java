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
 * Druid���ӳصĹ�����
 */
public class JdbcUtils {

	//1.�����Ա����DataSource
	private static DataSource ds;
	
	static {
		
		try {
			//1.���������ļ�
			Properties pro=new Properties();
			pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
			
			//2.��ȡDataSource
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
	 * ��ȡ����
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	/*
	 * �ͷ���Դ
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
				conn.close();//�黹����
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * ��ȡ���ӳط���
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	
}
