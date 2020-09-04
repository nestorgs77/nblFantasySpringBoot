/**
 * 
 */
package com.spring.nblFantasy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.nblFantasy.Model.Classic;
import com.spring.nblFantasy.Model.Jugador;

/**
 * @author Owner
 *
 */
public interface JugadorRepository extends JpaRepository<Jugador, Integer>{

	@Query("Select c from Jugador c where c.idfpl =: idfpl")
	public Jugador findJugadorbyIdFpl (@Param("idfpl") int idfpl);
	
	
	}
	

