package _test.buseo.model.dto;

import java.sql.Date;

public class BuseoDTO {
	private int buseoNo;
	private String buseo;
	private Date regiDate;
	public int getBuseoNo() {
		return buseoNo;
	}
	public void setBuseoNo(int buseoNo) {
		this.buseoNo = buseoNo;
	}
	public String getBuseo() {
		return buseo;
	}
	public void setBuseo(String buseo) {
		this.buseo = buseo;
	}
	public Date getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}
	
}
