package com.jq.survey.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class TestDB implements Serializable{

	/**  */
	private static final long serialVersionUID = -2036305952619307339L;
	
	private String stat;

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		return "TestDB [stat=" + stat + "]";
	}

}
