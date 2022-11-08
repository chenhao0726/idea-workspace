package two.daotest.domain;

public class User {

	private Long id;
	private String name;
	private String password;
	private Integer perId;

	public User() {
		super();
	}

	public User(Long id, String name, String password, Integer perId) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.perId = perId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPerId() {
		return perId;
	}
	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", perId=" + perId + "]";
	}
	
	
}
