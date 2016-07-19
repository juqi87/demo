package com.jq.survey.utils.enums;

/**
 * 状态枚举
 * 
 * @author juqi
 * @version $Id: StatEnum.java, v 0.1 2016年7月19日 上午10:41:00 juqi Exp $
 */
public enum StatEnum {

	NORMAL("N", "正常"),
    CLOSE("C", "关闭");
	
	public static StatEnum valueByCode(String code) {
        for (StatEnum stat : StatEnum.values()) {
            if (stat.getCode().equals(code)) {
                return stat;
            }
        }
        return null;
    }
	
	private String code;
	private String desc;
	
	private StatEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
