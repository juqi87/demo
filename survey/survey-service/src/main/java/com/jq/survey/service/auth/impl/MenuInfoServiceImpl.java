package com.jq.survey.service.auth.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jq.survey.dao.entity.MenuInfoDO;
import com.jq.survey.dao.mapper.MenuInfoMapper;
import com.jq.survey.service.auth.MenuInfoService;

/**
 * 
 * 
 * @author juqi
 * @version $Id: MenuInfoServiceImpl.java, v 0.1 2016年7月20日 下午5:25:51 juqi Exp $
 */
@Service("menuInfoService")
public class MenuInfoServiceImpl implements MenuInfoService {
	
	private Logger log = Logger.getLogger(MenuInfoService.class);

	@Resource
	private MenuInfoMapper menuInfoMapper;
	
	@Override
	public MenuInfoDO queryMenuInfoByPK(String menuId) {
		MenuInfoDO condition = new MenuInfoDO();
		condition.setMenuId(menuId);
		List<MenuInfoDO> list = menuInfoMapper.selectByCondition(condition);
		if(CollectionUtils.isEmpty(list)){
			log.warn("没有查询到该菜单信息,menuId="+menuId);
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<MenuInfoDO> queryMenuInfoByLevelAndParent(int menuLevel,String parentId) {
		MenuInfoDO condition = new MenuInfoDO();
		condition.setMenuLevel(menuLevel);
		condition.setParentId(parentId);
		List<MenuInfoDO> list = menuInfoMapper.selectByCondition(condition);
		if(CollectionUtils.isEmpty(list)){
			log.warn("没有查询到该菜单信息,menuLevel="+menuLevel+", parentId="+parentId);
			return null;
		}
		return list;
	}

}
