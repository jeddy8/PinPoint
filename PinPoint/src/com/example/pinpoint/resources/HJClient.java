package com.example.pinpoint.resources;

import com.example.pinpoint.models.*;
import com.example.pinpoint.models.PinResult.PinObject;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

/**
 * Created by root on 3/26/14.
 */
public interface HJClient {

	@POST("/users")
	void login(@Body User user, Callback<User> callback);
	
	@PUT("/pinpoint")
	void updateUser(@Body User user, Callback<User> callback);
	
	@GET("/users/_design/users/_view/all")
	void user(Callback<UserResult> callback);
	
	@DELETE("/pinpoint/{id}")
	void deletePin(@Path("id") String id, Callback<Pin> callback);
	
	@PUT("/pinpoint/{id}")
	void updatePin(@Path("id") String id, @Body Pin pin, Callback<Pin> callback);
	
	@POST("/pinpoint")
	void pinIt(@Body Pin pin, Callback<Pin> callback);
	
	@GET("/pinpoint/_design/pins/_view/all")
	void pins(Callback<PinResult> callback);
	
	@POST("/teams")
	void team(@Body Team team, Callback<Team> callback);
	
	@PUT("/teams")
	void updatTeams(@Body Team team, Callback<Team> callback);
	
	@GET("/teams/_design/teams/_view/all")
	void teams(Callback<TeamResult> callback);
}
