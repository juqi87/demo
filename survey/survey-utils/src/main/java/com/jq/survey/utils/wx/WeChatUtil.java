package com.jq.survey.utils.wx;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.jq.survey.utils.common.CommonUtils;


/**
 * 
 * 
 * @author juqi
 * @version $Id: WeChatUtil.java, v 0.1 2016年11月14日 下午2:17:15 juqi Exp $
 */
public class WeChatUtil {   
	
	private static Logger log = Logger.getLogger(WeChatUtil.class);
	  
    public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";  

    public final static String oauth2_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    public final static String oauth2_token_fresh_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
    
    public final static String oauth2_authorize_url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
    
    public final static String jsapi_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    
    /**
     * 获取授权链接
     * @param appId			公众号appid
     * @param redirectUrl	授权连转地址
     * @param scope			应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid）
     * 						snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。
     * 											并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
     * @param state			重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
     * @return
     */
    public static String getOauthRequestUrl(String appId, String redirectUrl, String scope, String state){
        redirectUrl = urlEncodeUTF8(redirectUrl);
        return oauth2_authorize_url.replace("APPID", appId).replace("REDIRECT_URI", redirectUrl).
        		replace("SCOPE", scope).replace("STATE", state);
    }
    
    /**
     * 获取用户openid
     * @param appId			公众号appid
     * @param appSecret		公众号appSecret
     * @param code			用户授权后微信服务器返回code。
     * 						code作为换取access_token的票据，每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。 
     * @return
     */
    public static String getOpenid(String appId, String appSecret, String code){
        String requestUrl = oauth2_token_url.replace("APPID", appId);
        requestUrl = requestUrl.replace("SECRET", appSecret);
        requestUrl = requestUrl.replace("CODE", code);
        log.info("requestUrl:"+requestUrl);
        
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        log.info("jsonObject:"+CommonUtils.showDetails(jsonObject));
        if(null != jsonObject){
            try {
            	return jsonObject.getString("openid");
            } catch (Exception e) {
                int errorCode = jsonObject.getInt("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                log.error("获取网页授权凭证失败errcode:{"+errorCode+"} errmsg:{"+errorMsg+"}", e);
            }
        }
        return "";
    }
    
    /**
     * 对链接进行utf-8编码处理
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source){
        String result = source;
        try {
            result = URLEncoder.encode(source,"utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 发送http请求
     * @param requestUrl
     * @param requestMethod
     * @param outputStr
     * @return
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {  
        JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();  
        try {  
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
            TrustManager[] tm = { new MyX509TrustManager() };  
            //SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE"); 
            SSLContext sslContext = SSLContext.getInstance("TLS");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            URL url = new URL(requestUrl);  
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
            httpUrlConn.setSSLSocketFactory(ssf);  
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            // 设置请求方式（GET/POST）  
            httpUrlConn.setRequestMethod(requestMethod);  
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            // 当有数据需要提交时  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码  
                outputStream.write(outputStr.getBytes("UTF-8"));  
                System.out.println(outputStr);
                outputStream.close();  
            }  
  
            // 将返回的输入流转换成字符串  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
            jsonObject = JSONObject.fromObject(buffer.toString());  
        } catch (ConnectException ce) {
        	log.error("Weixin server connection timed out.", ce);
        } catch (Exception e) {
        	log.error("https request error:{}", e);
        }  
        return jsonObject;  
    }
    
}
