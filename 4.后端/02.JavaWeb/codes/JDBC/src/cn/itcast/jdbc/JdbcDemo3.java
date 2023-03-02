package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * �޸ı�ļ�¼
 */

public class JdbcDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			
			String sql="update account set money= 1500 where id=4";
			
			stmt=conn.createStatement();
			
			int count=stmt.executeUpdate(sql);
			
			System.out.println(count);
			
			if(count>0) {
				System.out.println("�޸ĳɹ���");
			}else {
				System.out.println("�޸�ʧ�ܣ�");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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

}
