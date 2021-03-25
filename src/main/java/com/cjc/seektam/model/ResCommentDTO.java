package com.cjc.seektam.model;

import java.sql.Timestamp;

public class ResCommentDTO {
	private Integer num;
	private Double res_num;
	private String writer;
	private String comments;
	private String img;
	private Integer agree;
	private Integer disagree;
	private Integer num_of_vote;
	private Integer open;
	private Timestamp reg;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Double getRes_num() {
		return res_num;
	}
	public void setRes_num(Double res_num) {
		this.res_num = res_num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getAgree() {
		return agree;
	}
	public void setAgree(Integer agree) {
		this.agree = agree;
	}
	public Integer getDisagree() {
		return disagree;
	}
	public void setDisagree(Integer disagree) {
		this.disagree = disagree;
	}
	public Integer getNum_of_vote() {
		return num_of_vote;
	}
	public void setNum_of_vote(Integer num_of_vote) {
		this.num_of_vote = num_of_vote;
	}
	public Integer getOpen() {
		return open;
	}
	public void setOpen(Integer open) {
		this.open = open;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
}
