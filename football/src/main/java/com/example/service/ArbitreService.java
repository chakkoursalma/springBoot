package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.*;
import com.example.repository.*;

@Service
public class ArbitreService {

	    private final ArbitreRepository arbitreRepository;

	    public ArbitreService(ArbitreRepository arbitreRepository) {
	        this.arbitreRepository = arbitreRepository;
	    }

	    public List<ArbitreEntity> getAll() {
	      
	       return arbitreRepository.findAll();
	    }	     
	  
	    public ArbitreEntity addArbitre(ArbitreEntity arbitre) {
	        return arbitreRepository.save(arbitre);
	    }
	    
	    
	    public boolean deleteArbitreById(Long id) {
	        if (arbitreRepository.existsById(id)) { // Verify if ID exists
	            arbitreRepository.deleteById(id); // Delete the arbitre
	            return true; // If deleted, return true
	        }
	        return false; // If not found, return false
	    }
	    
	    public boolean updateArbitreById(Long id, ArbitreEntity updatedArbitre) {
	        if (arbitreRepository.existsById(id)) {
	            ArbitreEntity existingArbitre = arbitreRepository.findById(id).get(); 
	            existingArbitre.setNom(updatedArbitre.getNom()); 
	            existingArbitre.setNationalite(updatedArbitre.getNationalite()); 
	            arbitreRepository.save(existingArbitre);
	            return true;
	        }
	        return false; 
	    }

}