package com.idthk.weatherstation.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import com.idthk.weatherstation.ui.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HistoryItemAdapterArray extends ArrayAdapter<HistoryData> {

	private final Context context;
	private ArrayList<HistoryData> values;
	private ArrayList<View> views;

	private boolean enableDrag = false;

	public HistoryItemAdapterArray(Context context, ArrayList<HistoryData> values) {
		super(context, R.layout.history_list_item_layout, values);
		this.context = context;
		this.values = values;
		views = new ArrayList<View>();
	}

	public HistoryItemAdapterArray(Context context, int layoutId, int labelId,
			ArrayList<HistoryData> values) {
		super(context, layoutId, values);
		this.context = context;
		this.values = values;
		views = new ArrayList<View>();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.history_list_item_layout, parent,
				false);
		views.add(rowView);
		TextView weekday_tv = (TextView) rowView.findViewById(R.id.weekday_tv);
		TextView day_tv = (TextView) rowView.findViewById(R.id.day_tv);
		TextView month_tv = (TextView) rowView.findViewById(R.id.month_tv);
		TextView low_degree_tv = (TextView) rowView.findViewById(R.id.low_degree_tv);
		TextView degree_unit_tv1 = (TextView) rowView.findViewById(R.id.degree_unit_tv1);
		TextView degree_unit_tv2 = (TextView) rowView.findViewById(R.id.degree_unit_tv2);
		TextView hi_degree_tv = (TextView) rowView.findViewById(R.id.hi_degree_tv);
		HistoryData data = values.get(position);
		if(weekday_tv!=null)weekday_tv.setText(String.valueOf(data.date.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT,
				Locale.getDefault())));
		if(month_tv!=null)month_tv.setText(String.valueOf(data.date.getDisplayName(Calendar.MONTH, Calendar.SHORT,
				Locale.getDefault())));
		if(day_tv!=null)day_tv.setText(String.valueOf(data.date.get(Calendar.DAY_OF_MONTH)));
		if(low_degree_tv!=null)low_degree_tv.setText(String.valueOf(data.lowDegree));
		if(hi_degree_tv!=null)hi_degree_tv.setText(String.valueOf(data.hiDegree));
		if(degree_unit_tv1!=null)degree_unit_tv1.setText(context.getString(R.string.fahrenheit_degree));
		if(degree_unit_tv2!=null)degree_unit_tv2.setText(context.getString(R.string.fahrenheit_degree));
		return rowView;
	}

	
}
