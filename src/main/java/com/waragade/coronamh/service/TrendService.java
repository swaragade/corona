package com.waragade.coronamh.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.waragade.coronamh.client.TrendClient;
import com.waragade.coronamh.model.Trend;

@Component
public class TrendService {

	static HashMap<String, String> stateName = new HashMap<>();

	static {
		stateName.put("kl", "Kerala");
		stateName.put("kerala", "Kerala");
		stateName.put("dl", "Delhi");
		stateName.put("delhi", "Delhi");
		stateName.put("ts", "Telangana");
		stateName.put("telangana", "Telangana");
		stateName.put("rj", "Rajasthan");
		stateName.put("rajasthan", "Rajasthan");
		stateName.put("hr", "Haryana");
		stateName.put("haryana", "Haryana");
		stateName.put("up", "Uttar Pradesh");
		stateName.put("uttar pradesh", "Uttar Pradesh");
		stateName.put("la", "Ladakh");
		stateName.put("ladakh", "Ladakh");
		stateName.put("jk", "Jammu and Kashmir");
		stateName.put("jammu and kashmir", "Jammu and Kashmir");
		stateName.put("ka", "Karnataka");
		stateName.put("karnataka", "Karnataka");
		stateName.put("mh", "Maharashtra");
		stateName.put("maharashtra", "Maharashtra");
		stateName.put("pb", "Punjab");
		stateName.put("Punjab", "Punjab");
		stateName.put("ap", "Andhra Pradesh");
		stateName.put("andhra pradesh", "Andhra Pradesh");
		stateName.put("uk", "Uttarakhand");
		stateName.put("uttarakhand", "Uttarakhand");
		
		stateName.put("od", "Odisha");
		stateName.put("odisha", "Odisha");
		
		stateName.put("py", "Puducherry");
		stateName.put("puducherry", "Puducherry");
		
		stateName.put("wb", "West Bengal");
		stateName.put("west bengal", "West Bengal");
		
		stateName.put("ch", "Chandigarh");
		stateName.put("chandigarh", "Chandigarh");
		
		stateName.put("cg", "Chhattisgarh");
		stateName.put("chhattisgarh", "Chhattisgarh");
		
		stateName.put("gj", "Gujarat");
		stateName.put("gujarat", "Gujarat");
		
		stateName.put("hp", "Himachal Pradesh");
		stateName.put("himachal pradesh", "Himachal Pradesh");
		
		stateName.put("mp", "Madhya Pradesh");
		stateName.put("madhya pradesh", "Madhya Pradesh");
		
		stateName.put("br", "Bihar");
		stateName.put("bihar", "Bihar");
		
		stateName.put("mn", "Manipur");
		stateName.put("manipur", "Manipur");
		
		stateName.put("mz", "Mizoram");
		stateName.put("mizoram", "Mizoram");
		
		stateName.put("ga", "Goa");
		stateName.put("goa", "Goa");
		
		stateName.put("an", "Andaman and Nicobar Islands");
		stateName.put("andaman and nicobar islands", "Andaman and Nicobar Islands");
		
		stateName.put("jh", "Jharkhand");
		stateName.put("jharkhand", "Jharkhand");
		
		stateName.put("as", "Assam");
		stateName.put("assam", "Assam");
		
		stateName.put("ar", "Arunachal Pradesh");
		stateName.put("arunachal pradesh", "Arunachal Pradesh");
		
		stateName.put("dn", "Dadra and Nagar Haveli");
		stateName.put("dadra and nagar haveli", "Dadra and Nagar Haveli");
		
		stateName.put("tr", "Tripura");
		stateName.put("Tripura", "Tripura");
		
		stateName.put("tn", "Tamil Nadu");
		stateName.put("tamil nadu", "Tamil Nadu");
		
		stateName.put("sk", "Sikkim");
		stateName.put("sikkim", "Sikkim");
		
		stateName.put("dd", "Daman and Diu");
		stateName.put("daman and diu", "Daman and Diu");
		
		stateName.put("tr", "Tripura");
		stateName.put("Tripura", "Tripura");
		
		stateName.put("ml", "Meghalaya");
		stateName.put("Meghalaya", "Meghalaya");
		
		stateName.put("ld", "Lakshadweep");
		stateName.put("lakshadweep", "Lakshadweep");
		
		stateName.put("nl", "Nagaland");
		stateName.put("nagaland", "Nagaland");
	}

	@Autowired
	TrendClient trendClient;

	public List<JSONObject> mapTrend() {

		List<Trend> list = trendClient.getTrend();
		List<JSONObject> jsonList = new ArrayList<>();

		for (Trend t : list) {
			JSONObject formDetailsJson = new JSONObject();
			formDetailsJson.put("Cases", t.getCases());
			formDetailsJson.put("Date", t.getDate());
			jsonList.add(formDetailsJson);
		}
		return jsonList;
	}

	public String getFullName(String shortName) {
		String fullName = null;
		if (shortName != null) {
			fullName = stateName.get(shortName.toLowerCase());
			if (fullName != null || fullName != "") {
				return fullName;
			}
		}
		return fullName;
	}
	
	public String getIndia() {
		List<JSONObject> jsonList =mapTrend();
		String cases = "0";
		if (jsonList != null && !jsonList.isEmpty()) {
			JSONObject india = jsonList.get(jsonList.size()-1);
			if(india != null) {
				cases = india.get("Cases").toString();
				if (cases != null || cases != "" ) {
					return cases;
				}
			}
			
			
			/*
			 * String dateInString = "2016-08-16T15:23:01Z";
			 * 
			 * Instant instant = Instant.parse(dateInString);
			 * 
			 * System.out.println("Instant : " + instant);
			 * 
			 * //get date time only LocalDateTime result = LocalDateTime.ofInstant(instant,
			 * ZoneId.of(ZoneOffset.UTC.getId()));
			 * 
			 * //get localdate System.out.println("LocalDate : " + result.toLocalDate());
			 */
			
		}
		JSONObject error = new JSONObject();
		error.put("Error", "State not found");
		return error.toString();
	}

}
