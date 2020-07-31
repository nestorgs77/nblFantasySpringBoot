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
	private int golesJornada; 
	private int assistJornada ;
	private int redCardJornada ;
	private int csheetJornada ;
	private int bpsJornada ;
	private int ptosenBanco;
	private int waivers ;
	private int ranking;
	private int trades ; 


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_jugador", nullable = false)
	private Jugador jugadordraft;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ligas", nullable = false)
	private Ligas ligas;

	
	public Draft() {
	super();
} 
	

	
}
