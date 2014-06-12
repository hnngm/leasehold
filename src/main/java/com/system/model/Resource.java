package com.system.model;

import com.common.model.BaseModel;

/** 菜单
* @ClassName: Menu 
* @Description: TODO
* @author ning.han@baidao.com
* @date 2013-8-12 下午05:47:41 
*  
*/

public class Resource extends BaseModel {

	private String name;//名称
	private String code;//菜单编号
	private String roleId;//父菜单

	/**
	 * @return name
	 */

	public String getName() {
		return name;
	}

	/**   
	 * @param name the name to set   
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return code
	 */

	public String getCode() {
		return code;
	}

	/**   
	 * @param code the code to set   
	 */

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return roleId
	 */

	public String getRoleId() {
		return roleId;
	}

	/**   
	 * @param roleId the roleId to set   
	 */

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
