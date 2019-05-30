package com.syntel.orion.io;

import java.util.Map;

public class KVScoreCardResponse extends BaseResponse {
	
	
	private Map<String, ScoreCardResponse> scr;

	public Map<String, ScoreCardResponse> getScr() {
		return scr;
	}

	public void setScr(Map<String, ScoreCardResponse> scr) {
		this.scr = scr;
	}
	
	
	
	

}
