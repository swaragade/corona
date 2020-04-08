package com.waragade.coronamh.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trend {

	@JsonProperty("Cases")
	private String cases;

	@JsonProperty("Date")
	private String date;

	public String getCases() {
		return cases;
	}

	public void setCases(String cases) {
		this.cases = cases;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
