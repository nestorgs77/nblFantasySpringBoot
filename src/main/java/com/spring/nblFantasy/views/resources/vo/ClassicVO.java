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
import com.spring.nblFantasy.Model.Ligas;

import lombok.Data;

/**
 * @author Owner
 *
 */
@Data
public class ClassicVO  {

	
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
    private String codigoLiga; 
    
	
	
	public ClassicVO() {
		super();
	}
}
