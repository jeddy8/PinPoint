package com.example.pinpoint.resources;

import com.example.pinpoint.models.Event;
import com.example.pinpoint.models.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by root on 3/26/14.
 */
public interface HJClient {

	@POST("/user/login")
	void login(@Body User user, Callback<User> callback);

	@GET("/events")
	void events(Callback<List<Event>> callback);
}
