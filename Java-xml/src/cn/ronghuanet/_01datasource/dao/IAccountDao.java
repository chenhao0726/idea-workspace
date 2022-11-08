package cn.ronghuanet._01datasource.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

import cn.ronghuanet._01datasource.domain.Account;

public interface IAccountDao {
	boolean transfer(Account out,Account in,BigDecimal money)  throws SQLException ;
	
	Account getById(Long id) throws SQLException;
}
