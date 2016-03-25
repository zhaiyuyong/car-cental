package com.xxx.car.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xxx.car.domain.MainStore;

public interface MainStoreMapper {
	
	/**
	 * 添加新店信息
	 * @param mainStore
	 * @return
	 */
	@Insert("")
	public Integer saveMainStore(MainStore mainStore);
	/**
	 * 根据店铺id查找店铺
	 * @param mainStoreId
	 * @return
	 */
	@Select("select * from main_store where main_store_id=#{mainStoreId}")
	public MainStore findMainStoreByStoreId(@Param("mainStoreId")String mainStoreId);
	/**
	 * 根据店铺id修改店铺
	 * @param mainStore
	 * @return
	 */
	@Update("")
	public Integer updateMainStoreByStoreId(MainStore mainStore);
}
