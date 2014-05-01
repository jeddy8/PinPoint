package com.example.pinpoint.models;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class UserResult {

	@SerializedName("total_rows")
	private int total_rows;

	@SerializedName("offset")
	private int offset;

	@SerializedName("rows")
	private List<UserObject> rows = new ArrayList<UserObject>();

	public UserResult() {
	}

	public UserResult(int total_row, int offset, List<UserObject> rows) {
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

	public List<UserObject> getRows() {
		return rows;
	}

	public void setRows(List<UserObject> rows) {
		this.rows = rows;
	}

	public class UserObject {
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
		public User getUser() {
			return user;
		}

		@SuppressWarnings("unused")
		public void setUser(User user) {
			this.user = user;
		}

		@SerializedName("value")
		private User user;

		@SuppressWarnings("unused")
		public UserObject() {
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
