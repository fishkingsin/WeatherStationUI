package com.idthk.weatherstationui;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private Integer stationView[] = { R.id.small_panel1, R.id.small_panel2,
			R.id.small_panel3, R.id.small_panel4, R.id.small_panel5,
			R.id.small_panel6, R.id.small_panel7, R.id.small_panel8,
			R.id.small_panel9, R.id.small_panel10, };
	public static String stationName[] = { "Main", "Channel1", "Channel2",
			"Channel3", "Channel4", "Channel5", "Channel6", "Channel7",
			"Channel8", "Channel9", };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle(getString(R.string.HOME));
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
		return true;
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

}
