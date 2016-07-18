package com.jq.survey.web.controller.login;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jq.survey.web.controller.common.BaseController;

/**
 * 
 * 
 * @author juqi
 * @version $Id: LoginController.java, v 0.1 2016年6月16日 下午3:28:38 juqi Exp $
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	/**  */
	private static final long serialVersionUID = 2664563384739658397L;
	
	private Logger log = Logger.getLogger(LoginController.class);
	
	@RequestMapping("/goto")
	public String login(Model model){
		log.info("进入登陆页面");
		return "/view/login/login";
	}
	
	@RequestMapping("/do")
	public String doLogin(Model model){
		log.info("进行登陆操作");
		//
		
		
		return "/view/login/login";
	}
	
	
	
	@RequestMapping("/logout")
	public String logout(Model model){
		log.info("进行登出操作");
		//TODO
		
		
		return "/view/login/login";
	}

}
