package com.skymusic.blue.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sky_rite_schedule")
public class RiteSchedule extends IdEntity  {
	
	private Date gmtCreate;
	private String ritetype;
	private String riteschedule;
	private String title;
	private String memo ;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}



	public String getRitetype() {
		return ritetype;
	}

	public void setRitetype(String ritetype) {
		this.ritetype = ritetype;
	}

	public String getRiteschedule() {
		return riteschedule;
	}

	public void setRiteschedule(String riteschedule) {
		this.riteschedule = riteschedule;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}



	
	

	
}
