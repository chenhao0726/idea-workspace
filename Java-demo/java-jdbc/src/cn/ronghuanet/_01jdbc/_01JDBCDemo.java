package cn.ronghuanet._01jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class _01JDBCDemo {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			// 贾
			Class.forName("com.mysql.jdbc.Driver");
			// 琏
			conn = DriverManager.getConnection(
					"jdbc:mysql:///xiong",
					"root",
					"123456");
//			System.out.println(conn);
			// 欲 创建 预执行对象
			st = conn.createStatement();
			// 执 执行sql  增删改 都是executeUpdate
			String sql = "insert into t_user(id,name,pwd,gender,age)values(25,'fff','2222',0,22)";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			// 事  释放资源
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
