package com.minssam.cafepos.model.domain;

// 이 객체는 로직을 작성하기위한 용도가 아니라, Topcategory 테이블의 레코드를 담기위한,
// 데이터를 담기위한 객체이다. 이러한 용도의 객체를 가리켜 설계분야에서는 VO(Value Object)라 한다
// js 의 JSON의 역할과 비슷하다
public class Topcategory {
	private int topcategory_id;
	private String top_name;
	
	public int getTopcategory_id() {
		return topcategory_id;
	}
	public void setTopcategory_id(int topcategory_id) {
		this.topcategory_id = topcategory_id;
	}
	public String getTop_name() {
		return top_name;
	}
	public void setTop_name(String top_name) {
		this.top_name = top_name;
	}
	
	
}
