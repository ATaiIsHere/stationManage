package db;

public class TAssignment {
	private int assign_id;
	private int nurse_id;
	private int station_id;
	private java.sql.Timestamp timestamp;

	// 必須要有一個預設的建構方法
	// 以使得Hibernate可以使用Constructor.newInstance()建立物件
	public TAssignment() {
    }

	public int getNurseId() {
		return nurse_id;
	}

	public void setNurseId(int nurse_id) {
		this.nurse_id = nurse_id;
	}

	public int getStationId() {
		return station_id;
	}

	public void setStationId(int station_id) {
		this.station_id = station_id;
	}

	public java.sql.Timestamp getTimeStamp() {
		return timestamp;
	}

	public void setTimeStamp(java.sql.Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
