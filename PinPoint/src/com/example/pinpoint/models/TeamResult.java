package com.example.pinpoint.models;

import java.util.ArrayList;
import java.util.List;

import com.example.pinpoint.models.PinResult.PinObject;
import com.google.gson.annotations.SerializedName;

public class TeamResult {

	@SerializedName("total_rows")
	private int total_rows;

	@SerializedName("offset")
	private int offset;

	@SerializedName("rows")
	private List<TeamObject> rows = new ArrayList<TeamObject>();

	public TeamResult() {
	}

	public TeamResult(int total_row, int offset, List<TeamObject> rows) {
		total_row = this.total_rows;
		offset = this.offset;
		rows = this.rows;
	}

	public int getTotal_row() {
		return total_rows;
	}

	public void setTotal_row(int total_row) {
		this.total_rows = total_row;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public List<TeamObject> getRows() {
		return rows;
	}

	public void setRows(List<TeamObject> rows) {
		this.rows = rows;
	}

	public class TeamObject {
		@SerializedName("id")
		private String id;

		@SerializedName("key")
		private String key;

		@SuppressWarnings("unused")
		public String getKey() {
			return key;
		}

		@SuppressWarnings("unused")
		public void setKey(String key) {
			this.key = key;
		}

		@SuppressWarnings("unused")
		public Team getTeam() {
			return team;
		}

		@SuppressWarnings("unused")
		public void setTeam(Team team) {
			this.team = team;
		}

		@SerializedName("value")
		private Team team;

		@SuppressWarnings("unused")
		public TeamObject() {
		}

		@SuppressWarnings("unused")
		public void setId(String id) {
			this.id = id;
		}

		@SuppressWarnings("unused")
		public String getId() {
			return this.id;
		}

	}
}
