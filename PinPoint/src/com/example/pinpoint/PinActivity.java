package com.example.pinpoint;

import com.example.pinpoint.models.Pin;
import com.example.pinpoint.models.PinDB;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.os.Build;

public class PinActivity extends Activity {

	private Spinner spinner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pin);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		
		spinner = (Spinner) findViewById(R.id.type_spinner);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.pintype_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		findViewById(R.id.pin_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	pinIt();
            }
        });
	}
	
	public void pinIt(){
		LocationManager locMgr =  (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    	Location loc = locMgr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    	double lat = loc.getLatitude();
    	double lng = loc.getLongitude();
    	
    	Boolean done = false;
    	
    	float[] results = new float[1];
    	for (Pin p : PinDB.pins){
    		LatLng pos = p.getLocation();
        	Location.distanceBetween(lat, lng, pos.latitude, pos.longitude, results);
        	if (results[0] <= 5.0) {
        		p.colorIntensity();
        		done = true;
        	}
        }
    	if (!done){
	    	EditText edtTxt = (EditText)findViewById(R.id.description);
	    	String description = edtTxt.getText().toString();
	    	PinDB.pins.add(new Pin(new LatLng(lat,lng),spinner.getSelectedItem().toString(),
	    			description));
    	}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pin, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_pin, container,
					false);
			return rootView;
		}
	}

}
