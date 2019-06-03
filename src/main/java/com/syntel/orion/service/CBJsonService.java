package com.syntel.orion.service;

import java.util.List;

import com.syntel.orion.entity.CountriesList;
import com.syntel.orion.entity.Country;
import com.syntel.orion.entity.StateDetails;

public interface CBJsonService {

	List<CountriesList> findcountries();

	List<Country> findcountry();
	
	List<StateDetails> findstatedetails();

}
