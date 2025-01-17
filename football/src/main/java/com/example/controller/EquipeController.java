package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.entity.*;
import com.example.service.*;




@RestController
@RequestMapping("/equipe")
public class EquipeController {

	private final EquipeService equipeService;
	
	public EquipeController(EquipeService equipeService) {
        this.equipeService = equipeService;
    }
    	
	@GetMapping("/getAll")
	public List<EquipeEntity> getAllPlayers() {
	    return equipeService.getAll();
	}
	
	 @PostMapping("/add")
	 public EquipeEntity addEquipe(@RequestBody EquipeEntity equipe) {
	     return equipeService.addEquipe(equipe);
	 }
	 
	 @DeleteMapping("/delete/{id}")
	    public String deleteEquipe(@PathVariable Long id) {
	        boolean isDeleted = equipeService.deleteEquipeById(id);
	        if (isDeleted) {
	            return "Equipe with ID " + id + " has been deleted successfully.";
	        } else {
	            return "Equipe with ID " + id + " not found.";
	        }
	    }
	 
	 @PutMapping("/update/{id}")
	 public String updateEquipe(@PathVariable Long id, @RequestBody EquipeEntity equipeEntity) {
	     boolean isUpdated = equipeService.updateEquipeById(id, equipeEntity);
	     if (isUpdated) {
	         return "Team with ID " + id + " has been updated successfully.";
	     } else {
	         return "Team with ID " + id + " not found.";
	     }
	 }
	 
	 @GetMapping("/getByPays/{pays}")
	 public List<EquipeEntity> getEquipesByPays(@PathVariable String pays) {
	     return equipeService.getEquipesByPays(pays);
	 }


}
