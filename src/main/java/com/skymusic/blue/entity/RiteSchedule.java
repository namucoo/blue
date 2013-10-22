package com.skymusic.blue.entity;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sky_rite_schedule")
public class RiteSchedule extends IdEntity  {
	
	private Date gmt_create;
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


	public Date getGmt_create() {
		return gmt_create;
	}

	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
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
