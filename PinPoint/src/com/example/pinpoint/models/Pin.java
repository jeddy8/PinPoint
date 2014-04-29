package com.example.pinpoint.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

public class Pin {

	@SerializedName("location")
	LatLng location;

	@SerializedName("type")
	String type;

	@SerializedName("color")
	float color;
	
	@SerializedName("description")
	String description;
	
	@SerializedName("address")
	String address;

	public Pin(LatLng location, String type, String address) {
		this.location = location;
		this.type = type;
		this.description = null;
		this.color = 180;
		this.address = address;
	}
	
	public Pin(LatLng location, String type, String description, String address) {
		this.location = location;
		this.type = type;
		this.description = description;
		this.color = 180;
		this.address = address;
	}

	public LatLng getLocation() {
		return location;
	}

	public void setLocation(LatLng location) {
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

	public float getColor() {
		return color;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void colorIntensity(){
		if (color > 0)
			color = color - 15;
	}
}