package com.example.pinpoint.models;

import com.google.gson.annotations.SerializedName;

public class Pin {
	
	@SerializedName("location")
    String location;
	
	@SerializedName("type")
    String type;
    
    public Pin(String location, String type){
    	this.location = location;
    	this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}