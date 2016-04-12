package com.xxx.car.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xxx.car.domain.SubStore;

public interface SubStoreMapper {

	/**
	 * 添加新店信息
	 * @param mainStore
	 * @return
	 */
	//@Insert("")
	public Integer saveSubStore(SubStore subStore);
	/**
	 * 根据店铺id查找店铺
	 * @param mainStoreId
	 * @return
	 */
	//@Select("select * from sub_store where main_store_id=#{mainStoreId}")
	public SubStore findSubStoreByStoreId(@Param("subStoreId")String subStoreId);
	/**
	 * 根据店铺id修改店铺
	 * @param mainStore
	 * @return
	 */
	//@Update("")
	public Integer updateSubStoreByStoreId(SubStore subStore);
}
