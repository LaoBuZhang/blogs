package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * account表添加一条记录
 * insert语句
 */
public class JdbcDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Statement stmt=null;
		Connection conn=null;
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.定义sql
			String sql="insert into account values(null,'wangwu',3000)";
			
			//3.获取Connection对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","root");
			
			//4.获取执行sql的对象
			stmt=conn.createStatement();
			
			//5.执行sql
			int count=stmt.executeUpdate(sql);
			System.out.println(count);
			
			//6.处理结果
			if(count>0){
				System.out.println("成功");
			}else {
				System.out.println("失败");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//7.释放资源
			//避免空指针异常
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
