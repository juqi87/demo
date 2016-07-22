package com.jq.survey.dao.entity.ext;

import com.jq.survey.dao.entity.RoleMenuDO;

public class RoleMenuExtDO extends RoleMenuDO {

	/**  */
	private static final long serialVersionUID = 6234339186482804215L;
	
	private String menuName;
	private Integer menuLevel;
	private String parentId;
	private Integer serial;
	private String haveSon;
	private String moduleIcon;
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public Integer getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	public String getHaveSon() {
		return haveSon;
	}
	public void setHaveSon(String haveSon) {
		this.haveSon = haveSon;
	}
	public String getModuleIcon() {
		return moduleIcon;
	}
	public void setModuleIcon(String moduleIcon) {
		this.moduleIcon = moduleIcon;
	}

}
