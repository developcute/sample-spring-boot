package com.syntel.orion.io;

import java.util.List;

public class ListResponse<T> extends BaseResponse {

	private Long count;
	List<T> results;
	
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
}
