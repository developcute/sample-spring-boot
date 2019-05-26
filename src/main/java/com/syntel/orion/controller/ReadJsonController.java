package com.syntel.orion.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syntel.orion.exception.EntityNotFoundException;
import com.syntel.orion.io.EntityDetail;
import com.syntel.orion.io.ListResponse;
import com.syntel.orion.io.TestCaseReport;
import com.syntel.orion.service.ReadJsonService;
import com.syntel.orion.util.ResponseStatusCode;

@RestController
public class ReadJsonController {
	
	
	private ReadJsonService readJsonService;
	
	@Autowired
	public ReadJsonController(ReadJsonService readJsonService) {
		this.readJsonService = readJsonService;
	}
	
	@RequestMapping(value = "/report1", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ListResponse<EntityDetail> getReport() throws IOException {
		
		List<TestCaseReport> dataList = readJsonService.getReport();
		ListResponse<EntityDetail> response = new ListResponse<>();
		response.setStatus(ResponseStatusCode.SUCCESS);
		response.setCount((long)dataList.size());
		//response.setResults(dataList);
		return response;
	}

}
