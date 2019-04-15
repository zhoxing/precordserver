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
	private String modifyTime;
	
	
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
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
		return "StageCondition [goalNum=" + goalNum + ", stageNum=" + stageNum + ", count=" + count + ", content="
				+ content + ", reward=" + reward + ", stageStatus=" + stageStatus + ", modifyTime=" + modifyTime + "]";
	}
	
	
	
	
	
	
}
