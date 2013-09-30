package com.idthk.weatherstation.ui.activity;

import java.util.ArrayList;

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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_ extends Activity implements OnClickListener , OnNavigationListener{
	private Integer stationView[] = { R.id.small_panel1, R.id.small_panel2,
			R.id.small_panel3, R.id.small_panel4, R.id.small_panel5,
			R.id.small_panel6, R.id.small_panel7, R.id.small_panel8,
			R.id.small_panel9, R.id.small_panel10, };
	public static String stationName[] = { "Main", "Channel1", "Channel2",
			"Channel3", "Channel4", "Channel5", "Channel6", "Channel7",
			"Channel8", "Channel9", };
	ArrayList<String> itemList = new ArrayList<String>();
	private String TAG="MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle(getString(R.string.HOME));
		
		ActionBar actionBar = getActionBar();
//		actionBar.setDisplayShowTitleEnabled(false);
//		getActionBar().setDisplayHomeAsUpEnabled(true);
//		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
//		itemList.add(getString(R.string.HOME));
//		itemList.add(getString(R.string.action_settings));
//		itemList.add(getString(R.string.refresh));
//		ArrayAdapter<String> aAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, itemList);
//		actionBar.setListNavigationCallbacks(aAdpt, this);
			
		for (int i = 0; i < stationView.length; i++) {
			View view = (View) findViewById(stationView[i]);
			view.setOnClickListener(this);
			TextView station_name_tv = (TextView) view
					.findViewById(R.id.station_name_tv);
			station_name_tv.setText(stationName[i]);

			TextView temperature_tv = (TextView) view
					.findViewById(R.id.temperature_tv);

			TextView humidity_tv = (TextView) view
					.findViewById(R.id.humidity_tv);

			ImageView station_icon = (ImageView) view
					.findViewById(R.id.station_icon);

			if (!stationName[i].equals("Main")) {
				station_icon.setImageResource(R.drawable.child_yellow);
			}
		}
		

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
		for (int i = 0; i < stationView.length; i++) {
			if (v.getId() == stationView[i]) {
				Intent intent = new Intent(this, HistoryActivity.class);

				startActivityForResult(intent, 0);
				overridePendingTransition(R.anim.slide_in_right,
						R.anim.slide_out_left);
				return;
			}
		}
		// if (v.getId() == R.id.button_settings) {
		//
		// }
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		// TODO Auto-generated method stub
		Log.v(TAG,"item "+String.valueOf(itemId));
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
