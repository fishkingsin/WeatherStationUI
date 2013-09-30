package com.idthk.weatherstation.ui.activity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.idthk.weatherstation.data.MainAdapterArray;
import com.idthk.weatherstation.data.StationData;
import com.idthk.weatherstation.ui.R;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnNavigationListener {
	public class MainStationData extends StationData {

		public MainStationData(String _name) {
			super(_name);
			// TODO Auto-generated constructor stub
		}

	}

	public class ChannelData extends StationData {

		public ChannelData(String _name) {
			super(_name);
			// TODO Auto-generated constructor stub
		}

	}

	ArrayList<StationData> stationData = new ArrayList<StationData>();
	private String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle(getString(R.string.HOME));

		ActionBar actionBar = getActionBar();

		

		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				stationData.add(new MainStationData("Main"));
				stationData.add(new ChannelData("Main"));
			} else
				stationData.add(new ChannelData("Channel" + String.valueOf(i)));
		}
		ListView mainList = (ListView) findViewById(R.id.main_list);
		MainAdapterArray adapter = new MainAdapterArray(this, stationData);
		mainList.setAdapter(adapter);
		mainList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long arg3) {
				if (position != 0) {
					StationData data = stationData.get(position);

					Intent intent = new Intent(MainActivity.this,
							HistoryActivity.class);
					Bundle extras = new Bundle();
					extras.putParcelable("StationData", data);

					intent.putExtras(extras);
					startActivityForResult(intent, 0);
					overridePendingTransition(R.anim.slide_in_right,
							R.anim.slide_out_left);
				}
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.actionbar_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {

		case R.id.itemRefresh:
			Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
			// do something when this button is pressed
			return true;
		case R.id.itemSettings:
			Intent intent = new Intent(this, SettingsActivity.class);

			startActivityForResult(intent, 0);
			overridePendingTransition(R.anim.slide_in_right,
					R.anim.slide_out_left);
			return true;
		default:
			return true;
		}
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		// TODO Auto-generated method stub
		Log.v(TAG, "item " + String.valueOf(itemId));
		int id = (int) itemId;
		switch (id) {
		case 0:
			return false;

		case 1:
			Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
			// do something when this button is pressed
			return false;
		case 2:
			Intent intent = new Intent(this, SettingsActivity.class);

			startActivityForResult(intent, 0);
			overridePendingTransition(R.anim.slide_in_right,
					R.anim.slide_out_left);
			return false;
		default:
			return false;
		}
	}
	

}
