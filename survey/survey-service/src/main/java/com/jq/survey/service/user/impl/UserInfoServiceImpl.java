package com.jq.survey.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jq.survey.dao.entity.UserInfoDO;
import com.jq.survey.dao.mapper.UserInfoMapper;
import com.jq.survey.service.user.UserInfoService;
import com.jq.survey.utils.enums.RespCodeEnum;
import com.jq.survey.utils.exception.HandleException;

/**
 * 
 * 
 * @author juqi
 * @version $Id: UserInfoServiceImpl.java, v 0.1 2016年7月11日 下午5:59:42 juqi Exp $
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	
	private Logger log = Logger.getLogger(UserInfoService.class);
	
	@Resource
	private UserInfoMapper userInfoMapper;
	

	public UserInfoDO queryUserInfoByPK(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<UserInfoDO> queryUserInfoBy(UserInfoDO condition) {
		if(condition == null){
			return null;
		}
		return userInfoMapper.selectByCondition(condition);
	}
	
	@Override
	public UserInfoDO queryUserInfoByEmail(String email){
		UserInfoDO condition = new UserInfoDO();
		condition.setEmail(email);
		List<UserInfoDO> userInfoDOs = queryUserInfoBy(condition);
		if(CollectionUtils.isEmpty(userInfoDOs)){
			return null;
		}
		return userInfoDOs.get(0);
	}

	@Override
	public int registerUser(UserInfoDO userInfoDO) {
		log.info("新增商户"+userInfoDO);
		HandleException selfException = null;
		int resp = userInfoMapper.insert(userInfoDO);
		if(resp != 1){
			log.warn("新增记录失败"+userInfoDO);
			selfException = new HandleException();
			selfException.setErrorCode(RespCodeEnum.SYSTEM_ERROR.getCode());
			selfException.setErrorCode(RespCodeEnum.SYSTEM_ERROR.getDesc());
			throw selfException;
		}
		return resp;
	}
	
	

}
