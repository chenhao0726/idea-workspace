package cn.ronghuanet._03dao.test;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Test;

import cn.ronghuanet._03dao.dao.IStudentDao;
import cn.ronghuanet._03dao.dao.impl.StudentDaoImpl;
import cn.ronghuanet._03dao.dao.impl.StudentDaoImplUtil;
import cn.ronghuanet._03dao.domain.Student;
import cn.ronghuanet._04util.JDBCUtil;

public class StudentTest {
	public IStudentDao dao = new StudentDaoImplUtil();
	
	@Test
	public void testSaveStudent() {
		ClassLoader classLoader = JDBCUtil.class.getClassLoader();
		System.out.println("====");
		System.out.println(classLoader.toString());
		dao.save(new Student(null,"wmz"));
	}
	@Test
	public void testDeleteStudent() {
		dao.delete(1L);
	}
	@Test
	public void testUpdateStudent() {
		dao.update(new Student(2L, "ssss"));
	}
	
	@Test
	public void testSeletctOneStudent() {
		System.out.println(dao.queryOneById(2L));
	}
	
	@Test
	public void testQueryAllStudent() {
		List<Student> list = dao.queryAll();
		list.forEach(System.out::println);
	}
}
