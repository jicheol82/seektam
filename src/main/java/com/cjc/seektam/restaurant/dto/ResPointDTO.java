package com.cjc.seektam.restaurant.dto;

import java.sql.Timestamp;

public class ResPointDTO {
	private Integer num;
	private Integer res_num;
	private Integer ref;
	private Timestamp reg;
	private Integer taste;
	private Integer price;
	private Integer kindness;
	private Integer hygiene;
	
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
	public Integer getRef() {
		return ref;
	}
	public void setRef(Integer ref) {
		this.ref = ref;
	}
	public Timestamp getReg() {
		return reg;
	}
	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	public Integer getTaste() {
		return taste;
	}
	public void setTaste(Integer taste) {
		this.taste = taste;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getKindness() {
		return kindness;
	}
	public void setKindness(Integer kindness) {
		this.kindness = kindness;
	}
	public Integer getHygiene() {
		return hygiene;
	}
	public void setHygiene(Integer hygiene) {
		this.hygiene = hygiene;
	}
}
