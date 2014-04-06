package com.example.pinpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

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

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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
			switch(position){
			
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
		public ArrayList<Pin> pins = new ArrayList<Pin>();
		

		public PinsFragment() {
		}

		@Override
		  public void onActivityCreated(Bundle savedInstanceState) {
		    super.onActivityCreated(savedInstanceState);
		    //pins.add (new Pin("323 High St","Pothole"));
		    for (int i = 0; i<20; i++){
		    	pins.add(new Pin("Pin Location Dummy "+i, "Pin Type Dummy "+i));
		    }
		    PinAdapter adapter = new PinAdapter(getActivity(),pins);
		    setListAdapter(adapter);
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
		    String[] values = new String[] { "Team1", "Team2", "Team3", "Team4", "Team5",
		    		"Team6", "Team7", "Team8", "Team9", "Team10", "Team11", "Team12", "Team13" };
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
		        android.R.layout.simple_list_item_1, values);
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
		    String[] values = new String[] { "Notification1", "Notification2", "Notification3",
		    		"Notification4", "Notification5", "Notification6", "Notification7", "Notification8", 
		    		"Notification9", "Notification10", "Notification11", "Notification12", "Notification13" };
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
		        android.R.layout.simple_list_item_1, values);
		    setListAdapter(adapter);
		}
	}

}
