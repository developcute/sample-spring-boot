package com.syntel.orion.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.syntel.orion.entity.CountriesList;
import com.syntel.orion.entity.Country;
import com.syntel.orion.entity.StateDetails;

@Repository
public interface CountryBaseInfoRepository extends CrudRepository<Country, String> {

	
	
	@Query("select  META(t).id AS _ID, META(t).cas AS _CAS, type from test t")
	List<Country> findcountry();
	
	

}
