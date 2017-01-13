package org.jq.wechat.pojo;

/**
 * 
 * 
 * @author juqi
 * @version $Id: ViewButton.java, v 0.1 2017年1月13日 下午3:42:26 juqi Exp $
 */
public class ViewButton extends Button {
    private String type;  
    private String url;  
  
    public String getType() {  
        return type;  
    }  
  
    public void setType(String type) {  
        this.type = type;  
    }  
  
    public String getUrl() {  
        return url;  
    }  
  
    public void setUrl(String url) {  
        this.url = url;  
    }  
}
