package com.axonytes.corporate.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.axonytes.corporate.entity.VitalRecord;
import com.axonytes.corporate.exception.EntityNotFoundException;
import com.axonytes.corporate.io.UserUniqueVitalRecordDetail;
import com.axonytes.corporate.io.UserUniqueVitalRecordResponse;
import com.axonytes.corporate.io.UserVitalRecordTrendDetail;
import com.axonytes.corporate.io.UserVitalRecordTrendRequest;
import com.axonytes.corporate.io.UserVitalRecordTrendResponse;
import com.axonytes.corporate.service.VitalRecordService;
import com.axonytes.corporate.util.ResponseStatusCode;

@RestController
public class VitalRecordController extends BaseController {

	private VitalRecordService vitalRecordService;
	private static final Logger logger = LogManager.getLogger(VitalRecordController.class.getName());

	@Autowired
	public VitalRecordController(VitalRecordService vitalRecordService) {
		this.vitalRecordService = vitalRecordService;
	}

	@RequestMapping(value = "/user/{userId}/vitalrecords/unique", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserUniqueVitalRecordResponse getUserUniqueVitalRecords(@PathVariable("userId") Long userId) {
		logger.info("Entered in the UserUniqueVitalRecordResponse function..");
		List<VitalRecord> vitalRecordsList = vitalRecordService.getUserUniqueVitalRecords(userId);
		if (vitalRecordsList.size() == 0) {
			throw new EntityNotFoundException("No User Vital Records found");
		}
		UserUniqueVitalRecordResponse response = new UserUniqueVitalRecordResponse();
		List<UserUniqueVitalRecordDetail> entityDetailList = new ArrayList<>();
		UserUniqueVitalRecordDetail userUniqueVitalRecordDetail;
		for (VitalRecord vitalRecord : vitalRecordsList) {
			userUniqueVitalRecordDetail = new UserUniqueVitalRecordDetail();
			userUniqueVitalRecordDetail.setId(vitalRecord.getId());
			userUniqueVitalRecordDetail.setAppointmentId(vitalRecord.getAppointmentId());
			userUniqueVitalRecordDetail.setSelfDeclared(vitalRecord.getSelfDeclared());
			userUniqueVitalRecordDetail.setVitalName(vitalRecord.getVitalName());
			userUniqueVitalRecordDetail.setVitalValue(vitalRecord.getVitalValue());
			entityDetailList.add(userUniqueVitalRecordDetail);
		}
		response.setStatus(ResponseStatusCode.SUCCESS);
		response.setTotalUniqueVitalRecords((long) vitalRecordsList.size());
		response.setUserUniqueVitalRecordDetail(entityDetailList);
		return response;
	}

	@RequestMapping(value = "/user/{userId}/vital/trends", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserVitalRecordTrendResponse getUserVitalRecordTrends(@PathVariable("userId") Long userId,
			@Valid @RequestBody UserVitalRecordTrendRequest request) {
		logger.info("Entered in the getUserVitalRecordTrends function..");
		logger.info("request.getVitalName() " + request.getVitalName());
		if (request.getVitalName().equals("")) {
			throw new IllegalArgumentException("Please enter the valid vital name");
		}
		List<VitalRecord> vitalRecordsList;
		if( request.getFilterBy() != null && request.getFilterBy().getFromDate() != null && request.getFilterBy().getToDate() != null) {
			if(request.getFilterBy().getFromDate().isAfter(request.getFilterBy().getToDate())){
				throw new IllegalArgumentException("from date is greater than to date");
	        }
			if(request.getFilterBy().getFromDate().isAfter(LocalDate.now())){
				throw new IllegalArgumentException("from date should not be future date");
	        }
			vitalRecordsList = vitalRecordService.getUserVitalRecordTrendsByFilter(userId, request.getVitalName(),
					request.getFilterBy().getFromDate(), request.getFilterBy().getToDate());
		} else {
			vitalRecordsList = vitalRecordService.getUserVitalRecordTrends(userId, request.getVitalName());
		}
		if (vitalRecordsList.size() == 0) {
			throw new EntityNotFoundException("No User Vital Records found");
		}
		UserVitalRecordTrendResponse response = new UserVitalRecordTrendResponse();
		List<UserVitalRecordTrendDetail> userVitalRecordTrendDetailList = new ArrayList<>();
		for (VitalRecord vitalRecord : vitalRecordsList) {
			logger.info("vitalRecord --> " + vitalRecord.getVitalValue());
			userVitalRecordTrendDetailList.add(listVitalRecordDetail(vitalRecord));
		}
		response.setStatus(ResponseStatusCode.SUCCESS);
		response.setVitals(userVitalRecordTrendDetailList);
		return response;
	}

	private UserVitalRecordTrendDetail listVitalRecordDetail(VitalRecord vitalRecord) {
		UserVitalRecordTrendDetail detail = new UserVitalRecordTrendDetail();
		detail.setVitalValue(vitalRecord.getVitalValue());
		detail.setCreatedAt(vitalRecord.getCreatedAt());
		return detail;
	}

}
