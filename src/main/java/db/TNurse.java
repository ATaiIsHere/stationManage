package db;

public class TNurse {
	private int nurse_id;
    private String name;
    private java.sql.Timestamp timestamp;
 
    // �����n���@�ӹw�]���غc��k
    // �H�ϱoHibernate�i�H�ϥ�Constructor.newInstance()�إߪ���
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
