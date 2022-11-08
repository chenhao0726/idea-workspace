package daotest.Util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String url;
    private static String password;
    private static String username;
    private static String driver;
    static {
        // 申明一个 properties对象
        Properties properties = new Properties();
        // 获取当前配置文件的流
        InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        // 加载驱动
        try {
            properties.load(is);
            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            password = properties.getProperty("jdbc.password");
            username = properties.getProperty("jdbc.username");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取链接的方法
    public static Connection getConn() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    // 释放资源的方法
    public static void close(ResultSet rs, Statement st, Connection conn) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
