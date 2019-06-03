package com.syntel.orion.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.syntel.orion.entity.CountriesList;
import com.syntel.orion.entity.Country;
import com.syntel.orion.entity.StateDetails;

@Repository
public interface StateDetailsRepository extends CrudRepository<StateDetails, String> {

	/*
	@Query("SELECT META().id AS _ID, META().cas AS _CAS, cd.name AS countryName, sd.name, sd.id FROM test AS t UNNEST t.countryDetails AS cd UNNEST cd.stateInfo AS sd WHERE t.type = 'countries' order by cd.name, sd.name")
	List<StateDetails> findstatedetails();
	*/
	
	@Query("SELECT META(t).id AS _ID, META(t).cas AS _CAS, cd.name AS countryName, sd.name, sd.id FROM test AS t UNNEST t.countryDetails AS cd UNNEST cd.stateInfo AS sd WHERE t.type = 'countries' order by cd.name, sd.name")
	List<StateDetails> findstatedetails();
	
	//#{#n1ql.selectEntity}

}
