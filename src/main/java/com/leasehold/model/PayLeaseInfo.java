package com.leasehold.model;

import java.util.Date;

import com.common.model.BaseModel;

/***
 * 交租信息
 * @author Administrator
 *
 */
public class PayLeaseInfo extends BaseModel {

	private Integer payLeaseId;
	
	private Integer LeaseId;
	
	private Integer roomId;
	
	/***
	 * 基本租金
	 */
	private Double basicRentalCost;
	
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
	 * 租赁类型
	 */
	private String payLeaseType;
	
	/***
	 * 缴费日期
	 */
	private Date paymentDateTime;
	
	/***
	 * 预约缴费日期
	 */
	private Date reservationPaymentDateTime;
	
	/***
	 * 实际缴费日期
	 */
	private Date actualPaymentDateTime;
	
	public Integer getPayLeaseId() {
		return payLeaseId;
	}

	public void setPayLeaseId(Integer payLeaseId) {
		this.payLeaseId = payLeaseId;
	}

	public Integer getLeaseId() {
		return LeaseId;
	}

	public void setLeaseId(Integer leaseId) {
		LeaseId = leaseId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getPayLeaseType() {
		return payLeaseType;
	}

	public void setPayLeaseType(String payLeaseType) {
		this.payLeaseType = payLeaseType;
	}

	public Double getBasicRentalCost() {
		return basicRentalCost;
	}

	public void setBasicRentalCost(Double basicRentalCost) {
		this.basicRentalCost = basicRentalCost;
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

	public Date getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(Date paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	public Date getReservationPaymentDateTime() {
		return reservationPaymentDateTime;
	}

	public void setReservationPaymentDateTime(Date reservationPaymentDateTime) {
		this.reservationPaymentDateTime = reservationPaymentDateTime;
	}

	public Date getActualPaymentDateTime() {
		return actualPaymentDateTime;
	}

	public void setActualPaymentDateTime(Date actualPaymentDateTime) {
		this.actualPaymentDateTime = actualPaymentDateTime;
	}

}
