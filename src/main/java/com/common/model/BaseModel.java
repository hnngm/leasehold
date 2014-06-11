package com.common.model;

import java.io.Serializable;
import java.util.Date;

/****
 * 
 * MyBatis用POJO基类
 * 
 */
public class BaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	/***
	 * 创建人
	 */
	private String createUser;
	/***
	 * 创建时间
	 */
	private Date createTime;

	/***
	 * 修改人
	 */
	private String updateUser;

	/***
	 * 修改时间
	 */
	private Date updateTime;

	/***
	 * 删除标示
	 */
	private Boolean isDelete;

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
