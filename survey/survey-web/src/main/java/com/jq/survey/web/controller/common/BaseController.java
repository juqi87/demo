package com.jq.survey.web.controller.common;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.jq.survey.utils.common.JsonUtils;
import com.jq.survey.web.controller.common.domain.ResponseInfo;

/**
 * 基控制类
 * 提供一些公共的方法
 * @author juqi
 * @version $Id: BaseController.java, v 0.1 2016年6月16日 下午3:27:41 juqi Exp $
 */
public class BaseController implements Serializable {

	/**  */
	private static final long serialVersionUID = -2605726791067096142L;
	
	private Logger log = Logger.getLogger(BaseController.class);
	
	protected String convertResp(String respCode, String message){
		ResponseInfo ri = new ResponseInfo();
		ri.setRespCode(respCode);
		ri.setMessage(message);
		try{
			String respJson = JsonUtils.toJson(ri);
			return respJson;
		}catch(Exception e){
			
		}
		return "";
	}

}
