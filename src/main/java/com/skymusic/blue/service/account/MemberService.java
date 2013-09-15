package com.skymusic.blue.service.account;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skymusic.blue.constant.Constant;
import com.skymusic.blue.constant.ResultCode;
import com.skymusic.blue.entity.MobileSession;
import com.skymusic.blue.entity.User;
import com.skymusic.blue.result.Result;

@Component
public class MemberService {

	
	@Autowired
	private AccountService accountService;
	
	public Result login(String loginName ,String password){
		
		User loginUser = accountService.findUserByLoginName(loginName);
		Result re= new Result(false);
		if(loginUser == null){
			re.put(Constant.errorMsg, ResultCode.user_not_exist);
		}
		if(!accountService.correctUser(loginUser, password)){
			re.put(Constant.errorMsg, ResultCode.password_error);
		}else{
			re.setSuccess(true);
		}
		return re;
	}
	
	public Result changePassWord(String loginName,String oldPassword ,String newPassword){
		User loginUser = accountService.findUserByLoginName(loginName);
		Result re= new Result(false);
		if(loginUser == null){
			re.put(Constant.errorMsg, ResultCode.user_not_exist);
		}
		if(!accountService.correctUser(loginUser, oldPassword)){
			re.put(Constant.errorMsg, ResultCode.password_error);
		}else{
			//change password
			loginUser.setPlainPassword(newPassword);
			accountService.updateUser(loginUser);
			re.setSuccess(true);
		}
		return re;
	}
	
	public Result register(String loginName,String email,String password){
		User loginUser = accountService.findUserByLoginName(loginName);
		Result re= new Result(false);
		if(loginUser != null){
			re.put(Constant.errorMsg, ResultCode.user_exist);
		}else if(StringUtils.isBlank(email) || StringUtils.isBlank(password)){
		    re.put(Constant.errorMsg, ResultCode.user_info_error);
		}else{
		    User newUser= new User();
		    newUser.setLogin_name(loginName);
		    newUser.setPlainPassword(password);
		    newUser.setEmail(email);
		    accountService.registerUser(newUser);
		    re.setSuccess(true);
		}
		return re;
	}
}
