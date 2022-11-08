package two.daotest.test;

import org.junit.Test;
import two.daotest.dao.IUserDao;
import two.daotest.dao.impl.IUserDaoImplUtil;
import two.daotest.domain.User;

import java.util.List;

public class UserTest {
//	public IUserDao dao = new IUserDaoImpl();
	public IUserDao dao = new IUserDaoImplUtil();

	@Test
	public void testSaveUser() {
		dao.save(new User(null, "Marry", "123456", 2));
	}

	@Test
	public void testDeleteUser() {
		dao.delete(1L);
	}

	@Test
	public void testUpdate() {
		User jack = new User(3L, "张珊", "123456", 2);
		dao.update(jack);
	}

	@Test
	public void testSelectById() {
		User user = dao.selectById(2L);
		System.out.println(user);
	}
	@Test
	public void testSelectAll() {
		List<User> users = dao.selectAll();
		users.stream().forEach(System.out::println);
	}
}
