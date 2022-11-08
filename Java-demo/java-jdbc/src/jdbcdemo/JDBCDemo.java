package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chenhaotest", "root", "123456");
			// 要执行的sql语句
			String sql = "insert into t_user(name,pwd,gender,age) value('Tom','123456',1,25)";
			// 创建预执行的对象
			Statement st = conn.createStatement();
			// 执行sql语句
			st.executeUpdate(sql);
			// 事务释放
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
