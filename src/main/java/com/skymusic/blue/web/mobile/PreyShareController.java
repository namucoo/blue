package com.skymusic.blue.web.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.mapper.JsonMapper;

import com.skymusic.blue.domain.preyshare.PreyShareDomainService;

@Controller
@RequestMapping(value = "/mobile/preyshare")
public class PreyShareController {

    private static Logger  logger = LoggerFactory.getLogger(PreyShareController.class);

    private JsonMapper     mapper = new JsonMapper();

    @Autowired
    PreyShareDomainService preyShareDomainService;
    
    @RequestMapping(value = "/prey/getprey.do", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getPrey(@RequestParam(required = true)
    String page) {
        return mapper.toJson(preyShareDomainService.listPrey(page));
    }
    
    @RequestMapping(value = "/prey/sendprey.do", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object sendPrey(@RequestParam(required = true)
    String loginname,@RequestParam(required = true)
    String prey) {
        return mapper.toJson(preyShareDomainService.sendPrey(loginname, prey));
    }
    
    
    @RequestMapping(value = "/share/getshare.do", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getshare() {
        return mapper.toJson(preyShareDomainService.listShare());
    }
    
    @RequestMapping(value = "/share/sendshare.do", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object sendShare(@RequestParam(required = true)
    String loginname,@RequestParam(required = true)
    String share) {
        return mapper.toJson(preyShareDomainService.sendShare(loginname, share));
    }
}
