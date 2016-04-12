package com.xxx.car.persistence.provider;

public class TestMapperProvider {

	public String test(){
		StringBuffer sb = new StringBuffer();
		sb.append("select * from test_zyy where id in(#{age})");
		return sb.toString();
	}
}
