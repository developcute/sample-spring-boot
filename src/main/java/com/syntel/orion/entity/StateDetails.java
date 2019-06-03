package com.syntel.orion.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StateDetails {

    @NotNull
    @Field
    private String countryName;

    @NotNull
    @Field
    private String name;

    @NotNull
    @Field
    private String id;

	public String getCountryName() {
		return countryName;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}


}
