package com.xxx.car.domain;

public class CarLeaseDistribution extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String vin;//车架号
	private String subStoreId;
	private String num;
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getSubStoreId() {
		return subStoreId;
	}
	public void setSubStoreId(String subStoreId) {
		this.subStoreId = subStoreId;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
