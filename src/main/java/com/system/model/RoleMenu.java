package com.system.model;

import com.common.model.BaseModel;

/** 角色和资源
* @ClassName: RoleResource 
* @Description: TODO
* @author ning.han@baidao.com
* @date 2013-7-18 下午03:19:03 
*  
*/

public class RoleMenu extends BaseModel {

	private String roleId;
	private String menuId;

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

	/**
	 * @return menuId
	 */
	
	public String getMenuId() {
		return menuId;
	}

	/**   
	 * @param menuId the menuId to set   
	 */
	
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	

}
