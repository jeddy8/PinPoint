package com.example.pinpoint;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import com.example.pinpoint.PinActivity.pinItTask;
import com.example.pinpoint.models.Pin;
import com.example.pinpoint.models.Team;
import com.example.pinpoint.resources.Global;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;




public class CreateTeamActivity extends Activity {
	
	private createTask mCreateTask;
	private String mTeamName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_team);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		findViewById(R.id.create_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	EditText edtTxt = (EditText)findViewById(R.id.teamname);
            	mTeamName = edtTxt.getText().toString();
            	
            	mCreateTask = new createTask();
            	mCreateTask.execute();
            	
            	Intent backfeed = new Intent(getApplicationContext(),
    					MainActivity.class);
    			startActivity(backfeed);
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_team, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_create_team,
					container, false);
			return rootView;
		}
	}
	
	public class createTask extends AsyncTask<Void, Void, Void> {
        @SuppressWarnings("unchecked")
		@Override
        protected Void doInBackground(Void... params) {
        	Team team = new Team();
        	team.setTeamName(mTeamName);
        	team.setTeamLeader(Global.getUser().getName());
            Global.getClient().team(team, new Callback() {
            
                @Override
                public void success(Object o, Response response) {
                    //finish();
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    
                	//do something with the error and failure
                	
                }
            });
            return null;
        }

        @Override
        protected void onCancelled() {
            mCreateTask = null;
            //showProgress(false); //copy from LoginTask to show a spinning wheel
            //this allows you to show the user that something is loading on slow network.
        }
    }

}
