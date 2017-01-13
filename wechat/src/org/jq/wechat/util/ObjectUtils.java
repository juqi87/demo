package org.jq.wechat.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 封装一些对对象操作的一些方法
 * 
 * @author juqi
 * @version $Id: ObjectUtils.java, v 0.1 2017年1月9日 上午11:14:27 juqi Exp $
 */
public class ObjectUtils {

	/**
	 * 将一个object对象转换成map
	 * @param obj
	 * @return
	 * @author juqi
	 */
	public static Map<String, String> objectToMap(Object obj) {    
        if(obj == null){    
            return null;    
        }   
        Map<String, String> map = new HashMap<String, String>();    
  
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        try{
	        for (Field field : declaredFields) {    
	            field.setAccessible(true);  
	            if(field.get(obj) != null){
	            	map.put(field.getName(), field.get(obj)+""); 
	            }
	        }    
        }catch(Exception e){
        	throw new RuntimeException("对象转map失败");
        }
        return map;  
    }
	
	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * @param params	需要排序并参与字符拼接的参数组
	 * @return			拼接后字符串
	 * @author juqi
	 */
	public static String createLinkString(Map<String, String> params) {
		List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
	}
	
	/**
	 * 除去数组中的空值和签名参数
	 * @param sArray	签名参数组
	 * @return			去掉空值与签名参数后的新签名参数组
	 * @author juqi
	 */
	public static Map<String, String> filteParam(Map<String, String> sArray) {
		Map<String, String> result = new HashMap<String, String>();
		if (sArray == null || sArray.size() <= 0) {
            return result;
        }
		for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }
		return result;
	}
	
	/**
	 * 答应对象内容
	 * @param object
	 * @return
	 * @author juqi
	 */
	public static String showDetails(Object object) {
        if (object == null) {
            return "object is null";
        }
        return ToStringBuilder.reflectionToString(object, ToStringStyle.SHORT_PREFIX_STYLE);
    }
	
}
