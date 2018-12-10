package com.xingxing.privateRecord.qo;

import java.io.Serializable;

public class GoalCondition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String goalNum;
	private String goalName;
	private String goalLevel;
	private String completeStatus;
	private String setDate;
	private String preDate;
	
	
	public String getGoalNum() {
		return goalNum;
	}
	public void setGoalNum(String goalNum) {
		this.goalNum = goalNum;
	}
	public String getPreDate() {
		return preDate;
	}
	public void setPreDate(String preDate) {
		this.preDate = preDate;
	}
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	public String getGoalLevel() {
		return goalLevel;
	}
	public void setGoalLevel(String goalLevel) {
		this.goalLevel = goalLevel;
	}
	public String getCompleteStatus() {
		return completeStatus;
	}
	public void setCompleteStatus(String completeStatus) {
		this.completeStatus = completeStatus;
	}
	public String getSetDate() {
		return setDate;
	}
	public void setSetDate(String setDate) {
		this.setDate = setDate;
	}
	@Override
	public String toString() {
		return "GoalCondition [goalNum=" + goalNum + ", goalName=" + goalName + ", goalLevel=" + goalLevel
				+ ", completeStatus=" + completeStatus + ", setDate=" + setDate + ", preDate=" + preDate + "]";
	}
	
	
	
	
}
