package com.jq.survey.web.controller.common.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * 
 * @author juqi
 * @version $Id: ResponseInfo.java, v 0.1 2016年7月12日 下午3:46:03 juqi Exp $
 */
public class ResponseInfo implements Serializable {

	/**  */
	private static final long serialVersionUID = -6240181024544287879L;

	private String respCode;
	private String message;
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
