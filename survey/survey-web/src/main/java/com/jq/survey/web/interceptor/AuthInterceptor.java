package com.jq.survey.web.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jq.survey.dao.entity.ext.RoleMenuExtDO;
import com.jq.survey.service.auth.AuthService;
import com.jq.survey.utils.constant.Constants;
import com.jq.survey.utils.enums.MenuLevelEnum;
import com.jq.survey.web.vo.MenuInfoVO;
import com.jq.survey.web.vo.UserInfoVO;

/**
 * 权限拦截器
 * 
 * @author juqi
 * @version $Id: AuthInterceptor.java, v 0.1 2016年7月20日 下午5:02:54 juqi Exp $
 */
public class AuthInterceptor implements HandlerInterceptor {

	private Logger log = Logger.getLogger(AuthInterceptor.class);
	
	//不做拦截的请求
	private static final String[] IGNORE_REQUEST = {".act", ".txt"};
	//不做拦截的路径
	private static final String[] IGNORE_URL = {"/login", "/register", "/test"};
	//被拦截后跳转的路径
	private static final String LOGIN_URL = "../login/goto";
	
	@Resource
	private AuthService authService;
	
	/**
	 * 获取请求路径,判断该用户是否有请求权限
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) 
			throws Exception {
		log.info("权限拦截器,执行请求之前");
		String servletPath = request.getServletPath();
		if(isPlainResource(request)){
			return true;
		}
		HttpSession session = request.getSession();
		UserInfoVO userInfo = (UserInfoVO) session.getAttribute("userInfo");
		if(userInfo == null){
			request.getRequestDispatcher(LOGIN_URL).forward(request, response);
			return false;
		}
		String roleId = userInfo.getRoleId();
		String menuId = getMenu(request);
		if(authService.hasAuth(roleId, menuId) || servletPath.startsWith("/index")){
			log.info("该用户权限通过");
			return true;
		}
		log.warn("该用户无该权限, roleId="+roleId+",menuId+"+menuId);
		return false;
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 
	 * 记录每部请求后的操作
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) 
			throws Exception {
		log.info("权限拦截器,执行请求之后,视图生成之前");
		if(isPlainResource(request)){
			return;
		}
		HttpSession session = request.getSession();
		UserInfoVO userInfo = (UserInfoVO) session.getAttribute("userInfo");
		String roleId = userInfo.getRoleId();
		List<MenuInfoVO> menuInfoList = getMenuByRole(roleId);
		request.setAttribute("menuInfoList", menuInfoList);
		log.info(menuInfoList);
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
	
	/**
	 * 判断是否需要获取菜单
	 * @param request
	 * @return
	 */
	private boolean isNeedGetMenu(HttpServletRequest request){
		String servletPath = request.getServletPath();
		log.info("判断是否需要获取菜单"+servletPath);
		if(servletPath.startsWith("/login") || servletPath.startsWith("/register")
				|| servletPath.endsWith(".act")){
			return false;
		}
		return true;
	}
	
	private List<MenuInfoVO> getMenuByRole(String roleId){
		List<RoleMenuExtDO> roleMenu1ExtDOs = 
				authService.queryAuthOfRoleAndLevel(roleId, MenuLevelEnum.LEVEL1.getCode(), Constants.SYS_MENU_ID);
		if(CollectionUtils.isEmpty(roleMenu1ExtDOs)){
			return null;
		}
		List<MenuInfoVO> munuLevel1VOs = new ArrayList<MenuInfoVO>();
		for(RoleMenuExtDO roleMenuExtDO : roleMenu1ExtDOs){
			MenuInfoVO menuInfoVO = convert2VO(roleMenuExtDO);
			List<RoleMenuExtDO> roleMenu2ExtDOs = 
					authService.queryAuthOfRoleAndLevel(roleId, MenuLevelEnum.LEVEL2.getCode(), roleMenuExtDO.getMenuId());
			if(!CollectionUtils.isEmpty(roleMenu2ExtDOs)){
				List<MenuInfoVO> munuLevel2VOs = new ArrayList<MenuInfoVO>();
				for(RoleMenuExtDO ext : roleMenu2ExtDOs){
					MenuInfoVO menuInfo2VO = convert2VO(ext);
					munuLevel2VOs.add(menuInfo2VO);
				}
				menuInfoVO.setMunuInfoVOs(munuLevel2VOs);
			}
			munuLevel1VOs.add(menuInfoVO);
		}
		return munuLevel1VOs;
	}
	
	private boolean isPlainResource(HttpServletRequest request) {
		String servletPath = request.getServletPath();
		log.info(servletPath);
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
	
	/**
	 * 获取此次请求的菜单
	 * @param request
	 * @return
	 */
	private String getMenu(HttpServletRequest request){
		String servletPath = request.getServletPath();
		String[] param = StringUtils.split(servletPath, "/");
		String menuId = param[0];
		return menuId;
	}
	
	private MenuInfoVO convert2VO(RoleMenuExtDO ext){
		MenuInfoVO menuInfoVO = new MenuInfoVO();
		menuInfoVO.setMenuId(ext.getMenuId());
		menuInfoVO.setMenuName(ext.getMenuName());
		menuInfoVO.setMenuLevel(ext.getMenuLevel());
		menuInfoVO.setModuleIcon(ext.getModuleIcon());
		menuInfoVO.setParentId(ext.getParentId());
		menuInfoVO.setHaveSon(ext.getHaveSon());
		menuInfoVO.setSerial(ext.getSerial());
		menuInfoVO.setStat(ext.getStat());
		return menuInfoVO;
	}
	
}
