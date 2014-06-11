package com.leasehold.model;

import java.util.Date;

import com.common.model.BaseModel;

public class User extends BaseModel {
      
	private Integer userId;
	
	private String userName;
	
	private String password;
	
	private String leaseHoldSalt;
	
	private String realName;
	
	private Boolean isActive;
	
	private Date lastLoginTime;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLeaseHoldSalt() {
		return leaseHoldSalt;
	}

	public void setLeaseHoldSalt(String leaseHoldSalt) {
		this.leaseHoldSalt = leaseHoldSalt;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
}
