package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class JdbcDemo1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//1.��������jar��
		
		//2.ע������
		Class.forName("com.mysql.jdbc.Driver");
		//3.��ȡ���ݿ����Ӷ���
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
		//4.����sql���
		String sql="update account set money =500 where id=1";
		//5.��ȡִ��sql�Ķ��� Statement
		Statement stmt=conn.createStatement();
		//6.ִ��sql
		int count=stmt.executeUpdate(sql);
		//7.������
		System.out.println(count);
		//8.�ͷ���Դ
		stmt.close();
		conn.close();
		
	}

}
