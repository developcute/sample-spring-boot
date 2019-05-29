package com.axonytes.corporate.io;

import java.util.List;

public class UserUniqueVitalRecordResponse extends BaseResponse {
	
	private Long totalUniqueVitalRecords;
	List<UserUniqueVitalRecordDetail> userUniqueVitalRecordDetail;
	
	public Long getTotalUniqueVitalRecords() {
		return totalUniqueVitalRecords;
	}
	public void setTotalUniqueVitalRecords(Long totalUniqueVitalRecords) {
		this.totalUniqueVitalRecords = totalUniqueVitalRecords;
	}
	public List<UserUniqueVitalRecordDetail> getUserUniqueVitalRecordDetail() {
		return userUniqueVitalRecordDetail;
	}
	public void setUserUniqueVitalRecordDetail(List<UserUniqueVitalRecordDetail> userUniqueVitalRecordDetail) {
		this.userUniqueVitalRecordDetail = userUniqueVitalRecordDetail;
	}
	
}
