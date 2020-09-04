package com.spring.nblFantasy.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.nblFantasy.Model.Jugador;
import com.spring.nblFantasy.Repository.ClassicRepository;
import com.spring.nblFantasy.Repository.JugadorRepository;

import lombok.Data;
@Service
@Data
@Transactional (readOnly = true)
public class JugadorService {
    @Autowired
	private final JugadorRepository jugadorRepo ;

	public JugadorService(JugadorRepository jugadorRepo) {
		super();
		this.jugadorRepo = jugadorRepo;
	}
	@Transactional
	public Jugador jugadorByIdFpl (int idfpl) {
		
	return	this.jugadorRepo.findJugadorbyIdFpl(idfpl);
		
	}
	@Transactional
	public int saveJugador (Jugador jugador) {
		Jugador j = new Jugador();
		int count = 0 ; 
		j= this.jugadorRepo.save(jugador);
		if (j==null) {
			return count ; 
			
		}
	 	return 1 ; 
		
	}
	@Transactional
   public void deleteJugador (int id) {
		
		this.jugadorRepo.deleteById(id);
		
	}
	
	
	
	
	
	
}
