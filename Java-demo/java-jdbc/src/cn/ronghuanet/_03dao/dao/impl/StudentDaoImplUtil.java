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
import cn.ronghuanet._04util.JDBCUtil;

public class StudentDaoImplUtil implements IStudentDao{

	@Override
	public void save(Student stu) {
		Connection conn = JDBCUtil.getConn();
		Statement st = null;
		try {
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "insert into t_stu(name)"
					+ "values('"+stu.getName()+"')";
			st.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, st, conn);
		}
	}

	@Override
	public void delete(Long id) {
		Connection conn = JDBCUtil.getConn();
		Statement st = null;
		try {
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "delete from t_stu where id = " + id;
			st.executeUpdate(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, st, conn);
		}
	}

	@Override
	public void update(Student stu) {
		Connection conn = JDBCUtil.getConn();
		Statement st = null;
		try {
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "update t_stu set name ='"+ stu.getName() +"' where id = "+ stu.getId();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(null, st, conn);
		}
	}

	@Override
	public Student queryOneById(Long id) {
		Connection conn = JDBCUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		Student stu = new Student();
		try {
			st = conn.createStatement();
			// 执行sql
			String sql = "select * from t_stu where id = "+ id;
			rs = st.executeQuery(sql);
			while(rs.next()) {
				stu.setId(rs.getLong(1));
				stu.setName(rs.getString(2));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, st, conn);
		}
		return stu;
	}

	@Override
	public List<Student> queryAll() {
		ArrayList<Student> list = new ArrayList<Student>();
		Connection conn = JDBCUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		try {
			// 创建预执行对象
			st = conn.createStatement();
			// 执行sql
			String sql = "select * from t_stu";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Student student = new Student(rs.getLong(1),rs.getString(2));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, st, conn);
		}
		return list;
	}

}
