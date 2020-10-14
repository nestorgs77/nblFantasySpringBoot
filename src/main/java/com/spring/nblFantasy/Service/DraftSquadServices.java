package com.spring.nblFantasy.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.AccessOptions.SetOptions.Propagation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;

import com.spring.nblFantasy.Model.DraftSquad;
import com.spring.nblFantasy.Repository.DraftSquadRepository;

@Service
@Transactional (readOnly = true )
public class DraftSquadServices {
	
	@Autowired
	public final DraftSquadRepository draftsquadRepo;

	
	
	
	
	public DraftSquadServices( DraftSquadRepository draftsquadRepo) {
	
		super();
		this.draftsquadRepo = draftsquadRepo;
	}
@Transactional
	public DraftSquad createDraftSquad(DraftSquad draftsquad) {

	   try {
		   return draftsquadRepo.save(draftsquad);
	} catch (Exception e) {
	       e.getMessage();
	}
	return null;
		
	}
@Transactional
	public DraftSquad updateDraftSquad(DraftSquad draftsquad) {

		return draftsquadRepo.save(draftsquad);
	}
@Transactional
	public void removeDraftSquad(DraftSquad draftsquad) {

		draftsquadRepo.delete(draftsquad);
		;
	}
  
@Transactional
	public List<DraftSquad> listAllDraftSquad() {

		return draftsquadRepo.findAll();
		
	}

@Transactional(propagation = org.springframework.transaction.annotation.Propagation.NESTED)
public List <DraftSquad> findAllByIdDraft (int id){
	System.out.println(draftsquadRepo.findAllByIdDraft(id));	
	return this.draftsquadRepo.findAllByIdDraft(id);

}


}
