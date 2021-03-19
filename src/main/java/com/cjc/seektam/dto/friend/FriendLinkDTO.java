package com.cjc.seektam.dto.friend;

import java.sql.Timestamp;

public class FriendLinkDTO {
	private Integer num;
	private String asker_id;
	private String receiver_id;
	private Integer relation;
	private Timestamp reg;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getAsker_id() {
		return asker_id;
	}
	public void setAsker_id(String asker_id) {
		this.asker_id = asker_id;
	}
	public String getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	public Integer getRelation() {
		return relation;
	}
	public void setRelation(Integer relation) {
		this.relation = relation;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
}
