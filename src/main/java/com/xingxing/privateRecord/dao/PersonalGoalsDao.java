package com.xingxing.privateRecord.dao;

import java.util.List;

import com.xingxing.privateRecord.domain.PersonalGoalsDo;
import com.xingxing.privateRecord.qo.GoalCondition;
import com.xingxing.privateRecord.qo.StageCondition;

public interface PersonalGoalsDao {

	/**
	 * 根据条件查询目标集合
	 * @param condition
	 * @return
	 */
	public List<PersonalGoalsDo> selectGoalListByCondition(GoalCondition condition);
	
	/**
	 * 根据完成状态查询未完成的目标数量
	 * @param completeStatus
	 * @return
	 */
	public Integer selectCountByComSta(String completeStatus);
	
	/**
	 * 查询目标编号
	 * @return
	 */
	public String selectGoalEndID();
	
	/**
	 * 新增目标
	 * @param personalGoalDo
	 */
	public void insertDataForGoal(GoalCondition goalCondition);
	
	/**
	 * 修改目标数据
	 * @param goalCondition
	 */
	public void updateDataForGoal(GoalCondition goalCondition);
	
	/**
	 * 新增阶段数据
	 * @param stageCondition
	 */
	public void insertDataForStageRef(StageCondition stageCondition);
	
	/**
	 * 新增阶段进度数据
	 */
	public void insertDataForRecord();
	
}
