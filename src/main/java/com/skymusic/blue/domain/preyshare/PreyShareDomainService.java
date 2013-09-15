package com.skymusic.blue.domain.preyshare;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.constant.Constant;
import com.skymusic.blue.constant.ResultCode;
import com.skymusic.blue.domain.util.DomainUtils;
import com.skymusic.blue.entity.PreyEntity;
import com.skymusic.blue.entity.ShareEntity;
import com.skymusic.blue.result.Result;
import com.skymusic.blue.service.prey.PreyService;
import com.skymusic.blue.service.share.ShareService;

@Component
public class PreyShareDomainService {

    @Autowired
    PreyService preySrevice;
    
    @Autowired
    ShareService shareService;
    
    public Result sendPrey(String userName,String memo){
        Result re= new Result(false);
        try {
            preySrevice.sendPrey(userName, memo);
            re.setSuccess(true);
        } catch (Exception e) {
        }

        return re;
    }
    
    public Result listPrey(String pageCount){
        Result re= new Result(false);
        List<PreyEntity> preyList = preySrevice.listPrey(Integer.valueOf(pageCount), "auto");
        if(CollectionUtils.isEmpty(preyList)){
            re.put(Constant.errorMsg, ResultCode.all_empty);
            return re;
        }
        re.getResultInfo().put(Constant.all_prey, DomainUtils.transPreyToMapList(preyList));
        re.setSuccess(true);
        return re;
    }
    
    public Result sendShare(String userName,String memo){
        Result re= new Result(false);
        try {
            shareService.sendShare(userName, memo);
            re.setSuccess(true);
        } catch (Exception e) {
        }

        return re;
    }
    
    public Result listShare(){
        Result re= new Result(false);
        List<ShareEntity> shareList = shareService.listShare();
        if(CollectionUtils.isEmpty(shareList)){
            re.put(Constant.errorMsg, ResultCode.all_empty);
            return re;
        }
        re.getResultInfo().put(Constant.all_share, DomainUtils.transShareToMapList(shareList));
        re.setSuccess(true);
        return re;
    }
    
}
