package cn.ronghuanet._03dao.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.ronghuanet._03dao.dao.IStudentDao;
import cn.ronghuanet._03dao.domain.Student;

public class StudentDaoImpl implements IStudentDao{

	@Override
	public void save(Student stu) {
		Connection conn = null;
		Statement st = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取链接
			conn = DriverManager.getConnection("jdbc:mysql:///xiong", "root", "123456");
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "insert into t_stu(name)"
					+ "values('"+stu.getName()+"')";
			st.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			Class.forName("com.mysql.jdbc.Driver");
			// 获取链接
			conn = DriverManager.getConnection("jdbc:mysql:///xiong", "root", "123456");
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "delete from t_stu where id = " + id;
			st.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Student stu) {
		Connection conn = null;
		Statement st = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取链接
			conn = DriverManager.getConnection("jdbc:mysql:///xiong", "root", "123456");
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "update t_stu set name ='"+ stu.getName() +"' where id = "+ stu.getId();
			st.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Student queryOneById(Long id) {
		Connection conn = null;
		Statement st = null;
		ResultSet executeQuery = null;
		Student stu = new Student();
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取链接
			conn = DriverManager.getConnection("jdbc:mysql:///xiong", "root", "123456");
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "select * from t_stu where id = "+ id;
			executeQuery = st.executeQuery(sql);
			while(executeQuery.next()) {
				stu.setId(executeQuery.getLong(1));
				stu.setName(executeQuery.getString(2));
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
		return stu;
	}

	@Override
	public List<Student> queryAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet executeQuery = null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取链接
			conn = DriverManager.getConnection("jdbc:mysql:///xiong", "root", "123456");
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "select * from t_stu";
			executeQuery = st.executeQuery(sql);
			while(executeQuery.next()) {
				Student student = new Student(executeQuery.getLong(1),executeQuery.getString(2));
				list.add(student);
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
