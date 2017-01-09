package org.jq.wechat.pay.redpack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;
import org.jq.wechat.pay.redpack.request.RedPackRequest;

/**
 * 发送微信普通红包
 * 
 * @author juqi
 * @version $Id: SendRedPack.java, v 0.1 2017年1月9日 上午11:35:33 juqi Exp $
 */
public class SendRedPack {

	private Logger logger = Logger.getLogger(SendRedPack.class);
	
	public static final String url = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	public static final String payKey = "8EE25AD624FF332DBEE6BDA82DED43BF";
	public static final String mch_id = "1416730602";
	
	public static void main(String[] args) {
		
	}
	
	public static RedPackRequest packageredPack(){
		RedPackRequest redPackRequest = new RedPackRequest();
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
	
	public static void ClientCustomSSL(String url, String respXml) throws Exception {
		KeyStore keyStore  = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File("D:/zhengshu/apiclient_cert.p12"));//D:\微信\zhengshu
        try {
//            keyStore.load(instream, "10016225".toCharArray());
        	keyStore.load(instream, mch_id.toCharArray());
        } finally {
            instream.close();
        }
        // Trust own CA and all self-signed certs
        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mch_id.toCharArray()).build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,new String[] { "TLSv1" },null,
                SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {

            HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack");
            StringEntity  reqEntity  = new StringEntity(respXml, "utf-8");
            // 设置类型 
            reqEntity.setContentType("application/x-www-form-urlencoded"); 
            httpPost.setEntity(reqEntity);
            System.out.println("executing request" + httpPost.getRequestLine());

            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                HttpEntity entity = response.getEntity();

                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String text;
                    while ((text = bufferedReader.readLine()) != null) {
                        System.out.println(text);
                    }
                   
                }
//                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        
	} 
	
	
}
