package com.spring.nblFantasy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.spring.nblFantasy.Model.DraftSquad;

public interface DraftSquadRepository extends JpaRepository<DraftSquad, Integer> {

	@Query("Select d from DraftSquad d where d.jugadordraftsquad = :idjugador")
	public List<DraftSquad> findAllByIdDraft (@Param("idjugador") int idjugador);
	
	@Query("Select d from DraftSquad d where d.jugadordraftsquad = :idjugador and d.gameweek = :gameweek")
	public List<DraftSquad> findByIdAndGameWeek (@Param("idjugador") int idjugador  , @Param("gameweek") int gameweek);
	
	
	
	
}
