package com.xingxing.privateRecord.qo;

import java.io.Serializable;

public class WisdomCondition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8014330752017417203L;

	private String modIdd;
	private String wisNum;
	private String wisdom;
	public String getModIdd() {
		return modIdd;
	}
	public void setModIdd(String modIdd) {
		this.modIdd = modIdd;
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
	@Override
	public String toString() {
		return "WisdomCondition [modIdd=" + modIdd + ", wisNum=" + wisNum + ", wisdom=" + wisdom + "]";
	}
	
	
	
	
}
