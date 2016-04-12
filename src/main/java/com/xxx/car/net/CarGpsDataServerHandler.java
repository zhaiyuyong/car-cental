package com.xxx.car.net;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xxx.car.domain.CarHistoryRecord;
import com.xxx.car.service.CarHistoryRecordService;

public class CarGpsDataServerHandler extends ChannelInboundHandlerAdapter{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CarGpsDataServerHandler.class);
	
	private CarHistoryRecordService carHistoryRecordService;

	/**
	 * private String imei;
	private String simPhone;
	private Float batteryVoltage;
	private Boolean gpsModuleHasOnCar;
	private String gpsDate;
	private Float gpsLatitude;
	private Float gpsLongitude;
	private Float gpsAltitude;
	private Float gpsSpeed;
	private String recordValue;
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		java.net.InetSocketAddress isa = (InetSocketAddress) ctx.channel().remoteAddress();
		LOGGER.info( "  revice  from {}:{} data = {}" ,isa.getAddress(),isa.getPort(),msg);
		
		if(msg!=null){
			String record = (String) msg;
			if(record.startsWith("*")){
				try {
					record = record.substring(1);
					String[] datas = record.split(",");
					if(datas != null){
						CarHistoryRecord carHistoryRecord = new CarHistoryRecord();
						carHistoryRecord.setRecordValue(record);
						int length = datas.length;
						if(length >= 4){
							if(length == 7){
								carHistoryRecord.setImei(datas[0]);//IMEI
								carHistoryRecord.setCardNum(datas[1]);//卡号
								carHistoryRecord.setGpsSwVer(datas[2]);//软件版本
								carHistoryRecord.setGpsHwVer(datas[3]);//硬件版本
								carHistoryRecord.setTemperature(Float.valueOf(datas[4]));//温度
								carHistoryRecord.setBatteryVoltage(Float.valueOf(datas[5]));//电池电压
								carHistoryRecord.setGpsModuleHasOnCar(Integer.parseInt(datas[6]) == 1);//是否安装
							}else {
								carHistoryRecord.setImei(datas[0]);//IMEI
								carHistoryRecord.setTemperature(Float.valueOf(datas[1]));//温度
								carHistoryRecord.setBatteryVoltage(Float.valueOf(datas[2]));//电池电压
								carHistoryRecord.setGpsModuleHasOnCar(Integer.parseInt(datas[3]) == 1);//是否安装
								if(length == 8){
									carHistoryRecord.setGpsLatitude(Float.valueOf(datas[4]));//gps纬度
									carHistoryRecord.setGpsLongitude(Float.valueOf(datas[5]));//gps经度
									carHistoryRecord.setGpsAltitude(Float.valueOf(datas[6]));//gps海拔
									carHistoryRecord.setGpsSpeed(Float.valueOf(datas[7]));//gps速度
								}
							}
						}
						carHistoryRecordService.saveCarHistoryRecord(carHistoryRecord);
					}
				} catch (Exception e) {
					LOGGER.error("", e);
				}
				
			}else {
				LOGGER.info("error format message : {}", record);
			}
		}
		SimpleDateFormat myFmt = new SimpleDateFormat("yyyyMMddHHmmss");
		ctx.channel().write("zyy" + myFmt.format(new Date())).addListener(ChannelFutureListener.CLOSE);
	}

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    	java.net.InetSocketAddress isa = (InetSocketAddress) ctx.channel().remoteAddress();
    	LOGGER.info( "{}:{} read complete",isa.getAddress(),isa.getPort() );
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    	LOGGER.error("", cause);
        ctx.close();
    }

	public CarGpsDataServerHandler(CarHistoryRecordService carHistoryRecordService) {
		super();
		this.carHistoryRecordService = carHistoryRecordService;
	}
	
}

