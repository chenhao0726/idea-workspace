package cn.ronghuanet._03dao.domain;
/**
 * 	实体类
 * @author EDY
 *
 */
public class Student {
	private Long id;
	private String name;
	
	public Student() {
	}
	
	public Student(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
