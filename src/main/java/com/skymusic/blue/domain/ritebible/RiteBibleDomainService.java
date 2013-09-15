package com.skymusic.blue.domain.ritebible;

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
    
	public Result getBibleByParams(String testament,String chapter){
	    Result re= new Result(false);
	    List<BibleEntity> bibleList = bibleService.getBibleByParams(testament, chapter);
	    if(CollectionUtils.isEmpty(bibleList)){
            re.put(Constant.errorMsg, ResultCode.all_bible_empty);
            return re;
        }
      
            re.getResultInfo().put(Constant.all_bible, DomainUtils.transBibleToMapList(bibleList));
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
