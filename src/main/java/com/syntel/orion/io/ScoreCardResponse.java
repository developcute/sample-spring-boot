package com.syntel.orion.io;

public class ScoreCardResponse {
	
	
	 private String product;
	 private String total;
	 private String success;
	 private String failure;
	 private String availability;
	 
	public String getProduct() {
		return product;
	}
	public String getTotal() {
		return total;
	}
	public String getSuccess() {
		return success;
	}
	public String getFailure() {
		return failure;
	}
	public String getAvailability() {
		return availability;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public void setFailure(String failure) {
		this.failure = failure;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}

}
