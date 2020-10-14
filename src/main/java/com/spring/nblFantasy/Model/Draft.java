package com.spring.nblFantasy.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * Tabla que representa la tabla Draft
 * @author Owner
 *
 */

@Entity
@Data
@Table (name ="draft")
public class Draft {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iddraft")
	private int iddraft;
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
	private int season ;
	private int benchpoints ;
	private int benchgoals ; 
	private int benchassists ;
	private int benchcleansheets ;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jugador", nullable = false)
	private Jugador jugadordraft;
	
	

	
	public Draft() {
	super();
} 
	

	
}
