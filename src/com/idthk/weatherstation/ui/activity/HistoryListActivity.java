package com.idthk.weatherstation.ui.activity;

import java.util.ArrayList;
import java.util.Arrays;

import com.idthk.weatherstation.data.HistoryData;
import com.idthk.weatherstation.data.HistoryItemAdapterArray;
import com.idthk.weatherstation.ui.Utilities;
import com.idthk.weatherstation.ui.R;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

public class HistoryListActivity extends Activity {
	
	private static final String TAG = HistoryListActivity.class.getSimpleName();
	HistoryItemAdapterArray adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historylist);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		ListView listView = (ListView) findViewById(R.id.history_list);

		try{
		ArrayList<HistoryData> list = getIntent().getParcelableArrayListExtra(HistoryActivity.KEY_HISTORY);

		adapter = new HistoryItemAdapterArray(this, list);
		listView.setAdapter(adapter);
		}
		catch(NullPointerException e)
		{
			
		}
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
