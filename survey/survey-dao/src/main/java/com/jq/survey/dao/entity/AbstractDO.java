package com.jq.survey.dao.entity;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * 
 * @author juqi
 * @version $Id: AbstractDO.java, v 0.1 2016年7月11日 下午3:10:29 juqi Exp $
 */
public abstract class AbstractDO implements Serializable {

	/**  */
	private static final long serialVersionUID = 1151346663598730720L;
	
	@Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
