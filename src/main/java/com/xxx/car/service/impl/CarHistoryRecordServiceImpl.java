package com.xxx.car.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.car.domain.CarHistoryRecord;
import com.xxx.car.persistence.CarHistoryRecordMapper;
import com.xxx.car.service.CarHistoryRecordService;

@Service
public class CarHistoryRecordServiceImpl implements CarHistoryRecordService{

	@Autowired
	private CarHistoryRecordMapper carHistoryRecordMapper;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CarHistoryRecordServiceImpl.class);

	@Override
	public void saveCarHistoryRecord(CarHistoryRecord carHistoryRecord) {
		LOGGER.info("save car history");
		Date date = new Date();
		carHistoryRecord.setCreateTime(date);
		carHistoryRecord.setUpdateTime(date);
		carHistoryRecordMapper.saveCarHistoryRecord(carHistoryRecord);
	}
}
