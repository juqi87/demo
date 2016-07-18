package com.jq.survey.utils.common;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import com.jq.survey.utils.constant.Constants;

/**
 * 加密巩固类
 * 
 * @author juqi
 * @version $Id: EncryptUtils.java, v 0.1 2016年7月15日 下午4:47:18 juqi Exp $
 */
public class EncryptUtils {

	private static final String SALT = Constants.PWD_SALT;
	
	/**
	 * 对明文密码进行MD5摘要加密
	 * @param clearPassword	 明文密码
	 * @return  32位长度加密密码
	 */
	public static String encodePassword(String clearPassword){
		return DigestUtils.md5Hex(SALT + clearPassword);
	}
	
	/**
	 * 校验密码
	 * @param clearPassword	明文密码
	 * @param encodePassword 加密密码
	 * @return
	 */
	public static boolean validatePwd(String clearPassword, String encodePassword){
		if(clearPassword == null || encodePassword == null){
			return false;
		}
		return StringUtils.equals(encodePassword(clearPassword), encodePassword);
	}
	
}
