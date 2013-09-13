package com.idthk.weatherstationui;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.terlici.dragndroplist.DragNDropListView;
import com.terlici.dragndroplist.DragNDropSimpleAdapter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class StationActivity extends Activity  implements OnClickListener{
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_station);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.STATION));
//        final ListView listview = (ListView) findViewById(R.id.station_list);
        
        
        
        
        String []values=MainActivity.stationName;
        
        ArrayList<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
		for(int i = 0; i < values.length; ++i) {
			HashMap<String, Object> item = new HashMap<String, Object>();
			item.put("name",values[i]);
			item.put("_id", i);
			
			items.add(item);
		}
        
        DragNDropListView list = (DragNDropListView)findViewById(R.id.list1);
		list.addFooterView(getLayoutInflater().inflate(R.layout.footer, null));
		list.setDragNDropAdapter(new DragNDropSimpleAdapter(this,
				items,
				R.layout.rowlayout_station,
				 new String[]{"name"},
				 new int[]{R.id.label},
				 R.id.handler));
        
//		final StationArrayAdapter adapter = new StationArrayAdapter(this,
//				values);
//		list.setAdapter(adapter);
//		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, final View view,
//					int position, long id) {
//				Toast.makeText(StationActivity.this, adapter.getItem(position), Toast.LENGTH_SHORT).show();
//			}
//
//		});
		((Button)findViewById(R.id.btn_modify_connected_station)).setOnClickListener(this);
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.stations_menu, menu);
		return true;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
			case R.id.btn_modify_connected_station:
				Toast.makeText(this, "btn_modify_connected_station click", Toast.LENGTH_SHORT).show();
				break;
			
		}
	}
	
	private class StationArrayAdapter extends ArrayAdapter<String> {

		private final String[] values;
		private Context context;

		public StationArrayAdapter(Context context, String[] values) {
			super(context, R.layout.rowlayout_middle, values);
			this.context = context;
			this.values = values;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.rowlayout_station, parent,
						false);
			

			TextView textView = (TextView) rowView.findViewById(R.id.label);

			textView.setText(values[position]);
			

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
}
