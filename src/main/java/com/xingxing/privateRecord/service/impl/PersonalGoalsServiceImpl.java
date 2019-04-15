package com.xingxing.privateRecord.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xingxing.privateRecord.dao.ModuleRefDao;
import com.xingxing.privateRecord.dao.PersonalGoalsDao;
import com.xingxing.privateRecord.dao.UserInfoDao;
import com.xingxing.privateRecord.dao.WishingDao;
import com.xingxing.privateRecord.domain.ModuleRefDo;
import com.xingxing.privateRecord.domain.PersonalGoalsDo;
import com.xingxing.privateRecord.domain.UserInfoDo;
import com.xingxing.privateRecord.domain.WishingDo;
import com.xingxing.privateRecord.qo.GoalCondition;
import com.xingxing.privateRecord.qo.StageCondition;
import com.xingxing.privateRecord.qo.WisdomCondition;
import com.xingxing.privateRecord.qo.WishCondition;
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
	@Autowired
	private WishingDao wishingDao;
	
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

	@Override
	public List<WishingDo> queryWishList(String wishDate, String wishStatus) {
		WishCondition wishCondition = new WishCondition();
		wishCondition.setWishDate(wishDate);
		wishCondition.setWishStatus(wishStatus);
		return wishingDao.selectDataForWish(wishCondition);
	}

	@Override
	public void addOrUpdateWish(WishCondition wishCondition) {
		wishCondition.setWishDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		wishingDao.mergeDataForWish(wishCondition);
	}

	@Override
	public Integer queryCountByWishSta(String wishStatus) {
		return wishingDao.selectCountByWishSta(wishStatus);
	}

	@Override
	public List<PersonalGoalsDo> queryStageList(String goalNum, String stageStatus) {
		StageCondition stageCondition = new StageCondition();
		stageCondition.setGoalNum(goalNum);
		stageCondition.setStageStatus(stageStatus);
		return personalGoalsDao.selectStageList(stageCondition);
	}

	@Override
	public void addOrUpdateStage(StageCondition stageCondition) {
		personalGoalsDao.mergeDataForStage(stageCondition);
	}

	@Override
	public Integer queryCountByStageSta(String stageStatus) {
		return personalGoalsDao.selectCountByStageSta(stageStatus);
	}

	@Override
	public String queryLastCountByGoalNum(String goalNum) {
		List<PersonalGoalsDo> list = personalGoalsDao.selectStageNumByGoalNum(goalNum);
		if(list == null || list.isEmpty()) {
			return "0";
		}
		String stageNum = list.get(0).getStageNum();
		String[] stage = stageNum.split("-");
		return stage[1];
	}

	@Override
	public List<ModuleRefDo> queryWisdomList(String modIdd, String wisNum, String wisdom) {
		WisdomCondition wisdomCondition = new WisdomCondition();
		wisdomCondition.setModIdd(modIdd);
		wisdomCondition.setWisNum(wisNum);
		wisdomCondition.setWisdom(wisdom);
		return moduleRefDao.selectWisdomList(wisdomCondition);
	}

	@Override
	public void addOrUpdateWisdom(WisdomCondition wisdomCondition) {
		moduleRefDao.mergeDataForWisdom(wisdomCondition);
	}

}
