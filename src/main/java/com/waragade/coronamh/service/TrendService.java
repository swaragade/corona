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
	
	public String getFullName(String shortName) {
		
		HashMap <shortName, fullName>  stateName = new HashMap<>;
		

		stateName.put( "kl", "Kerala");
		stateName.put("kerala" , "Kerala");
		stateName.put( "dl", "Delhi");
		stateName.put("delhi" , "Delhi");
		stateName.put( "ts", "Telangana");
		stateName.put("telangana" , "Telangana");
		stateName.put( "rj", "Rajasthan");
		stateName.put("rajasthan" , "Rajasthan");
		stateName.put( "hr", "Haryana");
		stateName.put("haryana" , "Haryana");
		stateName.put( "up", "Uttar Pradesh");
		stateName.put("uttar pradesh" , "Uttar Pradesh");
		stateName.put( "la", "Ladakh");
		stateName.put("ladakh" , "Ladakh");
		stateName.put( "jk", "Jammu and Kashmir");
		stateName.put("jammu and kashmir" , "Jammu and Kashmir");
		stateName.put( "ka", "Karnataka");
		stateName.put("karnataka" , "Karnataka");
		stateName.put( "mh", "Maharashtra");
		stateName.put("maharashtra" , "Maharashtra");
		stateName.put( "pb", "Punjab");
		stateName.put("Punjab" , "Punjab");
		stateName.put( "ap", "Andhra Pradesh");
		stateName.put("andhra pradesh" , "Andhra Pradesh");
		stateName.put( "uk", "Uttarakhand");
		stateName.put("uttarakhand" , "Uttarakhand");
		stateName.put( "od", "Odisha");
		stateName.put("odisha" , "Odisha");
		stateName.put( "py", "Puducherry");
		stateName.put("puducherry" , "Puducherry");
		stateName.put( "wb", "West Bengal");
		stateName.put("west bengal" , "West Bengal");
		stateName.put( "ch", "Chandigarh");
		stateName.put("chandigarh" , "Chandigarh");
		stateName.put( "cg", "Chhattisgarh");
		stateName.put("chhattisgarh" , "Chhattisgarh");
		stateName.put( "gj", "Gujarat");
		stateName.put("gujarat" , "Gujarat");
		stateName.put( "hp", "Himachal Pradesh");
		stateName.put("himachal pradesh" , "Himachal Pradesh");
		stateName.put( "mp", "Madhya Pradesh");
		stateName.put("madhya pradesh" , "Madhya Pradesh");
		stateName.put( "br", "Bihar");
		stateName.put("bihar" , "Bihar");
		stateName.put( "mn", "Manipur");
		stateName.put("manipur" , "Manipur");
		stateName.put( "mz", "Mizoram");
		stateName.put("mizoram" , "Mizoram");
		stateName.put( "ga", "Goa");
		stateName.put("goa" , "Goa");
		stateName.put( "an", "Andaman and Nicobar Islands");
		stateName.put("andaman and nicobar islands" , "Andaman and Nicobar Islands");
		stateName.put( "jh", "Jharkhand");
		stateName.put("jharkhand" , "Jharkhand");
		stateName.put( "as", "Assam");
		stateName.put("assam" , "Assam");
		stateName.put( "ar", "Arunachal Pradesh");
		stateName.put("arunachal pradesh" , "Arunachal Pradesh");
		stateName.put( "dn", "Dadra and Nagar Haveli");
		stateName.put("dadra and nagar haveli" , "Dadra and Nagar Haveli");
		stateName.put( "tr", "Tripura");
		stateName.put("Tripura" , "Tripura");
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}

}
