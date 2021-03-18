package com.cjc.seektam.group.dto;

import java.sql.Timestamp;

public class GroupsDTO {
	private Integer num;
	private String name;
	private String area;
	private String group_leader;
	private Integer num_of_mem;
	private Integer activity_score;
	private Integer open;
	private Timestamp reg;
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getGroup_leader() {
		return group_leader;
	}
	public void setGroup_leader(String group_leader) {
		this.group_leader = group_leader;
	}
	public Integer getNum_of_mem() {
		return num_of_mem;
	}
	public void setNum_of_mem(Integer num_of_mem) {
		this.num_of_mem = num_of_mem;
	}
	public Integer getActivity_score() {
		return activity_score;
	}
	public void setActivity_score(Integer activity_score) {
		this.activity_score = activity_score;
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
