package com.springboot1.model;

import java.sql.Date;
import java.time.LocalDate;

public class Api2Rqt {
	
	long rqtuserId;
	String rqtname;
	//Date rqtdob;
	String rqtdob;
	String rqtemail;
	String rqtmobile;
	
	public long getRqtuserId() {
		return rqtuserId;
	}
	public void setRqtuserId(long rqtuserId) {
		this.rqtuserId = rqtuserId;
	}
	public String getRqtname() {
		return rqtname;
	}
	public void setRqtname(String rqtname) {
		this.rqtname = rqtname;
	}
	public String getRqtdob() {
		return rqtdob;
	}
	public void setRqtdob(String rqtdob) {
		this.rqtdob = rqtdob;
	}
	public String getRqtemail() {
		return rqtemail;
	}
	public void setRqtemail(String rqtemail) {
		this.rqtemail = rqtemail;
	}
	public String getRqtmobile() {
		return rqtmobile;
	}
	public void setRqtmobile(String rqtmobile) {
		this.rqtmobile = rqtmobile;
	}
	@Override
	public String toString() {
		return "UserRqt [rqtuserId=" + rqtuserId + ", rqtname=" + rqtname + ", rqtdob=" + rqtdob + ", rqtemail="
				+ rqtemail + ", rqtmobile=" + rqtmobile + "]";
	}
	

}
