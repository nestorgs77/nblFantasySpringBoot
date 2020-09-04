package com.spring.nblFantasy.views.resources.vo.consumingRestFPL;

import lombok.Data;

@Data
public class PlayerPickVO {

	private int id ; 
	private int regular ;
	private boolean is_capt;
	private boolean is_vicecapt ;
	public PlayerPickVO() {
		super();
	}
	
}
