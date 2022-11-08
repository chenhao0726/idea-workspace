package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class JunitDemo {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/chenhaotest?useSSL=false";
	private static String name = "root";
	private static String password = "123456";

	/**
	 * 根据id查询
	 */
	@Test
	public void testSelect() {
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, name, password);
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入id");
			long id = scanner.nextLong();
			String sql = "select * from t_user where id =" + id;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getLong(1)+"=="+rs.getString(2)+"=="+rs.getString(3)+"=="+rs.getInt(4)+"=="+rs.getInt(5));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询所有
	 * @throws Exception
	 */
	@Test
	public void testQueryAll() throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, name, password);
		Statement st = conn.createStatement();
		ResultSet query = st.executeQuery("select * from t_user");
		ArrayList<User> list = new ArrayList<User>();
		while(query.next()) {
			User user = new User(query.getLong(1), query.getString(2), query.getString(3), query.getInt(4), query.getInt(5));
			list.add(user);
		}
		list.forEach(System.out::println);
	}

	/**
	 * 插入数据
	 * @throws Exception
	 */
	@Test
	public void testInsert() throws Exception {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, name, password);
		String sql = "insert into t_user(id,name,pwd,gender,age)value(23,'zs','111',1,23)";
		Statement st = conn.createStatement();
		// 执行sql
		st.executeUpdate(sql);
		// 释放资源
		st.close();
		conn.close();
	}

	/**
	 * 更新
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		// 加载驱动
		Class.forName(driver);
		// 获取连接
		Connection conn = DriverManager.getConnection(url, name, password);
		// 创建预执行对象
		Statement st = conn.createStatement();
		// 准备sql
		String sql = "update t_user set name = 'ww',age=800 where id = 27";
		// 执行sql
		st.executeUpdate(sql);
		// 释放资源
		st.close();
		conn.close();
	}

	/**
	 * 删除
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {
		// 加载驱动
		Class.forName(driver);
		// 获取连接
		Connection conn = DriverManager.getConnection(url, name, password);
		// 创建预执行对象
		Statement st = conn.createStatement();
		// 准备sql
		String sql = "delete from t_user where id = 23";
		// 执行sql
		st.executeUpdate(sql);
		// 释放资源
		st.close();
		conn.close();
	}
}
