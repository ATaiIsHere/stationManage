package db;

public class TStation {
	private int station_id;
	private String name;
	private java.sql.Timestamp timestamp;

	// �����n���@�ӹw�]���غc��k
	// �H�ϱoHibernate�i�H�ϥ�Constructor.newInstance()�إߪ���
	public TStation() {
    }

	public int getId() {
		return station_id;
	}

	public void setId(int station_id) {
		this.station_id = station_id;
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
