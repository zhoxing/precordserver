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
	private String goalNam;
	private String goalLvl;
	private String comSta;
	private Date setDat;
	private Date preDat;
	private String staNum;
	private String content;
	private String reward;
	private String staSta;
	private String recNum;
	private Integer totalN;
	private Date filTim;
	private String recDet;
	public String getGoalNum() {
		return goalNum;
	}
	public void setGoalNum(String goalNum) {
		this.goalNum = goalNum;
	}
	public String getGoalNam() {
		return goalNam;
	}
	public void setGoalNam(String goalNam) {
		this.goalNam = goalNam;
	}
	public String getGoalLvl() {
		return goalLvl;
	}
	public void setGoalLvl(String goalLvl) {
		this.goalLvl = goalLvl;
	}
	public String getComSta() {
		return comSta;
	}
	public void setComSta(String comSta) {
		this.comSta = comSta;
	}
	public Date getSetDat() {
		return setDat;
	}
	public void setSetDat(Date setDat) {
		this.setDat = setDat;
	}
	public Date getPreDat() {
		return preDat;
	}
	public void setPreDat(Date preDat) {
		this.preDat = preDat;
	}
	public String getStaNum() {
		return staNum;
	}
	public void setStaNum(String staNum) {
		this.staNum = staNum;
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
	public String getStaSta() {
		return staSta;
	}
	public void setStaSta(String staSta) {
		this.staSta = staSta;
	}
	public String getRecNum() {
		return recNum;
	}
	public void setRecNum(String recNum) {
		this.recNum = recNum;
	}
	public Integer getTotalN() {
		return totalN;
	}
	public void setTotalN(Integer totalN) {
		this.totalN = totalN;
	}
	public Date getFilTim() {
		return filTim;
	}
	public void setFilTim(Date filTim) {
		this.filTim = filTim;
	}
	public String getRecDet() {
		return recDet;
	}
	public void setRecDet(String recDet) {
		this.recDet = recDet;
	}
	@Override
	public String toString() {
		return "PersonalGoalsDo [goalNum=" + goalNum + ", goalNam=" + goalNam
				+ ", goalLvl=" + goalLvl + ", comSta=" + comSta + ", setDat="
				+ setDat + ", preDat=" + preDat + ", staNum=" + staNum
				+ ", content=" + content + ", reward=" + reward + ", staSta="
				+ staSta + ", recNum=" + recNum + ", totalN=" + totalN
				+ ", filTim=" + filTim + ", recDet=" + recDet + "]";
	}

	
}
