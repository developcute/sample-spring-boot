package com.syntel.orion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.orion.entity.CountriesList;
import com.syntel.orion.entity.Country;
import com.syntel.orion.entity.StateDetails;
import com.syntel.orion.repository.CountryBaseInfoRepository;
import com.syntel.orion.repository.CountryRepository;
import com.syntel.orion.repository.StateDetailsRepository;
import com.syntel.orion.service.CBJsonService;

@Service
public class CBJsonServiceImpl implements CBJsonService {

	private CountryRepository countryRepository;
	private StateDetailsRepository stateDetailsRepository;
	private CountryBaseInfoRepository countryBaseInfoRepository;

	@Autowired
	public CBJsonServiceImpl(CountryRepository countryRepository,
			StateDetailsRepository stateDetailsRepository,
			CountryBaseInfoRepository countryBaseInfoRepository) {
		this.countryRepository = countryRepository;
		this.stateDetailsRepository = stateDetailsRepository;
		this.countryBaseInfoRepository = countryBaseInfoRepository;
	}

	public List<CountriesList> findcountries() {
		System.out.println("Find all findcountries in service implementation");
		return countryRepository.findcountries();
	}

	public List<Country> findcountry() {
		System.out.println("findcountry--->");
		return countryBaseInfoRepository.findcountry();
	}

	
	public List<StateDetails> findstatedetails() {
		return stateDetailsRepository.findstatedetails();
	}

}
