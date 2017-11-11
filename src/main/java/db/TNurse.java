package db;

public class TNurse {
	private int nurse_id;
    private String name;
    private java.sql.Timestamp timestamp;
 
    // 必須要有一個預設的建構方法
    // 以使得Hibernate可以使用Constructor.newInstance()建立物件
    public TNurse() {
    }

    public int getId() {
        return nurse_id;
    }

    public void setId(int nurse_id) {
        this.nurse_id = nurse_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public java.sql.Timestamp getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(java.sql.Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
