package daotest.dao.impl;

import daotest.Util.JDBCUtil;
import daotest.dao.IUserDao;
import daotest.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IUserDaoImplUtil implements IUserDao {

    @Override
    public void save(User user) {
        Connection conn = JDBCUtil.getConn();
        Statement st = null;
        try {
            // 创建预执行对象
            st = conn.createStatement();
            // 执行sql
            String sql = "insert into t_user(name,password,permissions_id) "
                    + "value('"+user.getName()+"','"+user.getPassword()+"',"+user.getPerId()+")";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
            String sql = "delete from t_user where "+id+"";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(null, st, conn);
        }
    }

    @Override
    public void update(User user) {
        Connection conn = JDBCUtil.getConn();
        Statement st = null;
        try {
            st = conn.createStatement();
            String sql = "update t_user set name ='"+ user.getName() +"', password ='" + user.getPassword()+"', permissions_id = "+user.getPerId()+" where id ="+ user.getId()+"";
            st.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(null, st, conn);
        }
    }

    @Override
    public User selectById(Long id) {
        Connection conn = JDBCUtil.getConn();
        Statement st = null;
        ResultSet executeQuery = null;
        User user = new User();
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(executeQuery, st, conn);
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        Connection conn = JDBCUtil.getConn();
        Statement st = null;
        ResultSet executeQuery = null;
        ArrayList<User> list = new ArrayList<User>();
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(executeQuery, st, conn);
        }
        return list;
    }
}
