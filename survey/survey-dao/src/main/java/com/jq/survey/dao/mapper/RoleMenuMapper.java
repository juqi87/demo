package com.jq.survey.dao.mapper;

import java.util.List;

import com.jq.survey.dao.entity.RoleMenuDO;

/**
 * 
 * 
 * @author juqi
 * @version $Id: RoleMenuMapper.java, v 0.1 2016年7月11日 下午4:26:23 juqi Exp $
 */
public interface RoleMenuMapper {

	List<RoleMenuDO> selectByCondition(RoleMenuDO condition);
	
}