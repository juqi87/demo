package com.jq.survey.web.controller.paper;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class TestController {

	
	@RequestMapping(value="test.htm", method = RequestMethod.GET)
	public String dataQuestion(String path, Model model, HttpServletRequest request){
		
		return "paper/dataQuestion";
	}
}
