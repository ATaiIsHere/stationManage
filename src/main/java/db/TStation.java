package db;

public class TStation {
	private int station_id;
	private String name;
	private java.sql.Timestamp addtime;

	// �����n���@�ӹw�]���غc��k
	// �H�ϱoHibernate�i�H�ϥ�Constructor.newInstance()�إߪ���
	public TStation() {
    }

	public int getStation_id() {
		return station_id;
	}

	public void setStation_id(int station_id) {
		this.station_id = station_id;
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
