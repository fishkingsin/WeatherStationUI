package com.idthk.weatherstation.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.idthk.weatherstation.ui.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapterArray extends ArrayAdapter<StationData> {

	private final Context context;
	private ArrayList<StationData> values;
	private ArrayList<View> views;

	public MainAdapterArray(Context context, ArrayList<StationData> values) {
		super(context, R.layout.history_list_item_layout, values);
		this.context = context;
		this.values = values;
		views = new ArrayList<View>();
	}

	public MainAdapterArray(Context context, int layoutId, int labelId,
			ArrayList<StationData> values) {
		super(context, layoutId, values);
		this.context = context;
		this.values = values;
		views = new ArrayList<View>();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = null;
		StationData data = values.get(position);
		if (position == 0) {
			if (data.name.equals("Main")) {

				rowView = inflater.inflate(R.layout.station_panel_large,
						parent, false);
				TextView air_pressure_tv = (TextView) rowView
						.findViewById(R.id.air_pressure_tv);
				air_pressure_tv.setText(String.valueOf(data.pressure));
			} else {
				rowView = inflater.inflate(R.layout.station_panel_empty,
						parent, false);
			}

			TextView data_tv = (TextView) rowView
					.findViewById(R.id.home_panel_date_tv);
			Calendar cal = Calendar.getInstance();

			SimpleDateFormat sdf = new SimpleDateFormat("EEE. d MMM yyyy");
			data_tv.setText(sdf.format(cal.getTime()));
		} else {
			rowView = inflater.inflate(R.layout.station_panel_small, parent,
					false);
			ImageView icon = (ImageView) rowView
					.findViewById(R.id.station_icon);
			icon.setImageResource(R.drawable.child_yellow);

			TextView humidity_tv = (TextView) rowView
					.findViewById(R.id.humidity_tv);
			TextView temperature_tv = (TextView) rowView
					.findViewById(R.id.temperature_tv);
			humidity_tv.setText(String.valueOf(data.humiditiy));
			temperature_tv.setText(String.valueOf(data.degree));
		}
		views.add(rowView);
		try {
			TextView station_name_tv = (TextView) rowView
					.findViewById(R.id.station_name_tv);

			station_name_tv.setText(data.name);

			ImageView station_battery = (ImageView) rowView
					.findViewById(R.id.station_battery);

			station_battery.setImageResource(data.battery_level);
		} catch (Exception e) {

		}
		return rowView;
	}
	@Override
	public boolean isEnabled(int position) {
	    if(position==0)return false;
	    else return true;
	}
}
