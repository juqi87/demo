package com.jq.survey.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登陆拦截器
 * @author juqi
 * @version $Id: LoginInterceptor.java, v 0.1 2016年6月16日 下午5:05:15 juqi Exp $
 */
public class LoginInterceptor implements HandlerInterceptor {

	private Logger log = Logger.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		log.info("==============执行顺序: 1、LoginInterceptor.preHandle================");
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) 
			throws Exception {
		log.info("==============执行顺序: 2、LoginInterceptor.postHandle================");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) 
			throws Exception {
		log.info("==============执行顺序: 3、LoginInterceptor.afterCompletion================"); 
		// TODO Auto-generated method stub
		
	}

}
