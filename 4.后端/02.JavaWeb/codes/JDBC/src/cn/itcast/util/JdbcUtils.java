package cn.itcast.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * JDBC������
 */
public class JdbcUtils {

	//����ʹ�������ļ�����ֵ�Ĵ��룬����Ƶ�����Ĵ���
	private static String url;
	private static String user;
	private static String password;
	private static String driver;
	/*
	 * �ļ��Ķ�ȡ��ֻ��Ҫ��һ�μ����õ���Щֵ��ʹ�þ�̬�����
	 */
	static {
		//��ȡ��Դ�ļ�����ȡֵ

		try {
			//1.����Properties������
			Properties pro=new Properties();
			
			
			//��ȡsrc·���µ��ļ��ķ�ʽ-->ClassLoader �������
			ClassLoader classLoader=JdbcUtils.class.getClassLoader();
			URL res=classLoader.getResource("jdbc.properties");
			String path=res.getPath();
			
			//System.out.println(path);
			
			
			//2.�����ļ�
			pro.load(new FileReader("src/jdbc.properties"));
			//3.��ȡ���ݣ�����
			url=pro.getProperty("url");
			user=pro.getProperty("user");
			password=pro.getProperty("password");
			driver=pro.getProperty("driver");
			//4.ע������
			Class.forName(driver);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * ��ȡ����
	 * @return ���Ӷ���
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	
	/*
	 * �ͷ���Դ
	 * @param stmt
	 * @param conn
	 */
	public static void close(Statement stmt,Connection conn) {
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
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * �ͷ���Դ
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
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
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
