package com.bug.report;

public class SomeSamplePojo {
	private String iso;
	private String continent;
	private String country;
	
	public SomeSamplePojo() {
	}

	public SomeSamplePojo(String iso, String continent, String country) {
		this.iso = iso;
		this.continent = continent;
		this.country = country;
	}
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
