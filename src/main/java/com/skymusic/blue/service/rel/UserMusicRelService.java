package com.skymusic.blue.service.rel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.entity.UserMusic;
import com.skymusic.blue.repository.UserMusicDao;

@Component
public class UserMusicRelService {
	@Autowired
	private UserMusicDao userMusicDao;
	
	
	public List<UserMusic> getMusics(Long userid) {
		return userMusicDao.findByUserId(userid);
	}
}
