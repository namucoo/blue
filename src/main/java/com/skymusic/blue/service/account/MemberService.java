package com.skymusic.blue.service.account;

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
	MobileAccountService mobileAccountService;
	
	@Autowired
	private AccountService accountService;
	
	public Result login(String loginName ,String password){
		
		User loginUser = accountService.findUserByLoginName(loginName);
		Result re= new Result(false);
		if(loginUser == null){
			re.put(Constant.errorMsg, ResultCode.user_not_exist);
		}
		if(!mobileAccountService.correctUser(loginUser, password)){
			re.put(Constant.errorMsg, ResultCode.password_error);
		}else{
			MobileSession session = mobileAccountService.Login(loginUser);
			re.put(Constant.loginName, loginUser.getLoginName());
			re.put(Constant.user_session, session.getSessionId());
			re.put(Constant.errorMsg, ResultCode.success);
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
		if(!mobileAccountService.correctUser(loginUser, oldPassword)){
			re.put(Constant.errorMsg, ResultCode.password_error);
		}else{
			//change password
			loginUser.setPlainPassword(newPassword);
			accountService.updateUser(loginUser);
			MobileSession session = mobileAccountService.Login(loginUser);
			re.put(Constant.loginName, loginUser.getLoginName());
			re.put(Constant.user_session, session.getSessionId());
			re.put(Constant.errorMsg, ResultCode.success);
			re.setSuccess(true);
		}
		return re;
	}
	
	public Result register(String loginName,String password){
		User loginUser = accountService.findUserByLoginName(loginName);
		Result re= new Result(false);
		if(loginUser != null){
			re.put(Constant.errorMsg, ResultCode.user_exist);
		}
//		if(!mobileAccountService.correctUser(loginUser, oldPassword)){
//			re.put(Constant.errorMsg, ResultCode.password_error);
//		}else{
//			//change password
//			loginUser.setPlainPassword(newPassword);
//			accountService.updateUser(loginUser);
//			MobileSession session = mobileAccountService.Login(loginUser);
//			re.put(Constant.loginName, loginUser.getLoginName());
//			re.put(Constant.user_session, session.getSessionId());
//			re.put(Constant.errorMsg, ResultCode.success);
//			re.setSuccess(true);
//		}
		return re;
	}
}
