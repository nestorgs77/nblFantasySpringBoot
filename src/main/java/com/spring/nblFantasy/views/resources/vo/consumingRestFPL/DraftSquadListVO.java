package com.spring.nblFantasy.views.resources.vo.consumingRestFPL;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class DraftSquadListVO {
@Min(value = 1, message = "Select any players!!")
private String player1 ;
private String player2 ;
private String player3 ;
private String player4 ;
private String player5 ;
private String player6 ;
private String player7 ;
private String player8 ;
private String player9 ;
private String player10 ;
private String player11;
private String player12 ;
private String player13 ;
private String player14 ;
private String player15 ;
private int idFPL;
private int gw ;
public DraftSquadListVO() {
	super();
}
	
	
}
