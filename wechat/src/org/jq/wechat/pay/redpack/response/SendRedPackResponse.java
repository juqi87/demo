package org.jq.wechat.pay.redpack.response;

import org.jq.wechat.base.BasePojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 发送微信红包返回参数
 * 
 * @author juqi
 * @version $Id: SendRedPackResponse.java, v 0.1 2017年1月9日 下午5:17:50 juqi Exp $
 */
@XStreamAlias("xml")
public class SendRedPackResponse extends BasePojo {

	@XStreamAlias("return_code")
	private String return_code;
	
	@XStreamAlias("return_msg")
	private String return_msg;
	
	@XStreamAlias("sign")
	private String sign;
	
	@XStreamAlias("result_code")
	private String result_code;
	
	@XStreamAlias("err_code")
	private String err_code;
	
	@XStreamAlias("err_code_des")
	private String err_code_des;
	
	@XStreamAlias("mch_billno")
	private String mch_billno;
	
	@XStreamAlias("mch_id")
	private String mch_id;
	
	@XStreamAlias("wxappid")
	private String wxappid;
	
	@XStreamAlias("re_openid")
	private String re_openid;
	
	@XStreamAlias("total_amount")
	private String total_amount;
	
	@XStreamAlias("send_listid")
	private String send_listid;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getMch_billno() {
		return mch_billno;
	}

	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getWxappid() {
		return wxappid;
	}

	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}

	public String getRe_openid() {
		return re_openid;
	}

	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getSend_listid() {
		return send_listid;
	}

	public void setSend_listid(String send_listid) {
		this.send_listid = send_listid;
	}
	
}
