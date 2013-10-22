package com.skymusic.blue.service.bible;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.entity.BibleEntity;
import com.skymusic.blue.repository.BibleDao;

@Component
public class BibleService {
    

	private BibleDao bibleDao;
	
	public List<BibleEntity> getBibleByParams(String book,String testament,String chapter){
	    if(StringUtils.isBlank(testament) && StringUtils.isBlank(chapter)){
	        return bibleDao.findByBook(book);
	    }else if(StringUtils.isBlank(chapter) && !StringUtils.isBlank(testament)){
	        return bibleDao.findByBookAndTestament(book,testament);
	    }else if(StringUtils.isBlank(testament) && !StringUtils.isBlank(chapter)){
	        return bibleDao.findByBookAndChapter(book,chapter);
	    }else{
	        return bibleDao.findByBookAndTestamentAndChapter(book,testament,chapter);
	    }
	}
	
	public List<String> getTestamentByBook(String book){
	    return bibleDao.findTestamentByBook(book);
	}
	
	public List<String> getChapterByTestament(String book,String testament){
	    return bibleDao.findChapterByBookAndTestament(book, testament);
	}
	
	   public List<BibleEntity> getBibleByKey(String key){
	        if(StringUtils.isBlank(key)){
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
