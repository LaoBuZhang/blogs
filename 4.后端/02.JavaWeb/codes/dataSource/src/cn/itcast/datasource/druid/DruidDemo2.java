package cn.itcast.datasource.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.itcast.utils.JdbcUtils;

/*
 * 使用新的工具类
 * 完成添加操作，给account表添加一条记录
 */
public class DruidDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="insert into account values(null,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "wangwu");
			pstmt.setDouble(2, 3000);
			int count=pstmt.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(pstmt, conn);
		}
		
	}

}
