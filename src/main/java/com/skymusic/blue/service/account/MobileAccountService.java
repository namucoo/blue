package com.skymusic.blue.service.account;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.skymusic.blue.entity.MobileSession;
import com.skymusic.blue.entity.User;
import com.skymusic.blue.repository.MobileSessionDao;
import com.skymusic.blue.repository.ResourceDao;

@Component
public class MobileAccountService {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	
	private MobileSessionDao mobileSessionDao;
	
	public boolean correctUser(User user,String password){
		if(user.getPassword().equals(enCodePassWord(user,password))){
			return true;
		}else{
			return false;
		}
	}
	
	public MobileSession Login(User user){
//		taskDao.save(entity);
		MobileSession session = mobileSessionDao.findByUserId(user.getId());
		if(session == null){
			session = new MobileSession();
			session.setSessionId(UUID.randomUUID().toString());
			session.setSessionTime(new Date());
			session.setUser(user);
		}
		session.setSessionTime(new Date());
		mobileSessionDao.save(session);
		return session;
	}
	
	@Autowired
	public void setMobileSessionDao(MobileSessionDao mobileSessionDao) {
		this.mobileSessionDao = mobileSessionDao;
	}
	
	private String  enCodePassWord(User user,String password ){
		byte[] salt = Encodes.decodeHex(user.getSalt());
		byte[] hashPassword = Digests.sha1(password.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(hashPassword);
	}
}
