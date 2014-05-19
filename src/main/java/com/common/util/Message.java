package com.common.util;

import java.util.HashMap;
import java.util.Map;

public class Message {

	private boolean isSuccess;//是否成功
	
	private String targetUrl="";
	private String msg;//返回提示消息
	private String callback="security";
	private int statusCode=200;
	private String message="";
	private String navTabId="";
	private String rel="";
	private String callbackType="";
	private String forwardUrl="";
	private Object callbackData=null;
	private Map<String, Object> result = new HashMap<String, Object>();//返回结果
	private boolean isLogin;//是否登录
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNavTabId() {
		return navTabId;
	}
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getCallbackType() {
		return callbackType;
	}
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}
	public String getForwardUrl() {
		return forwardUrl;
	}
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
	public String getTargetUrl() {
		return targetUrl;
	}
	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}
	
	public String getCallback() {
		return callback;
	}
	public void setCallback(String callback) {
		this.callback = callback;
	}

	/**
	 *callbackData
	 * @return Object
	 */
	public Object getCallbackData() {
		return callbackData;
	}
	/**
	 * @param callbackData ,callbackData 
	 */
	public void setCallbackData(Object callbackData) {
		this.callbackData = callbackData;
	}

	/**
	 * @return result
	 */

	public Map<String, Object> getResult() {
		return result;
	}

	/**   
	 * @param result the result to set   
	 */

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	/**
	 * @return isLogin
	 */

	public boolean getIsLogin() {
		return isLogin;
	}

	/**   
	 * @param isLogin the isLogin to set   
	 */

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	/**
	 * @return isSuccess
	 */

	public boolean getIsSuccess() {
		return isSuccess;
	}

	/**   
	 * @param isSuccess the isSuccess to set   
	 */

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
}
