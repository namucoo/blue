package com.skymusic.blue.service.bible;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.skymusic.blue.entity.BibleEntity;
import com.skymusic.blue.repository.BibleDao;

@Component
public class BibleService {
    

	private BibleDao bibleDao;
	
	public List<BibleEntity> getBibleByParams(String testament,String chapter){
	    if(StringUtils.hasLength(chapter)){
	        return bibleDao.findByTestament(testament);
	    }else{
	        return bibleDao.findByTestamentAndChapter(testament,chapter);
	    }
	}
	
	   public List<BibleEntity> getBibleByKey(String key){
	        if(StringUtils.hasLength(key)){
	            return null;
	        }else{
	            return bibleDao.findBySentenceLike("%"+key+"%");
	        }
	    }
	
	@Autowired
	public void setBibleDao(BibleDao bibleDao) {
		this.bibleDao = bibleDao;
	}
}
