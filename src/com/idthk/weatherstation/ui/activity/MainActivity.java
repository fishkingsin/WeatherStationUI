package com.idthk.weatherstation.ui.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.idthk.weatherstation.data.MainAdapterArray;
import com.idthk.weatherstation.data.StationData;
import com.idthk.weatherstation.ui.R;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
		OnNavigationListener {
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

		TextView data_tv = (TextView) findViewById(R.id.home_panel_date_tv);
		Calendar cal = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("EEE. d MMM yyyy");
		data_tv.setText(sdf.format(cal.getTime()));

		for (int i = 0; i < 10; i++) {
			if (i == 0) {
				stationData.add(new MainStationData("Main"));
				stationData.add(new MainStationData("Main"));
			} else
				stationData.add(new ChannelData("Channel" + String.valueOf(i)));
		}
		ListView mainList = (ListView) findViewById(R.id.main_list);
		MainAdapterArray adapter = new MainAdapterArray(this, stationData);
		mainList.setAdapter(adapter);

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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// if(v.getId()==R.id.button_history)
		// {
		// Intent intent = new Intent(this, HistoryActivity.class);
		//
		// startActivityForResult(intent, 0);
		// overridePendingTransition(R.anim.slide_in_right,
		// R.anim.slide_out_left);
		// }
		// else
		// for (int i = 0; i < stationView.length; i++) {
		// if (v.getId() == stationView[i]) {
		// Intent intent = new Intent(this, HistoryActivity.class);
		//
		// startActivityForResult(intent, 0);
		// overridePendingTransition(R.anim.slide_in_right,
		// R.anim.slide_out_left);
		// return;
		// }
		// }
		// if (v.getId() == R.id.button_settings) {
		//
		// }
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
