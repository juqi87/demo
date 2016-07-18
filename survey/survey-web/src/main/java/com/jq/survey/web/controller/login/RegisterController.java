package com.jq.survey.web.controller.login;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jq.survey.dao.entity.UserInfoDO;
import com.jq.survey.service.user.UserInfoService;
import com.jq.survey.utils.common.EncryptUtils;
import com.jq.survey.utils.common.ValidateUtils;
import com.jq.survey.utils.enums.RespCodeEnum;
import com.jq.survey.utils.exception.HandleException;
import com.jq.survey.web.controller.common.BaseController;
import com.jq.survey.web.vo.UserInfoVO;

/**
 * 系统注册
 * 
 * @author juqi
 * @version $Id: RegisterController.java, v 0.1 2016年7月12日 上午9:45:18 juqi Exp $
 */
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {

	/**  */
	private static final long serialVersionUID = -3467233622335564563L;
	
	private Logger log = Logger.getLogger(RegisterController.class);
	
	@Resource
	private UserInfoService userInfoService;
	
	@RequestMapping("/goto")
	public String register(Model model){
		log.info("进入注册页面");
		return "/view/login/register";
	}
	
	@RequestMapping(value="/doRegister",method = RequestMethod.POST)
	public String doRegister(ModelMap model, UserInfoVO userInfoVO){
		log.info("进行注册操作");
		try{
			//1.校验前台参数
			verifiyRegister(userInfoVO);
			
			UserInfoDO userInfoDO = new UserInfoDO();
			BeanUtils.copyProperties(userInfoVO, userInfoDO);
			String encodePwd = EncryptUtils.encodePassword(userInfoVO.getPassword());
			userInfoDO.setPassword(encodePwd);
			int resp = userInfoService.registerUser(userInfoDO);
			if(resp != 1){
				throw new RuntimeException("新增记录失败");
			}
		}catch(HandleException he){
			log.error(he.getErrorDesc(), he);
			model.put("message", he.getErrorDesc());
			model.put("userInfoVO", userInfoVO);
			return "/view/login/register";
		}catch(Exception e){
			log.error(e.getMessage(), e);
			model.put("message", RespCodeEnum.SYSTEM_ERROR.getDesc());
			model.put("userInfoVO", userInfoVO);
			return "/error/500/500";
		}
		return "/view/login/register";
	}
	
	/**
	 * 校验注册参数
	 * 
	 * @param vo
	 */
	private void verifiyRegister(UserInfoVO vo){
		log.info("校验注册参数");
		HandleException selfException = null;
		if(StringUtils.isBlank(vo.getEmail()) || !ValidateUtils.isEmail(vo.getEmail())){
			log.info(RespCodeEnum.EMAIL_ILLEGAL.getDesc());
			selfException = new HandleException();
			selfException.setErrorCode(RespCodeEnum.EMAIL_ILLEGAL.getCode());
			selfException.setErrorDesc(RespCodeEnum.EMAIL_ILLEGAL.getDesc());
			throw selfException; 
		}
		if(!ValidateUtils.ischeckParam(true, false, vo.getLoginName(), 16)){
			log.info(RespCodeEnum.LOGIN_NAME_ILLEGAL.getDesc());
			selfException = new HandleException();
			selfException.setErrorCode(RespCodeEnum.LOGIN_NAME_ILLEGAL.getCode());
			selfException.setErrorDesc(RespCodeEnum.LOGIN_NAME_ILLEGAL.getDesc());
			throw selfException; 
		}
		if(StringUtils.isBlank(vo.getTel()) || !ValidateUtils.isPhoneNum(vo.getTel())){
			log.info(RespCodeEnum.TEL_NAME_ILLEGAL.getDesc());
			selfException = new HandleException();
			selfException.setErrorCode(RespCodeEnum.TEL_NAME_ILLEGAL.getCode());
			selfException.setErrorDesc(RespCodeEnum.TEL_NAME_ILLEGAL.getDesc());
			throw selfException; 
		}
		if(ValidateUtils.ischeckParam(true, false, vo.getPassword(), 100)){
			log.info(RespCodeEnum.PASSWORD_ILLEGAL.getDesc());
			selfException = new HandleException();
			selfException.setErrorCode(RespCodeEnum.PASSWORD_ILLEGAL.getCode());
			selfException.setErrorDesc(RespCodeEnum.PASSWORD_ILLEGAL.getDesc());
			throw selfException; 
		}
	}

}
