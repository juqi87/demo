package com.jq.survey.web.wx;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jq.survey.utils.constant.Constants;
import com.jq.survey.utils.wx.SecurityUtil;

/**
 * 服务器绑定
 * 
 * @author juqi
 * @version $Id: BindingServerController.java, v 0.1 2016年6月24日 下午5:03:58 juqi Exp $
 */
@Controller
public class BindingServerController implements Serializable {

	/**  */
	private static final long serialVersionUID = -6377944868701616661L;
	
	private Logger log = Logger.getLogger(BindingServerController.class);
	
	@RequestMapping(value = "/bindingServer" , method =RequestMethod.GET )
    public void index(ModelMap model,HttpServletRequest req,HttpServletResponse rep) {
		log.info("接受微信绑定服务器请求");
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        
        if(timestamp == null) {
            timestamp ="";
        }
        if(nonce == null) {
            nonce = "";
        }
        if(echostr == null) {
            echostr = "";
        }
        log.info("收到参数:signature+["+signature+"]timestamp+["+timestamp+"]nonce+["+nonce+"]echostr+["+echostr+"]");
        String[] array = {Constants.TOKEN, timestamp, nonce};
        Arrays.sort(array);
        String tempStr = array[0]+array[1]+array[2];
        
        log.info("排序后的数据"+tempStr);
        
        String afterEncodeStr = SecurityUtil.encodeBySHA1(tempStr);
        log.info("加密后的字符串"+afterEncodeStr);
        
        if(afterEncodeStr.equals(signature)){
            log.info("校验成功，成为开发者！");
            try {
                PrintWriter out =  rep.getWriter();
                out.write(echostr);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            log.info("校验失败！");
        }
        
        
    }

}
