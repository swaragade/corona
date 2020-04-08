package com.waragade.coronamh.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DistrictData {
	@JsonProperty("total_cases")
	private String totalCases;

	@JsonProperty("total_recovered")
	private String totalRecovered;

	@JsonProperty("total_deaths")
	private String totalDeaths;

	@JsonProperty("total_affected_countries")
	private String totalAffectedCountries;

}


/*
 * "districtData": { "Thrissur": { "confirmed": 13, "lastupdatedtime": "",
 * "delta": { "confirmed": 1 } }, "Alappuzha":
 */