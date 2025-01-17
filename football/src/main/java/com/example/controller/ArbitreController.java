package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.entity.*;
import com.example.service.*;

@RestController
@RequestMapping("/arbitre")
public class ArbitreController {

	private final ArbitreService arbitreService;
	
	public ArbitreController(ArbitreService arbitreService) {
        this.arbitreService = arbitreService;
    }
    	
	@GetMapping("/getAll")
	public List<ArbitreEntity> getAllArbitre() {
	    return arbitreService.getAll();
	}
	
	 @PostMapping("/add")
	    public ArbitreEntity addArbitre(@RequestBody ArbitreEntity arbitre) {
	        return arbitreService.addArbitre(arbitre);
	    }
	
	 @DeleteMapping("/delete/{id}")
	    public String deleteArbitre(@PathVariable Long id) {
	        boolean isDeleted = arbitreService.deleteArbitreById(id);
	        if (isDeleted) {
	            return "Arbitre with ID " + id + " has been deleted successfully.";
	        } else {
	            return "Arbitre with ID " + id + " not found.";
	        }
	    }
	 
	 @PutMapping("/update/{id}")
	 public String updateArbitre(@PathVariable Long id, @RequestBody ArbitreEntity arbitreEntity) {
	     boolean isUpdated = arbitreService.updateArbitreById(id, arbitreEntity);
	     if (isUpdated) {
	         return "Arbitre with ID " + id + " has been updated successfully.";
	     } else {
	         return "Arbitre with ID " + id + " not found.";
	     }
	 }
}
