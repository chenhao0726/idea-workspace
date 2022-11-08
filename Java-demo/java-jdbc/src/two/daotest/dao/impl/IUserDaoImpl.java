package two.daotest.dao.impl;

import two.daotest.dao.IUserDao;
import two.daotest.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IUserDaoImpl implements IUserDao {
	// 数据库连接静态资源
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/chentesttwo?useSSL=false";
	private static String name = "root";
	private static String password = "123456";

	@Override
	public void save(User user) {
		Connection conn = null;
		Statement st = null;
		try {
			// 加载驱动
			Class.forName(driver);
			// 获取连接
			conn = DriverManager.getConnection(url, name, password);
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "insert into t_user(name,password,permissions_id) "
					+ "value('"+user.getName()+"','"+user.getPassword()+"',"+user.getPerId()+")";
			st.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	@Override
	public void delete(Long id) {
		Connection conn = null;
		Statement st = null;
		try {
			// 加载驱动
			Class.forName(driver);
			// 获取连接
			conn = DriverManager.getConnection(url, name, password);
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "delete from t_user where "+id+"";
			st.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	@Override
	public void update(User user) {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, name, password);
			st = conn.createStatement();
			String sql = "update t_user set name ='"+ user.getName() +"', password ='" + user.getPassword()+"', permissions_id = "+user.getPerId()+" where id ="+ user.getId()+"";
			st.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	@Override
	public User selectById(Long id) {
		Connection conn = null;
		Statement st = null;
		ResultSet executeQuery = null;
		User user = new User();
		try {
			// 加载驱动
			Class.forName(driver);
			// 获取链接
			conn = DriverManager.getConnection(url, name, password);
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "select * from t_user where id = "+ id+"";
			executeQuery = st.executeQuery(sql);
			while(executeQuery.next()) {
				user.setId(executeQuery.getLong(1));
				user.setName(executeQuery.getString(2));
				user.setPassword(executeQuery.getString(3));
				user.setPerId(executeQuery.getInt(4));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				executeQuery.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
		return user;
	}

	@Override
	public List<User> selectAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet executeQuery = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			// 加载驱动
			Class.forName(driver);
			// 获取链接
			conn = DriverManager.getConnection(url, name, password);
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "select * from t_user";
			executeQuery = st.executeQuery(sql);
			while(executeQuery.next()) {
				User user = new User(executeQuery.getLong(1),
									executeQuery.getString(2),
									executeQuery.getString(3),
									executeQuery.getInt(4));
				list.add(user);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				executeQuery.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		return list;
	}
}
