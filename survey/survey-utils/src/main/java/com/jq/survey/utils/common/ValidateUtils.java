package com.jq.survey.utils.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.util.Assert;

import com.jq.survey.utils.domain.Money;

public abstract class ValidateUtils {
	
	public final static String YUAN_FORMAT = "[\\d]+\\.[\\d]{2}";

    /**
     * 判断参数str不为空并且小于等于要求的最大长度
     * 
     * ValidateUtils.notNullAndLessEqualThanMaxLength(null, 2)   = false
     * ValidateUtils.notNullAndLessEqualThanMaxLength("", 2)     = false
     * ValidateUtils.notNullAndLessEqualThanMaxLength(" ", 2)    = false
     * ValidateUtils.notNullAndLessEqualThanMaxLength("1", 2)    = true
     * ValidateUtils.notNullAndLessEqualThanMaxLength("12", 2)   = true
     * ValidateUtils.notNullAndLessEqualThanMaxLength("测", 2)   = true
     * ValidateUtils.notNullAndLessEqualThanMaxLength("123", 2)  = false
     * 
     * @param str
     * @param maxLength
     * @return
     */
    public static boolean notNullAndLessEqualThanMaxLength(String str, int maxLength) {

        if (StringUtils.isBlank(str)) {
            return false;
        }

        return str.getBytes().length <= maxLength;
    }
    /**
     * 判断参数str小于等于要求的最大长度，大于等于要求的最小长度
     * 
     * @param str
     * @param maxLength
     * @param minLength
     * @return
     */
    public static boolean notNullAndGreatEqualThanMinLengthAndLessEqualThanMaxLength(String str, int minLength ,int maxLength) {

        if (StringUtils.isBlank(str)) {
            return false;
        }

        return str.getBytes().length <= maxLength && str.getBytes().length>=minLength;
    }

    /**
     * 判断参数str小于等于要求的最大长度
     * 
     * @param str
     * @param maxLength
     * @return
     */
    public static boolean lessEqualThanMaxLength(String str, int maxLength) {
        return str.getBytes().length <= maxLength;
    }
    /**
     * 判断参数str大于等于要求的最小长度
     * 
     * @param str
     * @param maxLength
     * @return
     */
    public static boolean lessEqualThanMinLength(String str, int minLength) {
    	if (StringUtils.isBlank(str)) {
            return false;
        }
    	return str.getBytes().length >= minLength;
    }
    
    /**
     * 是否是合法的金额格式
     * 
     * ValidateUtils.isValidMoney(null)      = false
     * ValidateUtils.isValidMoney(" ")       = false
     * ValidateUtils.isValidMoney("")        = false
     * ValidateUtils.isValidMoney("ab")      = false
     * ValidateUtils.isValidMoney("12.00")   = true
     * ValidateUtils.isValidMoney("12")      = false
     * ValidateUtils.isValidMoney("12.")     = false
     * ValidateUtils.isValidMoney("12.0")    = false
     * ValidateUtils.isValidMoney("12.254")  = false
     * ValidateUtils.isValidMoney("0.56")    = true
     * ValidateUtils.isValidMoney("1b.56")   = false
     * 
     * @param orderAmount
     * @return
     */
    public static boolean isValidMoney(String orderAmount) {
        if (!notNullAndLessEqualThanMaxLength(orderAmount, 14)) {
            return false;
        }
        if (!isYuanAmount(orderAmount)) {
            return false;
        }
        if (lessEqualThanZero(orderAmount)) {
            return false;
        }
        return true;
    }
    
    public static boolean isValidMoneyWithZero(String orderAmount) {
        if (!notNullAndLessEqualThanMaxLength(orderAmount, 14)) {
            return false;
        }
        if (!isYuanAmount(orderAmount)) {
            return false;
        }
        if (lessThanZero(orderAmount)) {
            return false;
        }
        return true;
    }

    private static boolean lessEqualThanZero(String orderAmount) {
        return new Money(orderAmount).compareTo(new Money(0)) <= 0;
    }
    
    private static boolean lessThanZero(String orderAmount) {
        return new Money(orderAmount).compareTo(new Money(0)) < 0;
    }

    /**
     * 金额是否匹配形如："12.00"
     * 
     * @param amount
     * @return "", "12", "12.000", "0.00" 返回false
     */
    public static boolean isYuanAmount(String amount) {
        if (StringUtils.isBlank(amount)) {
            return false;
        }
        if (!isRegexMatch(amount, YUAN_FORMAT)) {
            return false;
        }
        return true;
    }

    /**
     * 判断身份证号是否正确
     * @param ip
     * @return
     */
    public static final boolean isCertId(String certId) {
        return isRegexMatch(certId, "\\d{15}|\\d{17}[\\dXx]");
    }

    /**
     * 判断手机号码格式是否正确
     * 手机号格式判断1开头11位数字
     * @param cellPhoneNum
     * @return
     */
    public static final boolean isCellPhoneNum(String cellPhoneNum) {
        return isRegexMatch(cellPhoneNum, "^((\\(\\d{2,3}\\))|(\\d{3}\\-))?1\\d{10}$");
    }

    /**
     * 判断是否正确银行卡号8-32位
     */
    public static final boolean isCardNo(String cardNo) {
        return isRegexMatch(cardNo, "(^[0-9]{8,32}$)");
    }

    /**
     * 利用正则表达式检查是否完整匹配
     * @param text
     * @param reg
     * @return
     */
    public static final boolean isRegexMatch(String text, String reg) {
        if (StringUtils.isNotEmpty(text) && StringUtils.isNotBlank(reg)) {
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(text);
            return m.matches();
        }
        return false;
    }
    
	/**
	 * 判断Long、Integer、Short、Double、Float等数字是否为空或者0
	 * @param number
	 * @return
	 */
	public static final boolean isNumberNotNullOrZero(Number number){
		return (number!=null&& number.doubleValue()!=0);
	}
	
	/**
     * 判断密码是否6到16位
     * false 为非6-16位或汉字
     * */
    public static final boolean isPasswordFormat(String password){
        return isMatch(password,"^(.{6,16})$")&&isMatch(password,"^([\\x00-\\xff]+)");
    }
    
    /**
     * 判断email格式是否正确
     * @param email
     * @return
     */
    public static final boolean isEmail(String email){
        return isMatch(email,"^([a-zA-Z0-9_\\.\\-]+)(@{1})([a-zA-Z0-9_\\.\\-]+)(\\.[a-zA-Z0-9]{1,3})$");
    }
    
    /**
     * 判断电话号码格式是否正确
     * @param phoneNum
     * @return
     */
    public static final boolean isPhoneNum(String phoneNum){
        return isMatch(phoneNum,"^((\\(\\d{2,3}\\))|(\\d{3}\\-))?(\\(0\\d{2,3}\\)|0\\d{2,3}-)?[1-9]\\d{6,7}(\\-\\d{1,4})?$");
    }
    
    /**
	 * 判断（如"0123","123L","12.3S"等带有小数点和后缀的）字串，是否代表数字类型
	 * @param str
	 * @return
	 */
	public static final boolean isNumber(String str){
		return NumberUtils.isNumber(str);
	}
    
    /**
	 * 检查（如"0123","123L","12.3S"等带有小数点和后缀的）字串，是否代表数字类型
	 * @param str
	 */
	public static final void checkNumber(String str){
		Assert.isTrue(isNumber(str),"'"+str+"' must be a Number format here.");
	}
	
	/**
     * 校验BUSR_ID格式
     * 字母，数字，@，-，_，.，
     * 不能为10位数字，防止和cust_id重复
     * @param message
     * @return
     */
    public static final boolean isBusrId(String message) {
        return isMatch(message, "^[A-Za-z0-9-_@.]+$") && !isMatch(message, "(^[0-9]{10}$)");
    }
	
    /**
     * 利用正则表达式检查是否完整匹配
     * @param text
     * @param reg
     * @return
     */
    public static final boolean isMatch(String text,String reg){
        if (StringUtils.isNotEmpty(text)&&StringUtils.isNotBlank(reg)){
            Pattern p = Pattern.compile(reg); 
            Matcher m = p.matcher(text);
            return m.matches();
        }
        return false;
    }
    
    /**
     * 验证小数
     * @param str
     * @return
     */
    public static boolean isNumberAndPoint(String str) {
        String reg = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d*))$";
        return isMatch(str, reg);
    }

    /**
	 * 方法验证是否为空、是否固定长度、是否小于等于最大长度
	 * 
	 * @param isNeedCheckNotEmpty 是否为空
	 * @param isFixedLength 是否固定长度
	 * @param isFixedLength 需要验证的参数
	 * @param maxLength 是否小于等于最大长度
	 * @return
	 */
	public static final boolean ischeckParam(boolean isNeedCheckNotEmpty,
			boolean isFixedLength, String param, int maxLength) {
		if (isNeedCheckNotEmpty) {// 需要验证空
			if (StringUtils.isEmpty(param)) {
				return false;
			}
			param = param.trim();
		} else {// 不需要验证空，将字段trim处理
			if (param == null) {
				param = "";
			} else {
				param = param.trim();
			}
		}
		if (isFixedLength) {// 如果固定长度
			if (param.getBytes().length != maxLength) {
				return false;
			}
		} else {
			if (param.getBytes().length > maxLength) {
				return false;
			}
		}
		return true;
	}
    /**
     * 验证是字母数字下划线
     * @param busrId
     * @return
     */
    public static boolean isNumberLetterUnderLine(String str) {
        String reg = "^[0-9a-zA-Z_]{1,}$";
        return isMatch(str, reg);
    }
    
}
