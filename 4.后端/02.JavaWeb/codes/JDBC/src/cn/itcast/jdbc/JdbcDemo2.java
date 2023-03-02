package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * account�����һ����¼
 * insert���
 */
public class JdbcDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Statement stmt=null;
		Connection conn=null;
		try {
			//1.ע������
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.����sql
			String sql="insert into account values(null,'wangwu',3000)";
			
			//3.��ȡConnection����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			
			//4.��ȡִ��sql�Ķ���
			stmt=conn.createStatement();
			
			//5.ִ��sql
			int count=stmt.executeUpdate(sql);
			System.out.println(count);
			
			//6.������
			if(count>0){
				System.out.println("�ɹ�");
			}else {
				System.out.println("ʧ��");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7.�ͷ���Դ
			//�����ָ���쳣
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
