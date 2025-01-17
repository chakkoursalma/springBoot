package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.*;
import com.example.repository.*;

@Service
public class StadeService {

	    private final StadeRepository stadeRepository;

	    public StadeService(StadeRepository stadeRepository) {
	        this.stadeRepository = stadeRepository;
	    }
        
	    public List<StadeEntity> getAll() {
	      
	            return stadeRepository.findAll();
	      
	    }

	    public StadeEntity addStade(StadeEntity stade) {
	        return stadeRepository.save(stade);
	    }
	    
	    public boolean deleteStadeById(Long id) {
	        if (stadeRepository.existsById(id)) { // Verify if ID exists
	            stadeRepository.deleteById(id); // Delete the stade
	            return true; // If deleted, return true
	        }
	        return false; // If not found, return false
	    }
	    
	    public boolean updateStadeById(Long id, StadeEntity updatedStade) {
	        if (stadeRepository.existsById(id)) {
	            StadeEntity existingStade = stadeRepository.findById(id).get(); // Fetch the existing stade
	            existingStade.setNomStade(updatedStade.getNomStade()); // Update the fields
	            existingStade.setCapacite(updatedStade.getCapacite()); // Update other fields
	            // Add more fields to update as necessary
	            stadeRepository.save(existingStade); // Save the updated stade
	            return true;
	        }
	        return false; // If the stade is not found, return false
	    }

	
}