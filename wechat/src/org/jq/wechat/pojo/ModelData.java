package org.jq.wechat.pojo;

import org.jq.wechat.base.BasePojo;

/**
 * 
 * 
 * @author juqi
 * @version $Id: ModelData.java, v 0.1 2017年1月13日 下午3:42:46 juqi Exp $
 */
public class ModelData extends BasePojo {
	
    private String value;
    private String color;
    
    public ModelData() {
        this.value = "";
        this.color = "";
    }
    
    public ModelData(String value, String color) {
        super();
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
