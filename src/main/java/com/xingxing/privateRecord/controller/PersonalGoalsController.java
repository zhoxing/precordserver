package com.xingxing.privateRecord.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.xingxing.privateRecord.Application;
import com.xingxing.privateRecord.domain.ModuleRefDo;
import com.xingxing.privateRecord.domain.PersonalGoalsDo;
import com.xingxing.privateRecord.domain.UserInfoDo;
import com.xingxing.privateRecord.init.IDQueryRunner;
import com.xingxing.privateRecord.qo.GoalCondition;
import com.xingxing.privateRecord.qo.StageCondition;
import com.xingxing.privateRecord.service.PersonalGoalsService;
import com.xingxing.privateRecord.util.AtomicIDUtil;
import com.xingxing.privateRecord.util.PrecordException;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@RestController
@RequestMapping("/api/personalGoals")
public class PersonalGoalsController {

	private static Logger log= Logger.getLogger(Application.class);
	private Integer newEndNum;
	@Autowired
	private PersonalGoalsService personalGoalsService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public JSONObject login(HttpServletRequest req,HttpServletResponse resp){
		log.debug("进入登录验证!");
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		UserInfoDo user = null;
		JSONObject json = new JSONObject();
		try {
			user = personalGoalsService.queryUser(userId, password);
		} catch (PrecordException e) {
			json.put("flag", "fail");
			json.put("message", e.getMessage());
			return json;
		}
		json.put("flag", "success");
		json.put("user", user);
		return json;
	}
	
	@RequestMapping(value="/index",method=RequestMethod.POST)
	public JSONObject index(HttpServletRequest req,HttpServletResponse resp) {
		log.debug("进入模板查询!");
		List<ModuleRefDo> queryModuleList = personalGoalsService.queryMuduleRef();
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		json.put("queryModuleList", queryModuleList);
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		return json;
	}
	
	@RequestMapping(value="/queryGoalList", method=RequestMethod.POST)
	public JSONObject goalManage(HttpServletRequest req,HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
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
		return json;
	}
	
	@RequestMapping(value="addGoal", method=RequestMethod.POST)
	public JSONObject addGoal(HttpServletRequest req,HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
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
		return json;
	}
	
	@RequestMapping(value="addStage", method=RequestMethod.POST)
	public JSONObject addStage(HttpServletRequest req,HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		String stage = req.getParameter("stageForm");
		StageCondition stageCondition = JSONObject.toJavaObject(JSONObject.parseObject(stage), StageCondition.class);
		StringBuffer sb = new StringBuffer();
		String stageNum = sb.append(stageCondition.getGoalNum()).append("-").append(stageCondition.getCount()).toString();
		stageCondition.setStageNum(stageNum);
		personalGoalsService.addStage(stageCondition);
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		json.put("goalNum", stageCondition.getGoalNum());
		return json;
	}
	
	@RequestMapping(value="editGoal", method=RequestMethod.POST)
	public JSONObject editGoal(HttpServletRequest req,HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "*"); 
		String goal = req.getParameter("goalForm");
		JSONObject goaljson = JSONObject.parseObject(goal);
		GoalCondition personalGoal = JSONObject.toJavaObject(goaljson, GoalCondition.class);
		personalGoalsService.editGoal(personalGoal);
		JSONObject json = new JSONObject();
		json.put("flag", "success");
		return json;
	}
}
