package com.jq.survey.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jq.survey.dao.mapper.TestDBMapper;
import com.jq.survey.web.controller.paper.PaperController;

/**
 * 
 * 
 * @author juqi
 * @version $Id: TestController.java, v 0.1 2016年6月30日 下午3:17:08 juqi Exp $
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	private Logger log = Logger.getLogger(PaperController.class);

	@Autowired
    TestDBMapper testDBMapper;
	
	@RequestMapping("/testDB")
    public String index1(ModelMap model, HttpServletRequest request) {
		String dbstat = testDBMapper.testDB();
		log.info(dbstat);
		model.put("DBStat", dbstat);
        return "/testDB";
    }
	
	@RequestMapping("/testRequest")
    public String testRequest(ModelMap model, String auth_code) {
		log.info("auth_code="+auth_code);
		
        return "/test";
    }
	
	public static final String USRID_URL = ""; 
	

	
}
