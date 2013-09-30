package com.idthk.weatherstation.ui.activity;

import com.idthk.weatherstation.ui.Utilities;
import com.idthk.weatherstation.ui.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SettingsActivity extends Activity implements OnClickListener {
	public static Integer stationView[] = { R.id.button_station,
			R.id.button_temperature, R.id.button_pressure,
			R.id.button_rainfall, R.id.button_windspeed, };
	public static Integer stationName[] = { R.string.STATION,
			R.string.TEMPERATURE, R.string.PRESSURE, R.string.RAINFALL,
			R.string.WIND_SPEED, };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);

		for (int i = 0; i < stationView.length; i++) {
			findViewById(stationView[i]).setOnClickListener(this);
		}

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);

		ToggleButton tb = (ToggleButton) findViewById(R.id.toggle_hide_sensor);
		tb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				Toast.makeText(
						SettingsActivity.this,
						"toggle_hide_sensor checked "
								+ String.valueOf(isChecked), Toast.LENGTH_SHORT)
						.show();
			}

		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		for (int i = 0; i < stationView.length; i++) {
			if (v.getId() == stationView[i]) {
				Intent intent;
				if (v.getId() == R.id.button_station) {
					intent = new Intent(this, StationActivity.class);
				} else {

					intent = new Intent(this, UnitSettingActivity.class);
					Bundle bundle = new Bundle();
					intent.putExtra(getString(R.string.Measurement_Unit), i);

				}

				startActivityForResult(intent, 0);
				overridePendingTransition(R.anim.slide_in_right,
						R.anim.slide_out_left);
				return;
			}
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Utilities.finish(this);
		return true;

	}

	@Override
	public void onBackPressed() {
		Utilities.finish(this);
	}
}
