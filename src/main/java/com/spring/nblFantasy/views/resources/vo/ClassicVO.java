/**
 * 
 */
package com.spring.nblFantasy.views.resources.vo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.spring.nblFantasy.Model.Jugador;


import lombok.Data;

/**
 * @author Owner
 *
 */
@Data
public class ClassicVO  {

	private int idclassic;
	private int idplayer ;
	private int gameweek;
    private int minutes ;
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
    
	
	
	public ClassicVO() {
		super();
	}
}
