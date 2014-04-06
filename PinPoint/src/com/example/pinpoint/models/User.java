package com.example.pinpoint.models;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.example.pinpoint.resources.Global;
import com.google.gson.annotations.SerializedName;

public class User {
	@SerializedName("_id")
	private String _id;
	
	@SerializedName("email")
	private String email;
	
	@SerializedName("phone")
	private String phone;
	
	@SerializedName("name")
	private String name;
	
	@SerializedName("role")
	private String role;
	
	@SerializedName("verfied")
	private String verified;
	
	@SerializedName("reputation")
	private String reputation;
	
	private boolean isLoggedIn = false;
	private String password = null;
	
	
	public User User(){
	return this;
	}
	
	public Boolean getIsLoggedIn(){
		if(Global.getDatabase().getRowCount()>0)
			this.isLoggedIn = true;
		return isLoggedIn;
	}
	
	public void login(){
		this.isLoggedIn = true;
		TelephonyManager tMgr = (TelephonyManager) Global.getContext().getSystemService(Context.TELEPHONY_SERVICE);
		this.phone = tMgr.getLine1Number();
		Global.getDatabase().addUser(this._id,this.name,this.email,this.phone,this.role);
	}
	
	public void setEmail(String email){
		this.email =email;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getReputation(){
		return reputation;
	}
}

