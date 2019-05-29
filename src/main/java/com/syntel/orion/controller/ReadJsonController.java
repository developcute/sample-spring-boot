package com.syntel.orion.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syntel.orion.io.ListResponse;
import com.syntel.orion.io.ScoreCardResponse;
import com.syntel.orion.service.ReadJsonService;
import com.syntel.orion.util.ResponseStatusCode;

@RestController
public class ReadJsonController {
	
	
	private ReadJsonService readJsonService;
	
	@Autowired
	public ReadJsonController(ReadJsonService readJsonService) {
		this.readJsonService = readJsonService;
	}
	
	@RequestMapping(value = "/report/scorecard", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ListResponse<ScoreCardResponse> getExecutionDetails() {
           ListResponse<ScoreCardResponse> response = new ListResponse<>();
           File file = new File(getClass().getClassLoader().getResource("data/HealthScorecard.json").getFile());
           JSONParser parser = new JSONParser();
           try (FileReader reader = new FileReader(file)) {
                  JSONObject jsonObject = (JSONObject) parser.parse(reader);
                  // loop array
                  JSONArray scoreCardArray = (JSONArray) jsonObject.get("Orion Health Scorecard");
                  if (scoreCardArray == null) {
                        response.setStatus(ResponseStatusCode.FAILURE);
                        response.setErrorMessage("Parse exception, data missing");
                        return response;
                  }
                  List<ScoreCardResponse> scoreCardList = new ArrayList<>();
                  for (Object executionDetailObject : scoreCardArray) {
                	  ScoreCardResponse res = new ScoreCardResponse();
                        JSONObject scoreCardDetail = (JSONObject) executionDetailObject;
                        String product = (String) scoreCardDetail.get("Product");
                        String total = (String) scoreCardDetail.get("Total");
                        String success = (String) scoreCardDetail.get("Success");
                        String failure = (String) scoreCardDetail.get("Failure");
                        String availability = (String) scoreCardDetail.get("Availability");
                        
                        res.setProduct(product);
                        res.setTotal(total);
                        res.setSuccess(success);
                        res.setFailure(failure);
                        res.setAvailability(availability);
                        scoreCardList.add(res);
                  }
                  response.setStatus(ResponseStatusCode.SUCCESS);
                  response.setCount((long) scoreCardList.size());
                  response.setResults(scoreCardList);

           } catch (FileNotFoundException e) {
                  response.setStatus(ResponseStatusCode.FAILURE);
                  response.setErrorMessage("Resource File doesnt exist");
                  return response;
           } catch (IOException e) {
                  response.setStatus(ResponseStatusCode.FAILURE);
                  response.setErrorMessage("IO exception");
                  return response;
           } catch (ParseException e) {
                  response.setStatus(ResponseStatusCode.FAILURE);
                  response.setErrorMessage("Parse exception");
                  return response;
           }
           return response;

    }



}
