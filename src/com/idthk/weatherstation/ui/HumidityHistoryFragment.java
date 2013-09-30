package com.idthk.weatherstation.ui;


import com.idthk.weatherstation.ui.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HumidityHistoryFragment extends Fragment {
	public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
	private static final String TAG = HumidityHistoryFragment.class.getSimpleName();
	public static final HumidityHistoryFragment newInstance(String message) {
		HumidityHistoryFragment f = new HumidityHistoryFragment();
		Bundle bdl = new Bundle(1);
		bdl.putString(EXTRA_MESSAGE, message);
		f.setArguments(bdl);
		return f;
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		 Log.v(TAG,"HumidityHistoryFragment");
        return inflater.inflate(R.layout.fragment_history_humidity, container, false);
    }
}
