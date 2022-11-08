package cn.ronghuanet._01datasource.test;

import java.math.BigDecimal;
import java.sql.SQLException;



import cn.ronghuanet._01datasource.dao.IAccountDao;
import cn.ronghuanet._01datasource.dao.impl.AccountDaoImpl;
import cn.ronghuanet._01datasource.domain.Account;
import org.junit.Test;

public class AccountTest {

	private IAccountDao dao = new  AccountDaoImpl();
	
	@Test
	public void testTransfer() throws SQLException {
		Account in = dao.getById(1L);
		Account out = dao.getById(2L);
		System.out.println(in);
		System.out.println(out);
		System.out.println("===================");
		dao.transfer(out, in, new BigDecimal(300));
		in = dao.getById(1L);
		out = dao.getById(2L);
		System.out.println(in);
		System.out.println(out);
	}
}
