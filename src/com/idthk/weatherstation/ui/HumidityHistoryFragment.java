package com.idthk.weatherstation.ui;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.idthk.weatherstation.data.Category;
import com.idthk.weatherstation.data.HistoryData;
import com.idthk.weatherstation.data.StationData;
import com.idthk.weatherstation.ui.activity.HistoryActivity;

public class HumidityHistoryFragment extends MyFragmentFunction {
	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	private static final String TAG = HumidityHistoryFragment.class.getSimpleName();
	public static final HumidityHistoryFragment newInstance(StationData data, ArrayList<HistoryData> list) {
		HumidityHistoryFragment f = new HumidityHistoryFragment();
		Bundle bdl = new Bundle(1);
		bdl.putParcelable(EXTRA_MESSAGE, data);
		bdl.putParcelableArrayList(HistoryActivity.KEY_HISTORY,list );
		f.setArguments(bdl);
		
		return f;
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		ArrayList<HistoryData> list = getArguments().getParcelableArrayList(HistoryActivity.KEY_HISTORY);
		StationData data = getArguments().getParcelable(EXTRA_MESSAGE);
		 Log.v(TAG,"HumidityHistoryFragment");
		 View rootView = inflater.inflate(R.layout.fragment_history_humidity, container, false);
		 SimpleDateFormat sdf = new SimpleDateFormat(getActivity().getString(R.string.date_format));
			TextView data_tv = (TextView) rootView
					.findViewById(R.id.home_panel_date_tv);
			data_tv.setText(sdf.format(Calendar.getInstance().getTime()));
			
			TextView user_tv = (TextView) rootView
					.findViewById(R.id.user_tv);
			user_tv.setText(getActivity().getString(R.string.default_user_name));
			
		 try {
				((TextView) rootView.findViewById(R.id.humidity_tv))
						.setText(data.getHumidityAsString());
				((TextView) rootView.findViewById(R.id.max_humidity_tv))
						.setText(data.getMaxHumidityAsString());
				((TextView) rootView.findViewById(R.id.min_humidity_tv))
						.setText(data.getMinHumidityAsString());
			} catch (Exception e) {

			}
		 ViewGroup graph = (ViewGroup) rootView.findViewById(R.id.graph1);
		 super.createGraph(graph,getActivity(), list, Category.HUMIDITY);
        return rootView;
    }
	
}
