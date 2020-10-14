package com.spring.nblFantasy.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Table(name = "draftsquad")
@Entity
public class DraftSquad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddraftsquad;
	private int idplayer1 ; 
	private int idplayer2 ;
	private int idplayer3 ;
	private int idplayer4 ;
	private int idplayer5 ;
	private int idplayer6 ;
	private int idplayer7 ;
	private int idplayer8 ;
	private int idplayer9 ;
	private int idplayer10 ;
	private int idplayer11;
	private int idplayer12;
	private int idplayer13 ;
	private int idplayer14 ;
	private int idplayer15 ;
	private int gameweek ;
	private int season ;
	
	@JsonIgnore
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "id_jugador", nullable = false)
		private Jugador jugadordraftsquad;
	 
	 
	 
	 
}
