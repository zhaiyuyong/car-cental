package com.xxx.car.persistence;

import org.apache.ibatis.annotations.Insert;

import com.xxx.car.domain.CarHistoryRecord;

public interface CarHistoryRecordMapper {

	
	//@Insert("insert into car_history_record"
	//		+ "(imei,card_num,gps_sw_ver,gps_hw_ver,temperature,battery_voltage,gps_module_has_on_car,gps_date,gps_latitude,gps_longitude,gps_altitude,gps_speed,record_value,create_time,update_time)"
	//		+ "values"
	//		+ "(#{imei},#{cardNum},#{gpsSwVer},#{gpsHwVer},#{temperature},#{batteryVoltage},#{gpsModuleHasOnCar},#{gpsDate},#{gpsLatitude},#{gpsLongitude},#{gpsAltitude},#{gpsSpeed},#{recordValue},#{createTime},#{updateTime})")
	public Integer saveCarHistoryRecord(CarHistoryRecord carHistoryRecord);
}
