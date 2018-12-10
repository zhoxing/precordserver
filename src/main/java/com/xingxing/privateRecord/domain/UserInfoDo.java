package com.xingxing.privateRecord.domain;

import java.io.Serializable;

public class UserInfoDo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String nickName;
	private String password;
	private String createTime;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "UserInfoVo [userId=" + userId + ", nickName=" + nickName
				+ ", password=" + password + ", createTime=" + createTime + "]";
	}

	
}
