package com.jq.survey.web.controller.paper;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	private Logger log = Logger.getLogger(TestController.class);
	
	@RequestMapping(value="test.htm", method = RequestMethod.GET)
	public String dataQuestion(String path, Model model, HttpServletRequest request){
		System.out.println(1111122221);
		log.info("testetsttetstetstteest============================="+path);
		String word0 = "Hello ";
		String word1 = "World!2222222";
		//將數據添加到視圖數據容器中
		model.addAttribute("word0",word0);
		model.addAttribute("word1",word1);
		throw new RuntimeException("我是异常");
//		return "/view/test/test";
	}
}
