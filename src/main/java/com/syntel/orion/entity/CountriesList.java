package com.syntel.orion.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CountriesList {
	
	@NotNull
    @Field
    private String cname;
	
	
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Field
	private List<CountryDetail> countryDetails;


	public List<CountryDetail> getCountryDetails() {
		return countryDetails;
	}

	public void setCountryDetails(List<CountryDetail> countryDetails) {
		this.countryDetails = countryDetails;
	}
	
	


}
