/**
 * 
 */
package com.spring.nblFantasy.Model;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * @author Owner
 *
 */
@Data

@Table(name = "classic")
@Entity
public class Classic  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jugador", nullable = false)
	private Jugador jugadorclassic;
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_liga", nullable = false)
	private Ligas ligas;
	
	public Classic() {
		super();
	}
}
