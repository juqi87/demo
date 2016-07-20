package com.jq.survey.service.user;

import java.util.List;

import com.jq.survey.dao.entity.UserInfoDO;

/**
 * 
 * 
 * @author juqi
 * @version $Id: UserInfoService.java, v 0.1 2016年7月11日 下午5:59:48 juqi Exp $
 */
public interface UserInfoService {

	public UserInfoDO queryUserInfoByPK(String userId);
	
	public List<UserInfoDO> queryUserInfoBy(UserInfoDO condtion);
	
	public UserInfoDO queryUserInfoByEmail(String email);
	
	public int registerUser(UserInfoDO userInfoDO);
	
}
