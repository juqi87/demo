package com.jq.survey.web.wx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jq.survey.web.controller.common.BaseController;

/**
 * 绑定微信安全域名
 * 
 * @author juqi
 * @version $Id: BindingDomainController.java, v 0.1 2016年11月14日 下午2:06:42 juqi Exp $
 */
@Controller
public class BindingDomainController extends BaseController {

	/**  */
	private static final long serialVersionUID = 7983584652474370861L;

	@RequestMapping("/MP_verify_StUqeuWYW41S5Xtx.txt")
	@ResponseBody
	public String bindingDomain(){
		return "StUqeuWYW41S5Xtx";
	}
	
	
}
