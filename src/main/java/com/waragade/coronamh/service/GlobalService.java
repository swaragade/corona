package com.waragade.coronamh.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waragade.coronamh.client.GlobalClient;
import com.waragade.coronamh.model.Global;

@Component
public class GlobalService {

	@Autowired
	GlobalClient globalClient;

	@Autowired
	TrendService trendService;

	public String globalData() {

		String response1 = globalClient.getTrend();
		if(response1 != null || response1 != "") {
			JSONObject responseJson1 = new JSONObject(response1);

			System.out.println(responseJson1.get("results").toString());

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			List<Global> listFromJackson = null;
			try {
				listFromJackson = mapper.readValue(responseJson1.get("results").toString(),
						new TypeReference<ArrayList<Global>>() {
						});
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			JSONObject formDetailsJson = new JSONObject();
			for (Global t : listFromJackson) {

				formDetailsJson.put("TotalAffectedCountries", t.getTotalAffectedCountries());
				formDetailsJson.put("TotalCases", t.getTotalCases());
				formDetailsJson.put("TotalDeaths", t.getTotalDeaths());
				formDetailsJson.put("TotalRecovered", t.getTotalRecovered());

			}

			return formDetailsJson.toString();
		}else {
			JSONObject error = new JSONObject();
			error.put("Error", "State not found");
			return error.toString();
		}

	}

	public String stateData(String stateCode) {

		String stateName = trendService.getFullName(stateCode);

		if (stateName != null) {
			String clientResponse = new GlobalClient().getState();
			JSONObject stateJson = new JSONObject(clientResponse);
			String stateString = stateJson.get(stateName).toString();

			JSONObject distJson = new JSONObject(stateString);
			String distString = distJson.get("districtData").toString();

			JSONObject subDistJson = new JSONObject(distString);

			Integer sum = 0;
			List<JSONObject> response = new ArrayList<>();
			for (String district : subDistJson.keySet()) {
				System.out.println("keys =>" + district);
				String subDistString = subDistJson.get(district).toString();
				JSONObject confirmJson = new JSONObject(subDistString);
				String confirmString = confirmJson.get("confirmed").toString();
				JSONObject formDetailsJson = new JSONObject();
				if ((confirmString != null || confirmString != "") && !district.contains("Gujar")) {
					Integer cases = Integer.parseInt(confirmString);
					formDetailsJson.put("District", district);
					formDetailsJson.put("Cases", cases);
				}

				System.out.println("value : " + confirmString);
				sum += Integer.parseInt(confirmString);
				response.add(formDetailsJson);
			}
			System.out.println("sum = " + sum);
			JSONObject state = new JSONObject();
			state.put("State", stateName);
			state.put("Cases", sum);
			response.add(state);

			return response.toString();
		}
		JSONObject error = new JSONObject();
		error.put("Error", "State not found");
		return error.toString();

	}
}
