package com.example.pinpoint.models;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

public class Pin {

	@SerializedName("location")
	LatLng location;

	@SerializedName("type")
	String type;

	@SerializedName("color")
	String color;

	public Pin(LatLng location, String type) {
		this.location = location;
		this.type = type;
		this.color = color;
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

	public String getColor() {
		return color;
	}

	public void setColor() {
		this.color = color;
	}
}