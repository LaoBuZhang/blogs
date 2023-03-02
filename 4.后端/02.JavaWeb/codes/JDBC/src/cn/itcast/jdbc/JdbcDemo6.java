package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * ÷¥––ddl”Ôæ‰
 */

public class JdbcDemo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql:///jdbc", "root", "root");
			
			String sql="select * from account";
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString("name");
				int money=rs.getInt(3);
				System.out.println(id+"---"+name+"---"+money);
			}
			

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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

}
