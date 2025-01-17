package com.example.repository;

import java.util.List;

import com.example.entity.JoueuerEntity;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueuerRepository  extends JpaRepository<JoueuerEntity, Long>{
	
	 List<JoueuerEntity> findByPosteAndEquipeNomEquipe(String poste, String nomEquipe);
	 
	 @Query("SELECT j FROM JoueuerEntity j WHERE j.poste = 'Attacker' AND j.equipe.nomEquipe = :nomEquipe")
	 List<JoueuerEntity> findAttaquantsByEquipe(@Param("nomEquipe") String nomEquipe);
	
	

}
