package com.idthk.weatherstation.ui;

import com.idthk.weatherstation.data.StationData;
import com.idthk.weatherstation.ui.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TemperatureHistoryFragment extends Fragment {

	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

	public static final TemperatureHistoryFragment newInstance(StationData data) {
		TemperatureHistoryFragment f = new TemperatureHistoryFragment();
		Bundle bdl = new Bundle(1);
		bdl.putParcelable(EXTRA_MESSAGE, data);
		f.setArguments(bdl);
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		StationData data = getArguments().getParcelable(EXTRA_MESSAGE);

		View rootView = inflater.inflate(R.layout.fragment_history_temp,
				container, false);
		try {
			((TextView) rootView.findViewById(R.id.temperature_tv))
					.setText(data.getDegreeasString());
			((TextView) rootView.findViewById(R.id.max_temperature_tv))
					.setText(data.getMaxDegreeasString());
			((TextView) rootView.findViewById(R.id.min_temperature_tv))
					.setText(data.getMinDegreeasString());
		} catch (Exception e) {

		}
		return rootView;
	}
}
