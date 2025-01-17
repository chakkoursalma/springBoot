package com.example.controller;

import java.time.LocalDate;
import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.example.entity.*;
import com.example.service.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/match")
public class MatchController {

	private final MatchService matchService;
	
	public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    	
	@GetMapping("/getAll")
	public List<MatchEntity> getAllMatch() {
	    return matchService.getAll();
	}
	
	@PostMapping("/add")
	public MatchEntity createMatch(@RequestBody MatchEntity match) {
	    System.out.println("Received Match: " + match);
	    return matchService.createMatch(match);
	}
	
	 @DeleteMapping("/delete/{id}")
	    public String deleteMatch(@PathVariable Long id) {
	        boolean isDeleted = matchService.deleteMatchById(id);
	        if (isDeleted) {
	            return "Match with ID " + id + " has been deleted successfully.";
	        } else {
	            return "Match with ID " + id + " not found.";
	        }
	    }
	 @PutMapping("/update/{id}")
	 public String updateStade(@PathVariable Long id, @RequestBody MatchEntity matchEntity) {
	     boolean isUpdated = matchService.updateMatchById(id, matchEntity);
	     if (isUpdated) {
	         return "Match with ID " + id + " has been updated successfully.";
	     } else {
	         return "Match with ID " + id + " not found.";
	     }
	 }
	 
	 @GetMapping("/getByDate/{date}")
	 public List<MatchEntity> getMatchesByDate(@PathVariable String date) {
	     LocalDate parsedDate = LocalDate.parse(date); 
	     return matchService.getMatchesByDate(parsedDate);
	 }

	 
	  @GetMapping("/getStadeOfMatch/{id}")
	    public StadeEntity getStadeByMatchId(@PathVariable Long id) {
	        return matchService.getStadeByMatchId(id);
	    }
       
	  @GetMapping("/getEquipesOfMatch/{id}")
	  public String getEquipesOfMatch(@PathVariable Long id) {
	      MatchEntity match = matchService.getMatchById(id);  // Ensure you use the correct service method here.
	      if (match != null) {
	          String equipeOneName = (match.getEquipeOne() != null) ? match.getEquipeOne().getNomEquipe() : "Equipe One not assigned";
	          String equipeTwoName = (match.getEquipeTwo() != null) ? match.getEquipeTwo().getNomEquipe() : "Equipe Two not assigned";
	          
	          return "Equipe One: " + equipeOneName + ", Equipe Two: " + equipeTwoName;
	      } else {
	          return "Match with ID " + id + " not found.";
	      }
	  }
	
	  @DeleteMapping("/deletePastMatches")
	  public String deletePastMatches() {
	      int deletedCount = matchService.deletePastMatches();
	      return deletedCount + " past matches have been deleted.";
	  }


}
