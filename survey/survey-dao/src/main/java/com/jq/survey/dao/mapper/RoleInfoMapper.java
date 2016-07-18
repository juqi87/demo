package com.jq.survey.dao.mapper;

import java.util.List;

import com.jq.survey.dao.entity.RoleInfoDO;

/**
 * 
 * 
 * @author juqi
 * @version $Id: RoleInfoMapper.java, v 0.1 2016年7月11日 下午4:26:09 juqi Exp $
 */
public interface RoleInfoMapper {

	List<RoleInfoDO> selectByCondition(RoleInfoDO condition);
}