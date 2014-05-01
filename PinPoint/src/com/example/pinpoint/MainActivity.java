package com.example.pinpoint;

import java.util.List;
import java.util.Locale;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pinpoint.models.Pin;
import com.example.pinpoint.models.PinResult;
import com.example.pinpoint.resources.Global;

public class MainActivity extends FragmentActivity {
	private ListView mListView;
	private Context context;
	private static GetPins mGetPins;
	private PinAdapter pinAdapter;
	
	private static PinsFragment mPinsFragment;

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;
	ListView pinlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = getApplicationContext();
		mListView = new ListView(this);
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		mGetPins = new GetPins();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_pin:
			Intent feed = new Intent(getApplicationContext(), PinActivity.class);
			// feed.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(feed);
			finish();
			return true;
		case R.id.action_map:
			Intent mapfeed = new Intent(getApplicationContext(),
					MapActivity.class);
			// answerData.putExtra("qToAnswer", qToAnswer);
			startActivity(mapfeed);
			finish();
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class GetPins extends AsyncTask<Void, Void, Void> {
		@SuppressWarnings("unchecked")
		@Override
		protected Void doInBackground(Void... params) {

			Global.getClient().pins(new Callback() {

				@Override
				public void success(Object o, Response response) {
					PinResult result = (PinResult) o;
					List<Pin> pins = result.getRows();
					
					pinAdapter = new PinAdapter(context, pins);
					mPinsFragment.setListAdapter(pinAdapter);
					mGetPins = null;
					// close PinActivity, or load ViewPinActivity, or whatever
					// you want now.
				}

				@Override
					public void failure(RetrofitError retrofitError) {
					Log.i("Activity", retrofitError.toString());
					// do something with the error and failure
					mGetPins = null;
				}
			});
			return null;
		}

		@Override
		protected void onCancelled() {
			mGetPins = null;
			//showProgress(false); //copy from LoginTask to show a spinning
			// wheel
			// this allows you to show the user that something is loading on
			// slow network.
		}
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public ListFragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a DummySectionFragment (defined as a static inner class
			// below) with the page number as its lone argument.
			switch (position) {

			case 0:
				ListFragment fragment = new PinsFragment();
				Bundle args = new Bundle();
				args.putInt(PinsFragment.ARG_SECTION_NUMBER, position + 1);
				fragment.setArguments(args);
				return fragment;
			case 1:
				ListFragment fragment2 = new TeamsFragment();
				Bundle args2 = new Bundle();
				args2.putInt(PinsFragment.ARG_SECTION_NUMBER, position + 2);
				fragment2.setArguments(args2);
				return fragment2;

			case 2:
				ListFragment fragment3 = new NotificationsFragment();
				Bundle args3 = new Bundle();
				args3.putInt(PinsFragment.ARG_SECTION_NUMBER, position + 3);
				fragment3.setArguments(args3);
				return fragment3;

			default:
				return null;

			}
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class PinsFragment extends ListFragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		// public ArrayList<Pin> pins = new ArrayList<Pin>();

		public PinsFragment() {
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			
			mPinsFragment = this;
			mGetPins.execute();
			// PinAdapter adapter = new PinAdapter(getActivity(),pin);
			// setListAdapter(adapter);
		}

		@Override
		public void onListItemClick(ListView l, View v, int position, long id) {
			// TODO Auto-generated method stub
			super.onListItemClick(l, v, position, id);
			// String pinStuff = (String) l.getItemAtPosition(position);
			Intent pinData = new Intent(getActivity().getBaseContext(),
					ViewPinActivity.class);
			// answerData.putExtra("qToAnswer", qToAnswer);
			// pinData.putExtra("pin", pins.get(position));
			startActivity(pinData);
		}
	}

	public static class TeamsFragment extends ListFragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public TeamsFragment() {
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			String[] values = new String[] { "Team1", "Team2", "Team3",
					"Team4", "Team5", "Team6", "Team7", "Team8", "Team9",
					"Team10", "Team11", "Team12", "Team13" };
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
					getActivity(), android.R.layout.simple_list_item_1, values);
			setListAdapter(adapter);
		}
	}

	public static class NotificationsFragment extends ListFragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public NotificationsFragment() {
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			String[] values = new String[] { "Notification1", "Notification2",
					"Notification3", "Notification4", "Notification5",
					"Notification6", "Notification7", "Notification8",
					"Notification9", "Notification10", "Notification11",
					"Notification12", "Notification13" };
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
					getActivity(), android.R.layout.simple_list_item_1, values);
			setListAdapter(adapter);
		}
	}

}
