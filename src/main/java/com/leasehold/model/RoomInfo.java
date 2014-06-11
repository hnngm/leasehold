package com.leasehold.model;

import java.util.Date;

import com.common.model.BaseModel;

/***
 * 房间信息
 * @author Administrator
 *
 */
public class RoomInfo extends BaseModel {

	private Integer roomId;	
		
	private String roomNumber;
	  
	private String roomDescription;
		
	private Integer leaseId;
	  
	public Integer getRoomId() {
		return roomId;
	}
	
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	
	public String getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getRoomDescription() {
		return roomDescription;
	}
	
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	
	public Integer getLeaseId() {
		return leaseId;
	}
	
	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
	}
  
}
