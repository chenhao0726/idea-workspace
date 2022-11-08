package cn.ronghuanet._03dao.dao;

import java.util.List;

import cn.ronghuanet._03dao.domain.Student;

public interface IStudentDao {
	// 增
	void save(Student stu);
	// 删
	void delete(Long id);
	// 改
	void update(Student stu);
	// 查
	Student queryOneById(Long id);
	
	List<Student> queryAll();
}
