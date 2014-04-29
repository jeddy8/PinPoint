package com.example.pinpoint;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.example.pinpoint.models.Pin;
import com.example.pinpoint.models.PinDB;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity {
  static final LatLng MTNLAIR = new LatLng(39.635053, -79.954028);
  static final LatLng ESB = new LatLng(39.645480, -79.973254);
  private GoogleMap map;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_map);
    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
        .getMap();
    Marker mtnlair = map.addMarker(new MarkerOptions().position(MTNLAIR)
        .title("Mountainlair"));
    Marker esb = map.addMarker(new MarkerOptions()
        .position(ESB)
        .title("ESB")
        .snippet("description")
        .icon(BitmapDescriptorFactory
            .fromResource(R.drawable.ic_launcher)));
    
    for (Pin p : PinDB.pins){
    	map.addMarker(new MarkerOptions().position(p.getLocation())
    			.title(p.getType())
    			.snippet(p.getDescription())
    			.icon(BitmapDescriptorFactory.defaultMarker(p.getColor())));
    }

    // Move the camera instantly to esb with a zoom of 15.
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(ESB, 20));

    // Zoom in, animating the camera.
    map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
    
    map.setMyLocationEnabled(true);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.map, menu);
    return true;
  }

}
