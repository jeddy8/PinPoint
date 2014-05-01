package com.example.pinpoint.models;

import java.util.List;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

public class Team {


		@SerializedName("teamleader")
		String teamLeader;

		@SerializedName("teamname")
		String teamName;

		@SerializedName("teammembers")
		List<Double> teamMembers;
		
		@SerializedName("events")
		List<Double> events;
		
		public Team(List<Double> location, String type) {
			this.teamLeader = teamLeader;
			this.teamName = teamName;
			this.teamMembers = teamMembers;
			this.events = events;
		}
		
		public Team() {
			// TODO Auto-generated constructor stub
		}

		public String getTeamLeader() {
			return teamLeader;
		}
		
		public void setTeamLeader(String teamLeader) {
			this.teamLeader = teamLeader;
		}
		
		public String getTeamName() {
			return teamName;
		}
		
		public void setTeamName(String teamName) {
			this.teamName = teamName;
		}
		
		public List<Double> getTeamMembers() {
			return teamMembers;
		}

		public void setTeamMembers(List<Double> teamMembers) {
			this.teamMembers = teamMembers;
		}

		public List<Double> getEvents() {
			return events;
		}

		public void setEvents(List<Double> events) {
			this.events = events;
		}
}
