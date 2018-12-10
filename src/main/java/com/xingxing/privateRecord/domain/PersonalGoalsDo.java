package com.xingxing.privateRecord.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 目标基础实体类
 * @author zhouxing
 *
 */
public class PersonalGoalsDo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String goalNum;
	private String goalName;
	private String goalLevel;
	private String completeStatus;
	private Date setDate;
	private Date preDate;
	private String stageNum;
	private String content;
	private String reward;
	private String stageStatus;
	private String recordNum;
	private Integer totalNum;
	private Date fillTime;
	private String recordDetail;
	public String getGoalNum() {
		return goalNum;
	}
	public void setGoalNum(String goalNum) {
		this.goalNum = goalNum;
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
	public Date getSetDate() {
		return setDate;
	}
	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}
	public Date getPreDate() {
		return preDate;
	}
	public void setPreDate(Date preDate) {
		this.preDate = preDate;
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
	public String getRecordNum() {
		return recordNum;
	}
	public void setRecordNum(String recordNum) {
		this.recordNum = recordNum;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Date getFillTime() {
		return fillTime;
	}
	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}
	public String getRecordDetail() {
		return recordDetail;
	}
	public void setRecordDetail(String recordDetail) {
		this.recordDetail = recordDetail;
	}
	@Override
	public String toString() {
		return "PersonalGoalsDo [goalNum=" + goalNum + ", goalName=" + goalName + ", goalLevel=" + goalLevel
				+ ", completeStatus=" + completeStatus + ", setDate=" + setDate + ", preDate=" + preDate + ", stageNum="
				+ stageNum + ", content=" + content + ", reward=" + reward + ", stageStatus=" + stageStatus
				+ ", recordNum=" + recordNum + ", totalNum=" + totalNum + ", fillTime=" + fillTime + ", recordDetail="
				+ recordDetail + "]";
	}
	
	
	
}
