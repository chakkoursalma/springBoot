package com.example.service; 

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.*;
import com.example.repository.*;

@Service
public class MatchService {
	
    private final MatchRepository matchRepository;


    @Autowired
    public MatchService(MatchRepository matchRepository, ArbitreRepository arbitreRepository, 
                        EquipeRepository equipeRepository, StadeRepository stadeRepository) {
        this.matchRepository = matchRepository;
       
    }

	
	    public List<MatchEntity> getAll() {
	      
	       return matchRepository.findAll();
	    }	  
	    
	    public MatchEntity createMatch(MatchEntity match) {
	
	      
	        return matchRepository.save(match);
	    }
	    
	    public boolean deleteMatchById(Long id) {
	        if (matchRepository.existsById(id)) {
	        	matchRepository.deleteById(id); 
	            return true;
	        }
	        return false; 
	    }
	    
	    public boolean updateMatchById(Long id, MatchEntity updatedMatch) {
	    	
	        if (matchRepository.existsById(id)) {
	        	
	            MatchEntity existingMatch = matchRepository.findById(id).get(); 
	            existingMatch.setLieu(updatedMatch.getLieu()); 
	            existingMatch.setDateMatch(updatedMatch.getDateMatch()); 
	            existingMatch.setHeureMatch(updatedMatch.getHeureMatch()); 
	            existingMatch.setLieu(updatedMatch.getLieu());   
	            matchRepository.save(existingMatch); 
	            
	            return true;
	        }
	        
	        return false; 
	    }
	    
	    public List<MatchEntity> getMatchesByDate(LocalDate dateMatch) {
	        return matchRepository.findByDateMatch(dateMatch);
	    }
	    
	    public StadeEntity getStadeByMatchId(Long id) {
	        return matchRepository.findStadeByMatchId(id);
	    }
	    
	    public MatchEntity getMatchById(Long id) {
	        return matchRepository.findById(id).orElse(null); // Returns the match or null if not found
	    }
 
	    public int deletePastMatches() {
	        LocalDate today = LocalDate.now();
	        List<MatchEntity> pastMatches = matchRepository.findByDateMatchBefore(today);
	        int count = pastMatches.size();
	        matchRepository.deleteAll(pastMatches);
	        return count;
	    }
	    
}