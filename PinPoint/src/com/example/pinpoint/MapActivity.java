package com.example.pinpoint;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.example.pinpoint.models.Pin;
import com.example.pinpoint.models.PinResult;
import com.example.pinpoint.models.PinResult.PinObject;
import com.example.pinpoint.resources.Global;
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
	private mapIt mMapIt;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		
		double loc[] = getIntent().getDoubleArrayExtra("pin");
		LatLng latlng = new LatLng(loc[0],loc[1]);

		// Move the camera instantly to esb with a zoom of 15.
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 20));

		// Zoom in, animating the camera.
		map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

		map.setMyLocationEnabled(true);
		mMapIt = new mapIt();
		mMapIt.execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class mapIt extends AsyncTask<Void, Void, Void> {
		@SuppressWarnings("unchecked")
		@Override
		protected Void doInBackground(Void... params) {

			Global.getClient().pins(new Callback() {

				@Override
				public void success(Object o, Response response) {
					PinResult result = (PinResult) o;
					List<PinObject> pins = result.getRows();
					for (PinObject p : pins) {
						Pin pin = p.getPin();
						LatLng position = new LatLng(pin.getLocation().get(0),
								pin.getLocation().get(1));
						map.addMarker(new MarkerOptions().position(position)
								.title(pin.getType())
								.snippet(pin.getDescription()));
					}
					// close PinActivity, or load ViewPinActivity, or whatever
					// you want now.

				}

				@Override
				public void failure(RetrofitError retrofitError) {

					// do something with the error and failure

				}
			});
			return null;
		}

		@Override
		protected void onCancelled() {
			mMapIt = null;
			// showProgress(false); //copy from LoginTask to show a spinning
			// wheel
			// this allows you to show the user that something is loading on
			// slow network.
		}
	}

}
