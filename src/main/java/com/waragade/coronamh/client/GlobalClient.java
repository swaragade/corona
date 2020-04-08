package com.waragade.coronamh.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GlobalClient {

	private static final String URL_GLOBAL = "https://api.thevirustracker.com/free-api?global=stats";

	private static final String URL_STATE = "https://api.covid19india.org/state_district_wise.json";

	RestTemplate restTemplate;

	public String getTrend() {

		restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(URL_GLOBAL, String.class);
		
		return result;

	}
	
	public String getState() {

		restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(URL_STATE, String.class);
		
		return result;

	}

}
