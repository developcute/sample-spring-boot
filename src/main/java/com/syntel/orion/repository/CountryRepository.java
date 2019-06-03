package com.syntel.orion.repository;

import java.util.List;

import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.syntel.orion.entity.CountriesList;
import com.syntel.orion.entity.Country;
import com.syntel.orion.entity.StateDetails;

@Repository
public interface CountryRepository extends CrudRepository<CountriesList, String> {

	@Query("sElECT 'Hii' as cname, META(t).id AS _ID, META(t).cas AS _CAS, ARRAY {v.name,v.code} FOR v IN t.countryDetails END AS countryDetails FROM test AS t  WHERE t.type = 'countries'")
	List<CountriesList> findcountries();
	

}
