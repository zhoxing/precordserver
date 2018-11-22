package com.xingxing.privateRecord.dao;

public interface PersonalGoalsDao {

	
	/**
	 * 新增目标基础数据
	 */
	public void insertForGoalDataInf();
	
	/**
	 * 新增目标阶段关系数据
	 */
	public void insertForGoalStageRef();
	
	/**
	 * 新增阶段进度数据
	 */
	public void insertForStageProgressData();
	
	/**
	 * 新增日常记录数据
	 */
	public void insertForDailyRecordData();
	
	/**
	 * 新增用户信息数据
	 */
	public void insertForUserDataInf();
	
	/**
	 * 新增愿望清单数据
	 */
	public void insertForWishlistinf();
	
	
	
}
