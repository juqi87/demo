package com.jq.survey.utils.common;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * 
 * @author juqi
 * @version $Id: CommonUtils.java, v 0.1 2016年11月14日 下午2:55:17 juqi Exp $
 */
public class CommonUtils {

	public static String showDetails(Object object) {
        if (object == null) {
            return "object is null";
        }
        return ToStringBuilder.reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE);
    }
	
}
