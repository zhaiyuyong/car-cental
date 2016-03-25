package com.xxx.car.domain;

public class SubStore extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String subStoreId;
	private String mainStoreId;
	private String province;
	private String city;
	private String company;
	private String address;
	private String latitude;
	private String longitude;
	private String manager;
	private String mobilePhone;
	private String telePhone;
	public String getSubStoreId() {
		return subStoreId;
	}
	public void setSubStoreId(String subStoreId) {
		this.subStoreId = subStoreId;
	}
	public String getMainStoreId() {
		return mainStoreId;
	}
	public void setMainStoreId(String mainStoreId) {
		this.mainStoreId = mainStoreId;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getTelePhone() {
		return telePhone;
	}
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	
	
}
