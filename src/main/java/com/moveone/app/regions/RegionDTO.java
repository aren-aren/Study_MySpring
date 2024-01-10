package com.moveone.app.regions;

public class RegionDTO {
	//1. 모든 멤버 변수의 접근 지정자는 private
	//2. 모든 멤버 변수의 getter, setter를 생성
	//3. 생성자는 여러개 가능 하지만 기본 생성자는 필수
	//4. 멤버변수의 이름과 Datatype은 DB Table의 column명과 Datatype과 일치
	
	private Long region_id;
	private String region_name;
	
	public Long getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Long region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
}
