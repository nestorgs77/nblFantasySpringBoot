package com.spring.nblFantasy.views.resources.vo.consumingRestFPL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassicRestApiStats {

	private int goals_scored ;
	private int assists ;
	private int clean_sheets;
	private int goal_conceded ;
	private int own_goals ;
	private int penalties_saved;
	private int penalties_missed;
	private int yellow_cards ;
	private int red_cards ; 
	private int saves ;
	private int bonus ;
	private int bps ;
	private float influence;
	private float creativity;
	private float threat ;
	private float ict_index;
	private int total_points;
	private boolean in_dreamteam;
	
	
	
	public ClassicRestApiStats() {
		super();
	}
	
	
}
