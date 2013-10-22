package com.skymusic.blue.domain.ritebible;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.constant.Constant;
import com.skymusic.blue.constant.ResultCode;
import com.skymusic.blue.domain.util.DomainUtils;
import com.skymusic.blue.entity.BibleEntity;
import com.skymusic.blue.entity.RiteSchedule;
import com.skymusic.blue.result.Result;
import com.skymusic.blue.service.bible.BibleService;
import com.skymusic.blue.service.riteschedule.RiteScheduleService;

@Component
public class RiteBibleDomainService {

    @Autowired
    RiteScheduleService riteScheduleService;
    
    @Autowired
    BibleService bibleService;
    
    public Result getRiteList(){
        Result re= new Result(false);
        List<RiteSchedule> bibleList = riteScheduleService.getRiteScheduleList();
        if(CollectionUtils.isEmpty(bibleList)){
            re.put(Constant.errorMsg, ResultCode.all_empty);
            return re;
        }
        re.getResultInfo().put(Constant.all_rite, DomainUtils.transRiteToMapList(bibleList));
        re.setSuccess(true);
        return re;
    }
    
    public Result getRiteListByParam(String date,String riteType,String riteSchedule){
        Result re= new Result(false);
        List<RiteSchedule> bibleList = riteScheduleService.getRiteScheduleListByParam(date,riteType,riteSchedule);
        if(CollectionUtils.isEmpty(bibleList)){
            re.put(Constant.errorMsg, ResultCode.all_empty);
            return re;
        }
        re.getResultInfo().put(Constant.all_rite, DomainUtils.transRiteToMapList(bibleList));
        re.setSuccess(true);
        return re;
    }
    
    public Result getRiteListByParam(String riteType,String riteSchedule){
        Result re= new Result(false);
        List<RiteSchedule> bibleList = riteScheduleService.getRiteScheduleListByParam(riteType,riteSchedule);
        if(CollectionUtils.isEmpty(bibleList)){
            re.put(Constant.errorMsg, ResultCode.all_empty);
            return re;
        }
        re.getResultInfo().put(Constant.all_rite, DomainUtils.transRiteToMapList(bibleList));
        re.setSuccess(true);
        return re;
    }
    
	public Result getBibleByParams(String book,String testament,String chapter){
	    Result re= new Result(false);
	    List<BibleEntity> bibleList = bibleService.getBibleByParams(book,testament, chapter);
	    if(CollectionUtils.isEmpty(bibleList)){
            re.put(Constant.errorMsg, ResultCode.all_bible_empty);
            return re;
        }
      
            re.getResultInfo().put(Constant.all_bible, DomainUtils.transBibleToMapList(bibleList));
            re.setSuccess(true);
    
        
        return re;
	}
	
	public Result getTestamentByBook(String book){
	       Result re= new Result(false);
	        List<String> testamentList = bibleService.getTestamentByBook(book);
	        if(CollectionUtils.isEmpty(testamentList)){
	            re.put(Constant.errorMsg, ResultCode.all_testament_empty);
	            return re;
	        }
	      
	            re.getResultInfo().put(Constant.all_testament, DomainUtils.removeDuplicate(testamentList));
	            re.setSuccess(true);
	    
	        
	        return re;
	}
	
	   public Result getChapterByTestament(String book,String testament){
           Result re= new Result(false);
            List<String> chapterList = bibleService.getChapterByTestament(book,testament);
            if(CollectionUtils.isEmpty(chapterList)){
                re.put(Constant.errorMsg, ResultCode.all_chapter_empty);
                return re;
            }
          
                re.getResultInfo().put(Constant.all_chapter, DomainUtils.removeDuplicate(chapterList));
                re.setSuccess(true);
        
            
            return re;
    }
	

	
	   public Result getBibleByKey(String key){
	        Result re= new Result(false);
	        List<BibleEntity> bibleList = bibleService.getBibleByKey(key);
	        if(CollectionUtils.isEmpty(bibleList)){
	            re.put(Constant.errorMsg, ResultCode.all_bible_empty);
	            return re;
	        }
	        re.getResultInfo().put(Constant.all_bible, DomainUtils.transBibleToMapList(bibleList));
	        re.setSuccess(true);
	        return re;
	    }
}
