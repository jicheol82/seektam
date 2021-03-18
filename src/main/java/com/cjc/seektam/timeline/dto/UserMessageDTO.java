package com.cjc.seektam.timeline.dto;

import java.sql.Timestamp;

public class UserMessageDTO {
	private Integer num;
	private String sender;
	private String receiver;
	private String message;
	private Integer ref;
	private Integer ref_level;
	private Timestamp reg;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getRef() {
		return ref;
	}
	public void setRef(Integer ref) {
		this.ref = ref;
	}
	public Integer getRef_level() {
		return ref_level;
	}
	public void setRef_level(Integer ref_level) {
		this.ref_level = ref_level;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
}

