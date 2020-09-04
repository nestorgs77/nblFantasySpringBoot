/**
 * 
 */
package com.spring.nblFantasy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.nblFantasy.Model.Classic;

/**
 * @author Owner
 *
 */
public interface ClassicRepository extends JpaRepository<Classic, Integer> {

	
	@Query("Select c from Classic c where c.idclassic= :identification")
	public Classic findIdClassic (@Param("identification") int identification);
	
}
