package com.minssam.cafepos.model.domain;

import java.sql.Date;

// 아래의 클래스는 로직 작성용이 아닌 오직Subcategory 레코드 1건을 담기위한 VO이다

public class Product {
	private int product_uid; 
	private String product_number;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String state;
	private String category_code;
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	private int price;
	private Date regday;
	
	public int getProduct_uid() {
		return product_uid;
	}
	public void setProduct_uid(int product_uid) {
		this.product_uid = product_uid;
	}
	public String getProduct_number() {
		return product_number;
	}
	public void setProduct_number(String product_number) {
		this.product_number = product_number;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getRegday() {
		return regday;
	}
	public void setRegday(Date regday) {
		this.regday = regday;
	}
}


//단어 첫 시작은 소문자 그다음단어시작은 대문자 (카멜방법)