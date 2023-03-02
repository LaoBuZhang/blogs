package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.domain.Account;
import cn.itcast.util.JdbcUtils;



public class JdbcDemo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Account> list=new JdbcDemo7().findAll1();
		System.out.println(list);
		System.out.println(list.size());
		
	}
	
	public List<Account> findAll(){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<Account> list=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql:///jdbc", "root", "root");
			
			String sql="select * from account";
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			Account acc=null;
			list=new ArrayList<Account>();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int money=rs.getInt("money");
				
				acc=new Account();
				
				acc.setId(id);
				acc.setName(name);
				acc.setMoney(money);
				
				list.add(acc);
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
		
		return list;
	}
	
	
	public List<Account> findAll1(){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<Account> list=null;
		
		try {
			conn=JdbcUtils.getConnection();
			
			String sql="select * from account";
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			Account acc=null;
			list=new ArrayList<Account>();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int money=rs.getInt("money");
				
				acc=new Account();
				
				acc.setId(id);
				acc.setName(name);
				acc.setMoney(money);
				
				list.add(acc);
			}
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(rs, stmt, conn);
		}
		
		return list;
	}
}
