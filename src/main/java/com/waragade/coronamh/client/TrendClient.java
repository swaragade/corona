package com.waragade.coronamh.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waragade.coronamh.model.Trend;

@Component
public class TrendClient {

	private final String URL_TREND = "https://api.covid19api.com/country/india/status/confirmed";

	RestTemplate restTemplate;

	public List<Trend> getTrend() {

		restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(URL_TREND, String.class);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<Trend> listFromJackson = null;
		try {
			listFromJackson = mapper.readValue(result, new TypeReference<ArrayList<Trend>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return listFromJackson;

	}

}
