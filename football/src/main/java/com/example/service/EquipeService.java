package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.*;
import com.example.repository.*;

@Service
public class EquipeService {


       private final EquipeRepository equipeRepository;
   
       public EquipeService(EquipeRepository equipeRepository, MatchRepository matchRepository) {
           this.equipeRepository = equipeRepository;
         
    }
    
        
	    public List<EquipeEntity> getAll() {
	      
	            return equipeRepository.findAll();
	      
	    }

	    public EquipeEntity addEquipe(EquipeEntity equipe) {
	      
	        return equipeRepository.save(equipe); 
	    }
	
	    public boolean deleteEquipeById(Long id) {
	        if (equipeRepository.existsById(id)) { // Verify if ID exists
	            equipeRepository.deleteById(id); // Delete the equipe
	            return true; // If deleted, return true
	        }
	        return false; // If not found, return false
	    }
	    
	    
	    public boolean updateEquipeById(Long id, EquipeEntity equipeEntity) {
	        if (equipeRepository.existsById(id)) {
	        	EquipeEntity existingEquipe = equipeRepository.findById(id).get(); 
	        	existingEquipe.setNomEquipe(equipeEntity.getNomEquipe()); 
	        	existingEquipe.setPays(equipeEntity.getPays()); 
	        	equipeRepository.save(existingEquipe);
	            return true;
	        }
	        return false;
	    }
	    
	    public List<EquipeEntity> getEquipesByPays(String pays) {
	        return equipeRepository.findByPays(pays);
	    }

}