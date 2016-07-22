package com.jq.survey.dao.mapper;

import java.util.List;

import com.jq.survey.dao.entity.MenuInfoDO;

/**
 * 
 * 
 * @author juqi
 * @version $Id: MenuInfoMapper.java, v 0.1 2016年7月20日 下午5:15:30 juqi Exp $
 */
public interface MenuInfoMapper {
   
	List<MenuInfoDO> selectByCondition(MenuInfoDO condition);
	
}