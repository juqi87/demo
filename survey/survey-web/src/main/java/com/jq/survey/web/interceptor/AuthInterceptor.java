package com.jq.survey.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor {

	private Logger log = Logger.getLogger(AuthInterceptor.class);
	
	/**
	 * 获取请求路径,判断该用户是否有请求权限
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		log.info("权限拦截器,执行请求之前");
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 
	 * 记录每部请求后的操作
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) 
			throws Exception {
		log.info("权限拦截器,执行请求之后,视图生成之前");
		// TODO Auto-generated method stub
		
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用 
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) 
			throws Exception {
		log.info("权限拦截器,执行请求之后,视图生成之后"); 
		// TODO Auto-generated method stub
		
	}
}
