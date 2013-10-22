package com.skymusic.blue.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sky_share")
public class ShareEntity extends IdEntity{

	private Date gmtCreate;

	private String selected;
	private String memo;
	private MobileUser mobileUser ;
	
	@ManyToOne
	@JoinColumn(name = "username")
	public MobileUser getMobileUser() {
		return mobileUser;
	}
	public void setMobileUser(MobileUser mobileUser) {
		this.mobileUser = mobileUser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getGmtCreate() {
		return gmtCreate;
	}
	
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	

	
	public String getSelected() {
		return selected;
	}
	
	public void setSelected(String selected) {
		this.selected = selected;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
