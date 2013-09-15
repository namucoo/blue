package com.skymusic.blue.service.riteschedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.entity.RiteSchedule;
import com.skymusic.blue.repository.RiteScheduleDao;

@Component
public class RiteScheduleService {
	
	private RiteScheduleDao riteScheduleDao;
	
	public List<RiteSchedule> getRiteScheduleList(){
	    return riteScheduleDao.findAll();
	}

	@Autowired
	public void setRiteScheduleDao(RiteScheduleDao riteScheduleDao) {
		this.riteScheduleDao = riteScheduleDao;
	}

	
	
}
