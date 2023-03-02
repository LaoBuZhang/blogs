package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import cn.itcast.util.JdbcUtils;

public class JdbcDemo8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner cin=new Scanner(System.in);
		
		System.out.println("�������û�����");
		String username=cin.nextLine();
		System.out.println("���������룺");
		String password=cin.nextLine();
		boolean flag=new JdbcDemo8().login2(username,password);
		
		if(flag)System.out.println("��½�ɹ�");
		else System.out.println("�û������������");
	}

	public boolean login(String username,String password) {
		if(username==null || password==null) {
			return false;
		}
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=JdbcUtils.getConnection();
			
			String sql="select * from user where username='"+username+"' and password='"+password+"'";
			
			stmt=conn.createStatement();
			
			rs=stmt.executeQuery(sql);
			
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(rs, stmt, conn);
		}
		
		return false;
	}
	
	
	public boolean login2(String username,String password) {
		if(username==null || password==null) {
			return false;
		}
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=JdbcUtils.getConnection();
			
			String sql="select * from user where username=? and password=?";
			
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			rs=pstmt.executeQuery();
			
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(rs, pstmt, conn);
		}
		
		return false;
	}
}
