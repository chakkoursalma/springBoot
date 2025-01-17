package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.*;
import com.example.repository.*;

@Service
public class JoueuerService {
    @Autowired
    private EquipeRepository equipeRepository;
	    private final JoueuerRepository joueuerRepository;

	    public JoueuerService(JoueuerRepository joueurRepository) {
	        this.joueuerRepository = joueurRepository;
	    }

	    public List<JoueuerEntity> getAllPlayers() {
	        try {
	            return joueuerRepository.findAll();
	        } catch (Exception e) {
	            System.err.println("Error fetching players: " + e.getMessage());
	            throw new RuntimeException("Error fetching players", e);
	        }
	    }
	    public JoueuerEntity addJoueur(JoueuerEntity joueur) {
	        EquipeEntity equipe = joueur.getEquipe();

	        // If equipe is provided with a valid idEquipe (not null), fetch it from the database
	        if (equipe != null && equipe.getId() != null) {
	            // Check if equipe with the given id exists in the database
	            equipe = equipeRepository.findById(equipe.getId())
	                                     .orElseThrow(() -> new RuntimeException("Équipe introuvable"));
	        } else {
	            // If equipe doesn't have an id, it means it's a transient instance and needs to be saved
	            equipe = equipeRepository.save(equipe);  // Save the equipe first
	        }

	        // Set the equipe to the joueur entity
	        joueur.setEquipe(equipe);

	        // Save and return the joueur entity
	        return joueuerRepository.save(joueur);
	    }

 
	    public boolean deleteJoueurById(Long id) {
	        if (joueuerRepository.existsById(id)) {
	        	joueuerRepository.deleteById(id); 
	            return true;
	        }
	        return false; 
	    }
	    
	    public boolean updateJoueuerById(Long id, JoueuerEntity joueuerEntity) {
	        if (joueuerRepository.existsById(id)) {
	        	JoueuerEntity existingJoueuer = joueuerRepository.findById(id).get(); 
	        	existingJoueuer.setNom(joueuerEntity.getNom()); 
	        	existingJoueuer.setPoste(joueuerEntity.getPoste()); 
	        	joueuerRepository.save(existingJoueuer);
	            return true;
	        }
	        return false;
	    }
	    
	    public List<JoueuerEntity> getJoueursByEquipe(String nomEquipe ,String poste) {
	        return joueuerRepository.findByPosteAndEquipeNomEquipe(nomEquipe, poste);
	    }
        
	    public List<JoueuerEntity> getAttaquantsByEquipe(String nomEquipe) {
	        return joueuerRepository.findAttaquantsByEquipe(nomEquipe);
	    }

	
}