package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.LoadModel;

@RestController
public class LoadOperations {
	@Autowired
	public LoadController lc;
		@PostMapping("/load")
		public String AddLoadItems(@RequestBody LoadModel lm) {
			return  lc.addItems(lm);
			
			
		}

	
	  @PutMapping("/load/{loadId}") public String EditDetails(@PathVariable Integer loadId,@RequestBody LoadModel lm) {
	  
	  return lc.UpdateDetails(loadId,lm);
	  
	  }
	 
	@DeleteMapping("/load/{loadId}")
		public String DeleteDetalis(@PathVariable Integer loadId) {
		
			return lc.DeleteLoad(loadId);
			
		}
	@GetMapping("/load")
	public List<LoadModel> load(){
		return lc.getList();
		
	}
	@GetMapping("/load/{loadId}")
public Optional<LoadModel> loadById(@PathVariable Integer loadId){
		return lc.loadById(loadId);
		
		}

}
