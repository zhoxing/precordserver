package com.xingxing.privateRecord.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xingxing.privateRecord.dao.ModuleRefDao;
import com.xingxing.privateRecord.dao.PersonalGoalsDao;
import com.xingxing.privateRecord.dao.UserInfoDao;
import com.xingxing.privateRecord.domain.ModuleRefDo;
import com.xingxing.privateRecord.domain.PersonalGoalsDo;
import com.xingxing.privateRecord.domain.UserInfoDo;
import com.xingxing.privateRecord.qo.GoalCondition;
import com.xingxing.privateRecord.qo.StageCondition;
import com.xingxing.privateRecord.service.PersonalGoalsService;
import com.xingxing.privateRecord.util.PrecordException;

@Service
public class PersonalGoalsServiceImpl implements PersonalGoalsService{

	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private ModuleRefDao moduleRefDao;
	@Autowired
	private PersonalGoalsDao personalGoalsDao;
	
	@Override
	public UserInfoDo queryUser(String userId, String password) throws PrecordException {
		UserInfoDo isUser = userInfoDao.selectUserById(userId);
		if(isUser == null) {
			throw new PrecordException("该用户不存在!");
		}
		UserInfoDo user = userInfoDao.selectUserByIdAndPassword(userId, password);
		if(user == null) {
			throw new PrecordException("该用户密码有误!");
		}
		return user;
	}
	
	@Override
	public List<ModuleRefDo> queryMuduleRef() {
		List<ModuleRefDo> moduleList = moduleRefDao.selectModuleList();
		for (ModuleRefDo moduleRef : moduleList) {
			List<ModuleRefDo> wisdomList = moduleRefDao.selectWisdomListById(moduleRef.getModIdd());
			if(wisdomList != null&&!wisdomList.isEmpty()) {
				Random rand = new Random();
				ModuleRefDo wisdomDo = wisdomList.get(rand.nextInt(wisdomList.size()));
				moduleRef.setWisNum(wisdomDo.getWisNum());
				moduleRef.setWisdom(wisdomDo.getWisdom());
			}
		}
		return moduleList;
	}

	@Override
	public List<PersonalGoalsDo> queryGoalList(GoalCondition goalCondition) {
		
		return personalGoalsDao.selectGoalListByCondition(goalCondition);
	}

	@Override
	public String queryGoalEndID() {
		
		return personalGoalsDao.selectGoalEndID();
	}

	@Override
	public void addGoal(GoalCondition goalCondition) {
		personalGoalsDao.insertDataForGoal(goalCondition);
	}

	@Override
	public void addStage(StageCondition stageCondition) {
		personalGoalsDao.insertDataForStageRef(stageCondition);
	}

	@Override
	public void editGoal(GoalCondition goalCondition) {
		personalGoalsDao.updateDataForGoal(goalCondition);
	}

	@Override
	public Integer queryCountByComSta(String completeStatus) {
		return personalGoalsDao.selectCountByComSta(completeStatus);
	}

}
