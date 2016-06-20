package com.jq.survey.web.paper;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.jq.survey.web.common.BaseJUnit;

public class Test1 extends BaseJUnit {

	@Test
	public void test1() throws Exception{
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setServletPath("/test.htm");
		
		request.addParameter("path", "pppppppppppp");
		request.addParameter("id", "1002");
		// 执行URI对应的action  
		final ModelAndView mav = this.excuteAction(request, response);  
		// Assert logic  
		Assert.assertEquals("/test.htm", mav.getViewName());  
		String msg=(String)request.getAttribute("msg");  
		System.out.println(msg);  
	}
}
