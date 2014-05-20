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
	private String id = null;
	private Date createTime = null;
	private Date updateTime = null;
	private Integer isDelete = null;

	/**
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return isDelete
	 */

	public Integer getIsDelete() {
		return isDelete;
	}

	/**   
	 * @param isDelete the isDelete to set   
	 */

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * @return id
	 */

	public String getId() {
		return id;
	}

	/**   
	 * @param id the id to set   
	 */

	public void setId(String id) {
		this.id = id;
	}

}