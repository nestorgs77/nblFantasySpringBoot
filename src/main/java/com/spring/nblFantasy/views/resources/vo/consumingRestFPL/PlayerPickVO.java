package com.spring.nblFantasy.views.resources.vo.consumingRestFPL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerPickVO {

public PlayerPickVO() {
		
	}
	private int id ; 
	private int regular ;
	private boolean is_capt;
	private boolean is_vicecapt ;
	
	
	
	
}
