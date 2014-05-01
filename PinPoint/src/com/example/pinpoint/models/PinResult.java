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
	private List<Pin> rows = new ArrayList<Pin>();
 	
 	
 	public PinResult(){
 	}
 	
 	public PinResult(int total_row,int offset, List<Pin> rows){
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
	public List<Pin> getRows() {
		return rows;
	}
	public void setRows(List<Pin> rows) {
		this.rows = rows;
	}
}
