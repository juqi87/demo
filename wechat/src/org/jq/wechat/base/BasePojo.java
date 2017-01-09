package org.jq.wechat.base;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 基础类
 * 重写了一些基础方法
 * @author juqi
 * @version $Id: BasePojo.java, v 0.1 2017年1月9日 上午11:34:13 juqi Exp $
 */
public abstract class BasePojo {

	@Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
	
}
