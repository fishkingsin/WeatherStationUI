package com.idthk.weatherstation.data;

import java.util.ArrayList;

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

public class MYAdapterArray extends ArrayAdapter<String> {

	private final Context context;
	private ArrayList<String> values;
	private ArrayList<View> views;

	private boolean enableDrag = false;

	public MYAdapterArray(Context context, ArrayList<String> values) {
		super(context, R.layout.rowlayout_station, values);
		this.context = context;
		this.values = values;
		views = new ArrayList<View>();
	}

	public MYAdapterArray(Context context, int layoutId, int labelId,
			ArrayList<String> values) {
		super(context, layoutId, values);
		this.context = context;
		this.values = values;
		views = new ArrayList<View>();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.rowlayout_station, parent,
				false);
		views.add(rowView);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView
				.findViewById(R.id.station_icon);
		textView.setText(values.get(position));
		// Change the icon for Windows and iPhone
		String s = values.get(position);
		if (s.startsWith("Main")) {
			imageView.setImageResource(R.drawable.main_icon);
		} else {
			imageView.setImageResource(R.drawable.child_icon);
		}
		if (enableDrag) {
			((ImageView) rowView.findViewById(R.id.grabber_icon))
			.setVisibility(View.VISIBLE);
		}
		else
		{
			((ImageView) rowView.findViewById(R.id.grabber_icon))
				.setVisibility(View.GONE);
		}
		return rowView;
	}

	public void toggleDraggable() {
		enableDrag = !enableDrag;
		if (enableDrag) {
			for (View view : views) {
				ImageView im = (ImageView) view.findViewById(R.id.grabber_icon);
				im.setVisibility(View.VISIBLE);
				Animation fadeinAnimation = AnimationUtils.loadAnimation(context,
						R.anim.fade_in);
				im.startAnimation(fadeinAnimation);
			}
		} else {
			for (View view : views) {
				ImageView im = (ImageView) view.findViewById(R.id.grabber_icon);
				im.setVisibility(View.GONE);
				Animation fadeinAnimation = AnimationUtils.loadAnimation(context,
						R.anim.fade_out);
				im.startAnimation(fadeinAnimation);
			}
		}
	}

}
