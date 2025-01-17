package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.entity.*;
import com.example.service.*;

@RestController
@RequestMapping("/stade")
public class StadeController {

	private final StadeService stadeService;
	
	public StadeController(StadeService stadeService) {
        this.stadeService = stadeService;
    }
    	
	@GetMapping("/getAll")
	  public List<StadeEntity> getAllStade() {
	    return stadeService.getAll();
	}
	
	@PostMapping("/add")
	   public StadeEntity addStade(@RequestBody StadeEntity stadeEntity) {
	      return stadeService.addStade(stadeEntity);
	}
	
	 @DeleteMapping("/delete/{id}")
	    public String deleteStade(@PathVariable Long id) {
	        boolean isDeleted = stadeService.deleteStadeById(id);
	        if (isDeleted) {
	            return "Stade with ID " + id + " has been deleted successfully.";
	        } else {
	            return "Stade with ID " + id + " not found.";
	        }
	    }
	 
	 @PutMapping("/update/{id}")
	 public String updateStade(@PathVariable Long id, @RequestBody StadeEntity stadeEntity) {
	     boolean isUpdated = stadeService.updateStadeById(id, stadeEntity);
	     if (isUpdated) {
	         return "Stade with ID " + id + " has been updated successfully.";
	     } else {
	         return "Stade with ID " + id + " not found.";
	     }
	 }

}
