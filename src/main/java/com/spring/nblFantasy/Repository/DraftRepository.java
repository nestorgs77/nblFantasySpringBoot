/**
 * 
 */
package com.spring.nblFantasy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.nblFantasy.Model.Classic;
import com.spring.nblFantasy.Model.Draft;


/**
 * @author Owner
 *
 */

public interface DraftRepository extends JpaRepository<Draft, Integer>{

	@Query("Select d from Draft d where d.iddraft=  :idligadraft")
	public List<Draft> findIdDraft (@Param("idligadraft") int idligadraft);

	


}
