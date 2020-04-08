package com.waragade.coronamh.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waragade.coronamh.client.TrendClient;
import com.waragade.coronamh.model.Trend;

@Component
public class TrendService {

	@Autowired
	TrendClient trendClient;

	public String mapTrend() {

		List<Trend> list = trendClient.getTrend();
		List<JSONObject> json = new ArrayList<>();

		for (Trend t : list) {
			JSONObject formDetailsJson = new JSONObject();
			formDetailsJson.put("Cases", t.getCases());
			formDetailsJson.put("Date", t.getDate());
			json.add(formDetailsJson);
		}
		return json.toString();
	}

}
