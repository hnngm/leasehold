package com.system.model;

import com.common.model.BaseModel;

/** 资源表
* @ClassName: Source 
* @Description: TODO
* @author ning.han@baidao.com
* @date 2013-8-14 下午01:51:27 
*  
*/

public class Source extends BaseModel {

	private String name;
	private String code;

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
}
