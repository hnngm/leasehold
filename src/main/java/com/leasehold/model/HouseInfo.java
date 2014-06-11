package com.leasehold.model;

import com.common.model.BaseModel;

/** 房屋信息
* @ClassName: HouseInfo 
* @Description: TODO
* @author ning.han@baidao.com
* @date 2014-5-22 下午05:32:01 
*  
*/

public class HouseInfo extends BaseModel {

	private Integer houseId;
	
	/***
	 * 国家
	 */
	private String country;
	
	/***
	 * 省
	 */
	private String province;
	
	/***
	 * 城市
	 */
	private String city;
	
	/***
	 * 区域
	 */
	private String area;
	
	/***
	 * 房屋地址
	 */
	private String roomAddress;
	
	/***
	 * 房屋类型
	 */
	private int houseType;
	
	/***
	 * 法人代表
	 */
	private String legalUser;
	

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRoomAddress() {
		return roomAddress;
	}

	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}

	public int getHouseType() {
		return houseType;
	}

	public void setHouseType(int houseType) {
		this.houseType = houseType;
	}

	public String getLegalUser() {
		return legalUser;
	}

	public void setLegalUser(String legalUser) {
		this.legalUser = legalUser;
	}

}
