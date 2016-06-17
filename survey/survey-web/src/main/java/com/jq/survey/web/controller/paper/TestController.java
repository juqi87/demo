package com.jq.survey.web.controller.paper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	
	@RequestMapping(value="test.htm", method = RequestMethod.GET)
	public String dataQuestion(String path, Model model, HttpServletRequest request){
		System.out.println(11111222213333);
		return "paper/dataQuestion";
	}
}
