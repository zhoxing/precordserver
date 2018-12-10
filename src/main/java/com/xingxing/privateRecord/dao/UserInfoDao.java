package com.xingxing.privateRecord.dao;

import com.xingxing.privateRecord.domain.UserInfoDo;


public interface UserInfoDao {

	/**
	 * 根据用户名和密码查询用户
	 * @param userId
	 * @param password
	 * @return
	 */
	public UserInfoDo selectUserByIdAndPassword(String userId, String password);
	
	/**
	 * 查询是否有该账号
	 * @param userId
	 * @return
	 */
	public UserInfoDo selectUserById(String userId);
}
