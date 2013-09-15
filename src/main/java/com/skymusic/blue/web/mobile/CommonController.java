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

import com.skymusic.blue.constant.Constant;
import com.skymusic.blue.domain.info.InfoDomainService;
import com.skymusic.blue.domain.ritebible.RiteBibleDomainService;

@Controller
@RequestMapping(value = "/mobile/common")
public class CommonController {

    private static Logger  logger = LoggerFactory.getLogger(CommonController.class);

    private JsonMapper     mapper = new JsonMapper();

    @Autowired
    RiteBibleDomainService riteBibleDomainService;
    
    @Autowired
    InfoDomainService infoDomainService;

    @RequestMapping(value = "/bible/getbyparam", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getBibleByParams(@RequestParam(required = false)
    String testament, @RequestParam(required = false)
    String chapter) {
        return mapper.toJson(riteBibleDomainService.getBibleByParams(testament, chapter));
    }
    
    @RequestMapping(value = "/bible/getbykey", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getBibleByKey(@RequestParam(required = false)
    String key) {
        return mapper.toJson(riteBibleDomainService.getBibleByKey(key));
    }

    @RequestMapping(value = "/rite/getrite", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getRite() {
        return mapper.toJson(riteBibleDomainService.getRiteList());
    }
    
    @RequestMapping(value = "/info/contact", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getContact() {
        return mapper.toJson(infoDomainService.getInfo(Constant.contact));
    }
    
    @RequestMapping(value = "/info/thanks", method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Object getThanks() {
        return mapper.toJson(infoDomainService.getInfo(Constant.thanks));
    }
}
