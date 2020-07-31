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
	private int numJornada ;
	private int golesJornada;
	private int assistJornada;
	private int redCardJornada;
	private int csheetJornada;
	private int ptosJornada;
	private int bpsJornada;
	private int ptosenBanco;
	private int ptosBBoost;
	private int ptosWCard;
	private int ptosCapitan;
	private int ptosViceCapitan;
    private int ranking;
    private int formacion;
    private String codigoLiga; 
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jugador", nullable = false)
	private Jugador jugadorclassic;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_liga", nullable = false)
	private Ligas ligas;
	
	public Classic() {
		super();
	}
}
