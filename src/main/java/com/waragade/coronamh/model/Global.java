package com.waragade.coronamh.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Global {

	@JsonProperty("total_cases")
	private String totalCases;

	@JsonProperty("total_recovered")
	private String totalRecovered;

	@JsonProperty("total_deaths")
	private String totalDeaths;

	@JsonProperty("total_affected_countries")
	private String totalAffectedCountries;

	public String getTotalAffectedCountries() {
		return totalAffectedCountries;
	}

	public void setTotalAffectedCountries(String totalAffectedCountries) {
		this.totalAffectedCountries = totalAffectedCountries;
	}

	public String getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(String totalCases) {
		this.totalCases = totalCases;
	}

	public String getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public String getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(String totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

}
