package com.cjc.seektam.timeline.dto;

import java.sql.Timestamp;

public class GroupMessageDTO {
	private Integer num;
	private String gr_name;
	private String writer;
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
	public String getGr_name() {
		return gr_name;
	}
	public void setGr_name(String gr_name) {
		this.gr_name = gr_name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
