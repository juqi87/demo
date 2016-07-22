package com.jq.survey.utils.enums;

public enum MenuLevelEnum {

	LEVEL1(1, "一级菜单"),
	LEVEL2(2, "二级菜单"),;
	
	private Integer code;
	private String levelDesc;
	
	public static MenuLevelEnum valueByCode(String code) {
        for (MenuLevelEnum menuLevel : MenuLevelEnum.values()) {
            if (menuLevel.getCode().equals(code)) {
                return menuLevel;
            }
        }
        return null;
    }
	
	private MenuLevelEnum(Integer code, String levelDesc) {
		this.code = code;
		this.levelDesc = levelDesc;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getLevelDesc() {
		return levelDesc;
	}
	public void setLevelDesc(String levelDesc) {
		this.levelDesc = levelDesc;
	}

}
