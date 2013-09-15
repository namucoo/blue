package com.skymusic.blue.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//JPA标识
@Entity
@Table(name = "sky_mobilesession")
public class MobileSession extends IdEntity {

	
	private String sessionId;
	private Date sessionTime;
	private User user;
	
	
//	public MobileSession(String sessionId,Date sessionTime,User user ){
//		this.sessionId = sessionId;
//		this.sessionTime = sessionTime;
//		this.user = user;
//	}
//	
//	public MobileSession(User user){
//		sessionId = UUID.randomUUID().toString();
//		sessionTime = new Date();
//		this.user = user;
//	}
	
	public Date getsessionTime() {
		return sessionTime;
	}

	public void setSessionTime(Date sessionTime) {
		this.sessionTime = sessionTime;
	}

	
	

	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}



	// JPA 基于USER_ID列的多对一关系定义
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
