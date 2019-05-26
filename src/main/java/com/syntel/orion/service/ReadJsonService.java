package com.syntel.orion.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.syntel.orion.io.TestCaseReport;

@Service
public class ReadJsonService {

	/*
	 * @Value("${json.config.folder}")
	 */
	String jsonConfigFolder;

	List<TestCaseReport> tcs = new ArrayList<>();

	public List<TestCaseReport> getReport() throws IOException {
		TestCaseReport tc = new TestCaseReport();
		tc.setId(123L);
		tc.setName("ABC");

		tcs.add(tc);

		return tcs;
	}

}
