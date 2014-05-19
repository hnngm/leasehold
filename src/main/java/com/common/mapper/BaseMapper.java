package com.common.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.common.page.Page;

/** 基础Mapper
* @ClassName: BaseMapper 
* @Description: TODO
* @author ning.han@baidao.com
* @date 2013-7-16 下午05:48:20 
*  
*/

public interface BaseMapper<T extends Serializable, PK extends Serializable> {

	public void save(T obj);

	public void update(T obj);

	public void delete(T obj);

	public void isDelete(T obj);

	public T findById(@Param("id") PK id);

	public T findByObj(T obj);

	public List<T> find(T obj);

	public List<T> findByMap(Map<String, Object> map);

	public List<T> findByPage(Page<T> page);
}
