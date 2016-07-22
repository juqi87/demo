package com.jq.survey.web.vo;

import java.util.List;

import com.jq.survey.dao.entity.MenuInfoDO;

/**
 * 
 * 
 * @author juqi
 * @version $Id: MenuInfoVO.java, v 0.1 2016年7月21日 上午11:03:42 juqi Exp $
 */
public class MenuInfoVO extends MenuInfoDO {

	/**  */
	private static final long serialVersionUID = -1688320151684096680L;
	
	private List<MenuInfoVO> munuInfoVOs;

	public List<MenuInfoVO> getMunuInfoVOs() {
		return munuInfoVOs;
	}

	public void setMunuInfoVOs(List<MenuInfoVO> munuInfoVOs) {
		this.munuInfoVOs = munuInfoVOs;
	}
	
}
