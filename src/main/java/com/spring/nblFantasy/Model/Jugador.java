/**
 * 
 */
package com.spring.nblFantasy.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Owner
 *
 */
@Entity
@Data
@Table(name = "jugador")

public class Jugador  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idjugador;
	private String nombre ; 
	private String apellidos ;
	private String apodo ; 
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="jugadorclassic")
    private List<Classic> listaLigaClassic;
	   

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="jugadordraft")
    private List<Draft> listaLigaDraft;
	
	
	
	public Jugador() {
		super();
	}

	
	
	
}
