package com.syntel.orion.io;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "status", "errorCode", "errorMessage", "count", "pageCount", "results" })
public class PageResponse<T> extends ListResponse<T> {

	private Long pageCount;

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}
}
