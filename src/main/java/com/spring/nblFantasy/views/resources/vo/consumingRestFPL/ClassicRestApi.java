package com.spring.nblFantasy.views.resources.vo.consumingRestFPL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassicRestApi {

	
	private int id ; 
	private ClassicRestApiStats stats ;
	
	public ClassicRestApi() {
		super();
	} 
	
	
}
