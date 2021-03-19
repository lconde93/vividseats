package com.mx.vividseats.dto;

import java.util.List;

public class Member {
	private String id;
	private List<String> knowns;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getKnowns() {
		return knowns;
	}
	public void setKnowns(List<String> knowns) {
		this.knowns = knowns;
	}
	
	public Member(String id, List<String> knowns) {
		this.id = id;
		this.knowns = knowns;
		
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", knowns=" + 
				knowns + "]";
	}
}
