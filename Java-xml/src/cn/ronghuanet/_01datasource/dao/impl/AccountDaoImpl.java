package cn.ronghuanet._01datasource.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.ronghuanet._01datasource.dao.IAccountDao;
import cn.ronghuanet._01datasource.domain.Account;
import cn.ronghuanet._01datasource.util.HikariUtil;

public class AccountDaoImpl implements IAccountDao{

	@Override
	public boolean transfer(Account out, Account in, BigDecimal money) throws SQLException {
		// 获取连接
		Connection conn = HikariUtil.getConn();
		// 关闭自动提交
		conn.setAutoCommit(false);
		try {
			PreparedStatement ps = conn.prepareStatement("update t_account set money = ? where id = ?");
			// 给out的账户扣除资金
			ps.setBigDecimal(1, out.getMoney().subtract(money));
			ps.setLong(2, out.getId());
			ps.executeUpdate();
			System.out.println(1/0);
			// 给in的账户加上资金
			ps.setBigDecimal(1, in.getMoney().add(money));
			ps.setLong(2, in.getId());
			ps.executeUpdate();
			conn.commit();
			return true;
		} catch (Exception e) {
			conn.rollback();
			System.out.println("数据回滚");
		}
		return false;
	}

	@Override
	public Account getById(Long id) throws SQLException {
		// 获取连接
		Connection conn = HikariUtil.getConn();
		PreparedStatement ps = conn.prepareStatement("select * from t_account where id = ?");
		ps.setLong(1, id);
		ResultSet executeQuery = ps.executeQuery();
		while(executeQuery.next()) {
			long id1 = executeQuery.getLong(1);
			BigDecimal money = executeQuery.getBigDecimal(4);
			return new Account(id1, null, money);
		}
		return null;
	}

}
