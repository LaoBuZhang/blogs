package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * ÷¥––ddl”Ôæ‰
 */

public class JdbcDemo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn=null;
		Statement stmt=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql:///jdbc", "root", "root");
			
			String sql="create table student (id int,name varchar(20))";
			
			stmt=conn.createStatement();
			
			int count=stmt.executeUpdate(sql);
			
			System.out.println(count);
			
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
