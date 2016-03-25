CREATE TABLE `car_history_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `imei` varchar(50)  NULL COMMENT 'IMEI',
  `sim_phone` varchar(15)  NULL COMMENT '电话号码',
  `battery_voltage` double(20,6)  NULL COMMENT '电池电压',
  `gps_module_has_on_car` int(11)  NULL COMMENT '模块是否在车上',
  `gps_date` varchar(20)  NULL COMMENT 'gps时间',
  `gps_latitude` double(20,6)  NULL COMMENT 'gps纬度',
  `gps_longitude` double(20,6)  NULL COMMENT 'gps经度',
  `gps_altitude` double(20,6)  NULL COMMENT 'gps海拔',
  `gps_speed` double(20,6)  NULL COMMENT 'gps对地速度',
  `record_value` varchar(500)  NULL COMMENT '原始记录',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  key `imei_index`(`imei`),
  key `sim_phone_index`(`sim_phone`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='原始记录表';

CREATE TABLE `car_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `vin` varchar(50)  NULL COMMENT 'IMEI',
  `color` varchar(10)  NULL COMMENT '电话号码',
  `type` varchar(10)  NULL COMMENT 'BT3，BT4等等车辆类型：正三轮、电动正三轮 或者其他类型',
  `version` varchar(5)  NULL COMMENT '版本 1.0 or 2.0',
  `produce_time` varchar(20)  NULL COMMENT '出厂时间',
  `manufactor` varchar(50)  NULL COMMENT '生成厂家',
  `imei` varchar(50)  NULL COMMENT 'GPS模块IMEI',
  `sim_card_num` varchar(15)  NULL COMMENT 'GPS模块的sim卡号码',
  `boot_time` varchar(50)  NULL COMMENT 'GPS模块启动时间',
  `last_time_online` varchar(50)  NULL COMMENT 'gps上次在线时间',
  `online` int(11)  NULL COMMENT 'gps模块是否在线',
  `gps_signal` varchar(50)  NULL COMMENT 'GPS模块内部温度',
  `gps_temp` varchar(50)  NULL COMMENT 'GPS模块IMEI',
  `gps_bat_volt` varchar(50)  NULL COMMENT 'GPS电池电压',
  `gps_install` varchar(50)  NULL COMMENT 'gps模块是否安装',
  `gps_sw_ver` varchar(50)  NULL COMMENT 'GPS模块软件版本',
  `gps_hw_ver` varchar(50)  NULL COMMENT 'GPS模块硬件版本',
  `kmage` varchar(50)  NULL COMMENT '总行驶里程',
  `use` varchar(50)  NULL COMMENT '用途',
  `status` int(11)  NULL COMMENT '状态有以下几种：出厂、已分配、运输、待出租、出租、维修测试、回收、报废、车辆在分店之间调动',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='车辆信息表';
