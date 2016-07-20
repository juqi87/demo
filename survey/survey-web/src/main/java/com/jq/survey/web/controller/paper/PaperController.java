package com.jq.survey.web.controller.paper;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jq.survey.web.controller.common.BaseController;

@Controller
@RequestMapping("/paper")
public class PaperController extends BaseController {

	/**  */
	private static final long serialVersionUID = -6926183759648695625L;
	
	private Logger log = Logger.getLogger(PaperController.class);
	
	@RequestMapping(value="/test.htm", method = RequestMethod.GET)
	public String dataQuestion(String path, Model model, HttpServletRequest request){
		System.out.println(1111122221);
		log.info("testetsttetstetstteest============================="+path);
		String word0 = "Hello ";
		String word1 = "World!2222222";
		model.addAttribute("word0",word0);
		model.addAttribute("word1",word1);
//		throw new RuntimeException("我是异常");
		return "/view/test/test";
	}
}
