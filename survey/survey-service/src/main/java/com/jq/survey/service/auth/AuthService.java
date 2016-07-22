package com.jq.survey.service.auth;

import java.util.List;

import com.jq.survey.dao.entity.MenuInfoDO;
import com.jq.survey.dao.entity.ext.RoleMenuExtDO;

public interface AuthService {

	public List<MenuInfoDO> queryAuthOfRole(String roleId);
	
	public List<RoleMenuExtDO> queryAuthOfRoleAndLevel(String roleId, int level, String parentId);
	
	public boolean hasAuth(String roleId, String menuId);
	
}
