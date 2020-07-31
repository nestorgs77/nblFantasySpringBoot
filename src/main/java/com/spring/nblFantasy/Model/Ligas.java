/**
 * 
 */
package com.spring.nblFantasy.Model;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Owner
 *
 */
@Entity
@Data
@Table(name ="ligas")

public class Ligas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idligas; 
	private String idLigaFpl;
	private String temporada;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ligas")
    private List<Classic> listaLigaClassic;
	
	public Ligas() {
		super();
	}
}