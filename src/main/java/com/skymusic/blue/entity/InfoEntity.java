package com.skymusic.blue.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;


@Entity
@Table(name = "sky_info")
public class InfoEntity extends IdEntity{


	 
	private String infotype;
	private String memo;
	
	public InfoEntity() {
	}

	public InfoEntity(Long id) {
		this.id = id;
	}
	

	
	
    public String getInfotype() {
        return infotype;
    }

    
    public void setInfotype(String infotype) {
        this.infotype = infotype;
    }

    public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
