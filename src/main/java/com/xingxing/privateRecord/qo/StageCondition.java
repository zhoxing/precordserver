package com.xingxing.privateRecord.qo;

import java.io.Serializable;

public class StageCondition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String goalNum;
	private String stageNum;
	private int count;
	private String content;
	private String reward;
	private String stageStatus;
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getGoalNum() {
		return goalNum;
	}
	public void setGoalNum(String goalNum) {
		this.goalNum = goalNum;
	}
	public String getStageNum() {
		return stageNum;
	}
	public void setStageNum(String stageNum) {
		this.stageNum = stageNum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public String getStageStatus() {
		return stageStatus;
	}
	public void setStageStatus(String stageStatus) {
		this.stageStatus = stageStatus;
	}
	@Override
	public String toString() {
		return "StageCondition [goalNum=" + goalNum + ", stageNum=" + stageNum + ", content=" + content + ", reward="
				+ reward + ", stageStatus=" + stageStatus + "]";
	}
	
	
	
	
	
}
