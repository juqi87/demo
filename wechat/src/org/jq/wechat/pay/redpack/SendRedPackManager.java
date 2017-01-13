package org.jq.wechat.pay.redpack;

import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.jq.wechat.pay.redpack.request.SendRedPackRequest;
import org.jq.wechat.pay.redpack.response.SendRedPackResponse;
import org.jq.wechat.util.HttpUtils;
import org.jq.wechat.util.ObjectUtils;
import org.jq.wechat.util.XmlUtils;

/**
 * 发送微信普通红包
 * 
 * @author juqi
 * @version $Id: SendRedPack.java, v 0.1 2017年1月9日 上午11:35:33 juqi Exp $
 */
public class SendRedPackManager {

	private Logger logger = Logger.getLogger(SendRedPackManager.class);
	
	public static final String SEND_RED_PACK_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	public static final String payKey = "8EE25AD624FF332DBEE6BDA82DED43BF";
	public static final String mch_id = "1416730602";
	
	public static void main(String[] args) { 
		SendRedPackRequest sendRedPackRequest = packageredPack();
		SendRedPackManager sendRedPackManager = new SendRedPackManager();
		SendRedPackResponse sendRedPackResponse = sendRedPackManager.sendRedPack(sendRedPackRequest);
		System.out.println(ObjectUtils.showDetails(sendRedPackResponse));
	}
	
	public static SendRedPackRequest packageredPack(){
		SendRedPackRequest redPackRequest = new SendRedPackRequest();
		redPackRequest.setAct_name("慧管家测试");
		redPackRequest.setClient_ip("116.228.227.206");//116.228.227.206  192.168.32.103
		redPackRequest.setMch_billno("1416730602"+"20170109"+"0000000001");
		redPackRequest.setMch_id("1416730602");
		redPackRequest.setNonce_str("5K8264ILTKCH16CQ2502SI8ZNMTM67VS");
		redPackRequest.setRe_openid("oth38wTBj_lFRxX2-bAZx6sUjrHo");//oth38wTBj_lFRxX2-bAZx6sUjrHo
		redPackRequest.setRemark("我是测试者备注");
		redPackRequest.setSend_name("我是红包发送测试者");
		redPackRequest.setTotal_amount(100);
		redPackRequest.setTotal_num(1);
		redPackRequest.setWishing("测试祝福语，新年快乐");
		redPackRequest.setWxappid("wx6ac15371f14282ca");
		return redPackRequest;
	}
	
	/**
	 * 想微信服务器发送发送红包请求
	 * @param sendRedPackRequest
	 * @return
	 * @author juqi
	 */
	public SendRedPackResponse sendRedPack(SendRedPackRequest sendRedPackRequest){
		//将请求参数转换成xml报文
		String xmlReport = convertRequest2XmlReport(sendRedPackRequest);
		logger.info("微信发送红包xml报文:" + xmlReport);
		SendRedPackResponse sendRedPackResponse = new SendRedPackResponse();
		try {
			String responseXml = HttpUtils.clientCustomSSL(SEND_RED_PACK_URL, xmlReport, 
					"D:/zhengshu/apiclient_cert.p12", mch_id);
			logger.info("微信发送红包返回的xml报文:" + responseXml);
			sendRedPackResponse = XmlUtils.convertResult(responseXml, SendRedPackResponse.class);
		} catch (Exception e) {
			logger.error("向微信请求发送普通红包异常");
		}
		return sendRedPackResponse;
	}
	
	private String convertRequest2XmlReport(SendRedPackRequest sendRedPackRequest){
		Map<String, String> paramMap = ObjectUtils.objectToMap(sendRedPackRequest);
		String sign = sign(paramMap, payKey);
		sendRedPackRequest.setSign(sign);
		return XmlUtils.convert2Xml(sendRedPackRequest);
	}
	
	/**
	 * 对参数进行签名
	 * @param paramMap
	 * @param key
	 * @return
	 * @author juqi
	 */
	private String sign(Map<String, String> paramMap, String key){
		Map<String, String> filterMap = ObjectUtils.filteParam(paramMap);
		String param = ObjectUtils.createLinkString(filterMap).concat("&key=").concat(key);
		return DigestUtils.md5Hex(param).toUpperCase();
	}
	
	
}
