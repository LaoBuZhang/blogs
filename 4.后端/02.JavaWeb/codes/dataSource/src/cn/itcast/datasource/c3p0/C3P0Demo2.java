package cn.itcast.datasource.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		//1.��ȡDataSource��ʹ��Ĭ������
		DataSource ds=new ComboPooledDataSource();
		
		//2.��ȡ����
		for(int i=1;i<=11;i++) {
			Connection conn=ds.getConnection();
			System.out.println(i+":"+conn);
			
			if(i==5) {
				conn.close();//�黹�����ӳ���
			}
		}
		
		//testNamedConfig();
	}
	
	public static void testNamedConfig() throws SQLException {
		
		//1.��ȡDataSource��ʹ��ָ����������
		DataSource ds1=new ComboPooledDataSource("otherc3p0");
		
		//2.��ȡ����
		for(int i=1;i<=11;i++) {
			Connection conn1=ds1.getConnection();
			System.out.println(i+":"+conn1);
			
			if(i==5) {
				conn1.close();//�黹�����ӳ���
			}
		}
	}

}
