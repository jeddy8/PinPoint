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

	@POST("/user")
	void login(@Body User user, Callback<User> callback);
	
	@PUT("/pins")
	void updatePin(@Body Pin pin, Callback<Pin> callback);
	
	@POST("/pins")
	void pinIt(@Body Pin pin, Callback<Pin> callback);
	
	@GET("/_utils/pins/")
	void pins(Callback<List<Pin>> callback);
	
	@POST("/teams")
	void teams(@Body Teams team, Callback<Teams> callback);
	
	@GET("/pins")
	void updatTeams(@Body Teams team, Callback<Teams> callback);
	
	@GET("/teams")
	void team(Callback<List<Teams>> callback);
}
