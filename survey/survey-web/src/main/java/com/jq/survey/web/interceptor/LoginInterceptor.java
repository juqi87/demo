package com.jq.survey.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jq.survey.web.vo.UserInfoVO;

/**
 * 登陆拦截器
 * @author juqi
 * @version $Id: LoginInterceptor.java, v 0.1 2016年6月16日 下午5:05:15 juqi Exp $
 */
public class LoginInterceptor implements HandlerInterceptor {

	private Logger log = Logger.getLogger(LoginInterceptor.class);
	
	//不做拦截的请求
	private static final String[] IGNORE_REQUEST = {".act", ".txt"};
	//不做拦截的路径
	private static final String[] IGNORE_URL = {"/login", "/test"};
	//被拦截后跳转的路径
	private static final String LOGIN_URL = "/login/goto";
	
	/**
	 * 在业务处理器处理请求之前被调用 
	 * 如果返回false  
	 *    从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
	 * 
	 * 如果返回true 
     *    执行下一个拦截器,直到所有的拦截器都执行完毕 
     *    再执行被拦截的Controller 
     *    然后进入拦截器链, 
     *    从最后一个拦截器往回执行所有的postHandle() 
     *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
	 */
	@SuppressWarnings("unused")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		log.info("登陆拦截器,执行请求之前");
		if(isPlainResource(request)){
			return true;
		}
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("userInfo");
		if(obj == null){
			request.getRequestDispatcher(LOGIN_URL).forward(request, response);
			return false;
		}
		UserInfoVO userInfo = (UserInfoVO) obj;
		if(userInfo == null){
			request.getRequestDispatcher(LOGIN_URL).forward(request, response);
			return false;
		}
		return true;
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 
	 * 记录每部请求后的操作
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) 
			throws Exception {
		log.info("登陆拦截器,执行请求之后,视图生成之前");
		// TODO Auto-generated method stub
		
	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用 
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) 
			throws Exception {
		log.info("登陆拦截器,执行请求之后,视图生成之后"); 
		// TODO Auto-generated method stub
		
	}
	
	private boolean isPlainResource(HttpServletRequest request) {
		String servletPath = request.getServletPath();
		log.info("请求路径："+servletPath);
		for(String str : IGNORE_REQUEST){
			if(servletPath.endsWith(str)){
				return true;
			}
		}
		for(String str : IGNORE_URL){
			if(servletPath.startsWith(str)){
				return true;
			}
		}
		return false;
	}

}
