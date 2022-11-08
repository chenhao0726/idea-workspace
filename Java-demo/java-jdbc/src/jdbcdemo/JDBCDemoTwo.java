package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemoTwo {

	public static void main(String[] args) {
		/**
		 * 提取出来，不管有没有错最后我都要关闭事务
		 */
		Connection conn = null;
		Statement st = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chenhaotest", "root", "123456");
			// 要执行的sql语句
			String sql = "insert into t_user(name,pwd,gender,age) value('Tom','123456',1,25)";
			// 创建预执行的对象
			st = conn.createStatement();
			// 执行sql语句
			st.executeUpdate(sql);
			// 事务释放
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
