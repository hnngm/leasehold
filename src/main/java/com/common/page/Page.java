package com.common.page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.util.Helper;

public class Page<T> {

	private int pageSize = 50;
	private int pageNo = 1;

	private int totalPage;
	private int rowCount;

	private int prePage;
	private int nextPage;

	private boolean hasNextPage;
	private boolean hasPrePage;
	private List<T> list = null;
	private Map<String, Object> params = new HashMap<String, Object>();

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int rowCount) {
		if (rowCount % pageSize > 0) {
			totalPage = rowCount / pageSize + 1;
		} else {
			totalPage = rowCount / pageSize;
		}
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public void setPreNextPage() {
		nextPage = pageNo + 1;

		if (nextPage >= totalPage) {
			nextPage = totalPage;
			hasNextPage = false;
		} else {
			hasNextPage = true;
		}

		prePage = pageNo - 1;

		if (prePage <= 1) {
			prePage = 1;
			hasPrePage = false;
		} else {
			hasPrePage = true;
		}
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	/**
	 * @return  list
	 */
	public List<T> getList() {
		return list;
	}

	/**
	 * @param list  list 
	 */
	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * @return  params
	 */
	public Map<String, Object> getParams() {
		return params;
	}

	/**
	 * @param params  params 
	 */
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public void setBean(Object object) {
		this.params = Helper.convertBeanToMap(object);
	}

	/**
	 * @return pageNo
	 */

	public int getPageNo() {
		return pageNo;
	}

	/**   
	 * @param pageNo the pageNo to set   
	 */

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return pageSize
	 */

	public int getPageSize() {
		return pageSize;
	}

	/**   
	 * @param pageSize the pageSize to set   
	 */

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
