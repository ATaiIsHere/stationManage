package db;

public class TNurse {
	private Long nurse_id;
    private String name;
    private java.sql.Timestamp addtime;
 
    // �����n���@�ӹw�]���غc��k
    // �H�ϱoHibernate�i�H�ϥ�Constructor.newInstance()�إߪ���
    public TNurse() {
    }

    public Long getNurse_id() {
        return nurse_id;
    }

    public void setNurse_id(Long nurse_id) {
        this.nurse_id = nurse_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
 
    public java.sql.Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(java.sql.Timestamp addtime) {
        this.addtime = addtime;
    }
}
