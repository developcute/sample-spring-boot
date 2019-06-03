package com.syntel.orion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.syntel.orion.entity.CountriesList;
import com.syntel.orion.entity.Country;
import com.syntel.orion.entity.StateDetails;
import com.syntel.orion.service.CBJsonService;

@RestController
public class CBJsonController {

	private CBJsonService cBJsonService;

	@Autowired
	public CBJsonController(CBJsonService cBJsonService) {
		this.cBJsonService = cBJsonService;
	}

	@RequestMapping(value = "/findcountries", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<CountriesList> findcountries() {
		System.out.println("Find all findcountries");
		return cBJsonService.findcountries();
	}
	
	
	@RequestMapping(value = "/findcountry", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Country> findcountry() {
		System.out.println("Find all findcountry");
		
		
		List<Country> list =  cBJsonService.findcountry();
		
//		for(Country l : list) {
//			System.out.println("get countries list -->" + l.getType());
//		}
		List<Country> c = new ArrayList<>();
		
		
		
		
		return cBJsonService.findcountry();
	}
	
	
	@RequestMapping(value = "/findstatedetails", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<StateDetails> findstatedetails() {
		System.out.println("Find all findstatedetails");
		return cBJsonService.findstatedetails();
	}

}
