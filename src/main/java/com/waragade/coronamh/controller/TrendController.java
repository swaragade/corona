
package com.waragade.coronamh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.waragade.coronamh.service.GlobalService;
import com.waragade.coronamh.service.TrendService;

@RestController
public class TrendController {

	@Autowired
	TrendService trendService;

	@Autowired
	GlobalService globalService;

	@GetMapping("/trend")
	public String getTrend() {
		System.out.println("api called");
		String result = trendService.mapTrend();

		System.out.println("api result :  " + result);

		return result;
	}

	@GetMapping("/globe")
	public String getGlobal() {
		System.out.println("api called");
		String result = globalService.globalData();

		System.out.println("api result :  " + result);

		return result;
	}

	@GetMapping("/india")
	public String getIndia() {
		System.out.println("api called");
		String result = trendService.mapTrend();

		System.out.println("api result :  " + result);

		return result;
	}

	@GetMapping("/state/{state_name}")
	public String getState(@PathVariable(value = "state_name") String stateName) {
		String result = null;
		if (stateName != null || stateName != "") {
			result = globalService.stateData(stateName);
		} else {
			result = globalService.stateData("Maharashtra");
		}

		System.out.println("api result :  " + result);

		return result;
	}

}
