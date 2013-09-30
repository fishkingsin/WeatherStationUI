package com.idthk.weatherstation.ui;


import com.idthk.weatherstation.ui.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TemperatureHistoryFragment extends Fragment {
	
	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	public static final TemperatureHistoryFragment newInstance(String message) {
		TemperatureHistoryFragment f = new TemperatureHistoryFragment();
		Bundle bdl = new Bundle(1);
		bdl.putString(EXTRA_MESSAGE, message);
		f.setArguments(bdl);
		return f;
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_temp, container, false);
    }
}
