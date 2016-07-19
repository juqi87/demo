package com.jq.survey.service.user.impl;

import javax.annotation.Resource;

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

	public UserInfoDO queryUserInfoBy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerUser(UserInfoDO userInfoDO) {
		log.info("新增商户"+userInfoDO);
		HandleException selfException = null;
		String userId = "";
		int resp = userInfoMapper.insert(userInfoDO);
		if(resp != 1){
			log.info("新增记录失败"+userInfoDO);
			selfException = new HandleException();
			selfException.setErrorCode(RespCodeEnum.SYSTEM_ERROR.getCode());
			selfException.setErrorCode(RespCodeEnum.SYSTEM_ERROR.getDesc());
			throw selfException;
		}
		return resp;
	}
	
	

}
