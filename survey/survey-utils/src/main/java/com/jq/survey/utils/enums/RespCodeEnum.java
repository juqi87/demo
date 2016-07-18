package com.jq.survey.utils.enums;

/**
 * 错误返回码
 * 
 * @author juqi
 * @version $Id: RespCodeEnum.java, v 0.1 2016年7月15日 下午5:19:56 juqi Exp $
 */
public enum RespCodeEnum {

	SUCCESS("000", "成功"),
	FAIL("999", "失败"),
	SYSTEM_ERROR("XXX", "系统错误"),
	
	REQ_DATA_ILLEGAL("100", "请求参数不合法"),
	LOGIN_NAME_ILLEGAL("101", "账户名为空或格式不正确"),
	PASSWORD_ILLEGAL("102", "密码为空或格式不正确"),
	TEL_NAME_ILLEGAL("103", "手机号为空或格式不正确"),
	EMAIL_ILLEGAL("104", "邮件为空或格式不正确");
	
	public static RespCodeEnum valueByCode(String code) {
        for (RespCodeEnum respCodeEnum : RespCodeEnum.values()) {
            if (respCodeEnum.getCode().equals(code)) {
                return respCodeEnum;
            }
        }
        return null;
    }
	
	private String code;
	private String desc;
	
	private RespCodeEnum(String code, String desc) {
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
