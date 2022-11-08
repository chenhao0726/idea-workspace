package jdbcdemo;

public class User {

    private Long id;
    private String name;
    private String pwd;
    private Integer gender;
    private Integer age;

    public User() {
    }

    public User(Long id, String name, String pwd, Integer gender, Integer age) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", gender=" + gender + ", age=" + age + "]";
    }
}
