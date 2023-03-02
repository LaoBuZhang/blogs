package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 删除一条记录
 */

public class JdbcDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn=null;
		Statement stmt=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
			
			String sql="delete from account where id=4";
			
			stmt=conn.createStatement();
			
			int count=stmt.executeUpdate(sql);
			
			System.out.println(count);
			
			if(count>0) {
				System.out.println("修改成功");
			}else {
				System.out.println("修改失败");
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
