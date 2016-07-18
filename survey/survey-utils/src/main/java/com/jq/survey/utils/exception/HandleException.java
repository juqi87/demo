package com.jq.survey.utils.exception;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 处理异常
 * 
 * @author juqi
 * @version $Id: HandleException.java, v 0.1 2016年7月15日 下午5:11:58 juqi Exp $
 */
public class HandleException extends RuntimeException {

	/**  */
	private static final long serialVersionUID = -7828710154230623179L;

	private String errorCode;
	private String errorDesc;
	
	public HandleException() {
		super();
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	@Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
	
}
