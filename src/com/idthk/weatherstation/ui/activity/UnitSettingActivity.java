package com.idthk.weatherstation.ui.activity;

import java.util.ArrayList;
import com.idthk.weatherstation.ui.Utilities;
import com.idthk.weatherstation.ui.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class UnitSettingActivity extends Activity {

	ArrayList<String> listItems = new ArrayList<String>();

	// DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LISTVIEW
	ArrayAdapter<String> adapter;
	int clickCounter = 0;
	ListView listview ;
	protected String TAG = "UnitSettingActivity";

	private String prefKey;

	
	private int prefValueIndex;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_unitsetting);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		Intent intent = this.getIntent();

		int theID = intent.getIntExtra(getString(R.string.Measurement_Unit), 0);
		
		Resources res = getResources();
		

		
		String[] values;
		if (theID == 1) {
			values = res.getStringArray(R.array.temperature_units);
			prefKey = getString(R.string.pref_temperature_units);
		} else if (theID == 2) {
			values = res.getStringArray(R.array.pressure_units);
			prefKey = getString(R.string.pref_pressure_units);
		} else if (theID == 3) {
			values = res.getStringArray(R.array.rainfall_units);
			prefKey = getString(R.string.pref_rainfall_units);
		} else {
			values = res.getStringArray(R.array.windspeed_units);
			prefKey = getString(R.string.pref_windspeed_units);
		}
		setTitle(SettingsActivity.stationName[theID]);
		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(UnitSettingActivity.this);

		String prefValue = prefs.getString(prefKey, "");
		Log.v(TAG,"Pref Value "+prefValue);	
		

		listview = (ListView) findViewById(R.id.cli_lista_det);

		final StableArrayAdapter adapter = new StableArrayAdapter(this,
				values);
		listview.setAdapter(adapter);

		for(int i = 0 ; i < values.length ; i++)
		{
			if(prefValue.equals(values[i]))
			{
//				prefValue = values[i];
				prefValueIndex = i;
				break;
			}
					
		}
		
//		int length = listview.getChildCount();
//		for(int i = 0 ; i < length ;i++)
//		{
//			View _view = listview.getChildAt(i);
//			ImageView tickIcon = (ImageView) _view.findViewById(R.id.tick_icon);
//			if(i==prefValueIndex)
//			{
//				tickIcon.setVisibility(View.VISIBLE);
//			}
//			else
//			{
//				tickIcon.setVisibility(View.INVISIBLE);
//			}
//		}
		
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				// final String item = (String)
				// parent.getItemAtPosition(position);
				// view.animate().setDuration(2000).alpha(0)
				// .withEndAction(new Runnable() {
				// @Override
				// public void run() {
				// list.remove(item);
				// adapter.notifyDataSetChanged();
				// view.setAlpha(1);
				// }
				// });
				int length = listview.getChildCount();
				for(int i = 0 ; i < length ;i++)
				{
					View _view = listview.getChildAt(i);
					
					ImageView tickIcon = (ImageView) _view.findViewById(R.id.tick_icon);
					tickIcon.setVisibility(View.INVISIBLE);
				}
				
				Toast.makeText(UnitSettingActivity.this, "item "+String.valueOf(position)	, Toast.LENGTH_SHORT).show();
				String item = adapter.getItem(position);
				
				SharedPreferences prefs = PreferenceManager
						.getDefaultSharedPreferences(UnitSettingActivity.this);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putString(prefKey, item);

				// Commit the edits!
				editor.commit();
				ImageView tickIcon = (ImageView) view.findViewById(R.id.tick_icon);
				tickIcon.setVisibility(View.VISIBLE);
				
				Log.v(TAG ,view.toString());
			}

		});
		listview.setItemChecked(2, true);

	}

	private class StableArrayAdapter extends ArrayAdapter<String> {

		private final String[] values;
		private Context context;

		public StableArrayAdapter(Context context, String[] values) {
			super(context, R.layout.rowlayout_middle, values);
			this.context = context;
			this.values = values;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView;
			if (position == 0) {
				rowView = inflater.inflate(R.layout.rowlayout_top, parent,
						false);
			} else if (position == values.length - 1) {
				rowView = inflater.inflate(R.layout.rowlayout_bottom, parent,
						false);
			} else {
				rowView = inflater.inflate(R.layout.rowlayout_middle, parent,
						false);
			}

			TextView textView = (TextView) rowView.findViewById(R.id.label);
			// ImageView imageView = (ImageView)
			// rowView.findViewById(R.id.icon);
			textView.setText(values[position]);
			
			
			//get setting from shared preferences then assign to to corresponding position	
			if(position==prefValueIndex)
			{
				ImageView tickIcon = (ImageView) rowView.findViewById(R.id.tick_icon);
				tickIcon.setVisibility(View.VISIBLE);
			}
			// Change the icon for Windows and iPhone
			// String s = values[position];
			// if (s.startsWith("iPhone")) {
			// imageView.setImageResource(R.drawable.no);
			// } else {
			// imageView.setImageResource(R.drawable.ok);
			// }

			return rowView;
		}

		@Override
		public String getItem(int position) {

			return values[position];
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Utilities.finish(this);
		return true;

	}
	@Override 
	public void onBackPressed()
	{
		Utilities.finish(this);
	}
	@Override 
	public void onResume()
	{
//		int length = listview.getChildCount();
//		for(int i = 0 ; i < length ;i++)
//		{
//			View _view = listview.getChildAt(i);
//			
//			ImageView tickIcon = (ImageView) _view.findViewById(R.id.tick_icon);
//			if(i==0)tickIcon.setVisibility(View.VISIBLE);
//			else tickIcon.setVisibility(View.INVISIBLE);
//				
//		}
		super.onResume();
	}
}
