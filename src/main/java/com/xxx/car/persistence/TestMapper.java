package com.xxx.car.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.xxx.car.persistence.provider.TestMapperProvider;

public interface TestMapper {

	
	@Select("select * from test_zyy where id in(${age})")
	//@SelectProvider(method="test",type=TestMapperProvider.class)
	public List<Map<String, Object>> test(@Param("age")String age);
}
