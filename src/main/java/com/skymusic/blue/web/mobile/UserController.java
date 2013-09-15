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

import com.skymusic.blue.result.Result;
import com.skymusic.blue.service.account.MemberService;


@Controller
@RequestMapping(value = "/mobile/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private MemberService memberService;
    
    private JsonMapper mapper = new JsonMapper();
    
    //login
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public String login(@RequestParam String loginname,@RequestParam String password) {
        Result re = new Result(false);
        try {
            re = memberService.login(loginname, password);
        } catch (Exception e) {
            logger.error("login:",e);
        }
        return mapper.toJson(re);
    }
    
    @RequestMapping(value = "/changepassword",method = RequestMethod.GET)
    @ResponseBody
    public String changePassword(@RequestParam String loginname,@RequestParam String oldpassword,@RequestParam String newpassword) {
        
        Result re = new Result(false);
        try {
            re = memberService.changePassWord(loginname, oldpassword, newpassword);
        } catch (Exception e) {
            logger.error("changePassword",e);
        }
        return mapper.toJson(re);
    }
    
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @ResponseBody
    public String register(@RequestParam String loginname,@RequestParam String email,@RequestParam String password) {
        
        Result re = new Result(false);
        try {
            memberService.register(loginname, email, password);
        } catch (Exception e) {
            logger.error("changePassword",e);
        }
        return mapper.toJson(re);
    }
    

}
