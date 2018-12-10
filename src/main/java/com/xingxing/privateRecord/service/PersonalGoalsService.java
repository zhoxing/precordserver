package com.xingxing.privateRecord.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xingxing.privateRecord.domain.ModuleRefDo;
import com.xingxing.privateRecord.domain.PersonalGoalsDo;
import com.xingxing.privateRecord.domain.UserInfoDo;
import com.xingxing.privateRecord.qo.GoalCondition;
import com.xingxing.privateRecord.qo.StageCondition;
import com.xingxing.privateRecord.util.PrecordException;


@Service
public interface PersonalGoalsService {

	/**
	 * 根据用户名和密码查询该用户信息
	 * @param userId
	 * @param password
	 * @return
	 */
	public UserInfoDo queryUser(String userId, String password) throws PrecordException;
	
	/**
	 * 查询模板信息集合
	 * @return
	 */
	public List<ModuleRefDo> queryMuduleRef();
	
	/**
	 * 根据条件查询目标集合
	 * @param goalCondition
	 * @return
	 */
	public List<PersonalGoalsDo> queryGoalList(GoalCondition goalCondition);
	
	/**
	 * 根据完成状态查询未完成的目标数量
	 * @param completeStatus
	 * @return
	 */
	public Integer queryCountByComSta(String completeStatus);
	
	/**
	 * 按时间排序后取最新目标编号数据
	 * @return
	 */
	public String queryGoalEndID();
	
	/**
	 * 新增目标
	 * @param goalCondition
	 */
	public void addGoal(GoalCondition goalCondition);
	
	/**
	 * 修改目标数据
	 * @param goalCondition
	 */
	public void editGoal(GoalCondition goalCondition);
	
	/**
	 * 新增阶段
	 * @param stageCondition
	 */
	public void addStage(StageCondition stageCondition);
}
