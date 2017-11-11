package db;

public class User {
    private Long id;
    private String name;
    private Long age;
 
    // 必須要有一個預設的建構方法
    // 以使得Hibernate可以使用Constructor.newInstance()建立物件
    public User() {
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
 
    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}