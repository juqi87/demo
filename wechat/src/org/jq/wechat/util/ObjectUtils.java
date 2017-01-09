package org.jq.wechat.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;

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
	 * 將obj对象转成xml报文形式
	 * <xml>
	 * <sign><![CDATA[E1EE61A91C8E90F299DE6AE075D60A2D]]></sign>
	 * <mch_id><![CDATA[888]]></mch_id>
	 * </xml>
	 * @param obj
	 * @return
	 * @author juqi
	 */
	public static String convert2Xml(Object obj) {
        XStream xStream = new XStream(new DomDriver("UTF-8", new NoNameCoder()));
        xStream.autodetectAnnotations(true);
        xStream.autodetectAnnotations(true);
        String xmlReportBody = xStream.toXML(obj);
        System.out.println(xmlReportBody);
        return xmlReportBody;
    }
	
	
}
