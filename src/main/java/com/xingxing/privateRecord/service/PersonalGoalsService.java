package com.xingxing.privateRecord.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xingxing.privateRecord.domain.ModuleRefDo;
import com.xingxing.privateRecord.domain.PersonalGoalsDo;
import com.xingxing.privateRecord.domain.UserInfoDo;
import com.xingxing.privateRecord.domain.WishingDo;
import com.xingxing.privateRecord.qo.GoalCondition;
import com.xingxing.privateRecord.qo.StageCondition;
import com.xingxing.privateRecord.qo.WisdomCondition;
import com.xingxing.privateRecord.qo.WishCondition;
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
	
	/**
	 * 根据许愿日期和状态查询愿望清单集合
	 * @param wishDate
	 * @param wishStatus
	 * @return
	 */
	public List<WishingDo> queryWishList(String wishDate, String wishStatus);
	
	/**
	 * 新增或修改愿望
	 * @param wishCondition
	 */
	public void addOrUpdateWish(WishCondition wishCondition);
	
	/**
	 * 根据完成状态查询未完成愿望的数量
	 * @param wishStatus
	 * @return
	 */
	public Integer queryCountByWishSta(String wishStatus);
	
	/**
	 * 根据目标编号和状态查询阶段集合
	 * @param goalNum
	 * @param satgeStatus
	 * @return
	 */
	public List<PersonalGoalsDo> queryStageList(String goalNum, String stageStatus);
	
	/**
	 * 新增或修改阶段
	 * @param wishCondition
	 */
	public void addOrUpdateStage(StageCondition stageCondition);
	
	/**
	 * 根据完成状态查询未完成阶段的数量
	 * @param wishStatus
	 * @return
	 */
	public Integer queryCountByStageSta(String stageStatus);
	
	/**
	 * 查询该目标下最后一个阶段尾数为新增阶段准备
	 * @param goalNum
	 * @return
	 */
	public String queryLastCountByGoalNum(String goalNum);
	
	/**
	 * 查询名言集合
	 * @param modIdd
	 * @param wisNum
	 * @param wisdom
	 * @return
	 */
	public List<ModuleRefDo> queryWisdomList(String modIdd, String wisNum, String wisdom);
	
	/**
	 * 新增或修改名言
	 * @param wisdomCondition
	 */
	public void addOrUpdateWisdom(WisdomCondition wisdomCondition);
}
