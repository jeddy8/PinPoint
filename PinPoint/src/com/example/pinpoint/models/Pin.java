package com.example.pinpoint.models;

import java.util.List;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

public class Pin {

	@SerializedName("location")
	List<Double> location;

	@SerializedName("type")
	String type;

	@SerializedName("color")
	Float color;
	
	@SerializedName("description")
	String description;
	
	public Pin(List<Double> location, String type) {
		this.location = location;
		this.type = type;
		this.description = description;
	}
	
	public Pin(List<Double> location, String type, String description) {
		this.location = location;
		this.type = type;
		this.description = description;
	}

	public Pin() {
		// TODO Auto-generated constructor stub
	}

	public List<Double> getLocation() {
		return location;
	}

	public void setLocation(List<Double> location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getColor() {
		return color;
	}
	
	public void colorIntensity(){
		color = color-10;
	}

	public void setColor(float color) {
		this.color = color;
	}
}