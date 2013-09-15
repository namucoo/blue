package com.skymusic.blue.web.mobile;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.skymusic.blue.constant.ResultCode;
import com.skymusic.blue.domain.music.MusicDomainService;
import com.skymusic.blue.domain.rel.UserMusicDomainService;
import com.skymusic.blue.entity.MobileSession;
import com.skymusic.blue.entity.Music;
import com.skymusic.blue.entity.Resource;
import com.skymusic.blue.entity.User;
import com.skymusic.blue.result.Result;
import com.skymusic.blue.service.account.AccountService;
import com.skymusic.blue.service.account.MemberService;
import com.skymusic.blue.service.account.MobileAccountService;
import com.skymusic.blue.service.music.MusicService;
import com.skymusic.blue.service.rel.UserMusicRelService;
import com.skymusic.blue.service.resources.ResourceService;

/**
 * 

 * 真正登录的POST请求由Filter完成
 * 
 * @author peng.gongp
 */
@Controller
@RequestMapping(value = "/mobile/default")
public class MobileController {
	
	private static Logger logger = LoggerFactory.getLogger(MobileController.class);
	
	private static final String DEFAULT_JQUERY_JSONP_CALLBACK_PARM_NAME = "callback";

	private JsonMapper mapper = new JsonMapper();

	@Autowired
	private MusicDomainService musicDataService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private UserMusicDomainService userMusicDomainService;
	
	@RequestMapping(value = "/music/getall",method = RequestMethod.GET)
	@ResponseBody
	public Object getAll() {
		//设置需要被格式化为JSON字符串的内容.
 		Map<String, Object> map = new HashMap<String, Object>();
 		Result re = musicDataService.getAllMusic();
		//渲染返回结果.
		return mapper.toJson(re);
	}
	
	@RequestMapping(value = "/music/getbyuser",method = RequestMethod.GET)
	@ResponseBody
	public Object getByUser(@RequestParam String user_id) {
		//设置需要被格式化为JSON字符串的内容.
 		Map<String, Object> map = new HashMap<String, Object>();
 		Result re = userMusicDomainService.getAllMusicByUser(Long.valueOf(user_id));
		//渲染返回结果.
		return mapper.toJson(re);
	}
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
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
	
	@RequestMapping(value = "changepassword",method = RequestMethod.GET)
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
	
	@RequestMapping(value = "register",method = RequestMethod.GET)
	@ResponseBody
	public String changePassword(@RequestParam String loginname,@RequestParam String oldpassword) {
		
		Result re = new Result(false);
		try {
//			re = memberService.changePassWord(loginname, oldpassword, newpassword);
		} catch (Exception e) {
			logger.error("changePassword",e);
		}
		return mapper.toJson(re);
	}
		
}
