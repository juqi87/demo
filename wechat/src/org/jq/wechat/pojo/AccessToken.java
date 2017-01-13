package org.jq.wechat.pojo;

import org.jq.wechat.base.BasePojo;

/**
 * 
 * 
 * @author juqi
 * @version $Id: AccessToken.java, v 0.1 2017年1月13日 下午3:41:39 juqi Exp $
 */
public class AccessToken extends BasePojo {
	
    // 获取到的凭证  
    private String token;  
    // 凭证有效时间，单位：秒  
    private int expiresIn;  
  
    public String getToken() {  
        return token;  
    }  
  
    public void setToken(String token) {  
        this.token = token;  
    }  
  
    public int getExpiresIn() {  
        return expiresIn;  
    }  
  
    public void setExpiresIn(int expiresIn) {  
        this.expiresIn = expiresIn;  
    }  
}
