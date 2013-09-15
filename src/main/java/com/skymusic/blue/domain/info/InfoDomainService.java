package com.skymusic.blue.domain.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.constant.Constant;
import com.skymusic.blue.result.Result;
import com.skymusic.blue.service.info.InfoService;

@Component
public class InfoDomainService {

    @Autowired
    InfoService infoService;
    
    public Result getInfo(String infoType){
        Result re= new Result(false);
        String info = infoService.getInfo(infoType);
        re.getResultInfo().put(Constant.info, info);
        re.setSuccess(true);
        return re;
    }
}
