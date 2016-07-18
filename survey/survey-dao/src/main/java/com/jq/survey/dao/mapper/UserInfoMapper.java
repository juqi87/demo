package com.jq.survey.dao.mapper;

import java.util.List;

import com.jq.survey.dao.entity.UserInfoDO;

/**
 * 
 * 
 * @author juqi
 * @version $Id: UserInfoMapper.java, v 0.1 2016年7月11日 下午4:23:46 juqi Exp $
 */
public interface UserInfoMapper {

	List<UserInfoDO> selectByCondition(UserInfoDO condition);
	
	int insert(UserInfoDO userInfoDO);
	
}