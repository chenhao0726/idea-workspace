package daotest.dao;

import java.util.List;

import daotest.domain.User;

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
