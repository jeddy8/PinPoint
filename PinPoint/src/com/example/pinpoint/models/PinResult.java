package com.example.pinpoint.models;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PinResult {
	
	
 	@SerializedName("total_rows")
	private int total_rows;

	@SerializedName("offset")
	private int offset;
	
	@SerializedName("rows")
	private List<PinObject> rows = new ArrayList<PinObject>();
 	
 	
 	public PinResult(){
 	}
 	
 	public PinResult(int total_row,int offset, List<PinObject> rows){
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
	public List<PinObject> getRows() {
		return rows;
	}
	public void setRows(List<PinObject> rows) {
		this.rows = rows;
	}
	
	public class PinObject {
		@SerializedName("id")
		private String id;
		
		@SerializedName("rev")
		private String rev;	
		
		@SerializedName("deleted")
		private Boolean deleted;
		
		
		
		public Boolean getDeleted() {
			return deleted;
		}

		public void setDeleted(Boolean deleted) {
			this.deleted = deleted;
		}

		public String getRev() {
			return this.rev;
		}

		public void setRev(String rev) {
			this.rev = rev;
		}

		@SuppressWarnings("unused")
		public Pin getPin() {
			return pin;
		}

		@SuppressWarnings("unused")
		public void setPin(Pin pin) {
			this.pin = pin;
		}

		@SerializedName("value")
		private Pin pin;
		
		@SuppressWarnings("unused")
		public PinObject() {
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