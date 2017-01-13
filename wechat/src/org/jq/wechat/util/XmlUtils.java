package org.jq.wechat.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * xml文件的一些处理类
 * 
 * @author juqi
 * @version $Id: XmlUtils.java, v 0.1 2017年1月13日 下午3:15:29 juqi Exp $
 */
public class XmlUtils {

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
	
	/**
	 * 将xml字符串转换成对应的对象
	 * @param result
	 * @param clazz
	 * @return
	 * @author juqi
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertResult(String result, Class<T> clazz) {
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        xStream.processAnnotations(clazz);
        Object transaction = xStream.fromXML(result);
        return (T)transaction;
    }
	
	
}
