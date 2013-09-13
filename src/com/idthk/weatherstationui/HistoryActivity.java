package com.idthk.weatherstationui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.terlici.dragndroplist.DragNDropCursorAdapter;
import com.terlici.dragndroplist.DragNDropListView;
import com.terlici.dragndroplist.DragNDropSimpleAdapter;


import android.app.ActionBar;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class HistoryActivity extends Activity  implements OnClickListener{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        
//        ArrayList<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
//		for(int i = 0; i < 30; ++i) {
//			HashMap<String, Object> item = new HashMap<String, Object>();
//			item.put("name", "item" + i);
//			item.put("_id", i);
//			
//			items.add(item);
//		}
		
		
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
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
}
