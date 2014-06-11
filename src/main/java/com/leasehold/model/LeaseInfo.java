package com.leasehold.model;

import java.util.Date;

import com.common.model.BaseModel;

/***
 * 租赁信息
 * @author Administrator
 *
 */
public class LeaseInfo extends BaseModel {

	
	private Integer leaseId;
	
	/***
	 * 房屋Id
	 */
	private Integer houseId;
	
	/***
	 * 房间Id
	 */
	private Integer roomId;
	
	/***
	 * 房间号
	 */
	private String roomNumber;
	
	/***
	 * 基本租金
	 */
	private Double basicRentalCost;
	
	/***
	 * 缴纳方式
	 */
	private int paymentType;
	
	/***
	 * 费用开始日期
	 */
	private Date startPayDateTime;
	
	/***
	 * 费用结束日期
	 */
	private Date endPayDateTime;
	
	/***
	 * 电视费用
	 */
	private Double televisionCost;
	
	/***
	 * 网费
	 */
	private Double netWorkCost;
	
	/**
	 * 电费
	 */
	private Double electricCost;
	
	/***
	 * 水费
	 */
	private Double waterCost;
	
	/***
	 * 天然气费用
	 */
	private Double natgasCost;
	
	/***
	 * 总费用
	 */
	private Double totalCost;
	
	/***
	 * 租赁人名称
	 */
	private String leaseUserName;
	
	/***
	 * 租赁人身份证号码
	 */
	private String leaseIdentityCard;
	
	/***
	 * 租赁人联系方式
	 */
	private String leaseUserPhone;
	
	/***
	 * 租赁人性别
	 */
	private Boolean leaseUserSex;
	
	/***
	 * 常住人口
	 */
	private Integer residentNumber;
	
	/***
	 * 入住日期
	 */
	private Date checkInDateTime;
	
	/***
	 * 合同期限
	 */
	private Integer contractDeadline;
	
	/***
	 * 合同开始日期
	 */
	private Date contractStartDateTime;
	
	/***
	 * 合同结束日期
	 */
	private Date contractEndDateTime; 
	

	public Integer getLeaseId() {
		return leaseId;
	}

	public void setLeaseId(Integer leaseId) {
		this.leaseId = leaseId;
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

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Double getBasicRentalCost() {
		return basicRentalCost;
	}

	public void setBasicRentalCost(Double basicRentalCost) {
		this.basicRentalCost = basicRentalCost;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public Date getStartPayDateTime() {
		return startPayDateTime;
	}

	public void setStartPayDateTime(Date startPayDateTime) {
		this.startPayDateTime = startPayDateTime;
	}

	public Date getEndPayDateTime() {
		return endPayDateTime;
	}

	public void setEndPayDateTime(Date endPayDateTime) {
		this.endPayDateTime = endPayDateTime;
	}

	public Double getTelevisionCost() {
		return televisionCost;
	}

	public void setTelevisionCost(Double televisionCost) {
		this.televisionCost = televisionCost;
	}

	public Double getNetWorkCost() {
		return netWorkCost;
	}

	public void setNetWorkCost(Double netWorkCost) {
		this.netWorkCost = netWorkCost;
	}

	public Double getElectricCost() {
		return electricCost;
	}

	public void setElectricCost(Double electricCost) {
		this.electricCost = electricCost;
	}

	public Double getWaterCost() {
		return waterCost;
	}

	public void setWaterCost(Double waterCost) {
		this.waterCost = waterCost;
	}

	public Double getNatgasCost() {
		return natgasCost;
	}

	public void setNatgasCost(Double natgasCost) {
		this.natgasCost = natgasCost;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public String getLeaseUserName() {
		return leaseUserName;
	}

	public void setLeaseUserName(String leaseUserName) {
		this.leaseUserName = leaseUserName;
	}

	public String getLeaseIdentityCard() {
		return leaseIdentityCard;
	}

	public void setLeaseIdentityCard(String leaseIdentityCard) {
		this.leaseIdentityCard = leaseIdentityCard;
	}

	public String getLeaseUserPhone() {
		return leaseUserPhone;
	}

	public void setLeaseUserPhone(String leaseUserPhone) {
		this.leaseUserPhone = leaseUserPhone;
	}

	public Boolean getLeaseUserSex() {
		return leaseUserSex;
	}

	public void setLeaseUserSex(Boolean leaseUserSex) {
		this.leaseUserSex = leaseUserSex;
	}

	public Integer getResidentNumber() {
		return residentNumber;
	}

	public void setResidentNumber(Integer residentNumber) {
		this.residentNumber = residentNumber;
	}

	public Date getCheckInDateTime() {
		return checkInDateTime;
	}

	public void setCheckInDateTime(Date checkInDateTime) {
		this.checkInDateTime = checkInDateTime;
	}

	public Integer getContractDeadline() {
		return contractDeadline;
	}

	public void setContractDeadline(Integer contractDeadline) {
		this.contractDeadline = contractDeadline;
	}

	public Date getContractStartDateTime() {
		return contractStartDateTime;
	}

	public void setContractStartDateTime(Date contractStartDateTime) {
		this.contractStartDateTime = contractStartDateTime;
	}

	public Date getContractEndDateTime() {
		return contractEndDateTime;
	}

	public void setContractEndDateTime(Date contractEndDateTime) {
		this.contractEndDateTime = contractEndDateTime;
	}
    
}
