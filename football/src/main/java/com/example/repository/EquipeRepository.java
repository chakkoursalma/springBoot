package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.EquipeEntity;

@Repository
public interface EquipeRepository  extends JpaRepository<EquipeEntity, Long>{
	
	@Query("SELECT e FROM EquipeEntity e WHERE e.pays = :pays")
    List<EquipeEntity> findByPays(@Param("pays") String pays);

}
