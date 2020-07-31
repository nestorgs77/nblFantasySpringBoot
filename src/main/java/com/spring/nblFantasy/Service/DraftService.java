/**
 * 
 */
package com.spring.nblFantasy.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.nblFantasy.Model.Draft;
import com.spring.nblFantasy.Repository.DraftRepository;

/**
 * @author Owner
 * This is the the class DraftService where we going to develop the main functionalities
 */
@Service
@Transactional
public class DraftService {

	public final DraftRepository draftrepository ;

	public DraftService(DraftRepository draftrepository) {
		super();
		this.draftrepository = draftrepository;
	} 
	
	public Draft create (Draft draft) {
		
		return this.draftrepository.save(draft);
	}
	
public Draft update (Draft draft) {
		
		return this.draftrepository.save(draft);
	}
public void delete (Draft draft) {
	
 this.draftrepository.delete(draft);;
}
}
