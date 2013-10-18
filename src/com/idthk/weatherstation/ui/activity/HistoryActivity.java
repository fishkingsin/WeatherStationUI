package com.idthk.weatherstation.ui.activity;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

import com.idthk.weatherstation.data.Category;
import com.idthk.weatherstation.data.HistoryData;
import com.idthk.weatherstation.data.StationData;
import com.idthk.weatherstation.ui.HumidityHistoryFragment;
import com.idthk.weatherstation.ui.PressureHistoryFragment;
import com.idthk.weatherstation.ui.R;
import com.idthk.weatherstation.ui.TemperatureHistoryFragment;
import com.idthk.weatherstation.ui.Utilities;

public class HistoryActivity extends FragmentActivity implements
		OnTabChangeListener {
	
	ArrayList<HistoryData> list;
	
	private TabHost mTabHost;
	String TAG = HistoryActivity.this.getClass().getSimpleName();
	private String currentTab;
	private String TAB="HistoryActivity";
	public static String KEY_HISTORY="history";
	
	
	Category category;
	private StationData data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		data = (StationData) bundle.getParcelable("StationData");
//		Log.v(TAB,data.toString());
		
		
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup();
		list = getIntent().getParcelableArrayListExtra(HistoryActivity.KEY_HISTORY);

//		View indicator = LayoutInflater.from(this).inflate(R.layout.tab,
//				(ViewGroup) findViewById(android.R.id.tabs), false);

		mTabHost.addTab(newTab(getString(R.string.TEMPERATURE),
				R.string.TEMPERATURE, R.id.fragment1,
				R.drawable.tab_icon_selector_tempreture));
		mTabHost.addTab(newTab(getString(R.string.HUMIDITY), R.string.HUMIDITY,
				R.id.fragment2, R.drawable.tab_icon_selector_humidity));
		mTabHost.addTab(newTab(getString(R.string.PRESSURE), R.string.PRESSURE,
				R.id.fragment3, R.drawable.tab_icon_selector_pressure));
		mTabHost.addTab(newTab(getString(R.string.RAINFALL), R.string.RAINFALL,
				R.id.fragment4, R.drawable.tab_icon_selector_rainfall));
		mTabHost.addTab(newTab(getString(R.string.WIND_SPEED),
				R.string.WIND_SPEED, R.id.fragment5,
				R.drawable.tab_icon_selector_windspeed));
		mTabHost.addTab(newTab(getString(R.string.UV), R.string.UV,
				R.id.fragment6, R.drawable.tab_icon_selector_uv));

		mTabHost.getTabWidget().getChildTabViewAt(3).setEnabled(false);
		mTabHost.getTabWidget().getChildTabViewAt(4).setEnabled(false);
		mTabHost.getTabWidget().getChildTabViewAt(5).setEnabled(false);

		updateTab(getString(R.string.TEMPERATURE), R.id.fragment1);
		updateTab(getString(R.string.HUMIDITY), R.id.fragment2);
		updateTab(getString(R.string.PRESSURE), R.id.fragment3);

	}

	private TabSpec newTab(String tag, int labelId, int tabContentId,
			int imageId) {

		View tab = LayoutInflater.from(this).inflate(R.layout.tab, null);
		ImageView image = (ImageView) tab.findViewById(R.id.grabber_icon);

		if (imageId != 0) {
			image.setImageResource(imageId);
		}

		TabSpec tabSpec = mTabHost.newTabSpec(tag).setIndicator(tab)
				.setContent(tabContentId);
		return tabSpec;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.history_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {

		case R.id.history_menu_item1:
			
			Intent intent = new Intent(this, HistoryListActivity.class);
			intent.putExtra("TAB", currentTab);

			intent.putParcelableArrayListExtra(KEY_HISTORY,list );
			
			startActivityForResult(intent, 0);
			overridePendingTransition(R.anim.slide_in_right,
					R.anim.slide_out_left);
			return true;

		default:
			Utilities.finish(this);
			return true;
		}
	}

	@Override
	public void onBackPressed() {
		Utilities.finish(this);
	}

	@Override
	public void onTabChanged(String tabId) {
	}

	public void updateTab(String tabId, int placeholder) {
//		Log.d(TAG, tabId);
		currentTab = tabId;
		FragmentManager fm = getSupportFragmentManager();
		
		switch (placeholder) {
		case R.id.fragment1:
			category = Category.TEMPERATURE;
			if (fm.findFragmentByTag(tabId) == null) {
				// gonna to manage actvitiy here
				fm.beginTransaction()
						.replace(
								placeholder,
								TemperatureHistoryFragment
										.newInstance(data,list),
								tabId).commit();

			}
			break;
		case R.id.fragment2:
			category = Category.HUMIDITY;
			if (fm.findFragmentByTag(tabId) == null) {
				// gonna to manage actvitiy here
				fm.beginTransaction()
						.replace(
								placeholder,
								HumidityHistoryFragment
										.newInstance(data,list), tabId)
						.commit();

			}
			break;
		case R.id.fragment3:
			category = Category.PRESSURE;
			if (fm.findFragmentByTag(tabId) == null) {
				// gonna to manage actvitiy here
				fm.beginTransaction()
						.replace(
								placeholder,
								PressureHistoryFragment
										.newInstance(data,list),
								tabId).commit();

			}
			break;
		}
	}

}
