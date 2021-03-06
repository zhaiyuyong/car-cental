package com.xxx.car.domain;

public class CarHistoryRecord extends BaseModel{

	/**
	 * *865067021871770,18401576490,4.180,0,20160325010741.000,22.558602,113.945420,65.600,0.07
	 */
	private static final long serialVersionUID = 1L;
	
	private String imei;
	private String cardNum;
	private String gpsSwVer;
	private String gpsHwVer;
	private Float temperature;
	private Float batteryVoltage;
	private Boolean gpsModuleHasOnCar;
	private String gpsDate;
	private Float gpsLatitude;
	private Float gpsLongitude;
	private Float gpsAltitude;
	private Float gpsSpeed;
	private String recordValue;
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getGpsSwVer() {
		return gpsSwVer;
	}
	public void setGpsSwVer(String gpsSwVer) {
		this.gpsSwVer = gpsSwVer;
	}
	public String getGpsHwVer() {
		return gpsHwVer;
	}
	public void setGpsHwVer(String gpsHwVer) {
		this.gpsHwVer = gpsHwVer;
	}
	
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public Float getBatteryVoltage() {
		return batteryVoltage;
	}
	public void setBatteryVoltage(Float batteryVoltage) {
		this.batteryVoltage = batteryVoltage;
	}
	public Boolean getGpsModuleHasOnCar() {
		return gpsModuleHasOnCar;
	}
	public void setGpsModuleHasOnCar(Boolean gpsModuleHasOnCar) {
		this.gpsModuleHasOnCar = gpsModuleHasOnCar;
	}
	public String getGpsDate() {
		return gpsDate;
	}
	public void setGpsDate(String gpsDate) {
		this.gpsDate = gpsDate;
	}
	public Float getGpsLatitude() {
		return gpsLatitude;
	}
	public void setGpsLatitude(Float gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}
	public Float getGpsLongitude() {
		return gpsLongitude;
	}
	public void setGpsLongitude(Float gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}
	public Float getGpsAltitude() {
		return gpsAltitude;
	}
	public void setGpsAltitude(Float gpsAltitude) {
		this.gpsAltitude = gpsAltitude;
	}
	public Float getGpsSpeed() {
		return gpsSpeed;
	}
	public void setGpsSpeed(Float gpsSpeed) {
		this.gpsSpeed = gpsSpeed;
	}
	public String getRecordValue() {
		return recordValue;
	}
	public void setRecordValue(String recordValue) {
		this.recordValue = recordValue;
	}
	
}
