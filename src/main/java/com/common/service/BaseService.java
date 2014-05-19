package com.common.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.common.page.Page;

public interface BaseService<T extends Serializable, PK extends Serializable> {

	public T findById(PK id);

	public T findByObj(T obj);

	public List<T> find(T obj);

	public List<T> find(Map<String, Object> map);

	public Page<T> find(Page<T> page);

	public boolean delete(T obj);

	public void isDelete(T obj);

	public void update(T obj);

	public boolean save(T obj);

}
