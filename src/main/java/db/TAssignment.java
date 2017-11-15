package db;

public class TAssignment {
	private Long assign_id;
	private Long nurse_id;
	private Long station_id;
	private java.sql.Timestamp addtime;
	private Boolean expired;

	// 必須要有一個預設的建構方法
	// 以使得Hibernate可以使用Constructor.newInstance()建立物件
	public TAssignment() {
    }

	public Long getAssign_id() {
		return assign_id;
	}

	public void setAssign_id(Long assign_id) {
		this.assign_id = assign_id;
	}
	
	public Long getNurse_id() {
		return nurse_id;
	}

	public void setNurse_id(Long nurse_id) {
		this.nurse_id = nurse_id;
	}

	public Long getStation_id() {
		return station_id;
	}

	public void setStation_id(Long station_id) {
		this.station_id = station_id;
	}

	public java.sql.Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(java.sql.Timestamp addtime) {
		this.addtime = addtime;
	}
	
	public Boolean getExpired() {
		return expired;
	}

	public void setExpired(Boolean expired) {
		this.expired = expired;
	}
}
