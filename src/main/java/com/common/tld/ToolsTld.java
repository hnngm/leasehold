package com.common.tld;

import com.common.util.JsonJacksonUtil;

/**
 * jsp工具标签
* @ClassName: ToolsTld 
* @Description: TODO
* @author ning.han@baidao.com
* @date 2013-11-12 下午03:59:58 
*
 */
public class ToolsTld {

	/**
	 * javaobj 转换成json
	 * @Title: listToJSON 
	 * @Description: 
	 * @return  
	 * @author ning.han@baidao.com
	 */
	public static String objToJSON(Object obj) {
		return JsonJacksonUtil.getInstance().obj2json(obj);
	}

}