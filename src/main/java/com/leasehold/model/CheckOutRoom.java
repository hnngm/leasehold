package com.leasehold.model;

import java.util.Date;

import com.common.model.BaseModel;

/***
 * 退房信息
 * @author Administrator
 *
 */
public class CheckOutRoom extends BaseModel {

	private Integer checkOutRoomId;
	
	private Integer houseId;
	
	private Integer roomId;
	
	/***
	 * 退房人名称
	 */
	private String checkOutUserName;

	/***
	 * 退房时间
	 */
	private Date checkOutDateTime;
	
	/***
	 * 应退金额
	 */
	private Double shouldRetreatCost;
	/***
	 * 实退金额
	 */
	private Double actualRetreatCost;
	
	/***
	 * 总费用
	 */
	private Double tatalCost;
	

	public Integer getCheckOutRoomId() {
		return checkOutRoomId;
	}

	public void setCheckOutRoomId(Integer checkOutRoomId) {
		this.checkOutRoomId = checkOutRoomId;
	}

	public Integer getHouseId() {
		return houseId;
	}

	public void setHouseId(Integer houseId) {
		this.houseId = houseId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getCheckOutUserName() {
		return checkOutUserName;
	}

	public void setCheckOutUserName(String checkOutUserName) {
		this.checkOutUserName = checkOutUserName;
	}

	public Date getCheckOutDateTime() {
		return checkOutDateTime;
	}

	public void setCheckOutDateTime(Date checkOutDateTime) {
		this.checkOutDateTime = checkOutDateTime;
	}

	public Double getShouldRetreatCost() {
		return shouldRetreatCost;
	}

	public void setShouldRetreatCost(Double shouldRetreatCost) {
		this.shouldRetreatCost = shouldRetreatCost;
	}

	public Double getActualRetreatCost() {
		return actualRetreatCost;
	}

	public void setActualRetreatCost(Double actualRetreatCost) {
		this.actualRetreatCost = actualRetreatCost;
	}

	public Double getTatalCost() {
		return tatalCost;
	}

	public void setTatalCost(Double tatalCost) {
		this.tatalCost = tatalCost;
	}
    
}
