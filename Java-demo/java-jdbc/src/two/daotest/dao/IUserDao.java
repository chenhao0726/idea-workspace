package two.daotest.dao;

import two.daotest.domain.User;

import java.util.List;

public interface IUserDao {
	// 增
	void save(User user);
	// 删
	void delete(Long id);
	// 改
	void update(User user);
	// 查
	User selectById(Long id);// 根据id查询
	List<User> selectAll();// 查询所有
}
