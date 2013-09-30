package com.idthk.weatherstation.ui.activity;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.idthk.weatherstation.data.MYAdapterArray;
import com.idthk.weatherstation.ui.Utilities;
import com.idthk.weatherstation.ui.R;
import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortListView;

public class StationActivity extends Activity implements OnClickListener {
	private static String[] items = { "Main", "ipsum", "dolor", "sit", "amet",
			"consectetuer", "adipiscing", "elit", "morbi", "vel", "ligula",
			"vitae", "arcu", "aliquet", "mollis", "etiam", "vel", "erat",
			"placerat", "ante", "porttitor", "sodales", "pellentesque",
			"augue", "purus" };

	DragSortListView listView;
	MYAdapterArray adapter;

	private DragSortListView.DropListener onDrop = new DragSortListView.DropListener() {
		@Override
		public void drop(int from, int to) {
			if (from != to) {
				String item = adapter.getItem(from);
				adapter.remove(item);
				adapter.insert(item, to);
			}
			//do some to save setting
		}
	};

	private DragSortListView.RemoveListener onRemove = new DragSortListView.RemoveListener() {
		@Override
		public void remove(int which) {
			adapter.remove(adapter.getItem(which));
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_station);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		setTitle(getString(R.string.STATION));

		((Button) findViewById(R.id.btn_modify_connected_station))
				.setOnClickListener(this);

		listView = (DragSortListView) findViewById(R.id.station_list);
		String[] names = items;// getResources().getStringArray(R.array.random_names);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(names));

		adapter = new MYAdapterArray(this, R.layout.rowlayout_station,
				R.id.label, list);
		listView.setAdapter(adapter);
		listView.setDropListener(onDrop);
		listView.setRemoveListener(onRemove);

		DragSortController controller = new DragSortController(listView);
		controller.setDragHandleId(R.id.grabber_icon);
		controller.setRemoveEnabled(false);
		controller.setSortEnabled(true);
		controller.setDragInitMode(1);

		listView.setFloatViewManager(controller);
		listView.setOnTouchListener(controller);
		listView.setDragEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
			          int position, long id) {
				// TODO Auto-generated method stub
				String item = adapter.getItem(position);
//				Toast.makeText(StationActivity.this,
//						"Item in position " + position + " clicked "+item,
//						Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(StationActivity.this, RenameActivity.class);
				intent.putExtra(getString(R.string.station_name_extra), item);
				startActivityForResult(intent, 0);
				overridePendingTransition(R.anim.slide_in_right,
						R.anim.slide_out_left);
				// Return true to consume the click event. In this case the
				// onListItemClick listener is not called anymore.
			}
		});
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
		switch (v.getId()) {
		case R.id.btn_modify_connected_station:
			Toast.makeText(this, "btn_modify_connected_station click",
					Toast.LENGTH_SHORT).show();
			break;

		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {

		case R.id.edit_button:
			Toast.makeText(this, getString(R.string.EDIT), Toast.LENGTH_SHORT).show();
			// do something when this button is pressed
			adapter.toggleDraggable();
			return true;
		
		default:
			return true;
		}
	}

	@Override
	public void onBackPressed() {
		Utilities.finish(this);
	}

}
