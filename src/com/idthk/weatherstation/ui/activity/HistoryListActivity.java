package com.idthk.weatherstation.ui.activity;

import java.util.ArrayList;
import java.util.Arrays;

import com.idthk.weatherstation.data.HistoryData;
import com.idthk.weatherstation.data.HistoryItemAdapterArray;
import com.idthk.weatherstation.ui.Utilities;
import com.idthk.weatherstation.ui.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HistoryListActivity extends Activity {
	private static HistoryData[] items = { new HistoryData(), new HistoryData(), new HistoryData(), new HistoryData(), new HistoryData(),};
	HistoryItemAdapterArray adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historylist);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		ListView listView =  (ListView) findViewById(R.id.history_list);
		HistoryData[] names = items;// getResources().getStringArray(R.array.random_names);
		ArrayList<HistoryData> list = new ArrayList<HistoryData>(Arrays.asList(names));

		adapter = new HistoryItemAdapterArray(this, list);
		listView.setAdapter(adapter);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {

		default:
			Utilities.finish(this);
			return true;
		}
	}

	@Override
	public void onBackPressed() {
		Utilities.finish(this);
	}
}
