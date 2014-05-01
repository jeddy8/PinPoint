package com.example.pinpoint.resources;

import com.example.pinpoint.models.*;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;

/**
 * Created by root on 3/26/14.
 */
public interface HJClient {

	@POST("/pinpoint")
	void login(@Body User user, Callback<User> callback);
	
	@PUT("/pinpoint")
	void updateUser(@Body User user, Callback<User> callback);
	
	@GET("/pinpoint/_design/user/_view/all")
	void user(Callback<UserResult> callback);
	
	@PUT("/pinpoint")
	void updatePin(@Body Pin pin, Callback<Pin> callback);
	
	@POST("/pinpoint")
	void pinIt(@Body Pin pin, Callback<Pin> callback);
	
	@GET("/pinpoint/_design/pins/_view/all")
	void pins(Callback<PinResult> callback);
	
	@POST("/teams")
	void teams(@Body Team team, Callback<Team> callback);
	
	@PUT("/pinpoint")
	void updatTeams(@Body Team team, Callback<Team> callback);
	
	@GET("/pinpoint/_design/teams/_views/all")
	void team(Callback<List<Team>> callback);
}
