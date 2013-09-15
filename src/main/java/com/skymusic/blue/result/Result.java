package com.skymusic.blue.result;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1192760595617980548L;
	
	
	
	
	private boolean success;
	
	private ConcurrentHashMap<String , Object> resultInfo = new ConcurrentHashMap<String , Object>();
	
	public Result(boolean isSuccess){
		success = isSuccess;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ConcurrentHashMap<String, Object> getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(ConcurrentHashMap<String, Object> resultInfo) {
		this.resultInfo = resultInfo;
	}

	
	public void put(String key ,Object value){
		resultInfo.put(key, value);
	}

}
