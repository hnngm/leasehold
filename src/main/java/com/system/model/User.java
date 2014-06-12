package com.system.model;

import java.util.Date;

import com.common.model.BaseModel;

public class User extends BaseModel {

	private String username;
	private String password;
	private String salt;// salt值
	private String realName;// 真实姓名
	private String email;// 邮箱
	private Integer enable;// 是否可用
	private Date lastLoginTime;// 最后登录时间

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return salt
	 */

	public String getSalt() {
		return salt;
	}

	/**   
	 * @param salt the salt to set   
	 */

	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return realName
	 */

	public String getRealName() {
		return realName;
	}

	/**   
	 * @param realName the realName to set   
	 */

	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * @return email
	 */

	public String getEmail() {
		return email;
	}

	/**   
	 * @param email the email to set   
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return enable
	 */

	public Integer getEnable() {
		return enable;
	}

	/**   
	 * @param enable the enable to set   
	 */

	public void setEnable(Integer enable) {
		this.enable = enable;
	}

	/**
	 * @return lastLoginTime
	 */

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**   
	 * @param lastLoginTime the lastLoginTime to set   
	 */

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

}
