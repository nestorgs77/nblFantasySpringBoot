/**
 * 
 */
package com.spring.nblFantasy.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.nblFantasy.Model.Classic;
import com.spring.nblFantasy.Repository.ClassicRepository;

/**
 * @author Owner
 *
 */
@Service
@Transactional (readOnly = true)
public class ClassicService {
 
	private final ClassicRepository classicRepo ;

	public ClassicService(ClassicRepository classicRepo) {
		super();
		this.classicRepo = classicRepo;
	} 
	// Method to create a Classic
	@Transactional
	public Classic create (Classic classic) {
		
		return this.classicRepo.save(classic) ;
		
	}
	// Method to update a Classic
	@Transactional
public Classic update (Classic classic) {
		
		return this.classicRepo.save(classic) ;
		
	}
// Method to delete a Classic
	@Transactional
public void delete (Classic classic) {
	
	this.classicRepo.delete(classic);
	
}
// Method to find a Classic Day by Id 
	
public Classic findIdClassic(int idligaclassic) {
	return this.classicRepo.findIdClassic(idligaclassic);
	
}
public void deleteIdClassic(Classic classic) {
	 this.classicRepo.delete(classic);;
	
}
public List<Classic> findAllClassic() {
	return this.classicRepo.findAll();
	
}

}
