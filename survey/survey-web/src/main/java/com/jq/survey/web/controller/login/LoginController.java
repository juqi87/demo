package com.jq.survey.web.controller.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jq.survey.dao.entity.UserInfoDO;
import com.jq.survey.service.user.UserInfoService;
import com.jq.survey.utils.common.CaptchaUtils;
import com.jq.survey.utils.common.EncryptUtils;
import com.jq.survey.utils.common.ValidateUtils;
import com.jq.survey.utils.constant.Constants;
import com.jq.survey.utils.enums.RespCodeEnum;
import com.jq.survey.utils.exception.HandleException;
import com.jq.survey.web.controller.common.BaseController;
import com.jq.survey.web.vo.LoginVO;
import com.jq.survey.web.vo.UserInfoVO;

/**
 * 
 * 
 * @author juqi
 * @version $Id: LoginController.java, v 0.1 2016年6月16日 下午3:28:38 juqi Exp $
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	/**  */
	private static final long serialVersionUID = 2664563384739658397L;
	
	private Logger log = Logger.getLogger(LoginController.class);
	
	@Resource
	private UserInfoService userInfoService;
	
	@RequestMapping("/goto")
	public String login(Model model){
		log.info("进入登陆页面");
		return "/view/login/login";
	}
	
	@RequestMapping(value="/imageCode.act")
	public void imageCode(HttpServletRequest request, HttpServletResponse response) {
		log.info("生成验证码");
		try{
			CaptchaUtils captcha = new CaptchaUtils();
			captcha.getRandcode(request, response);
		}catch(Exception e){
			log.error("生成验证码失败", e);
		}
		log.info("生成验证码成功");
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(ModelMap model, HttpSession session, LoginVO loginVO){
		log.info("进行登陆操作");
		try{
			//1.校验登陆参数
			verifiyLogin(loginVO);
			//2.校验验证码
			String sessionChkCode = (String) session.getAttribute(Constants.CHKCODE);
			if(!StringUtils.equals(sessionChkCode, loginVO.getChkCode())){
				log.warn("验证码错误");
				model.put("message", RespCodeEnum.CHK_CODE_ERROR.getDesc());
				model.put("loginVO", loginVO);
				return "/view/login/login";
			}
			//3.根据邮箱查询用户
			UserInfoDO userInfoDO = userInfoService.queryUserInfoByEmail(loginVO.getEmail());
			if(userInfoDO == null){
				log.warn("用户不存在");
				model.put("message", RespCodeEnum.USER_INFO_NOT_EXIST.getDesc());
				model.put("loginVO", loginVO);
				return "/view/login/login";
			}
			//4.校验密码
			String clearPassword = loginVO.getPassword();
			String encodePassword = userInfoDO.getPassword();
			if(!EncryptUtils.validatePwd(clearPassword, encodePassword)){
				log.warn("用户密码错误");
				model.put("message", RespCodeEnum.PASSWORD_ERROR.getDesc());
				model.put("loginVO", loginVO);
				return "/view/login/login";
			}
			log.info("密码校验成功！");
			log.info("用户身份信息正确");
			//5.保存进入session
//			session.invalidate();//让之前的session失效
			UserInfoVO userInfoVO = new UserInfoVO();
			BeanUtils.copyProperties(userInfoDO, userInfoVO);
			session.setAttribute("userInfo", userInfoVO);
			
		}catch(HandleException he){
			log.error(he.getErrorDesc(), he);
			model.put("message", he.getErrorDesc());
			return "/view/login/login";
		}catch(Exception e){
			log.error(e);
			model.put("message", RespCodeEnum.SYSTEM_ERROR.getDesc());
			return "/view/login/login";
		}
		return "/view/login/index";
	}
		
	@RequestMapping("/logout")
	public String logout(ModelMap model, HttpSession session){
		log.info("进行登出操作");
		session.invalidate();
		return "/view/login/login";
	}
	
	/**
	 * 校验登陆参数
	 * @param vo
	 */
	private void verifiyLogin(LoginVO vo){
		log.info("校验登陆参数"+vo);
		HandleException selfException = null;
		if(StringUtils.isBlank(vo.getEmail()) || !ValidateUtils.isEmail(vo.getEmail())){
			log.info(RespCodeEnum.EMAIL_ILLEGAL.getDesc());
			selfException = new HandleException();
			selfException.setErrorCode(RespCodeEnum.EMAIL_ILLEGAL.getCode());
			selfException.setErrorDesc(RespCodeEnum.EMAIL_ILLEGAL.getDesc());
			throw selfException;
		}
		if(StringUtils.isBlank(vo.getPassword())){
			log.info(RespCodeEnum.PASSWORD_ILLEGAL.getDesc());
			selfException = new HandleException();
			selfException.setErrorCode(RespCodeEnum.PASSWORD_ILLEGAL.getCode());
			selfException.setErrorDesc(RespCodeEnum.PASSWORD_ILLEGAL.getDesc());
			throw selfException;
		}
		if(StringUtils.isBlank(vo.getChkCode())){
			log.info(RespCodeEnum.CHK_CODE_NULL.getDesc());
			selfException = new HandleException();
			selfException.setErrorCode(RespCodeEnum.CHK_CODE_NULL.getCode());
			selfException.setErrorDesc(RespCodeEnum.CHK_CODE_NULL.getDesc());
			throw selfException;
		}
		
	}

}
