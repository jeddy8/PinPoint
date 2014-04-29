package com.example.pinpoint.models;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.google.android.gms.maps.model.LatLng;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

public class LocationTools {
	
	public String convertToAddress(Context context, LatLng point) {   
	    String address = "";
	    Geocoder geoCoder = new Geocoder(context, Locale.getDefault());
	    try {
	      List<Address> addresses = geoCoder.getFromLocation(
	        point.latitude, point.longitude, 1);
	 
	      if (addresses.size() > 0) {
	        for (int index = 0; 
		index < addresses.get(0).getMaxAddressLineIndex(); index++)
	          address += addresses.get(0).getAddressLine(index) + " ";
	      }
	    }
	    catch (IOException e) {        
	      e.printStackTrace();
	    }   
	    
	    return address;
	  } 
	
	
	public LatLng randomLocation(){
		Random rand = new Random();
		double latmax = 39.670365;
	    double latmin = 39.605885;
	    double longmax = -79.912640;
	    double longmin = -79.994847;
	    return new LatLng((rand.nextDouble() * (latmax - latmin)) + latmin
    			, (rand.nextDouble() * (longmax-longmin)) + longmin);
	}
}
