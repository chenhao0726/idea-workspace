package cn.ronghuanet._02junit4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JDBCTest<E> {
	/**
	 * ​	1．Junit4中的测试方法上都必须加上@Test才能被标识为测试方法
	​	2．测试方法中没有返回值和参数，因为没有必要
	​	3．测试方法必须是公开的
	​	4．其他测试方法若有问题，也可能影响到当前测试方法
	​	5．测试类命名XxxTest 
	​	6．测试方法命名public void testXxx();方法上面加上注解@Test
	 * @throws Exception 
	 */
	/**
	 * 	新增
	 * @throws Exception
	 */
	@Test
	public void testInsert() throws Exception {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:///xiong", "root", "123456");
		// 创建预执行对象
		Statement st = conn.createStatement();
		// 准备sql
		String sql = "insert into t_user(id,name,pwd,gender,age)value(28,'zs','111',1,23)";
		// 执行sql
		st.executeUpdate(sql);
		// 释放资源
		st.close();
		conn.close();
	}
	/**
	 * 	修改
	 * @throws Exception
	 */
	@Test
	public void testUpdate() throws Exception {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:///xiong", "root", "123456");
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
	 * 	删除
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {

		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:///xiong", "root", "123456");
		// 创建预执行对象
		Statement st = conn.createStatement();
		// 准备sql
		String sql = "delete from t_user where id = 27";
		// 执行sql
		st.executeUpdate(sql);
		// 释放资源
		st.close();
		conn.close();
	}
	/**
	 * 	根据id查询
	 * @throws Exception
	 */
	@Test
	public void testQueryOne() throws Exception {
		// 贾
		Class.forName("com.mysql.jdbc.Driver");
		// 琏
		Connection conn = DriverManager.getConnection("jdbc:mysql:///xiong", "root", "123456");
		// 欲
		Statement st = conn.createStatement();
		// 执
		// 创建一个输入对象
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("请输入您要查询的用户id");
//		long id = scanner.nextLong();
		String sql = "select * from t_user where id = 16"  ;
		// 查询和增删改不一样 因为查询我要获取结果 所以executeQuery有返回值
		// ResultSet 结果集
		ResultSet rs = st.executeQuery(sql);
//		获取结果方式一
//		while (rs.next()) {
//			System.out.print(rs.getInt(1)+"--");// 获取第1列的数据
//			System.out.print(rs.getString(2)+"--");
//			System.out.print(rs.getString(3)+"--");
//			System.out.print(rs.getInt(4)+"--");
//			System.out.print(rs.getInt(5));
//		}
//		获取结果方式二
//		while (rs.next()) {
//			System.out.print(rs.getInt("id")+"--");// 获取第1列的数据
//			System.out.print(rs.getString("pwd")+"--");
//			System.out.print(rs.getString("name")+"--");
//			System.out.print(rs.getInt("age")+"--");
//			System.out.print(rs.getInt("gender"));
//		}
//		获取结果方式三
		while (rs.next()) {
			System.out.print(rs.getObject("id")+"--");// 获取第1列的数据
			System.out.print(rs.getObject("pwd")+"--");
			System.out.print(rs.getObject("name")+"--");
			System.out.print(rs.getObject("age")+"--");
			System.out.print(rs.getObject("gender"));
		}
		// 事
		rs.close();
		st.close();
		conn.close();
	}

	@Test
	public void testQueryAll() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:///xiong", "root", "123456");
		Statement st = conn.createStatement();
		ResultSet query = st.executeQuery("select * from t_user");
		ArrayList<User> list = new ArrayList<User>();
		while(query.next()) {
			User user = new User(query.getLong(1), query.getString(2), query.getString(3), query.getInt(4), query.getInt(5));
			list.add(user);
		}
		list.forEach(System.out::println);
	}
}
