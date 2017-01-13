package org.jq.wechat.pojo;

import org.jq.wechat.base.BasePojo;

/**
 * 
 * 
 * @author juqi
 * @version $Id: ModelMessage.java, v 0.1 2017年1月13日 下午3:42:41 juqi Exp $
 */
public class ModelMessage extends BasePojo {
	
    private String touser;
    private String template_id;
    private String url;
    private String topcolor;
    private Model data;
    
    public String getTouser() {
        return touser;
    }
    public void setTouser(String touser) {
        this.touser = touser;
    }
    public String getTemplate_id() {
        return template_id;
    }
    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTopcolor() {
        return topcolor;
    }
    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }
    public Model getData() {
        return data;
    }
    public void setData(Model data) {
        this.data = data;
    }
    
}
