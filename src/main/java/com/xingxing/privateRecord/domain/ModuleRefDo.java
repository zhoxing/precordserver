package com.xingxing.privateRecord.domain;

import java.io.Serializable;
import java.util.Date;

public class ModuleRefDo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String modIdd;
	private String modName;
	private String wisNum;
	private String wisdom;
	private Date notiTime;
	private String notiMsg;
	public String getModIdd() {
		return modIdd;
	}
	public void setModIdd(String modIdd) {
		this.modIdd = modIdd;
	}
	public String getModName() {
		return modName;
	}
	public void setModName(String modName) {
		this.modName = modName;
	}
	public String getWisNum() {
		return wisNum;
	}
	public void setWisNum(String wisNum) {
		this.wisNum = wisNum;
	}
	public String getWisdom() {
		return wisdom;
	}
	public void setWisdom(String wisdom) {
		this.wisdom = wisdom;
	}
	public Date getNotiTime() {
		return notiTime;
	}
	public void setNotiTime(Date notiTime) {
		this.notiTime = notiTime;
	}
	public String getNotiMsg() {
		return notiMsg;
	}
	public void setNotiMsg(String notiMsg) {
		this.notiMsg = notiMsg;
	}
	@Override
	public String toString() {
		return "MuduleRefDo [modIdd=" + modIdd + ", modName=" + modName + ", wisNum=" + wisNum + ", wisdom=" + wisdom
				+ ", notiTime=" + notiTime + ", notiMsg=" + notiMsg + "]";
	}

	
}
