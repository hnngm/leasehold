package com.system.model;

import java.util.List;

import com.common.model.BaseModel;


public class Role extends BaseModel {
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String content;
	/**
	 * 资源
	 */
	private List<Resource> resourceList = null;

	/**
	 * @return  名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param 名称  name 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return  描述
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param 描述  content 
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return resourceList
	 */
	
	public List<Resource> getResourceList() {
		return resourceList;
	}

	/**   
	 * @param resourceList the resourceList to set   
	 */
	
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

	

}
