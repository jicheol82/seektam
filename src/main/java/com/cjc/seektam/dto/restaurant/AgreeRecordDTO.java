package com.cjc.seektam.dto.restaurant;

import java.sql.Timestamp;

public class AgreeRecordDTO {
	private Integer num;
	private Integer res_num;
	private String id;
	private String decision;
	private Timestamp reg;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getRes_num() {
		return res_num;
	}
	public void setRes_num(Integer res_num) {
		this.res_num = res_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
}

