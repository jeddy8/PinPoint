package com.example.pinpoint.models;
import com.google.gson.annotations.SerializedName;

public class Event {
	@SerializedName("_id")
	private String _id;
	
	@SerializedName("teamLeader")
	private String teamLeader;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("sponsor")
	private String sponsor;
	
	public Event Event(){
		return this;
	}
	
	public String getName(){
		return name;
	}
	
	public String getID(){
		return _id;
	}
	
	public String getTeamLeader(){
		return teamLeader;
	}
	
	public String getSponsor(){
		return sponsor;
	}
}
