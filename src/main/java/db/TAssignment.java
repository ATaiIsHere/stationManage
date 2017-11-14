package db;

public class TAssignment {
	private int assign_id;
	private int nurse_id;
	private int station_id;
	private java.sql.Timestamp addtime;

	// 必須要有一個預設的建構方法
	// 以使得Hibernate可以使用Constructor.newInstance()建立物件
	public TAssignment() {
    }

	public int getAssign_id() {
		return assign_id;
	}

	public void setAssign_id(int assign_id) {
		this.assign_id = assign_id;
	}
	
	public int getNurse_id() {
		return nurse_id;
	}

	public void setNurse_id(int nurse_id) {
		this.nurse_id = nurse_id;
	}

	public int getStation_id() {
		return station_id;
	}

	public void setStation_id(int station_id) {
		this.station_id = station_id;
	}

	public java.sql.Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(java.sql.Timestamp addtime) {
		this.addtime = addtime;
	}
}
