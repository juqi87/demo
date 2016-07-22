package com.jq.survey.service.auth;

import java.util.List;

import com.jq.survey.dao.entity.MenuInfoDO;

public interface MenuInfoService {

	public MenuInfoDO queryMenuInfoByPK(String menuId);
	
	public List<MenuInfoDO> queryMenuInfoByLevelAndParent(int menuLevel, String parentId);
	
}
