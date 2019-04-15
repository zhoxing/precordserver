package com.xingxing.privateRecord.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.xingxing.privateRecord.domain.ModuleRefDo;
import com.xingxing.privateRecord.domain.PersonalGoalsDo;
import com.xingxing.privateRecord.domain.UserInfoDo;
import com.xingxing.privateRecord.domain.WishingDo;
import com.xingxing.privateRecord.init.IDQueryRunner;
import com.xingxing.privateRecord.qo.GoalCondition;
import com.xingxing.privateRecord.qo.StageCondition;
import com.xingxing.privateRecord.qo.WisdomCondition;
import com.xingxing.privateRecord.qo.WishCondition;
import com.xingxing.privateRecord.service.PersonalGoalsService;
import com.xingxing.privateRecord.util.AtomicIDUtil;
import com.xingxing.privateRecord.util.PrecordException;
import com.xingxing.privateRecord.util.commonResponseUtil;


@RestController
@RequestMapping("/api/personalGoals")
public class PersonalGoalsController {

	private static Logger log=LoggerFactory.getLogger(PersonalGoalsController.class);
	private Integer newEndNum;
	@Autowired
	private PersonalGoalsService personalGoalsService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public JSONObject login(HttpServletRequest req,HttpServletResponse resp){
		log.debug("进入登录验证!");
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		UserInfoDo user = null;
		JSONObject json = new JSONObject();
		try {
			user = personalGoalsService.queryUser(userId, password);
		} catch (PrecordException e) {
			json.put("flag", "fail");
			json.put("message", e.getMessage());
			return commonResponseUtil.responseMethod(json, resp);
		}
		json.put("flag", "success");
		json.put("user", user);
		return commonResponseUtil.responseMethod(json, resp);
	}
	
	@RequestMapping(value="/index",method=RequestMethod.POST)
	public JSONObject index(HttpServletRequest req,HttpServletResponse resp) {
		log.debug("进入模板查询!");
		List<ModuleRefDo> queryModuleList = personalGoalsService.queryMuduleRef();
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		json.put("queryModuleList", queryModuleList);
		return commonResponseUtil.responseMethod(json, resp);
	}
	
	@RequestMapping(value="/queryGoalList", method=RequestMethod.POST)
	public JSONObject goalManage(HttpServletRequest req,HttpServletResponse resp) {
		JSONObject json = new JSONObject();
		GoalCondition goalCondition = new GoalCondition();
		goalCondition.setSetDate(null==req.getParameter("setDate")?"":req.getParameter("setDate").trim());
		goalCondition.setGoalName(null==req.getParameter("goalName")?"":req.getParameter("goalName").trim());
		goalCondition.setGoalLevel(null==req.getParameter("goalLevel")?"":req.getParameter("goalLevel").trim());
		goalCondition.setCompleteStatus(null==req.getParameter("completeStatus")?"":req.getParameter("completeStatus").trim());
		List<PersonalGoalsDo> goalList = personalGoalsService.queryGoalList(goalCondition);
		json.put("flag", "success");
		json.put("goalList", goalList);
		Integer count = personalGoalsService.queryCountByComSta("3");
		json.put("count", count);
		return commonResponseUtil.responseMethod(json, resp);
	}
	
	@RequestMapping(value="addGoal", method=RequestMethod.POST)
	public JSONObject addGoal(HttpServletRequest req,HttpServletResponse resp) {
		String goal = req.getParameter("goalForm");
		JSONObject goaljson = JSONObject.parseObject(goal);
		GoalCondition personalGoal = JSONObject.toJavaObject(goaljson, GoalCondition.class);
		int endNum = IDQueryRunner.goalEndNum;
		String newEndString = AtomicIDUtil.getQualityNum("G", null==newEndNum?endNum:newEndNum);
		String endString = newEndString.substring(1, newEndString.length());
		newEndNum = Integer.valueOf(endString);
		personalGoal.setGoalNum(newEndString);
		personalGoalsService.addGoal(personalGoal);
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		json.put("goalNum", newEndString);
		return commonResponseUtil.responseMethod(json, resp);
	}
	
	@RequestMapping(value="addStage", method=RequestMethod.POST)
	public JSONObject addStage(HttpServletRequest req,HttpServletResponse resp) {
		String stage = req.getParameter("stageForm");
		StageCondition stageCondition = JSONObject.toJavaObject(JSONObject.parseObject(stage), StageCondition.class);
		StringBuffer sb = new StringBuffer();
		String stageNum = sb.append(stageCondition.getGoalNum()).append("-").append(stageCondition.getCount()).toString();
		stageCondition.setStageNum(stageNum);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		stageCondition.setModifyTime(sdf.format(date));
		personalGoalsService.addStage(stageCondition);
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		json.put("goalNum", stageCondition.getGoalNum());
		return commonResponseUtil.responseMethod(json, resp);
	}
	
	@RequestMapping(value="editGoal", method=RequestMethod.POST)
	public JSONObject editGoal(HttpServletRequest req,HttpServletResponse resp) {
		String goal = req.getParameter("goalForm");
		JSONObject goaljson = JSONObject.parseObject(goal);
		GoalCondition personalGoal = JSONObject.toJavaObject(goaljson, GoalCondition.class);
		personalGoalsService.editGoal(personalGoal);
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		return commonResponseUtil.responseMethod(json, resp);
	}
	
	@RequestMapping(value="queryWishList", method=RequestMethod.POST)
	public JSONObject queryWishList(HttpServletRequest req,HttpServletResponse resp) {
		String wishDate = req.getParameter("wishDate");
		String wishStatus = req.getParameter("wishStatus");
		List<WishingDo> wishList = personalGoalsService.queryWishList(wishDate, wishStatus);
		Integer count = personalGoalsService.queryCountByWishSta("0");
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		json.put("wishList", wishList);
		json.put("count", count);
		return commonResponseUtil.responseMethod(json, resp);
	}
	
	@RequestMapping(value="addOrUpdateWish", method=RequestMethod.POST)
	public JSONObject addOrUpdateWish(HttpServletRequest req,HttpServletResponse resp) {
		String wish = req.getParameter("wishForm");
		WishCondition wishCondition = JSONObject.toJavaObject(JSONObject.parseObject(wish), WishCondition.class);
		personalGoalsService.addOrUpdateWish(wishCondition);
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		return commonResponseUtil.responseMethod(json, resp);
	}
	
	@RequestMapping(value="queryStageList", method=RequestMethod.POST)
	public JSONObject queryStageList(HttpServletRequest req,HttpServletResponse resp) {
		String goalNum = req.getParameter("goalNum");
		String stageStatus = req.getParameter("stageStatus");
		List<PersonalGoalsDo> stageList = personalGoalsService.queryStageList(goalNum, stageStatus);
		Integer count = personalGoalsService.queryCountByStageSta("3");
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		json.put("stageList", stageList);
		json.put("count", count);
		return commonResponseUtil.responseMethod(json, resp);
	}
	
	@RequestMapping(value="addOrUpdateStage", method=RequestMethod.POST)
	public JSONObject addOrUpdateStage(HttpServletRequest req,HttpServletResponse resp) {
		JSONObject json = new JSONObject();
		String stage = req.getParameter("stageForm");
		StageCondition stageCondition = JSONObject.toJavaObject(JSONObject.parseObject(stage), StageCondition.class);
		String goalNum = stageCondition.getGoalNum();
		if(goalNum == null || "".equals(goalNum)) {
			json.put("flag", "fail");
			json.put("message", "目标编号为空无法添加或修改阶段!");
			return commonResponseUtil.responseMethod(json, resp);
		}
		GoalCondition goalCondition = new GoalCondition();
		goalCondition.setGoalNum(goalNum);
		List<PersonalGoalsDo> list = personalGoalsService.queryGoalList(goalCondition);
		if(list == null || list.isEmpty()) {
			json.put("flag", "fail");
			json.put("message", "该目标不存在无法添加或修改阶段!");
			return commonResponseUtil.responseMethod(json, resp);
		}
		if(stageCondition.getStageNum() == null || "".equals(stageCondition.getStageNum())) {
			String count = personalGoalsService.queryLastCountByGoalNum(goalNum);
			StringBuffer sb = new StringBuffer();
			String NewStageNum = sb.append(goalNum).append("-").append(String.valueOf(Integer.valueOf(count)+1)).toString();
			stageCondition.setStageNum(NewStageNum);
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		stageCondition.setModifyTime(sdf.format(date));
		personalGoalsService.addOrUpdateStage(stageCondition);
		json.put("flag", "success");
		return commonResponseUtil.responseMethod(json, resp);
	}
	
	@RequestMapping(value="queryWisdomList", method=RequestMethod.POST)
	public JSONObject queryWisdomList(HttpServletRequest req,HttpServletResponse resp) {
		String modIdd = req.getParameter("modIdd");
		String wisNum = req.getParameter("wisNum");
		String wisdom = req.getParameter("wisdom");
		List<ModuleRefDo> wisdomList = personalGoalsService.queryWisdomList(modIdd, wisNum, wisdom);
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		json.put("wisdomList", wisdomList);
		return commonResponseUtil.responseMethod(json, resp);
	}
	
	@RequestMapping(value="addOrUpdateWisdom", method=RequestMethod.POST)
	public JSONObject addOrUpdateWisdom(HttpServletRequest req,HttpServletResponse resp) {
		String wisdom = req.getParameter("wisdomForm");
		WisdomCondition wisdomCondition = JSONObject.toJavaObject(JSONObject.parseObject(wisdom), WisdomCondition.class);
		personalGoalsService.addOrUpdateWisdom(wisdomCondition);
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		return commonResponseUtil.responseMethod(json, resp);
	}
}
