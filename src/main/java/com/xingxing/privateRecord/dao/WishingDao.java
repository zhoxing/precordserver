package com.xingxing.privateRecord.dao;

import java.util.List;

import com.xingxing.privateRecord.domain.UserInfoDo;
import com.xingxing.privateRecord.domain.WishingDo;
import com.xingxing.privateRecord.qo.WishCondition;


public interface WishingDao {

	/**
	 * 根据许愿日期和状态查询愿望清单集合
	 * @param wishCondition
	 * @return
	 */
	public List<WishingDo> selectDataForWish(WishCondition wishCondition);
	
	/**
	 * 新增或修改愿望
	 * @param wishCondition
	 */
	public void mergeDataForWish(WishCondition wishCondition);
	
	/**
	 * 根据完成状态查询未完成的愿望数量
	 * @param completeStatus
	 * @return
	 */
	public Integer selectCountByWishSta(String wishStatus);
}
