package com.example.repository;

import java.time.LocalDate;
import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.*;

@Repository
public interface MatchRepository  extends JpaRepository<MatchEntity, Long>{
   

    @Query("SELECT m FROM MatchEntity m WHERE m.dateMatch = :dateMatch")
    List<MatchEntity> findByDateMatch(@Param("dateMatch") LocalDate dateMatch);
 
    
    @Query("SELECT m.stade FROM MatchEntity m WHERE m.id = :id")
    StadeEntity findStadeByMatchId(@Param("id") Long id);
   
    List<MatchEntity> findByDateMatchBefore(LocalDate date);
  }
