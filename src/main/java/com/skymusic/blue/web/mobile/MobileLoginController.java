package com.skymusic.blue.web.mobile;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jetty.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.mapper.JsonMapper;

import com.skymusic.blue.entity.Resource;
import com.skymusic.blue.service.resources.ResourceService;
import com.skymusic.blue.service.task.TaskService;

/**
 * 

 * 真正登录的POST请求由Filter完成
 * 
 * @author peng.gongp
 */
@Controller
@RequestMapping(value = "/mobile")
public class MobileLoginController {

	private static final String DEFAULT_JQUERY_JSONP_CALLBACK_PARM_NAME = "callback";

	private JsonMapper mapper = new JsonMapper();

	@Autowired
	private ResourceService skyResourceService;
	
	@RequestMapping(value = "get",method = RequestMethod.GET)
	@ResponseBody
	public Object login() {
		//设置需要被格式化为JSON字符串的内容.
 		Map<String, Object> map = new HashMap<String, Object>();
 		map.put("123", "456");
 		List<Resource> list = skyResourceService.getAllResource();
 		map.put("res", list);
		//渲染返回结果.
		return mapper.toJson(map);
	}
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	@ResponseBody
	public String login(@RequestParam String loginid,@RequestParam String password) {
		Map<String, String> map = Collections.singletonMap("content", "<p>Hello World!</p>");
		return mapper.toJson(map);
	}
}
