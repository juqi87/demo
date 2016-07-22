package com.jq.survey.service.auth.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.jq.survey.dao.entity.MenuInfoDO;
import com.jq.survey.dao.entity.RoleMenuDO;
import com.jq.survey.dao.entity.ext.RoleMenuExtDO;
import com.jq.survey.dao.mapper.RoleMenuMapper;
import com.jq.survey.service.auth.AuthService;
import com.jq.survey.service.auth.MenuInfoService;
import com.jq.survey.utils.enums.StatEnum;

/**
 * 
 * 
 * @author juqi
 * @version $Id: AuthServiceImpl.java, v 0.1 2016年7月20日 下午5:34:34 juqi Exp $
 */
@Service("authService")
public class AuthServiceImpl implements AuthService {
	
	private Logger log = Logger.getLogger(AuthService.class);

	@Resource
	private RoleMenuMapper roleMenuMapper;
	@Resource
	private MenuInfoService menuInfoService;
	
	@Override
	public List<MenuInfoDO> queryAuthOfRole(String roleId) {
		log.info("查询该角色所有可用的权限, roleId="+roleId);
		RoleMenuDO condition = new RoleMenuDO();
		condition.setRoleId(roleId);
		condition.setStat(StatEnum.NORMAL.getCode());
		List<RoleMenuDO> roleMenus = roleMenuMapper.selectByCondition(condition);
		if(CollectionUtils.isEmpty(roleMenus)){
			return null;
		}
		List<MenuInfoDO> menuInfos = new ArrayList<MenuInfoDO>();
		for(RoleMenuDO roleMenu : roleMenus){
			MenuInfoDO menuInfo = menuInfoService.queryMenuInfoByPK(roleMenu.getMenuId());
			menuInfos.add(menuInfo);
		}
		return menuInfos;
	}
	
	@Override
	public List<RoleMenuExtDO> queryAuthOfRoleAndLevel(String roleId, int menuLevel, String parentId){
		log.info("查询该角色该级别下的权限, roleId="+roleId+", menuLevel=" + menuLevel+", parentId="+parentId);
		RoleMenuExtDO condition = new RoleMenuExtDO();
		condition.setRoleId(roleId);
		condition.setMenuLevel(menuLevel);
		condition.setParentId(parentId);
		condition.setStat(StatEnum.NORMAL.getCode());
		List<RoleMenuExtDO> list = roleMenuMapper.queryRoleMenuBy(condition);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return list;
	}

	@Override
	public boolean hasAuth(String roleId, String menuId) {
		log.info("查询该角色是否有该菜单的权限,【roleId="+roleId+"】,【menuId="+menuId+"】");
		RoleMenuDO condition = new RoleMenuDO();
		condition.setRoleId(roleId);
		condition.setMenuId(menuId);
		condition.setStat(StatEnum.NORMAL.getCode());
		List<RoleMenuDO> roleMenus = roleMenuMapper.selectByCondition(condition);
		return !CollectionUtils.isEmpty(roleMenus);
	}

}
