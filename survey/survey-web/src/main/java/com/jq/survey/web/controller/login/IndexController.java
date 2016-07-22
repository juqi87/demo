package com.jq.survey.web.controller.login;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jq.survey.web.controller.common.BaseController;

@Controller
public class IndexController extends BaseController {

	/**  */
	private static final long serialVersionUID = -6451451422527073094L;
	
	private Logger log = Logger.getLogger(IndexController.class);
	
	@RequestMapping("/index.htm")
	public String login(Model model){
		log.info("进入系统首页");
		return "/view/login/index";
	}
	

}
