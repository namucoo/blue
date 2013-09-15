package com.skymusic.blue.service.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.repository.InfoDao;

@Component
public class InfoService {

	private InfoDao infoDao;
	

	
	public String getInfo(String infoType){
	    return infoDao.findByInfotype(infoType).getMemo();
	}
	
	
	
	@Autowired
	public void setInfoDao(InfoDao infoDao) {
		this.infoDao = infoDao;
	}
}
