package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.util.JdbcUtils;

public class JdbcDemo9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		
		try {
			conn=JdbcUtils.getConnection();
			//¿ªÆôÊÂÎñ
			conn.setAutoCommit(false);
			
			String sql1="update account set money =money-? where id=?";
			String sql2="update account set money =money+? where id=?";
			
			pstmt1=conn.prepareStatement(sql1);
			pstmt2=conn.prepareStatement(sql2);
			
			pstmt1.setInt(1, 500);
			pstmt1.setInt(2, 1);
			pstmt2.setInt(1, 500);
			pstmt2.setInt(2, 2);
			
			pstmt1.executeUpdate();
			int a=3/0;
			pstmt2.executeUpdate();
			
			conn.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				if(conn!=null) {
					conn.rollback();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JdbcUtils.close(pstmt1, conn);
			JdbcUtils.close(pstmt2, null);
		}
	}

	
}
