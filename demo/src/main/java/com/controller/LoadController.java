package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.model.LoadModel;
import com.repo.LoadsRepo;

@RestController
public class LoadController {
	@Autowired
	public LoadsRepo lp;
	

	public String addItems(LoadModel lm) {
		
		if(lp.save(lm) != null) {
			return "loads details added successfully ";
		}
		return "Error While Adding";
		
	}
	
	  public String UpdateDetails(Integer loadId, LoadModel lm) { LoadModel
	  ldetails=lp.findById(loadId).orElse(null); 
	  ldetails.setDates(lm.getDates());
	  ldetails.setLoadingPoint(lm.getLoadingPoint());
	  ldetails.setNoOfTrucks(lm.getNoOfTrucks());
	  ldetails.setcOmment(lm.getcOmment());
	  ldetails.setProductType(lm.getProductType());
	 // ldetails.setLoadId(lm.getLoadId());
	  ldetails.setShipperId(lm.getShipperId());
	  ldetails.setTruckType(lm.getTruckType());
	  ldetails.setUnloadingPoint(lm.getUnloadingPoint());
	  ldetails.setWeight(lm.getWeight()); if(lp.save(ldetails) != null) { return
	  "Success"; } return "Error";
	  
	  }
	 

	public String DeleteLoad(Integer loadId) {
		if(lp.existsById(loadId)) {
			if(lp.findById(loadId) != null) {
				lp.deleteById(loadId);
				return "Records Are Deleted";
			}
			return "Records Not Found";
		}
		
		return "Records Not Found";
	}

	public List<LoadModel> getList() {
		
		return lp.findAll();
	}

	public Optional<LoadModel> loadById(Integer loadId ) {
		
		return lp.findById(loadId);
	}
	
	
}
