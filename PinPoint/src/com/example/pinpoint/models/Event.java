package com.example.pinpoint.models;
import com.google.gson.annotations.SerializedName;

public class Event {
	@SerliazedName("_id")
	private String _id;
	
	@SerliazedName("teamLeader")
	private String teamLeader;
	
	@SerliazedName("name")
	private String name;
	
	@SerliazedName("sponsor")
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
