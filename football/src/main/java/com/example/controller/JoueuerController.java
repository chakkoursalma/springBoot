package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.entity.*;
import com.example.service.JoueuerService;




@RestController
@RequestMapping("/joueur")
public class JoueuerController {

	private final JoueuerService joueuerService;
	
	public JoueuerController(JoueuerService joueuerService) {
        this.joueuerService = joueuerService;
    }
	
	@GetMapping("/getAll")
	public List<JoueuerEntity> getAllPlayers() {
	    return joueuerService.getAllPlayers();
	}
	
	 @PostMapping("/add")
	    public JoueuerEntity addJoueur(@RequestBody JoueuerEntity joueuer) {
	       return joueuerService.addJoueur(joueuer);
	    }
	 @DeleteMapping("/delete/{id}")
	    public String deleteEquipe(@PathVariable Long id) {
	        boolean isDeleted = joueuerService.deleteJoueurById(id);
	        if (isDeleted) {
	            return "Joueur with ID " + id + " has been deleted successfully.";
	        } else {
	            return "Joueur with ID " + id + " not found.";
	        }
	    }
	 
	 @PutMapping("/update/{id}")
	 public String updateJoueur(@PathVariable Long id, @RequestBody JoueuerEntity joueuerEntity) {
	     boolean isUpdated = joueuerService.updateJoueuerById(id, joueuerEntity);
	     if (isUpdated) {
	         return "Player with ID " + id + " has been updated successfully.";
	     } else {
	         return "Player with ID " + id + " not found.";
	     }
	 }
	 
	   @GetMapping("/getJoueurOfEquipe/{nomEquipe}")
	    public List<JoueuerEntity> getJoueursByEquipe(@PathVariable String nomEquipe) {
	        return joueuerService.getAttaquantsByEquipe(nomEquipe);
	    }
	   
	   
	   @GetMapping("/Attacker/{nomEquipe}")
	    public List<JoueuerEntity> getAttaquants(@PathVariable String nomEquipe) {
	        return joueuerService.getAttaquantsByEquipe(nomEquipe);
	    }

}
