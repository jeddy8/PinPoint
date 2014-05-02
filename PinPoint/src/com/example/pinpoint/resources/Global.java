package com.example.pinpoint.resources;

import android.content.Context;
import android.location.LocationManager;

import com.example.pinpoint.models.User;

import retrofit.RestAdapter;

public class Global {
	private static final String API_URL = "http://24.131.120.142:5984";
	private static RestAdapter restAdapter = new RestAdapter.Builder()
			.setEndpoint(API_URL).build();
	private static HJClient client = restAdapter.create(HJClient.class);
	private static User user = new User();

	private static Context context;
	private static Database database = new Database(context);
	private static LocationManager locationManager = null;
	

	public static User getUser() {
		return user;
	}

	public static void setUser(User newUser) {
		user = newUser;
	}

	public static void newInstance(LocationManager locMan) {
		database = new Database(context);
		locationManager = locMan;
	}

	public static Database getDatabase() {
		return database;
	}

	public static void setContext(Context con) {
		context = con;
	}

	public static Context getContext() {
		return context;
	}

	public static HJClient getClient() {
		return client;
	}

	public static String getRootUrl() {
		return API_URL;
	}

	public static LocationManager getLocationManager() {
		return locationManager;
	}
}
