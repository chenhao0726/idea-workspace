package cn.ronghuanet._01datasource.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 连接池工具
 * @author EDY
 *
 */
public class HikariUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	/**
	 * 静态代码块初始化数据
	 */
	static {
		Properties p = new Properties();
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
		try {
			p.load(in);
			// 初始化参数
			driver = p.getProperty("jdbc.driver");
			url = p.getProperty("jdbc.url");
			username = p.getProperty("jdbc.username");
			password = p.getProperty("jdbc.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 */
	public static Connection getConn() {
		// 创建配置对象
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(driver);
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setPassword(password);
		hikariConfig.setUsername(username);
		hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
		hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
		hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		// 创建数据库连接池对象
		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
		try {
			return hikariDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭
	 */
}
