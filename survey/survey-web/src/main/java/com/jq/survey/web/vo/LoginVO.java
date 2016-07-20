package com.jq.survey.web.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class LoginVO implements Serializable{

	/**  */
	private static final long serialVersionUID = 7219140007591907029L;
	
	private String email;
	private String password;
	private String chkCode;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChkCode() {
		return chkCode;
	}
	public void setChkCode(String chkCode) {
		this.chkCode = chkCode;
	}
	
	@Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
	
}
