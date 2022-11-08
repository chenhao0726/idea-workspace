package cn.ronghuanet._01jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _02JDBC2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement createStatement = null;
		try {
			// 贾
			Class.forName("com.mysql.jdbc.Driver");
			// 琏
			conn = DriverManager.getConnection("jdbc:mysql:///xiong", "root", "123456");
			// 欲
			createStatement = conn.createStatement();
			// 执
			String sql = "insert into t_user(id,name,pwd,gender,age)values(26,'fff','2222',0,22)";
			createStatement.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 事
			try {
				createStatement.close();
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
